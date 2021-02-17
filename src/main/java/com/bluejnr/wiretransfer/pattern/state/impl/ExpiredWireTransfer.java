package com.bluejnr.wiretransfer.pattern.state.impl;

import com.bluejnr.wiretransfer.exception.FinalStateException;
import com.bluejnr.wiretransfer.model.domain.WireTransferVO;
import com.bluejnr.wiretransfer.pattern.state.WireTransferState;
import com.bluejnr.wiretransfer.pattern.strategy.WireTransferStrategy;

public class ExpiredWireTransfer extends WireTransferState {

	public ExpiredWireTransfer(WireTransferVO wireTransferVO) {
		super(wireTransferVO);
	}

	@Override
	public void process() {
		throw new FinalStateException("La transferencia ya se encuentra VENCIDA");
	}
	
	@Override
	public String toString() {
		return WireTransferStrategy
				.EXPIRED
				.name();
	}

}
