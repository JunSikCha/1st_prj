package manager.MyInformation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class MyInformationSubWindowEvt implements ActionListener {

	private MyInformationSubWindow misw;
	private MyInformationTab mit;
	private int empNo;

	public MyInformationSubWindowEvt(MyInformationTab mit, MyInformationSubWindow misw) {
		this.mit = mit;
		this.misw = misw;
		empNo = Integer.parseInt(mit.getJtfEmpNo().getText());
	}

	public void phone() {
		String phone = misw.getJtfManagerPhone().getText();
		if (!phone.isEmpty()) {
			String phone_regex = "^(\\d{3}-\\d{4}-\\d{4})$";
			Pattern pattern = Pattern.compile(phone_regex);
			// 주어진 이메일 주소와 패턴을 비교합니다.
			Matcher matcher = pattern.matcher(phone);

			if (!matcher.matches()) {
				JOptionPane.showMessageDialog(misw, "전화번호 양식이 틀립니다 양식에 맞게 작성해주세요");
				misw.getJtfManagerPhone().setText("");
				misw.getJtfManagerPhone().requestFocus();
				return;
			}
			MyInformationDAO miDAO = MyInformationDAO.getInstance();
			try {
				miDAO.updateEmpPhone(phone, empNo);
				mit.getJtfManagerPhone().setText(phone);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void email() {
		String email = misw.getJtfManagerEmail().getText();
		if (!email.isEmpty()) {
			String email_regex = "^[A-Za-z0-9+_.-]+@(.+)$";
			// 이메일 주소의 유효성을 검사하기 위한 정규 표현식 패턴을 컴파일합니다.
			Pattern pattern = Pattern.compile(email_regex);
			// 주어진 이메일 주소와 패턴을 비교합니다.
			Matcher matcher = pattern.matcher(email);

			if (!matcher.matches()) {
				JOptionPane.showMessageDialog(misw, "이메일 양식이 틀립니다 양식에 맞게 작성해주세요");
				misw.getJtfManagerEmail().setText("");
				misw.getJtfManagerEmail().requestFocus();
				return;
			}

			MyInformationDAO miDAO = MyInformationDAO.getInstance();
			try {
				miDAO.updateEmpEmail(email, empNo);
				mit.getJtfManagerEmail().setText(email);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	public void password() {

		String password = String.valueOf(misw.getJpfPassword().getPassword());
		String passwordConfirm = String.valueOf(misw.getJpfPasswordConfirm().getPassword());
		String passwordStr = "";

		if (!password.equals("") && !passwordConfirm.equals("")) {
			if (!password.equals(passwordConfirm)) {
				JOptionPane.showMessageDialog(misw, "비밀번호가 일치하지 않습니다.");
				misw.getJpfPassword().setText("");
				misw.getJpfPasswordConfirm().setText("");
				misw.getJpfPassword().requestFocus();
				return;
			}
			passwordStr = String.valueOf(password);
			MyInformationDAO miDAO = MyInformationDAO.getInstance();
			try {
				miDAO.updateEmpPass(passwordStr, empNo);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == misw.getJbConfirm()) {
			phone();
			email();
			password();
			misw.dispose();

		}
	}

}
