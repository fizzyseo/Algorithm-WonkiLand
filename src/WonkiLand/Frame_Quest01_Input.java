package WonkiLand;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Frame_Quest01_Input extends JFrame {

   private JTextField storeField;
    private JTextField lengthField;
    private JTextField carrotField;
   
    public Frame_Quest01_Input() {
        super("Frame_Quest01_Input");
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
        JLabel titleLabel = new JLabel("Quest 1: Giving carrots to Lord Wonki's horse");
        titleLabel.setFont(new Font("Inter", Font.BOLD, 45));
        titleLabel.setBounds(160, 55, 1168, 115);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        layeredPane.add(titleLabel, new Integer(1));

        // 상점 아이콘 설정
        JLabel storeLabel = new JLabel();
        Image store = new ImageIcon("image/icon_store.png").getImage();
        Image scaledstoreImage = store.getScaledInstance(115, 115, Image.SCALE_SMOOTH);
        storeLabel.setIcon(new ImageIcon(scaledstoreImage));
        storeLabel.setBounds(230, 221, 115, 115);
        layeredPane.add(storeLabel, new Integer(2));
        
        // 거리 아이콘 설정
        JLabel lengthLabel = new JLabel();
        Image length = new ImageIcon("image/icon_length.png").getImage();
        Image scaledlengthImage = length.getScaledInstance(115, 115, Image.SCALE_SMOOTH);
        lengthLabel.setIcon(new ImageIcon(scaledlengthImage));
        lengthLabel.setBounds(230, 378, 115, 115);
        layeredPane.add(lengthLabel, new Integer(2));
        
        // 당근 아이콘 설정
        JLabel carrotLabel = new JLabel();
        Image carrot = new ImageIcon("image/icon_carrot.png").getImage();
        Image scaledcarrotImage = carrot.getScaledInstance(115, 115, Image.SCALE_SMOOTH);
        carrotLabel.setIcon(new ImageIcon(scaledcarrotImage));
        carrotLabel.setBounds(230, 530, 115, 115);
        layeredPane.add(carrotLabel, new Integer(2));
        
        // 텍스트 설정
        JLabel textLabel1 = new JLabel("The number of stores");
        textLabel1.setFont(new Font("Inter", Font.BOLD, 30));
        textLabel1.setBounds(398, 248, 470, 60);
        layeredPane.add(textLabel1, new Integer(1));

        JLabel textLabel2 = new JLabel("<html>"
        		+ "Length of each road based on the <br>"
        		+ "leftmost store");
        textLabel2.setFont(new Font("Inter", Font.BOLD, 30));
        textLabel2.setBounds(398, 410, 565, 65);
        layeredPane.add(textLabel2, new Integer(1));

        JLabel textLabel3 = new JLabel("The price of each carrot in each store");
        textLabel3.setFont(new Font("Inter", Font.BOLD, 30));
        textLabel3.setBounds(398, 558, 598, 60);
        layeredPane.add(textLabel3, new Integer(1));
        
        // 입력 받을 메세지 창
        storeField = new HintTextField("4");
        storeField.setFont(new Font("Inter", Font.PLAIN, 25));
        storeField.setBounds(1035, 248, 270, 65);
        layeredPane.add(storeField, new Integer(3));

        lengthField = new HintTextField("2 3 1");
        lengthField.setFont(new Font("Inter", Font.PLAIN, 25));
        lengthField.setBounds(1035, 410, 270, 65);
        layeredPane.add(lengthField, new Integer(3));

        carrotField = new HintTextField("5 2 4 1");
        carrotField.setFont(new Font("Inter", Font.PLAIN, 25));
        carrotField.setBounds(1035, 558, 270, 65);
        layeredPane.add(carrotField, new Integer(3));
        
        
        // 제출 스크롤 설정
        JLabel nextLabel = new JLabel();
        Image ScrollImage = new ImageIcon("image/submit_scroll.png").getImage();
        Image scaledScrollImage = ScrollImage.getScaledInstance(187, 100, Image.SCALE_SMOOTH);
        nextLabel.setIcon(new ImageIcon(scaledScrollImage));
        nextLabel.setBounds(1205, 660, 187, 100);
        layeredPane.add(nextLabel, new Integer(4));
        
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

    // 다음 프레임 열기 위한 메소드
    private void nextFrame() {
        // 사용자로부터 입력받은 값
        int 가게수 = Integer.parseInt(storeField.getText()); // 가게수를 storeField로부터 입력받음
        String[] 거리입력 = lengthField.getText().split(" ");
        long[] 거리 = new long[거리입력.length];
        for (int i = 0; i < 거리입력.length; i++) {
            거리[i] = Long.parseLong(거리입력[i]); // 거리를 lengthField로부터 입력받음
        }
        String[] 연료가격입력 = carrotField.getText().split(" ");
        long[] 연료가격 = new long[연료가격입력.length];
        for (int i = 0; i < 연료가격입력.length; i++) {
            연료가격[i] = Long.parseLong(연료가격입력[i]); // 연료가격을 carrotField로부터 입력받음
        }

        Frame_Quest01_Output frame_Quest01_Output = new Frame_Quest01_Output(가게수, 거리, 연료가격);
        frame_Quest01_Output.setVisible(true);

        setVisible(false);
        dispose();
    }

    
    public static void main(String[] args) {
        new Frame_Quest01_1();
    }
}