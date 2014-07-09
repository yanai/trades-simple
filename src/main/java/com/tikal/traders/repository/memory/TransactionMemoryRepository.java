package com.tikal.traders.repository.memory;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.tikal.traders.domain.entity.Trader;
import com.tikal.traders.domain.entity.Transaction;

@Component
public class TransactionMemoryRepository {
	private List<Transaction> transactions;
	private List<Trader> traders;
	
	public List<Transaction> getTransactions() {
		return transactions;
	}


	public List<Trader> getTraders() {
		return traders;
	}


	@PostConstruct
	private void init(){
		final Trader raoul = new Trader("Raoul", "Cambridge");
		final Trader mario = new Trader("Mario","Milan");
		final Trader alan = new Trader("Alan","Cambridge");
		final Trader brian = new Trader("Brian","Cambridge");
		traders = Arrays.asList(raoul,mario,alan,brian);
		
		transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950));
	}

	
	public List<Transaction> findAllTransactions(final int year){
		return transactions.stream()
				.filter(transaction -> transaction.getYear() == year) 
				.sorted(comparing(Transaction::getValue)) 
				.collect(toList());
	}
	
	public Set<String> findTransactionTradersCities(){
		return 	transactions.stream()
				.map(transaction -> transaction.getTrader().getCity())
				.distinct()
				.collect(toSet());
	}
	
	public List<Trader> findAllTransactionTradersFrom(final String city){
		return transactions.stream()
				.map(Transaction::getTrader) 
				.filter(trader -> trader.getCity().equals(city)) 
				.distinct() 
				.sorted(comparing(Trader::getName)) 
				.collect(toList());
	}

}
