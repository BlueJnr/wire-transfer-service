package com.bluejnr.wiretransfer.pattern.state.impl;

import java.util.EnumSet;

import com.bluejnr.wiretransfer.exception.ChangeStateException;
import com.bluejnr.wiretransfer.model.domain.WireTransferVO;
import com.bluejnr.wiretransfer.pattern.state.WireTransferState;
import com.bluejnr.wiretransfer.pattern.strategy.WireTransferStrategy;

public class ReviewDataWrongWireTransfer extends WireTransferState {

	public ReviewDataWrongWireTransfer(WireTransferVO wireTransferVO) {
		super(wireTransferVO);
		addPossibleStates();
	}

	@Override
	public void process(WireTransferStrategy nextStatus) {
		if (possibleStates.contains(nextStatus)) {
			wireTransferVO.setState(nextStatus.get(wireTransferVO));
		} else {
			throw new ChangeStateException("Cambio de estado no permitido: REVIEW_DATA_WRONG -> " + nextStatus.name());
		}
	}

	@Override
	public String toString() {
		return WireTransferStrategy.REVIEW_DATA_WRONG.name();
	}

	@Override
	public void addPossibleStates() {
		possibleStates = EnumSet.of(WireTransferStrategy.CONFIRMED_PAYMENT);
	}

}
