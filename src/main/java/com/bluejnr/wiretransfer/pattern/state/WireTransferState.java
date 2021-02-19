package com.bluejnr.wiretransfer.pattern.state;

import java.util.EnumSet;

import com.bluejnr.wiretransfer.model.domain.WireTransferVO;
import com.bluejnr.wiretransfer.pattern.strategy.WireTransferStrategy;

public abstract class WireTransferState {

	protected EnumSet<WireTransferStrategy> possibleStates;
	protected WireTransferVO wireTransferVO;

	public WireTransferState(WireTransferVO wireTransferVO) {
		this.wireTransferVO = wireTransferVO;
	}
	
	public abstract void process(WireTransferStrategy nextStatus);
	public abstract void addPossibleStates();
}
