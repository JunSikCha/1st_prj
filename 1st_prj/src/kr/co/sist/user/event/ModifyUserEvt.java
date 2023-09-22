package kr.co.sist.user.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import kr.co.sist.user.dao.ModifyUserDAO;
import kr.co.sist.user.design.ModifyUserDesign;
import kr.co.sist.user.vo.ModifyUserVO;

public class ModifyUserEvt extends WindowAdapter implements ActionListener {

	private ModifyUserDesign mud;

	public ModifyUserEvt(ModifyUserDesign mud) {
		this.mud = mud;
	}//ModifyUserEvt

	public void modifyUser() {
		ModifyUserVO muVO = new ModifyUserVO();

		try {

			muVO.setUserTel(mud.getJtfPhoneNum().getText());
			muVO.setUserEmail(mud.getJtfEmail().getText());
			muVO.setUserID(UserData.id);

			ModifyUserDAO muDAO = ModifyUserDAO.getInstance();
			int cnt = muDAO.updateUser(muVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}// modifyUser

	public Boolean userValidate() {

		// 전화번호 검증
		String tel = mud.getJtfPhoneNum().getText();

		if ("".equals(tel)) {
			JOptionPane.showMessageDialog(mud, "전화번호를 입력해주세요.");
			return false;
		}
		String regexTel = "\\d{3}-\\d{4}-\\d{4}";
		if (!tel.matches(regexTel)) {
			;
			JOptionPane.showMessageDialog(mud, tel + "은(는) 잘못된 형식 입니다.");
			return false;
		}

		// 이메일 검증
		String email = mud.getJtfEmail().getText();
		// 이메일 칸 공백
		if ("".equals(email)) {
			JOptionPane.showMessageDialog(mud, "이메일 주소를 입력해주세요.");
			return false;
		}
		// 이메일이 너무 길때
		if (email.length() >= 30) {
			JOptionPane.showMessageDialog(mud, email + "은(는) 이메일이 너무 깁니다.");
			return false;
		}
		// 이메일 형식과 다를때
		String regexEmail = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$";
		Pattern pattern = Pattern.compile(regexEmail);
		Matcher matcher = pattern.matcher(email);
		if (!matcher.matches()) {
			JOptionPane.showMessageDialog(mud, email + "은(는) 유효하지 않은 형식입니다.");
			return false;
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == mud.getJbtComplete()) {
			if(userValidate()) { //유효성검사를 통과했을때
				modifyUser(); //회원정보 수정
				JOptionPane.showMessageDialog(mud, "수정이 완료되었습니다.");
			}
		}

	}

	@Override
	public void windowClosing(WindowEvent we) {
		mud.dispose();
	}

}
