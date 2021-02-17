package com.bluejnr.wiretransfer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluejnr.wiretransfer.exception.StateNotMatchException;
import com.bluejnr.wiretransfer.model.api.WireTransfer;
import com.bluejnr.wiretransfer.model.domain.WireTransferVO;
import com.bluejnr.wiretransfer.model.entity.Transfer;
import com.bluejnr.wiretransfer.pattern.strategy.WireTransferStrategy;
import com.bluejnr.wiretransfer.repository.WireTransferRepository;
import com.bluejnr.wiretransfer.service.WireTransferService;

@Service
public class WireTransferServiceImpl implements WireTransferService {

	@Autowired
	private WireTransferRepository transferRepository;

	@Override
	public void process(WireTransfer wireTransfer) {
		validateTransfer(wireTransfer);
		WireTransferVO transferVO = toWireTransferVO(wireTransfer);
		transferVO.setWireTransferState(WireTransferStrategy.valueOf(wireTransfer.getWireTransferState()).get(transferVO));
		transferVO.getWireTransferState().process();
		transferRepository.saveAndFlush(toTransfer(transferVO));

	}

	private void validateTransfer(WireTransfer wireTransfer) {
		transferRepository.findById(wireTransfer.getId())
				.filter(transfer -> transfer.getState()
						.equals(wireTransfer.getWireTransferState()))
				.orElseThrow(() -> new StateNotMatchException("Es estado de la Transferencia no coincide con el actual"));
	}

	private WireTransferVO toWireTransferVO(WireTransfer wireTransfer) {
		return WireTransferVO.builder()
				.id(wireTransfer.getId())
				.rejected(wireTransfer.isRejected())
				.expired(wireTransfer.isExpired())
				.canceled(wireTransfer.isCanceled())
				.reviewed(wireTransfer.isReviewed())
				.build();
	}

	private Transfer toTransfer(WireTransferVO transferVO) {
		return new Transfer(transferVO.getId(), 
				transferVO.getWireTransferState()
				.toString());
	}
}
