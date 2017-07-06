package com.hanbit.kb.domain;

public class kbBean {
	private String name,id,pw,txDate,ssn;
	private int kbAccount,money;
	public final static String kbname="KB국민은행";
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setId(String id){
		this.id=id;
	}
	public String getId() {
		return id;
	}
	public void setPw(String pw){
		this.pw=pw;
	}
	public String getPw(){
		return pw;
	}
	public void setMoney(int money){
		this.money=money;
	}
	public int getMoney(){
		return money;
	}
	public void setTxDate(String txDate){
		this.txDate=txDate;
	}
	public String geTtxDate(){
		return txDate;
	}
	public void setSsn(String ssn){
		this.ssn=ssn;
	}
	public String getSsn(){
		return ssn;
	}
	public void setkbAccount(int kbAccount){
		this.kbAccount=kbAccount;
	}
	public int getkbAccount(){
		return kbAccount;
	}
	public String toString(){
		return String.format("계좌정보[이름 :%s ,번호:%d ,거래일자 : %s ,잔액 :%d]\n 비밀번호%s", name,kbAccount,txDate,money,pw);
		
	}
}
