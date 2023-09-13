package kr.co.sist.user.design;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class NotificateDesign extends JFrame {
	private JLabel jlTitle;
	private JLabel jlsubTitle;
	private JTextArea jtaNotifi;
	private JButton jbtCancel;

    public NotificateDesign() {
        super("알림톡");
        JLabel jlTitle = new JLabel("MYCAR");
        JLabel jlsubTitle = new JLabel("알림톡");
        jbtCancel = new JButton("X");
        jtaNotifi = new JTextArea("*안녕하세요 ooo고객님.\r\n"
                + "  BMW자동차 예약센터입니다\r\n"
                + "  고객님의 소중한 차의 수리가 완료되었습니다.\n\n\n"
                + "*안녕하세요 ooo고객님.\r\n"
                + "  BMW자동차 예약센터입니다 고객님의 차량은 1년마다  \r\n"
                + "  정기점검을 받으셔야합니다.\r\n"
                + "  검사가능기간: 2023.07.26~2023.09.26");

        jlTitle.setBounds(50, 2, 200, 50);
        jlsubTitle.setBounds(50, 20, 100, 100);
        jtaNotifi.setBounds(50, 80, 400, 150);
        jbtCancel.setBounds(440, 2, 50, 30);
        
        Font titleFont = new Font("SansSerif", Font.BOLD, 18);
        jlTitle.setFont(titleFont);
        Font labelFont = new Font("SansSerif", Font.BOLD, 13);
        jlsubTitle.setFont(labelFont);
        Font btnFont = new Font("SansSerif", Font.BOLD, 15);
        jbtCancel.setFont(btnFont);

        setLayout(null);
        add(jlTitle);
        add(jlsubTitle);
        add(jtaNotifi);
   	    add(jbtCancel);

        setBounds(500, 280, 500, 300);
        setVisible(true);

    }
    

    public JLabel getJlTitle() {
		return jlTitle;
	}


	public JLabel getJlsubTitle() {
		return jlsubTitle;
	}


	public JTextArea getJtaNotifi() {
		return jtaNotifi;
	}


	public JButton getJbtCancel() {
		return jbtCancel;
	}


	public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // JFrame 생성
            NotificateDesign frame = new NotificateDesign();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}






