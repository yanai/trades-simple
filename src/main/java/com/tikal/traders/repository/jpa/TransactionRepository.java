package com.tikal.traders.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tikal.traders.domain.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

	@Query("select t from Transaction t where t.year=?1 order by value")
	List<Transaction> findAllTransactions(int year);
	
	

}
