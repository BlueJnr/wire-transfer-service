package com.bluejnr.wiretransfer.pattern.state;

import com.bluejnr.wiretransfer.model.domain.WireTransferVO;

public abstract class WireTransferState {

	protected WireTransferVO wireTransferVO;

	public WireTransferState(WireTransferVO wireTransferVO) {
		this.wireTransferVO = wireTransferVO;
	}
	
	public abstract void process();
}
