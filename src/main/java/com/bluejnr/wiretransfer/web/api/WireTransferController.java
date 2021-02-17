package com.bluejnr.wiretransfer.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluejnr.wiretransfer.model.api.WireTransfer;
import com.bluejnr.wiretransfer.service.WireTransferService;

@RestController
@RequestMapping("/wire-transfer")
public class WireTransferController {

	@Autowired
	private WireTransferService wireTransferService;
	
	@PutMapping("/process")
	public void process(@RequestBody WireTransfer wireTransfer) {
		wireTransferService.process(wireTransfer);
	}
}
