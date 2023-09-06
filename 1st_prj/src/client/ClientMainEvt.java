package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClientMainEvt extends WindowAdapter implements ActionListener {

	private ClientMainDesign cmd;

	public ClientMainEvt(ClientMainDesign cmd) {
		this.cmd = cmd;
	}// ClientMainEvt

	@Override
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == cmd.getJbtRegist()) {
			RegistCarDesign rcd = new RegistCarDesign();
			rcd.setVisible(true);
		} // end if
		
		if (ae.getSource() == cmd.getJbtModify()) {
			ModifyDesign md = new ModifyDesign();
			md.setVisible(true);
		}
		
		if (ae.getSource() == cmd.getJbtHistory()) {
			HistoryDesign hd = new HistoryDesign();
			hd.setVisible(true);
		}
		
		if(ae.getSource() == cmd.getJbtBook()) {
			BookingDesign bd = new BookingDesign();
			bd.setVisible(true);
		}
		
		if(ae.getSource() == cmd.getJbtBookCheck()) {
			BookingCheckDesign bcd = new BookingCheckDesign();
			bcd.setVisible(true);
		}
		
		if(ae.getSource() == cmd.getJbtRecall()) {
			RecallDesign rd = new RecallDesign();
			rd.setVisible(true);
		}
		
		if(ae.getSource() == cmd.getJbtNotify()) {
			NotificateDesign nd = new NotificateDesign();
			nd.setVisible(true);
		}

	}// actionPerformed

	@Override
	public void windowClosing(WindowEvent we) {
		cmd.dispose();
	}// windowClising

}
