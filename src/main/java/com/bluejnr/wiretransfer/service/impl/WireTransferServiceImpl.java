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
	public void process(WireTransfer wireTransfer, String nextState) {
		validateTransfer(wireTransfer);
		WireTransferVO transferProcessed = getWireTransferProcessed(wireTransfer, nextState);
		transferRepository.saveAndFlush(toTransfer(transferProcessed));
	}
	
	private WireTransferVO getWireTransferProcessed(WireTransfer wireTransfer, String nextState) {
		WireTransferVO transferVO = toWireTransferVO(wireTransfer);
		transferVO.setState(getWireTransferState(wireTransfer.getState()).get(transferVO));
		transferVO.getState().process(getWireTransferState(nextState));
		return transferVO;
	}

	private void validateTransfer(WireTransfer wireTransfer) {
		transferRepository.findById(wireTransfer.getId())
				.filter(transfer -> transfer.getState()
						.equals(wireTransfer.getState()))
				.orElseThrow(() -> new StateNotMatchException("El estado de la Transferencia no coincide con el actual"));
	}

	private WireTransferVO toWireTransferVO(WireTransfer wireTransfer) {
		return WireTransferVO.builder()
				.id(wireTransfer.getId())
				.description(wireTransfer.getDescription())
				.build();
	}
	
	private WireTransferStrategy getWireTransferState(String state) {
		return  WireTransferStrategy.valueOf(state);
	}

	private Transfer toTransfer(WireTransferVO transferVO) {
		return new Transfer(transferVO.getId(), 
				transferVO.getState()
				.toString());
	}
}
