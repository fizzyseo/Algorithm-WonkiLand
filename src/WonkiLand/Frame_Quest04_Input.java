package WonkiLand;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Frame_Quest04_Input extends JFrame {

    private JTextField n_taskField;
    private JTextField happyField;
    private JLabel imageLabel;
    private JLabel manLabel;
    private JLabel dialogLabel;
    private JLabel textLabel;
   
    public Frame_Quest04_Input() {
        super("Frame_Quest04_Input");
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
        titleLabel.setFont(new Font("Inter", Font.BOLD, 45));
        titleLabel.setBounds(160, 55, 1168, 115);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        layeredPane.add(titleLabel, new Integer(1));

        // 텍스트 설정
        JLabel textLabel1 = new JLabel("The number of Tasks");
        textLabel1.setFont(new Font("Inter", Font.BOLD, 22));
        textLabel1.setBounds(250, 582, 450, 60);
        layeredPane.add(textLabel1, new Integer(3));

        JLabel textLabel2 = new JLabel("<html>"
        		+ "The Deadline and the number <br>"
        		+ "of villagers getting happy");
        textLabel2.setFont(new Font("Inter", Font.BOLD, 22));
        textLabel2.setBounds(251, 687, 450, 60);
        layeredPane.add(textLabel2, new Integer(3));

        // 메세지창 배경 설정
        dialogLabel = new JLabel();
        Image dialogImage = new ImageIcon("image/dialog.png").getImage();
        Image scaledDialogImage = dialogImage.getScaledInstance(1325, 364, Image.SCALE_SMOOTH);
        dialogLabel.setIcon(new ImageIcon(scaledDialogImage));
        dialogLabel.setBounds(95, 165, 1325, 364);
        layeredPane.add(dialogLabel, new Integer(2));
        
        // 입력 받을 메세지 창
        n_taskField = new HintTextField("5");
        n_taskField.setFont(new Font("Inter", Font.PLAIN, 20));
        n_taskField.setBounds(756, 582, 270, 60);
        layeredPane.add(n_taskField, new Integer(3));

        happyField = new HintTextField("(1 6)(1 7)(3 2)(3 1)(2 4)");
        happyField.setFont(new Font("Inter", Font.PLAIN, 20));
        happyField.setBounds(756, 687, 270, 60);
        layeredPane.add(happyField, new Integer(3));
        
        // 메세지창 텍스트 설정
        textLabel = new JLabel("<html>"
                + "Lord Wonki is behind in his administrative work.<br><br>"
                + "We have to deal with administrative tasks with a fixed deadline to help him.<br><br>"
                + "Only one task can be handled per day.<br><br>"
                + "When dealing with administrative tasks, we want to maximize the number of villagers we are satisfied with.<br><br>"
                + "Let's find the number of villagers who are happy when they handle each task and the maximum number of villagers who are happy by output.</html>");
        textLabel.setFont(new Font("Inter", Font.BOLD, 23));
        textLabel.setBounds(124, 190, 1304, 309);
        layeredPane.add(textLabel, new Integer(3));
        
        
        // 제출 스크롤 설정
        JLabel nextLabel = new JLabel();
        Image ScrollImage = new ImageIcon("image/submit_scroll.png").getImage();
        Image scaledScrollImage = ScrollImage.getScaledInstance(220, 128, Image.SCALE_SMOOTH);
        nextLabel.setIcon(new ImageIcon(scaledScrollImage));
        nextLabel.setBounds(1190, 601, 220, 128);
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
    	try {
            // 입력값 파싱
            int taskNum = Integer.parseInt(n_taskField.getText());
            String inputText = happyField.getText();

            // 예외 처리: 사용자가 숫자를 입력하지 않으면 NumberFormatException 발생
            String[] happyStrings = inputText.split("\\)\\(");

            // 정확한 크기의 cost 배열을 초기화
            int[][] happyCosts = new int[happyStrings.length][2];

            for (int i = 0; i < happyStrings.length; i++) {
                // 문자열 앞 뒤의 괄호를 제거하고, 각 숫자를 추출
                String[] input = happyStrings[i].replaceAll("\\(", "").replaceAll("\\)", "").split(" ");

                // 예시로 i 를 사용
                happyCosts[i][0] = Integer.parseInt(input[0]);
                happyCosts[i][1] = Integer.parseInt(input[1]);
            }

            // 첫 번째 코드 스니펫에서 알고리즘 실행
            int maxHappyVillagers = runAlgorithm(taskNum, happyCosts);

            // 결과를 표시하거나 필요한 대로 사용
            System.out.println("최대 행복 마을 주민 수: " + maxHappyVillagers);

            // 다음 프레임 열기
            Frame_Quest04_Output frame_Quest04_Output = new Frame_Quest04_Output(maxHappyVillagers);
            frame_Quest04_Output.setVisible(true);

            // 현재 프레임을 숨김
            setVisible(false);
            dispose(); // 현재 프레임을 메모리에서 제거
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            // 예외 처리 (예: 잘못된 입력 형식)
            e.printStackTrace();
            // 사용자에게 오류 메시지 표시 (선택 사항)
            JOptionPane.showMessageDialog(this, "유효하지 않은 입력 형식입니다. 올바른 숫자를 입력하세요.");
        }
    
    }
    
    // Algorithm 적용 
    public int runAlgorithm(int taskNum, int[][] happyCosts) {
    	ArrayList<Problem> arr = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int max = 0;
        for (int i = 0; i < taskNum; i++) {
            int deadline = happyCosts[i][0];
            int happyVillagers = happyCosts[i][1];
            arr.add(new Problem(deadline, happyVillagers));
        }
        // 데드라인이 작고, 행복한 주민 수가 큰 순으로 정렬하기
        Collections.sort(arr);

        for (Problem problem : arr) {
            // 사이즈는 일(day) 수를 뜻함
            int size = queue.size();
            // 데드라인이 작다면 무조건 삽입 가능
            if (size < problem.deadLine) {
                queue.offer(problem.happyVillagers);
            }
            // 같은 날짜라면, 큐에 담겨진 가장 작은 행복한 주민 수와 현재 주민 수 비교하기
            else if (size == problem.deadLine) {
                Integer peek = queue.peek();
                // 현재 주민 수가 크다면 큐에 있던 것을 빼주고 현재 값으로 넣어주기
                if (peek != null && problem.happyVillagers > peek) {
                    queue.poll();
                    queue.add(problem.happyVillagers);
                }
            }
        }
        while (!queue.isEmpty()) {
            max += queue.poll();
        }

        // 최대 행복 마을 주민 수 반환
        return max;
    }
    
    private static class Problem implements Comparable<Problem>{
		int deadLine, happyVillagers;
		
		public Problem(int deadLine, int happyVillagers) {
			this.deadLine = deadLine;
			this.happyVillagers = happyVillagers;
		}
		
		// deadline 이 작은 순, 컵라면이 큰 순 
		public int compareTo(Problem o) {
			if(o.deadLine == this.deadLine) {
				return o.happyVillagers - this.happyVillagers;
			}
			return this.deadLine - o.deadLine;
		}
	}
    
    	
    public static void main(String[] args) {
        new Frame_Quest04_Input();
    }
}