package kr.co.sist.user.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.sist.user.dao.JoinDAO;
import kr.co.sist.user.design.JoinDesign;
import kr.co.sist.user.vo.JoinVO;

public class JoinDesignEvt extends WindowAdapter implements ActionListener {

	private JoinDesign jd;
	private boolean dopFlag;
	private boolean checked;
	
	public JoinDesignEvt(JoinDesign jd) {
		this.jd=jd;
	}
	
	public JoinVO newMemberInfo() {
		String id = jd.getJtfId().getText();
		String pw = String.valueOf(jd.getJpwPass().getPassword());
		String name = jd.getJtfName().getText();
		String tel = jd.getJtfPhNum().getText();
		String email = jd.getJtfEmail().getText();
		JoinVO jVO = new JoinVO(id, pw, name, tel, email);
		
		return jVO; 
		}
	
	public void validate() {
		
		String id = jd.getJtfId().getText().trim();
		if( "".equals(id)) {
			JOptionPane.showMessageDialog(jd, "아이디를 입력해주세요.");
			return;
		}
		
		String pw = String.valueOf(jd.getJpwPass().getPassword());
		if( "".equals(pw)) {
			JOptionPane.showMessageDialog(jd, "아이디를 입력해주세요.");
			return;
		}
		
		String name = jd.getJtfName().getText();
		if( "".equals(name)) {
			JOptionPane.showMessageDialog(jd, "아이디를 입력해주세요.");
			return;
		}
		
		String tel = jd.getJtfPhNum().getText();
		if( "".equals(tel)) {
			JOptionPane.showMessageDialog(jd, "아이디를 입력해주세요.");
			return;
		}
		
		String email = jd.getJtfEmail().getText();
		if( "".equals(email)) {
			JOptionPane.showMessageDialog(jd, "아이디를 입력해주세요.");
			return;
		}
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		//ID중복검사 버튼을 눌렀을 때.
		if(ae.getSource()==jd.getJbtldCheck()) {
			String id=jd.getJtfId().getText().trim();
			if( "".equals(id)) {
				JOptionPane.showMessageDialog(jd, "아이디를 입력해주세요.");
				return;
			}
			
			JoinDAO jDAO=new JoinDAO();
			try {
				checked=jDAO.IdCheck(id);
				if(checked) {
					JOptionPane.showMessageDialog(jd, "중복된 아이디 입니다.");
					 jd.getJtfId().setText("");
					return;
				}
				JOptionPane.showMessageDialog(jd, "사용 가능한 아이디 입니다.");
				dopFlag=true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(ae.getSource()==jd.getJbtOk()) {
			if(!dopFlag) {
				JOptionPane.showMessageDialog(jd,"ID 중복 검사를 실행해주세요.");
				return;
			}
			
			if(checked) {
				JOptionPane.showConfirmDialog(jd,"정보를 다시 확인해주세요");
				return;
				}
			String pw=jd.getJtfId().getText().trim();
			String confirmPw=jd.getJtfId().getText().trim();
			
			JoinDAO jDAO = new JoinDAO();
			try {
				boolean memberJoin = jDAO.createId(newMemberInfo());
				if(memberJoin) {
					JOptionPane.showConfirmDialog(jd,"성공적으로 회원등록이 완료되었습니다.");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		
		if(ae.getSource()==jd.getJbtCancel()) {
			jd.dispose();
			}
		}
 
	@Override
	public void windowClosing(WindowEvent we) {
		jd.dispose();
	}
	
}
