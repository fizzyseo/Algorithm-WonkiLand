package WonkiLand;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Frame_Last extends JFrame{
	
	public Frame_Last() {
		super("Last");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // JLayeredPane을 이용하여 백그라운드 이미지가 가장 뒤로 가도록 설정
        JLayeredPane layeredPane = new JLayeredPane();
        
        // 백그라운드 이미지 설정
        JLabel backgroundLabel = new JLabel();
        Image background = new ImageIcon("image/background.png").getImage();
        Image scaledbackground = background.getScaledInstance(1500, 840, Image.SCALE_SMOOTH);
        backgroundLabel.setIcon(new ImageIcon(scaledbackground));
        backgroundLabel.setBounds(0, 0, 1500, 840);
        layeredPane.add(backgroundLabel, new Integer(0)); // 앞 뒤 우선순위 조절 0 1 2 3 순으로 위로 올라감
        
        // 바탕 넣기
        JLabel backgroundLabel2 = new JLabel();
        Image background2 = new ImageIcon("image/background2.png").getImage();
        Image scaledbackground2 = background2.getScaledInstance(1315, 675, Image.SCALE_SMOOTH);
        backgroundLabel2.setIcon(new ImageIcon(scaledbackground2));
        backgroundLabel2.setBounds(95, 80, 1315, 675);
        layeredPane.add(backgroundLabel2, new Integer(1));
        
        // 위쪽에 설명 넣기
        JLabel textLabel = new JLabel("<html>"
                + "You did a great job.  Smart mercenary.<br><br>"
                + "Thanks to you, Wonki Land came back to life.<br><br>"
        		+ "Good bye.."+ "</html>");
        textLabel.setFont(new Font("Inter", Font.BOLD, 35));
        textLabel.setBounds(200, 175, 794, 243);
        layeredPane.add(textLabel, new Integer(2));
        
        // 골드 주머니 사진
        JLabel imageLabel = new JLabel();
        Image image = new ImageIcon("image/Gold.png").getImage();
        Image scaledImage = image.getScaledInstance(311, 291, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaledImage));
        imageLabel.setBounds(355, 374, 311, 291);
        layeredPane.add(imageLabel, new Integer(3));
        
        // 미션 컴플리트 사진
        imageLabel = new JLabel();
        Image mission = new ImageIcon("image/stamp_com.png").getImage();
        Image scaledMissionImage = mission.getScaledInstance(666, 438, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaledMissionImage));
        imageLabel.setBounds(825, 5, 666, 438);
        layeredPane.add(imageLabel, new Integer(3));
        
        // close 스크롤
        imageLabel = new JLabel();
        Image close_image = new ImageIcon("image/close_scroll.png").getImage();
        Image scaledAcceptImage = close_image.getScaledInstance(315, 168, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaledAcceptImage));
        imageLabel.setBounds(908, 505, 315, 168);
        layeredPane.add(imageLabel, new Integer(5));
        
		// 스크롤 눌렀을 때 다음 프레임으로 이동하도록 MouseListener 추가
        imageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 다음 프레임으로 이동
            	nextFrame();
            }
        });
		
		setFocusable(true);  // 키 이벤트를 받을 수 있도록 포커스 설정
        requestFocusInWindow();  // 창이 열리면서 바로 포커스 요청
        
        // JLayeredPane을 프레임에 추가
        add(layeredPane);
        
        // 프레임 사이즈 설정
        setSize(1510, 880);
        setVisible(true);
		
		}
	
	// 다음 프레임 열기 위한 메소드
    private void nextFrame() {
        
    	// 현재 프레임을 숨김
    	setVisible(false);
    	dispose();  // 현재 프레임을 메모리에서 제거
    }
    
    public static void main(String[] args) {
    	new Frame_Last();
    }
}