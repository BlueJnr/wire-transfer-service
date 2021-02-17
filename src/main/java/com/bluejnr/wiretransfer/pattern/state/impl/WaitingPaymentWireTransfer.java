package com.bluejnr.wiretransfer.pattern.state.impl;

import com.bluejnr.wiretransfer.model.domain.WireTransferVO;
import com.bluejnr.wiretransfer.pattern.state.WireTransferState;
import com.bluejnr.wiretransfer.pattern.strategy.WireTransferStrategy;

public class WaitingPaymentWireTransfer extends WireTransferState {

	public WaitingPaymentWireTransfer(WireTransferVO wireTransferVO) {
		super(wireTransferVO);
	}

	@Override
	public void process() {
		if (wireTransferVO.isExpired()) {
			wireTransferVO.setWireTransferState(new ExpiredWireTransfer(wireTransferVO));
		} else {
			if (wireTransferVO.isCanceled()) {
				wireTransferVO.setWireTransferState(new CanceledWireTransfer(wireTransferVO));
			} else {
				if (wireTransferVO.isRejected()) {
					wireTransferVO.setWireTransferState(new RejectedWireTransfer(wireTransferVO));
				} else {
					wireTransferVO.setWireTransferState(new ConfirmedPaymentWireTransfer(wireTransferVO));
				}
			}
		}
		
	}

	
	@Override
	public String toString() {
		return WireTransferStrategy
				.WAITING_PAYMENT
				.name();
	}
}
