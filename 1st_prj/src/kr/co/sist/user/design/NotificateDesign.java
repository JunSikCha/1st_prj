package kr.co.sist.user.design;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import kr.co.sist.user.dao.NotificateDAO;
import kr.co.sist.user.event.NotificateEvt;
import kr.co.sist.user.event.UserData;
import kr.co.sist.user.vo.NotificateVO;

@SuppressWarnings("serial")
public class NotificateDesign extends JDialog {
	
	private JTextArea jtaNotifi;
	private NotificateEvt noEvt = new NotificateEvt();

    public NotificateDesign(JFrame parent) {
    	super(parent, "알림톡", true); // 모달 창으로 설정
        
        JLabel jlTitle = new JLabel("MYCAR");
        JLabel jlsubTitle = new JLabel("알림톡");
        try {
			jtaNotifi = new JTextArea(noEvt.notificateInfo());
			jtaNotifi.setEditable(false);
		} catch (ParseException e) {
			e.printStackTrace();
		}

        jlTitle.setBounds(50, 12, 200, 50);
        jlsubTitle.setBounds(50, 17, 100, 100);
        jtaNotifi.setBounds(50, 80, 400, 150);
        
        jtaNotifi.setBorder(new LineBorder(Color.BLACK, 1));
        Font titleFont = new Font("SansSerif", Font.BOLD, 18);
        jlTitle.setFont(titleFont);
        Font labelFont = new Font("SansSerif", Font.BOLD, 13);
        jlsubTitle.setFont(labelFont);
        Font btnFont = new Font("SansSerif", Font.BOLD, 15);

        setLayout(null);
        add(jlTitle);
        add(jlsubTitle);
        add(jtaNotifi);
        
        setBounds(700, 500, 500, 300);
        setVisible(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // 창 닫기 동작 설정
    }

	public JTextArea getJtaNotifi() {
		return jtaNotifi;
	}

}






