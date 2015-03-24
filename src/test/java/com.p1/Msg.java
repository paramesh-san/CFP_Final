package com.p1;

public class Msg {
	  String userId ;
      String currencyFrom ;
      String currencyTo;
      Long amountSell ;
      Double amountBuy;
      Double rate ;
      String timePlaced;
      String originatingCountry ;
	public Msg(String userId, String currencyFrom, String currencyTo,
			Long amountSell, Double amountBuy, Double rate, String timePlaced,
			String originatingCountry) {
		super();
		this.userId = userId;
		this.currencyFrom = currencyFrom;
		this.currencyTo = currencyTo;
		this.amountSell = amountSell;
		this.amountBuy = amountBuy;
		this.rate = rate;
		this.timePlaced = timePlaced;
		this.originatingCountry = originatingCountry;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCurrencyFrom() {
		return currencyFrom;
	}
	public void setCurrencyFrom(String currencyFrom) {
		this.currencyFrom = currencyFrom;
	}
	public String getCurrencyTo() {
		return currencyTo;
	}
	public void setCurrencyTo(String currencyTo) {
		this.currencyTo = currencyTo;
	}
	public Long getAmountSell() {
		return amountSell;
	}
	public void setAmountSell(Long amountSell) {
		this.amountSell = amountSell;
	}
	public Double getAmountBuy() {
		return amountBuy;
	}
	public void setAmountBuy(Double amountBuy) {
		this.amountBuy = amountBuy;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	public String getTimePlaced() {
		return timePlaced;
	}
	public void setTimePlaced(String timePlaced) {
		this.timePlaced = timePlaced;
	}
	public String getOriginatingCountry() {
		return originatingCountry;
	}
	public void setOriginatingCountry(String originatingCountry) {
		this.originatingCountry = originatingCountry;
	}
      
}
