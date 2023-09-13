package kr.co.sist.user.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import kr.co.sist.user.dao.ModifyUserDAO;
import kr.co.sist.user.vo.ModifyUserVO;

public class ModifyUserEvt implements ActionListener {

	public void modifyUser(String id, String tel, String email) {
		
		try {
			ModifyUserVO muVO = new ModifyUserVO(id, tel, email);
			ModifyUserDAO muDAO = ModifyUserDAO.getInstance();
			int cnt=muDAO.updateUser(muVO);
			System.out.println(cnt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}//modifyUser
	
	public void userValidate() {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public static void main(String[] args) {
		new ModifyUserEvt().modifyUser("kanna3", "010-9898-9898", "test@email");
	}

}
