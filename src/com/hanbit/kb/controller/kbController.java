package com.hanbit.kb.controller;

import java.util.Vector;

import javax.swing.JOptionPane;

import com.hanbit.kb.domain.kbBean;
import com.hanbit.kb.service.kbService;
import com.hanbit.kb.serviceImpl.kbServiceImpl;

public class kbController {
	
	public static void main(String[] args) {
		kbService kService=new kbServiceImpl();
		kbBean bean=new kbBean();
	while(true){
		switch (JOptionPane.showInputDialog("0.종료 1.계좌개설 2.계좌전체목록 3.이름검색(동명이인 허용) "
				+ "4.계좌번호 조회 5. 전체 개좌수 6.비밀번호 변경 7.예금 8.출금 9.계좌해지")) {
		case "0":
			JOptionPane.showMessageDialog(null, "종료합니다.");
			return;
		case "1":
			bean =new kbBean();
			String[] info=JOptionPane.showInputDialog("이름/ID/PW/입금액/SSN").split("/");
			bean.setName(info[0]);
			bean.setId(info[1]);
			bean.setPw(info[2]);
			bean.setMoney(Integer.parseInt(info[3]));
			bean.setSsn(info[4]);
			kService.createAccount(bean);
			JOptionPane.showMessageDialog(null, "계좌생성");
			break;
		case "2":
			Vector<kbBean> vec=kService.list();
			JOptionPane.showMessageDialog(null, vec);
			break;
		case "3":
			Vector<kbBean> vec2=kService.findByName(JOptionPane.showInputDialog("이름"));
			JOptionPane.showMessageDialog(null, vec2);
			break;
		case "4":
			bean =new kbBean();
			bean=kService.findByAccount(Integer.parseInt(JOptionPane.showInputDialog("계좌번호")));
			JOptionPane.showMessageDialog(null, bean);
			break;
		case "5":
			bean =new kbBean();
			int count=kService.countAccount();
			JOptionPane.showMessageDialog(null, count);
			break;
		case "6":
			bean =new kbBean();
			String[] baz=JOptionPane.showInputDialog("계좌번호/비밀번호").split("/");
			bean.setkbAccount(Integer.parseInt(baz[0]));
			bean.setPw(baz[1]);
			kService.updatePw(bean);
			JOptionPane.showMessageDialog(null, bean);
			break;
		case "7":
			bean =new kbBean();
			String[] foo=JOptionPane.showInputDialog("계좌번호/예금금액").split("/");
			bean.setkbAccount(Integer.parseInt(foo[0]));
			bean.setMoney(Integer.parseInt(foo[1]));
			kService.deposit(bean);
			JOptionPane.showMessageDialog(null, "입금완료");
			break;
		case "8":
			bean =new kbBean();
			String[] bar=JOptionPane.showInputDialog("계좌번호/출금금액").split("/");
			bean.setkbAccount(Integer.parseInt(bar[0]));
			bean.setMoney(Integer.parseInt(bar[1]));
			kService.withdraw(bean);
			JOptionPane.showMessageDialog(null, "출금완료");
			break;
		case "9":
			bean =new kbBean();
			kService.deleteAccount(Integer.parseInt(JOptionPane.showInputDialog("계좌번호")));
			JOptionPane.showMessageDialog(null, "삭제되었습니다.");
			break;
		default:
			JOptionPane.showMessageDialog(null, "잘못입력하셨습니다.\n 확인하여 다시 입력하세요.");
			break;
		}
	}
}
}
