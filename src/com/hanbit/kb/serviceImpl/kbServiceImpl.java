package com.hanbit.kb.serviceImpl;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Vector;

import com.hanbit.kb.domain.kbBean;
import com.hanbit.kb.service.kbService;

public class kbServiceImpl implements kbService{
	Vector<kbBean> vec;
	kbBean kbb;
	int count=0;
	public kbServiceImpl(){
		vec=new Vector<kbBean>(10,10);
		
	}
	
	@Override
	public void createAccount(kbBean kbbean) {
		// 계좌개설
		Calendar now=Calendar.getInstance();
		int yy=now.get(now.YEAR);
		int mm=now.get(now.MONTH)+1;
		int dd=now.get(now.DAY_OF_MONTH);
		int randomNo=(int)(Math.random()*99+10);
		kbbean.setTxDate(String.format("%d년%d월%d일",yy,mm,dd));
		kbbean.setkbAccount(randomNo);
		vec.add(kbbean);
	}

	@Override
	public Vector<kbBean> list() {
		//계좌전체목록
		return vec;
	}
	@Override
	public Vector<kbBean> findByName(String name) {
		// 이름검색(동명이인 허용)
		Vector<kbBean> temp=new Vector<>();
		for(int i=0;i<vec.size();i++){
			if(name.equals(vec.get(i).getName())){
				temp.add(vec.get(i));
			}
		}
		return temp;
		
		
	}

	@Override
	public kbBean findByAccount(int kbAccount) {
		// 계좌번호 조회
		kbb=new kbBean();
		for(int i=0;i<vec.size();i++){
			if(kbAccount==vec.get(i).getkbAccount()){
				kbb=vec.get(i);
				break;
			}
		}
		return kbb;
	}

	@Override
	public int countAccount() {
		// 전체 개좌수
		return vec.size();
	}

	@Override
	public void updatePw(kbBean kbbean) {
		// 비밀번호 변경
		kbb=findByAccount(kbbean.getkbAccount());
		kbb.setPw(kbbean.getPw());
	}

	@Override
	public void deposit(kbBean kbbean) {
		// 예금
		
		for(int i=0;i<vec.size();i++){
			if(vec.get(i).getkbAccount()==kbbean.getkbAccount()){
				vec.get(i).setMoney(vec.get(i).getMoney()+kbbean.getMoney());
				
				
			}
		}
		
	}

	@Override
	public void withdraw(kbBean kbbean) {
		// 출금
		for(int i=0;i<vec.size();i++){
			if(vec.get(i).getkbAccount()==kbbean.getkbAccount()){
				vec.get(i).setMoney(vec.get(i).getMoney()-kbbean.getMoney());
				
				
			}
		}
	}

	@Override
	public void deleteAccount(int kbAccount) {
		// 계좌해지
		for(int i=0;i<vec.size();i++){
			if(kbAccount==vec.get(i).getkbAccount()){
				vec.remove(vec.get(i));
				
			}
		}
	}

	
	
}
