package com.bluejnr.wiretransfer.pattern.state.impl;

import java.util.EnumSet;

import com.bluejnr.wiretransfer.exception.ChangeStateException;
import com.bluejnr.wiretransfer.model.domain.WireTransferVO;
import com.bluejnr.wiretransfer.pattern.state.WireTransferState;
import com.bluejnr.wiretransfer.pattern.strategy.WireTransferStrategy;

public class WaitingPaymentWireTransfer extends WireTransferState {

	public WaitingPaymentWireTransfer(WireTransferVO wireTransferVO) {
		super(wireTransferVO);
		addPossibleStates();
	}

	@Override
	public void process(WireTransferStrategy nextStatus) {
		if (possibleStates.contains(nextStatus)) {
			wireTransferVO.setState(nextStatus.get(wireTransferVO));
		} else {
			throw new ChangeStateException("Cambio de estado no permitido: WAITING_PAYMENT -> " + nextStatus.name());
		}
	}

	@Override
	public String toString() {
		return WireTransferStrategy.WAITING_PAYMENT.name();
	}

	@Override
	public void addPossibleStates() {
		possibleStates = EnumSet.of(WireTransferStrategy.CANCELED, WireTransferStrategy.EXPIRED,
				WireTransferStrategy.REJECTED, WireTransferStrategy.CONFIRMED_PAYMENT);
	}
}
