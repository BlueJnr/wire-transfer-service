package com.bluejnr.wiretransfer.pattern.state.impl;

import com.bluejnr.wiretransfer.model.domain.WireTransferVO;
import com.bluejnr.wiretransfer.pattern.state.WireTransferState;
import com.bluejnr.wiretransfer.pattern.strategy.WireTransferStrategy;

public class ReviewComplianceWireTransfer extends WireTransferState {

	public ReviewComplianceWireTransfer(WireTransferVO wireTransferVO) {
		super(wireTransferVO);
	}

	@Override
	public void process() {
		wireTransferVO.setWireTransferState(new ConfirmedPaymentWireTransfer(wireTransferVO));
	}

	@Override
	public String toString() {
		return WireTransferStrategy
				.REVIEW_COMPLIANCE
				.name();
	}
}
