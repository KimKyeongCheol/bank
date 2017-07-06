package com.hanbit.kb.service;
import java.util.Vector;
import com.hanbit.kb.domain.kbBean;
public interface kbService {
	public void createAccount(kbBean kbbean);
	public Vector<kbBean> list();
	public Vector<kbBean> findByName(String name);
	public kbBean findByAccount(int kbAccount);
	public int countAccount();
	public void updatePw(kbBean kbbean);
	public void deposit(kbBean kbbean);
	public void withdraw(kbBean kbbean);
	public void deleteAccount(int kbAccount);
	
	

}
