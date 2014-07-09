package com.tikal.traders.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "transactions")
public class Transaction {

	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "trader_id")
	@NotNull
	private Trader trader;

	@NotNull
	private int year;

	@NotNull
	private int value;

	public Transaction() {
	}

	public Transaction(final Trader trader, final int year, final int value) {
		this.trader = trader;
		this.year = year;
		this.value = value;
	}

	public Integer getId() {
		return id;
	}

	public Trader getTrader() {
		return trader;
	}

	public int getYear() {
		return year;
	}

	public int getValue() {
		return value;
	}
	
	

	public void setTrader(final Trader trader) {
		this.trader = trader;
	}

	public void setYear(final int year) {
		this.year = year;
	}

	public void setValue(final int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", trader=" + trader + ", year="
				+ year + ", value=" + value + "]";
	}
	
	

}
