package WonkiLand;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Frame_Setting extends JFrame{
	
	public Frame_Setting() {
		super("Frame_Setting");
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
                + "You're a smart mercenary and you go around making money.<br><br>"
                + "The lord of WK Land became seriously ill and his administrative work was <br>"
                + "paralyzed. <br><br>"
        		+ "Help the village's request to bring stability to the town."+ "</html>");
        textLabel.setFont(new Font("Inter", Font.BOLD, 30));
        textLabel.setBounds(213, 80, 1186, 343);
        layeredPane.add(textLabel, new Integer(2));
        
        // 지도 사진
        JLabel imageLabel = new JLabel();
        Image image = new ImageIcon("image/WonkiLand.png").getImage();
        Image scaledImage = image.getScaledInstance(450, 297, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaledImage));
        imageLabel.setBounds(225, 408, 450, 297);
        layeredPane.add(imageLabel, new Integer(3));
        
        // Client 글
        JLabel titleLabel = new JLabel("Client : WonkiLand    Reward : 1000G");
        titleLabel.setFont(new Font("Inter", Font.BOLD, 30));
        titleLabel.setBounds(718, 441, 623, 69);
        titleLabel.setHorizontalAlignment(SwingConstants.RIGHT); // 가운데 정렬
        layeredPane.add(titleLabel, new Integer(4));
        
        // ACCEPT
        imageLabel = new JLabel();
        Image accept_image = new ImageIcon("image/accept.png").getImage();
        Image scaledAcceptImage = accept_image.getScaledInstance(177, 87, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaledAcceptImage));
        imageLabel.setBounds(961, 579, 177, 87);
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
	// 다음 프레임, Frame_Quest01_2를 열기 위한 메소드
    private void nextFrame() {
    	Frame_Quest01_1 Frame_Quest01_1 = new Frame_Quest01_1();
    	Frame_Quest01_1.setVisible(true);
        
    	// 현재 프레임을 숨김
    	setVisible(false);
    	dispose();  // 현재 프레임을 메모리에서 제거
    }
    
    public static void main(String[] args) {
    	new Frame_Setting();
    }

}