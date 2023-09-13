package kr.co.sist.user.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import kr.co.sist.user.dao.ModifyPassDAO;
import kr.co.sist.user.vo.ModifyPassVO;

public class ModifyPassEvt implements ActionListener {

	public void modifyPass(String id, String pass) {
		
		
		try {
			ModifyPassVO mpVO = new ModifyPassVO(id, pass);
			ModifyPassDAO mpDAO = ModifyPassDAO.getInstance();
			int cnt = mpDAO.updatePass(mpVO);
			System.out.println(cnt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

	}
	
	public static void main(String[] args) {
		new ModifyPassEvt().modifyPass("Dok2", "9898");
	}
	
}
