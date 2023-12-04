package WonkiLand;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Frame_Main extends JFrame{
	
	public Frame_Main() {
		super("Frame_Main");
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
	    
	    // 위쪽에 Title 넣기
        JLabel titleLabel = new JLabel("<html>"
        		+ "Welcome <br>"
        		+ "To <br>"
        		+ "WonkiLand" );
        titleLabel.setFont(new Font("Inter", Font.BOLD, 80));
        titleLabel.setBounds(221, 125, 473, 312);
        layeredPane.add(titleLabel, new Integer(1));
        
        // Main Photo
        JLabel imageLabel = new JLabel();
        Image image = new ImageIcon("image/MainPhoto.png").getImage();
        Image scaledImage = image.getScaledInstance(480, 587, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaledImage));
        imageLabel.setBounds(903, 126, 480, 587);
        layeredPane.add(imageLabel, new Integer(2));
        
        // 다음 스크롤 설정
        JLabel nextLabel = new JLabel();
        Image ScrollImage = new ImageIcon("image/start_scroll.png").getImage();
        Image scaledScrollImage = ScrollImage.getScaledInstance(335, 177, Image.SCALE_SMOOTH);
        nextLabel.setIcon(new ImageIcon(scaledScrollImage));
        nextLabel.setBounds(457, 533, 335, 177);
        layeredPane.add(nextLabel, new Integer(3));
        
        // 스크롤 눌렀을 때 다음 프레임으로 이동하도록 MouseListener 추
        nextLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 다음 프레임 이동
            	nextFrame();
            }
        });
        
        setFocusable(true);		// 키 이벤트를 받을 수 있도록 포커스 설정
        requestFocusInWindow();  // 창이 열리면서 바로 포커스 요청
        
        // JLayeredPane을 프레임에 추가
        add(layeredPane);
        
        // 프레임 사이즈 설정
        setSize(1510, 880);
        setVisible(true);
    	}
	
	// 다음 프레임 열기 위한 메소드
    private void nextFrame() {
    	Frame_Setting Frame_Setting = new Frame_Setting();
    	Frame_Setting.setVisible(true);
        
    	// 현재 프레임을 숨김
    	setVisible(false);
    	dispose();  // 현재 프레임을 메모리에서 제거
    }

	
    
	public static void main(String[] args) {
        new Frame_Main();
	}  
}