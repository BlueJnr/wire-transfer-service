package com.bluejnr.wiretransfer.pattern.state.impl;

import com.bluejnr.wiretransfer.model.domain.WireTransferVO;
import com.bluejnr.wiretransfer.pattern.state.WireTransferState;
import com.bluejnr.wiretransfer.pattern.strategy.WireTransferStrategy;

public class ConfirmedPaymentWireTransfer extends WireTransferState {

	public ConfirmedPaymentWireTransfer(WireTransferVO wireTransferVO) {
		super(wireTransferVO);
	}

	@Override
	public void process() {
		if (wireTransferVO.isReviewed()) {
			wireTransferVO.setWireTransferState(new ReviewComplianceWireTransfer(wireTransferVO));
		} else {
			wireTransferVO.setWireTransferState(new SentWireTransfer(wireTransferVO));
		}

	}
	
	@Override
	public String toString() {
		return WireTransferStrategy
				.CONFIRMED_PAYMENT
				.name();
	}

}
