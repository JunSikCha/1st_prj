package manager.MyInformation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyInformationSubWindowEvt implements ActionListener {
//	private MyInformationSubWindow misw;
	

	private MyInformationSubWindow misw;

	public MyInformationSubWindowEvt(MyInformationTab mit, MyInformationSubWindow misw) {
		this.misw=misw;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

}
