package kr.co.sist.user.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.sist.user.dao.ModifyUserDAO;
import kr.co.sist.user.design.ModifyUserDesign;
import kr.co.sist.user.vo.ModifyUserVO;

public class ModifyUserEvt extends WindowAdapter implements ActionListener {
	
	private ModifyUserDesign mud;
	
	public ModifyUserEvt(ModifyUserDesign mud) {
		this.mud=mud;
	}

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
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==mud.getJbtComplete()) {
			modifyUserMessage();
		}

	}
	public void modifyUserMessage() {
		JOptionPane.showMessageDialog(mud, "수정이 완료되었습니다.");
	}
	

	@Override
	public void windowClosing(WindowEvent we) {
		mud.dispose();
	}

}
