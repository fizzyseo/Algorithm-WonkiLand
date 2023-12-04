package WonkiLand;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Frame_Quest03_Input extends JFrame {

    private JTextField n_villagesField;
    private JTextField n_pathsField;
    private JTextField costField;
    private JLabel manLabel;
    private JLabel dialogLabel;
    private JLabel textLabel;
   
    public Frame_Quest03_Input() {
        super("Frame_Quest03_Input");
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
        JLabel titleLabel = new JLabel("Quest 3 : The cost of connecting a road ");
        titleLabel.setFont(new Font("Inter", Font.BOLD, 50));
        titleLabel.setBounds(160, 55, 1168, 115);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        layeredPane.add(titleLabel, new Integer(1));

        // 텍스트 설정
        JLabel textLabel1 = new JLabel("The number of villages");
        textLabel1.setFont(new Font("Inter", Font.BOLD, 30));
        textLabel1.setBounds(150, 490, 550, 60);
        layeredPane.add(textLabel1, new Integer(1));

        JLabel textLabel2 = new JLabel("The number of paths to connect");
        textLabel2.setFont(new Font("Inter", Font.BOLD, 30));
        textLabel2.setBounds(150, 595, 550, 60);
        layeredPane.add(textLabel2, new Integer(1));
        
        JLabel textLabel3 = new JLabel("<html>The cost of connecting each road"+"<html>");
        textLabel3.setFont(new Font("Inter", Font.BOLD, 30));
        textLabel3.setBounds(150, 680, 550, 80);
        layeredPane.add(textLabel3, new Integer(1));
        
        // 메세지창 배경 설정
        dialogLabel = new JLabel();
        Image dialogImage = new ImageIcon("image/dialog.png").getImage();
        Image scaledDialogImage = dialogImage.getScaledInstance(1100, 280, Image.SCALE_SMOOTH);
        dialogLabel.setIcon(new ImageIcon(scaledDialogImage));
        dialogLabel.setBounds(340, 168, 1100, 280);
        layeredPane.add(dialogLabel, new Integer(2));
        
        // 입력 받을 메세지 창
        n_villagesField = new HintTextField("4");
        n_villagesField.setFont(new Font("Inter", Font.PLAIN, 20));
        n_villagesField.setBounds(830, 490, 270, 60);
        layeredPane.add(n_villagesField, new Integer(3));

        n_pathsField = new HintTextField("4");
        n_pathsField.setFont(new Font("Inter", Font.PLAIN, 20));
        n_pathsField.setBounds(830, 595, 270, 60);
        layeredPane.add(n_pathsField, new Integer(3));

        costField = new HintTextField("(1 2 3)(2 3 3)(3 4 5)(4 1 1)");
        costField.setFont(new Font("Inter", Font.PLAIN, 20));
        costField.setBounds(830, 700, 270, 60);
        layeredPane.add(costField, new Integer(3));
        
        // 메세지창 텍스트 설정
        textLabel = new JLabel("<html>"
        		+ "We need to create a road that connects the village to the village.<br>"
                + "Each village must be connected to every village.<br><br>"
                + "For example, if there are roads to villages A and B, and there are roads to villages B and C, <br>"
                + "it means that villages A and C are connected.<br><br>"
                + "Let's find the minimum cost of connecting all towns when the cost of connecting each <br>"
                + "road is fixed.</html>");
        textLabel.setFont(new Font("Inter", Font.BOLD, 19));
        textLabel.setBounds(364, 195, 1054, 230);
        layeredPane.add(textLabel, new Integer(3));
        
        //퀘스트 남자 이미지 설정
        manLabel = new JLabel();
        Image manImage = new ImageIcon("image/quest03_man.png").getImage();
        Image scaledManImage = manImage.getScaledInstance(238, 262, Image.SCALE_SMOOTH);
        manLabel.setIcon(new ImageIcon(scaledManImage));
        manLabel.setBounds(93, 170, 238, 262);
        layeredPane.add(manLabel, new Integer(1));
        
        // 제출 스크롤 설정
        JLabel nextLabel = new JLabel();
        Image ScrollImage = new ImageIcon("image/submit_scroll.png").getImage();
        Image scaledScrollImage = ScrollImage.getScaledInstance(187, 100, Image.SCALE_SMOOTH);
        nextLabel.setIcon(new ImageIcon(scaledScrollImage));
        nextLabel.setBounds(1205, 660, 187, 100);
        layeredPane.add(nextLabel, new Integer(4));
        
        // JLayeredPane을 프레임에 추가
        add(layeredPane);
        
        // 프레임 사이즈 설정
        setSize(1510, 880);
        setVisible(true);
        
        // 스크롤 눌렀을 때 다음 프레임으로 이동하도록 MouseListener 추가
        nextLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 다음 프레임으로 이동
            	nextFrame();
            }
        });
        
        // 아무 키를 눌렀을 때 다음 프레임으로 이동하도록 KeyListener 추가
//        addKeyListener(new KeyAdapter() {
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

    // nextFrame 메서드
    private void nextFrame() {
        try {
            // 입력값 파싱
            int numberOfVillages = Integer.parseInt(n_villagesField.getText());
            int numberOfPaths = Integer.parseInt(n_pathsField.getText());
            String inputText = costField.getText(); // 한줄 입력을 위해 (1 2 3)(2 3 55)(1 3 42)로 입력받을 예정.

            // 예외 처리: 사용자가 숫자를 입력하지 않으면 NumberFormatException 발생
            String[] roadStrings = inputText.split("\\)\\(");

            // 정확한 크기의 roadCosts 배열을 초기화
            int[][][] roadCosts = new int[roadStrings.length][3][3];

            for (int i = 0; i < roadStrings.length; i++) {
                // 문자열 앞뒤의 괄호를 제거하고, 각 숫자를 추출
                String[] input = roadStrings[i].replaceAll("\\(", "").replaceAll("\\)", "").split(" ");

                // 예시로 i를 사용
                roadCosts[i][0][0] = Integer.parseInt(input[0]) - 1; // 출발지
                roadCosts[i][1][0] = Integer.parseInt(input[1]) - 1; // 목적지
                roadCosts[i][2][0] = Integer.parseInt(input[2]); // 비용
            }

            Frame_Quest03_Algorithm algorithm = new Frame_Quest03_Algorithm(numberOfVillages, numberOfPaths, roadCosts);
            int calculatedValue = algorithm.calculate(); // 알고리즘 계산

            // 다음 프레임으로 이동
            Frame_Quest03_Output frame_Quest03_Output = new Frame_Quest03_Output(calculatedValue);
            frame_Quest03_Output.setVisible(true);

            // 현재 프레임을 숨김
            setVisible(false);
            dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new Frame_Quest03_Input();
    }
}