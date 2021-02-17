package com.bluejnr.wiretransfer.pattern.state.impl;

import com.bluejnr.wiretransfer.model.domain.WireTransferVO;
import com.bluejnr.wiretransfer.pattern.state.WireTransferState;
import com.bluejnr.wiretransfer.pattern.strategy.WireTransferStrategy;

public class SentWireTransfer extends WireTransferState {

	public SentWireTransfer(WireTransferVO wireTransferVO) {
		super(wireTransferVO);
	}

	@Override
	public void process() {
		if (wireTransferVO.isRejected()) {
			wireTransferVO.setWireTransferState(new RejectedWireTransfer(wireTransferVO));
		} else {
			if (wireTransferVO.isReviewed()) {
				wireTransferVO.setWireTransferState(new ReviewDataWrongWireTransfer(wireTransferVO));
			} else {
				wireTransferVO.setWireTransferState(new SuccessfulWireTransfer(wireTransferVO));
			}
		}

	}
	
	@Override
	public String toString() {
		return WireTransferStrategy
				.SENT
				.name();
	}

}
