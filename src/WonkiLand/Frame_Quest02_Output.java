package WonkiLand;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Frame_Quest02_Output extends JFrame {

    private JLabel titleLabel;
    private JLabel imageLabel;
    private JLabel manLabel;
    private JLabel stampLabel;
    private JLabel dialogLabel;
    private JLabel textLabel;

    public Frame_Quest02_Output(int calculatedValue) {
        super("Frame_Quest02_Output");
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
        titleLabel = new JLabel("Quest 2 : Minimum number of dungeons ");
        titleLabel.setFont(new Font("Inter", Font.BOLD, 50));
        titleLabel.setBounds(160, 55, 1168, 115);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER); // 가운데 정렬
        layeredPane.add(titleLabel, new Integer(1));
        
        //퀘스트 남자 이미지 설정
        manLabel = new JLabel();
        Image manImage = new ImageIcon("image/quest02_man_smile.png").getImage();
        Image scaledManImage = manImage.getScaledInstance(360, 354, Image.SCALE_SMOOTH);
        manLabel.setIcon(new ImageIcon(scaledManImage));
        manLabel.setBounds(164, 217, 360, 354);
        layeredPane.add(manLabel, new Integer(1));

        //스탬프 이미지 설정
        stampLabel = new JLabel();
        Image stampImage = new ImageIcon("image/stamp02.png").getImage();
        Image scaledstampImage = stampImage.getScaledInstance(364, 371, Image.SCALE_FAST);
        stampLabel.setIcon(new ImageIcon(scaledstampImage));
        stampLabel.setBounds(874, 170, 364, 371);
        layeredPane.add(stampLabel, new Integer(3));
        
        // 메세지창 배경 설정
        dialogLabel = new JLabel();
        Image dialogImage = new ImageIcon("image/dialog.png").getImage();
        Image scaledDialogImage = dialogImage.getScaledInstance(1042, 193, Image.SCALE_SMOOTH);
        dialogLabel.setIcon(new ImageIcon(scaledDialogImage));
        dialogLabel.setBounds(136, 530, 1042, 193);
        layeredPane.add(dialogLabel, new Integer(2));

        
        // 메세지창 텍스트 설정
        textLabel = new JLabel("<html>"
                + "Good job!</html>");
        textLabel.setFont(new Font("Inter", Font.BOLD, 40));
        textLabel.setBounds(163, 505, 986, 142);
        layeredPane.add(textLabel, new Integer(3));
        
        // 메세지창 텍스트 설정
        textLabel = new JLabel("<html>The minimum number of dungeons is " + calculatedValue + "<br>"
        		+ "Thanks to you, adventurers will be able to easily attack Dungeon!</html>");
        textLabel.setFont(new Font("Inter", Font.BOLD, 27));
        textLabel.setBounds(163, 595, 986, 142);
        layeredPane.add(textLabel, new Integer(3));


        // 다음 스크롤 설정
        JLabel nextLabel = new JLabel();
        Image ScrollImage = new ImageIcon("image/next_scroll.png").getImage();
        Image scaledScrollImage = ScrollImage.getScaledInstance(220, 128, Image.SCALE_SMOOTH);
        nextLabel.setIcon(new ImageIcon(scaledScrollImage));
        nextLabel.setBounds(1200, 560, 220, 128);
        layeredPane.add(nextLabel, new Integer(3));
        
        // 스크롤 눌렀을 때 다음 프레임으로 이동하도록 MouseListener 추가
        nextLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 다음 프레임으로 이동
            	nextFrame();
            }
        });
        
       // 아무 키를 눌렀을 때 다음 프레임으로 이동하도록 KeyListener 추가
//       addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                // 아무 키를 눌렀을 때 다음 프레임으로 이동
//            	nextFrame();
//            }
//        });
        
        setFocusable(true);  // 키 이벤트를 받을 수 있도록 포커스 설정
        requestFocusInWindow();  // 창이 열리면서 바로 포커스 요청
        
        // JLayeredPane을 프레임에 추가
        add(layeredPane);
        
        // 프레임 사이즈 설정
        setSize(1510, 880);
        setVisible(true);
    	}

    // 다음 프레임을 열기 위한 메소드
    private void nextFrame() {
    	Frame_Quest03_Input frame_Quest03_Input = new Frame_Quest03_Input();
    	frame_Quest03_Input.setVisible(true);
        
    	// 현재 프레임을 숨김
    	setVisible(false);
    	dispose();  // 현재 프레임을 메모리에서 제거
    }
        
    public static void main(String[] args) {
        new Frame_Quest02_Output(123);
    }
}