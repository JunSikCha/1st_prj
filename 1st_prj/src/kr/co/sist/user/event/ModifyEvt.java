package kr.co.sist.user.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import kr.co.sist.user.design.ModifyDesign;
import kr.co.sist.user.design.ModifyPassDesign;
import kr.co.sist.user.design.ModifyUserDesign;

public class ModifyEvt extends WindowAdapter implements ActionListener {
	private ModifyDesign md;
	
	public ModifyEvt(ModifyDesign md) {
		this.md=md;
	}//ModifyEvt

	@Override
	public void actionPerformed(ActionEvent ae) {
		//회원 정보 수정
		if(ae.getSource() == md.getJbtModifyUserDesign()) {
			ModifyUserDesign mud = new ModifyUserDesign(md);
			mud.setVisible(true);
		}
		
		//비밀번호 변경
		if(ae.getSource()  == md.getJbtModifyPassDesign()) {
			ModifyPassDesign mpd = new ModifyPassDesign(md);
			mpd.setVisible(true);
		}
		

	}
	
	public void windowClosing(WindowEvent we) {
		md.dispose();

	}


}
