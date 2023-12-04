package WonkiLand;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Frame_Quest04_Output extends JFrame {
   
	private JLabel imageLabel;
    private JLabel manLabel;
    private JLabel dialogLabel;
    private JLabel textLabel;
    private JLabel stampLabel;

    public Frame_Quest04_Output(int calculatedValue) {
    	
        super("Frame_Quest04_Output");
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
        JLabel titleLabel = new JLabel("Quest 4 : The largest number of happy villagers ");
        titleLabel.setFont(new Font("Inter", Font.BOLD, 50));
        titleLabel.setBounds(160, 55, 1168, 115);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        layeredPane.add(titleLabel, new Integer(1));

        //퀘스트 남자 이미지 설정
        manLabel = new JLabel();
        Image manImage = new ImageIcon("image/Lord_Wonki.png").getImage();
        Image scaledManImage = manImage.getScaledInstance(280, 315, Image.SCALE_SMOOTH);
        manLabel.setIcon(new ImageIcon(scaledManImage));
        manLabel.setBounds(117, 213, 280, 315);
        layeredPane.add(manLabel, new Integer(1));
        
        // 메세지창 배경 설정
        dialogLabel = new JLabel();
        Image dialogImage = new ImageIcon("image/dialog.png").getImage();
        Image scaledDialogImage = dialogImage.getScaledInstance(776, 296, Image.SCALE_SMOOTH);
        dialogLabel.setIcon(new ImageIcon(scaledDialogImage));
        dialogLabel.setBounds(411, 230, 776, 296);
        layeredPane.add(dialogLabel, new Integer(2));
        
        //스탬프 이미지 설정
        stampLabel = new JLabel();
        Image stampImage = new ImageIcon("image/stamp02.png").getImage();
        Image scaledstampImage = stampImage.getScaledInstance(323, 326, Image.SCALE_FAST);
        stampLabel.setIcon(new ImageIcon(scaledstampImage));
        stampLabel.setBounds(1077, 309, 323, 326);
        layeredPane.add(stampLabel, new Integer(3));
        

        // 메세지창 텍스트 설정
        textLabel = new JLabel("<html>"
                + "It's perfect!<br><br>"
                + calculatedValue + " residents became happy.<br><br>"
                + "Thanks, smart mercenary.</html>");
        textLabel.setFont(new Font("Inter", Font.BOLD, 37));
        textLabel.setBounds(441, 250, 720, 240);
        layeredPane.add(textLabel, new Integer(3));
        
        
        // 메세지창 텍스트 설정
        JLabel textLabel1 = new JLabel("Lord Wonki");
        textLabel1.setFont(new Font("Palatino Linotype", Font.BOLD, 30));
        textLabel1.setBounds(156, 547, 200, 49);
        textLabel1.setHorizontalAlignment(SwingConstants.CENTER); // 가운데 정렬
        layeredPane.add(textLabel1, new Integer(3));
        

        // 다음 스크롤 설정
        JLabel nextLabel = new JLabel();
        Image ScrollImage = new ImageIcon("image/next_scroll.png").getImage();
        Image scaledScrollImage = ScrollImage.getScaledInstance(220, 128, Image.SCALE_SMOOTH);
        nextLabel.setIcon(new ImageIcon(scaledScrollImage));
        nextLabel.setBounds(640, 596, 220, 128);
        layeredPane.add(nextLabel, new Integer(3));
        
        // 스크롤 눌렀을 때 다음 프레임으로 이동하도록 MouseListener 추가
        nextLabel.addMouseListener(new MouseAdapter() {
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
    	Frame_Last frame_Last = new Frame_Last();
    	frame_Last.setVisible(true);
        
    	// 현재 프레임을 숨김
    	setVisible(false);
    	dispose();  // 현재 프레임을 메모리에서 제거
    }
    
    
    	
    public static void main(String[] args) {
        new Frame_Quest04_Output(123);
    }
}