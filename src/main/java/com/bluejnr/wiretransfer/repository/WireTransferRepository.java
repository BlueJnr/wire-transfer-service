package com.bluejnr.wiretransfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bluejnr.wiretransfer.model.entity.Transfer;

public interface WireTransferRepository extends JpaRepository<Transfer, Integer>{

}
