package kr.co.sist.user.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

import kr.co.sist.user.dao.JoinDAO;
import kr.co.sist.user.design.JoinDesign;
import kr.co.sist.user.vo.JoinVO;

public class JoinDesignEvt extends WindowAdapter implements ActionListener {

	private JoinDesign jd;
	private boolean dopFlag;
	private boolean validateFlag;
	private boolean checked;
	
	public JoinDesignEvt(JoinDesign jd) {
		this.jd=jd;
	}
	
	public JoinVO newMemberInfo() {
		String id = jd.getJtfId().getText().trim();
		String pw = String.valueOf(jd.getJpwPass().getPassword());
		String name = jd.getJtfName().getText().trim();
		String tel = jd.getJtfPhNum().getText().trim();
		String email = jd.getJtfEmail().getText().trim();
		JoinVO jVO = new JoinVO(id, pw, name, tel, email);
		
		return jVO; 
		}
	
	public void validate() {
		//id검증
		String id = jd.getJtfId().getText().trim();
		if( "".equals(id)) {
			JOptionPane.showMessageDialog(jd, "아이디를 입력해주세요.");
			validateFlag = false;
			return;
		}
		//pw검증
		String pw = String.valueOf(jd.getJpwPass().getPassword());
		if( "".equals(pw)) {
			JOptionPane.showMessageDialog(jd, "비밀번호를 입력해주세요.");
			validateFlag = false;
			return;
		}
		if(pw.length()>=30) {
			JOptionPane.showMessageDialog(jd, "비밀번호가 너무 깁니다.");
			validateFlag = false;
			return;
		}
		String confirmPw=String.valueOf(jd.getJtfCheckPass().getPassword());
		//pw와 확인pw가 다를때
		if(!pw.equals(confirmPw)) {
			JOptionPane.showMessageDialog(jd,"비밀번호를 다시 확인해주세요");
			return;
		}
			
		
		//이름검증
		String name = jd.getJtfName().getText().trim();
		if( "".equals(name)) {
			JOptionPane.showMessageDialog(jd, "이름을 입력해주세요.");
			validateFlag = false;
			return;
		}
		
		//핸드폰 검증
		String tel = jd.getJtfPhNum().getText().trim();
				
		if( "".equals(tel)) {
			JOptionPane.showMessageDialog(jd, "전화번호를 입력해주세요.");
			validateFlag = false;
			return;
		}
		String regexTel = "\\d{3}-\\d{4}-\\d{4}";
		if(!tel.matches(regexTel)) {;
		JOptionPane.showMessageDialog(jd, tel+"은(는) 잘못된 형식 입니다.");
		validateFlag = false;
		return;
		}

		//이메일 검증
		String email = jd.getJtfEmail().getText().trim();
			//이메일 칸 공백
		if( "".equals(email)) {
			JOptionPane.showMessageDialog(jd, "이메일 주소를 입력해주세요.");
			validateFlag = false;
			return;
		}
			//이메일이 너무 길때
		if(email.length() >=30 ) {
			JOptionPane.showMessageDialog(jd, email + "은(는) 이메일이 너무 깁니다.");
			validateFlag = false;
			return;
		}
			//이메일 형식과 다를때
		 String regexEmail = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$";
	     Pattern pattern = Pattern.compile(regexEmail);
	     Matcher matcher =  pattern.matcher(email);
		if (!matcher.matches()) {
            JOptionPane.showMessageDialog(jd, email + "은(는) 유효하지 않은 형식입니다.");
            validateFlag = false;
            return;
        }
		validateFlag = true;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		//ID중복검사 버튼을 눌렀을 때.
		if(ae.getSource()==jd.getJbtldCheck()) {
			String id=jd.getJtfId().getText().trim();
			//빈칸으로 눌렀을때
			if( "".equals(id)) {
				JOptionPane.showMessageDialog(jd, "아이디를 입력해주세요.");
				return;
			}
			JoinDAO jDAO=new JoinDAO();
			try {
				checked=jDAO.IdCheck(id);
				//중복 ID일 경우 IdCheck에서 T가 반환되고, 아닐경우 F반환.
				if(checked) {
					JOptionPane.showMessageDialog(jd, "중복된 아이디 입니다.");
					 jd.getJtfId().setText("");
					return;
				}
				JOptionPane.showMessageDialog(jd, "사용 가능한 아이디 입니다.");
				dopFlag=true; //중복검사를 눌렀는지 안눌렀는지에대한 유무.
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//확인 버튼을 눌렀을 때.
		if(ae.getSource()==jd.getJbtOk()) {
			//중복검사를 실행하지 않았다면.
			if(!dopFlag) { //dopFlag 가 True라면 !가 붙어 F가 되고, False라면 True가 됨.
				JOptionPane.showMessageDialog(jd,"ID 중복 검사를 실행해주세요.");
				return;
			}
			//중복인 ID로 확인버튼을 눌렀을 때.
			if(checked) {
				JOptionPane.showConfirmDialog(jd,"ID를 다시 확인해주세요");
				return;
				}
			//기입된 정보의 유효성 검증
			validate();
			if(!validateFlag) {
				return;
			}
			
						
			JoinDAO jDAO = new JoinDAO();
			try {
				boolean memberJoin = jDAO.createId(newMemberInfo());
				if(memberJoin) {
					JOptionPane.showMessageDialog(jd,"성공적으로 회원등록이 완료되었습니다.");
					jd.dispose();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		
		//취소버튼 눌렀을때.
		if(ae.getSource()==jd.getJbtCancel()) {
			jd.dispose();
			}
		}
 
	@Override
	public void windowClosing(WindowEvent we) {
		jd.dispose();
	}
	
}
