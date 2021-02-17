package com.bluejnr.wiretransfer.model.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WireTransfer {
	
	private Integer id;
	private String wireTransferState;
	private boolean rejected;
	private boolean expired;
	private boolean canceled;
	private boolean reviewed;
	
}
