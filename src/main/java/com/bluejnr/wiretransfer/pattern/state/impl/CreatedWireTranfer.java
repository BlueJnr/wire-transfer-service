package com.bluejnr.wiretransfer.pattern.state.impl;

import java.util.EnumSet;

import com.bluejnr.wiretransfer.exception.ChangeStateException;
import com.bluejnr.wiretransfer.model.domain.WireTransferVO;
import com.bluejnr.wiretransfer.pattern.state.WireTransferState;
import com.bluejnr.wiretransfer.pattern.strategy.WireTransferStrategy;

public class CreatedWireTranfer extends WireTransferState {

	public CreatedWireTranfer(WireTransferVO wireTransferVO) {
		super(wireTransferVO);
		addPossibleStates();
	}

	@Override
	public void process(WireTransferStrategy nextStatus) {
		if (possibleStates.contains(nextStatus)) {
			wireTransferVO.setState(nextStatus.get(wireTransferVO));
		} else {
			throw new ChangeStateException("Cambio de estado no permitido: CREATED -> " + nextStatus.name());
		}
	}

	@Override
	public String toString() {
		return WireTransferStrategy.CREATED.name();
	}

	@Override
	public void addPossibleStates() {
		possibleStates = EnumSet.of(WireTransferStrategy.EXPIRED, WireTransferStrategy.CANCELED,
				WireTransferStrategy.WAITING_PAYMENT);
	}

}
