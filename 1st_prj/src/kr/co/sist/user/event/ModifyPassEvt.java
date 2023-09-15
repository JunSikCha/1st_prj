package kr.co.sist.user.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.sist.user.dao.ModifyPassDAO;
import kr.co.sist.user.design.ModifyPassDesign;
import kr.co.sist.user.vo.ModifyPassVO;

public class ModifyPassEvt extends WindowAdapter implements ActionListener {
	
	private ModifyPassDesign mpd;
	
	public ModifyPassEvt(ModifyPassDesign mpd) {
		this.mpd=mpd;
	}

	
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
	public void actionPerformed(ActionEvent ae) {

		if(ae.getSource()==mpd.getJbtComplete()) {
			modifyPassMessage();
		}
		
	}
	
	public void modifyPassMessage() {
		JOptionPane.showMessageDialog(mpd, "변경이 완료되었습니다.");
	}

	@Override
	public void windowClosing(WindowEvent we) {
		
	}

	
}
