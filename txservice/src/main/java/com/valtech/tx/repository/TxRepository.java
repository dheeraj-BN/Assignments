package com.valtech.tx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.tx.entity.Tx;

@Repository
public interface TxRepository extends JpaRepository<Tx, Long> {
	

}
