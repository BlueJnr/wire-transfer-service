package com.bluejnr.wiretransfer.pattern.state.impl;

import com.bluejnr.wiretransfer.model.domain.WireTransferVO;
import com.bluejnr.wiretransfer.pattern.state.WireTransferState;
import com.bluejnr.wiretransfer.pattern.strategy.WireTransferStrategy;

public class StartedWireTranfer extends WireTransferState {

	public StartedWireTranfer(WireTransferVO wireTransferVO) {
		super(wireTransferVO);
	}

	@Override
	public void process() {
		wireTransferVO.setWireTransferState(new CreatedWireTranfer(wireTransferVO));
	}
	
	@Override
	public String toString() {
		return WireTransferStrategy
				.STARTED
				.name();
	}

}
