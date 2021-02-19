package com.bluejnr.wiretransfer.model.domain;

import com.bluejnr.wiretransfer.pattern.state.WireTransferState;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class WireTransferVO {
	
	private Integer id;
	private WireTransferState state;
	private String description;
	
}
