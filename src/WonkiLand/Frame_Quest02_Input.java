package WonkiLand;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Frame_Quest02_Input extends JFrame {

	private JTextField partyField;
    private JTextField timeField;
	
    public Frame_Quest02_Input() {
        super("Frame_Quest02_Input");
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
        JLabel titleLabel = new JLabel("Quest 2 : Minimum number of dungeons ");
        titleLabel.setFont(new Font("Inter", Font.BOLD, 50));
        titleLabel.setBounds(160, 55, 1168, 115);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        layeredPane.add(titleLabel, new Integer(1));

        // 파티 아이콘 설정
        JLabel storeLabel = new JLabel();
        Image store = new ImageIcon("image/icon_party.png").getImage();
        Image scaledstoreImage = store.getScaledInstance(217, 170, Image.SCALE_SMOOTH);
        storeLabel.setIcon(new ImageIcon(scaledstoreImage));
        storeLabel.setBounds(239, 224, 217, 170);
        layeredPane.add(storeLabel, new Integer(2));
        
        // 시간 아이콘 설정
        JLabel lengthLabel = new JLabel();
        Image length = new ImageIcon("image/icon_time.png").getImage();
        Image scaledlengthImage = length.getScaledInstance(187, 187, Image.SCALE_SMOOTH);
        lengthLabel.setIcon(new ImageIcon(scaledlengthImage));
        lengthLabel.setBounds(254, 465, 187, 187);
        layeredPane.add(lengthLabel, new Integer(2));
        
        // 텍스트 설정
        JLabel textLabel1 = new JLabel("The number of party");
        textLabel1.setFont(new Font("Inter", Font.BOLD, 35));
        textLabel1.setBounds(475, 276, 550, 65);
        layeredPane.add(textLabel1, new Integer(1));

        JLabel textLabel2 = new JLabel("Reservation time for each team");
        textLabel2.setFont(new Font("Inter", Font.BOLD, 27));
        textLabel2.setBounds(475, 524, 550, 65);
        layeredPane.add(textLabel2, new Integer(1));

        
        // 입력 받을 메세지 창
        partyField = new HintTextField("3");
        partyField.setFont(new Font("Inter", Font.PLAIN, 25));
        partyField.setBounds(1040, 276, 270, 65);
        layeredPane.add(partyField, new Integer(3));

        timeField = new HintTextField("(1 3)(2 4)(3 5)");
        timeField.setFont(new Font("Inter", Font.PLAIN, 25));
        timeField.setBounds(1040, 524, 270, 65);
        layeredPane.add(timeField, new Integer(3));

        
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
        try {
            // 입력값 파싱
            int numberOfDungeon = Integer.parseInt(partyField.getText());
            String inputText = timeField.getText();

            // 예외 처리: 사용자가 숫자를 입력하지 않으면 NumberFormatException 발생
            String[] timeStrings = inputText.split("\\)\\(");

            // 정확한 크기의 study 배열을 초기화
            Point[] study = new Point[timeStrings.length];

            for (int i = 0; i < timeStrings.length; i++) {
                // 문자열 앞뒤의 괄호를 제거하고, 각 숫자를 추출
                String[] input = timeStrings[i].replaceAll("\\(", "").replaceAll("\\)", "").split(" ");

                // 예시로 i 를 사용
                study[i] = new Point(Integer.parseInt(input[0]) - 1, Integer.parseInt(input[1]) - 1);
            }

            // 시작 시간을 기준으로 오름차순 정렬하되,
            // 시작 시간이 같다면, 종료 시간을 기준으로 오름차순 정렬한다.
            Arrays.sort(study, (l1, l2) -> l1.x == l2.x ? l1.y - l2.y : l1.x - l2.x);

            // Your existing logic for finding minimum classrooms
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.offer(study[0].y);

            for (int i = 1; i < numberOfDungeon; i++) {
                // 우선순위 큐에서 가장 작은 종료 시간과
                // 현재 study[i]의 시작 시간을 비교한다.
                if (pq.peek() <= study[i].x) {
                    pq.poll();
                }
                pq.offer(study[i].y);
            }

            int calculatedValue = pq.size();

            // Continue with the rest of your nextFrame() method
            Frame_Quest02_Output frame_Quest02_Output = new Frame_Quest02_Output(calculatedValue);
            frame_Quest02_Output.setVisible(true);

            // 현재 프레임을 숨김
            setVisible(false);
            dispose();  // 현재 프레임을 메모리에서 제거
        } catch (NumberFormatException e) {
            // Handle the case where parsing fails
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid numbers.");
        }
    }
    
    public static void main(String[] args) {
        new Frame_Quest02_1();
    }
}