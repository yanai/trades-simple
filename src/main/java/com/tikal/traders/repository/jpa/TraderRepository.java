package com.tikal.traders.repository.jpa;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tikal.traders.domain.entity.Trader;

public interface TraderRepository extends JpaRepository<Trader, Integer>{

	@Query("select distinct t.trader.city from Transaction t")
	Set<String> findTransactionTradersCities();
	
	@Query("select distinct trader from Transaction t "
		+  "join t.trader trader "
		+  " where trader.city=?1 order by trader.city")
	List<Trader> findAllTradersTradersFrom(String city);
}
