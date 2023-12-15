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

        // Use the JLayerPane to set the background image to be most backward
        JLayeredPane layeredPane = new JLayeredPane();

        // Put a background picture
        JLabel backgroundLabel = new JLabel();
        Image background = new ImageIcon("image/background.png").getImage();
        Image scaledbackground = background.getScaledInstance(1500, 840, Image.SCALE_SMOOTH);
        backgroundLabel.setIcon(new ImageIcon(scaledbackground));
        backgroundLabel.setBounds(0, 0, 1500, 840);
        layeredPane.add(backgroundLabel, new Integer(0)); 

        // Put Titles on top
        JLabel titleLabel = new JLabel("Quest 4 : The largest number of happy villagers ");
        titleLabel.setFont(new Font("Inter", Font.BOLD, 45));
        titleLabel.setBounds(160, 55, 1168, 115);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        layeredPane.add(titleLabel, new Integer(1));

        // Text Settings
        JLabel textLabel1 = new JLabel("The number of Tasks");
        textLabel1.setFont(new Font("Inter", Font.BOLD, 22));
        textLabel1.setBounds(250, 582, 450, 60);
        layeredPane.add(textLabel1, new Integer(3));

        // Add description at the top
        JLabel textLabel2 = new JLabel("<html>"
        		+ "The Deadline and the number <br>"
        		+ "of villagers getting happy");
        textLabel2.setFont(new Font("Inter", Font.BOLD, 22));
        textLabel2.setBounds(251, 687, 450, 60);
        layeredPane.add(textLabel2, new Integer(3));

        // Message window background settings
        dialogLabel = new JLabel();
        Image dialogImage = new ImageIcon("image/dialog.png").getImage();
        Image scaledDialogImage = dialogImage.getScaledInstance(1325, 364, Image.SCALE_SMOOTH);
        dialogLabel.setIcon(new ImageIcon(scaledDialogImage));
        dialogLabel.setBounds(95, 165, 1325, 364);
        layeredPane.add(dialogLabel, new Integer(2));
        
        // Message window to be entered
        n_taskField = new HintTextField("5");
        n_taskField.setFont(new Font("Inter", Font.PLAIN, 20));
        n_taskField.setBounds(756, 582, 270, 60);
        layeredPane.add(n_taskField, new Integer(3));

        // Hint message
        happyField = new HintTextField("(1 6)(1 7)(3 2)(3 1)(2 4)");
        happyField.setFont(new Font("Inter", Font.PLAIN, 20));
        happyField.setBounds(756, 687, 270, 60);
        layeredPane.add(happyField, new Integer(3));
        
        // Add description at the top
        textLabel = new JLabel("<html>"
                + "Lord Wonki is behind in his administrative work.<br><br>"
                + "We have to deal with administrative tasks with a fixed deadline to help him.<br><br>"
                + "Only one task can be handled per day.<br><br>"
                + "When dealing with administrative tasks, we want to maximize the number of villagers we are satisfied with.<br><br>"
                + "Let's find the number of villagers who are happy when they handle each task and the maximum number of villagers who are happy by output.</html>");
        textLabel.setFont(new Font("Inter", Font.BOLD, 23));
        textLabel.setBounds(124, 190, 1304, 309);
        layeredPane.add(textLabel, new Integer(3));
        
        
        // submit scroll
        JLabel nextLabel = new JLabel();
        Image ScrollImage = new ImageIcon("image/submit_scroll.png").getImage();
        Image scaledScrollImage = ScrollImage.getScaledInstance(220, 128, Image.SCALE_SMOOTH);
        nextLabel.setIcon(new ImageIcon(scaledScrollImage));
        nextLabel.setBounds(1190, 601, 220, 128);
        layeredPane.add(nextLabel, new Integer(4));
        
        // Adding JLayerPane to the Frame
        add(layeredPane);
        
        // Setting the Frame Size
        setSize(1510, 880);
        setVisible(true);
        
        // Add MouseListener to move to the next frame when scrolling is pressed
        nextLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // move to the next frame
            	nextFrame();
            }
        });
        
        setFocusable(true);  // Set focus to receive key events
        requestFocusInWindow();  // Request focus as soon as the window opens
        
        // Adding JLayerPane to the Frame
        add(layeredPane);
        
        // Setting the Frame Size
        setSize(1510, 880);
        setVisible(true);
    	}

    // Method to open the next frame
    private void nextFrame() {
    	try {
            // Parsing Input Values
            int taskNum = Integer.parseInt(n_taskField.getText());
            String inputText = happyField.getText();

            // Exception: NumberFormatException occurs if the user does not enter a number
            String[] happyStrings = inputText.split("\\)\\(");

            // Initialize the correct size cost array
            int[][] happyCosts = new int[happyStrings.length][2];

            for (int i = 0; i < happyStrings.length; i++) {
                // Remove parentheses before and after the string, and extract each number
                String[] input = happyStrings[i].replaceAll("\\(", "").replaceAll("\\)", "").split(" ");
         
                happyCosts[i][0] = Integer.parseInt(input[0]);
                happyCosts[i][1] = Integer.parseInt(input[1]);
            }

            // Run the algorithm
            int maxHappyVillagers = runAlgorithm(taskNum, happyCosts);

            // Output in terminal
            System.out.println("최대 행복 마을 주민 수: " + maxHappyVillagers);

            // Open the next frame
            Frame_Quest04_Output frame_Quest04_Output = new Frame_Quest04_Output(maxHappyVillagers);
            frame_Quest04_Output.setVisible(true);

            // Hide current frame
            setVisible(false);
            dispose(); // Remove current frame from memory
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            // Exceptions (e.g., incorrect input format)
            e.printStackTrace();
            // Show error messages to users
            JOptionPane.showMessageDialog(this, "유효하지 않은 입력 형식입니다. 올바른 숫자를 입력하세요.");
        }
    
    }
    
    // Algorithm 
    public int runAlgorithm(int taskNum, int[][] happyCosts) {
    	ArrayList<Problem> arr = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int max = 0;
        for (int i = 0; i < taskNum; i++) {
            int deadline = happyCosts[i][0];
            int happyVillagers = happyCosts[i][1];
            arr.add(new Problem(deadline, happyVillagers));
        }
        // Sorting in order of smaller deadlines and the number of happy residents
        Collections.sort(arr);

        for (Problem problem : arr) {
            // Size means number of days
            int size = queue.size();
            // If the deadline is small, it can be inserted unconditionally
            if (size < problem.deadLine) {
                queue.offer(problem.happyVillagers);
            }
            // On the same date, 
            // compare the smallest number of happy residents in the queue to the current number of residents
            
            else if (size == problem.deadLine) {
                Integer peek = queue.peek();
                // If the current number of residents is large, take out 
                // what was in the queue and put it in the current value
                if (peek != null && problem.happyVillagers > peek) {
                    queue.poll();
                    queue.add(problem.happyVillagers);
                }
            }
        }
        while (!queue.isEmpty()) {
            max += queue.poll();
        }

        // Return of the maximum number of happy villagers
        return max;
    }
    
    private static class Problem implements Comparable<Problem>{
		int deadLine, happyVillagers;
		
		public Problem(int deadLine, int happyVillagers) {
			this.deadLine = deadLine;
			this.happyVillagers = happyVillagers;
		}
		
		// Deadline in order of small, happy Villagers in order of large numbers
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