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

        // Set the background image to be most backward Using the JLayerPane 
        JLayeredPane layeredPane = new JLayeredPane();

        // Background Image Settings
        JLabel backgroundLabel = new JLabel();
        Image background = new ImageIcon("image/background.png").getImage();
        Image scaledbackground = background.getScaledInstance(1500, 840, Image.SCALE_SMOOTH);
        backgroundLabel.setIcon(new ImageIcon(scaledbackground));
        backgroundLabel.setBounds(0, 0, 1500, 840);
        layeredPane.add(backgroundLabel, new Integer(0)); // 앞 뒤 우선순위 조절 0 1 2 3 순으로 위로 올라감

        // add title
        JLabel titleLabel = new JLabel("Quest 2 : Minimum number of dungeons ");
        titleLabel.setFont(new Font("Inter", Font.BOLD, 50));
        titleLabel.setBounds(160, 55, 1168, 115);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        layeredPane.add(titleLabel, new Integer(1));

        // add party icon
        JLabel storeLabel = new JLabel();
        Image store = new ImageIcon("image/icon_party.png").getImage();
        Image scaledstoreImage = store.getScaledInstance(217, 170, Image.SCALE_SMOOTH);
        storeLabel.setIcon(new ImageIcon(scaledstoreImage));
        storeLabel.setBounds(239, 224, 217, 170);
        layeredPane.add(storeLabel, new Integer(2));
        
        // add time icon
        JLabel lengthLabel = new JLabel();
        Image length = new ImageIcon("image/icon_time.png").getImage();
        Image scaledlengthImage = length.getScaledInstance(187, 187, Image.SCALE_SMOOTH);
        lengthLabel.setIcon(new ImageIcon(scaledlengthImage));
        lengthLabel.setBounds(254, 465, 187, 187);
        layeredPane.add(lengthLabel, new Integer(2));
        
        // add text
        JLabel textLabel1 = new JLabel("The number of party");
        textLabel1.setFont(new Font("Inter", Font.BOLD, 35));
        textLabel1.setBounds(475, 276, 550, 65);
        layeredPane.add(textLabel1, new Integer(1));

        JLabel textLabel2 = new JLabel("Reservation time for each team");
        textLabel2.setFont(new Font("Inter", Font.BOLD, 35));
        textLabel2.setBounds(475, 524, 550, 65);
        layeredPane.add(textLabel2, new Integer(1));

        
     // Set the message window text
        partyField = new HintTextField("3");
        partyField.setFont(new Font("Inter", Font.PLAIN, 25));
        partyField.setBounds(1040, 276, 270, 65);
        layeredPane.add(partyField, new Integer(3));

        timeField = new HintTextField("(1 3)(2 4)(3 5)");
        timeField.setFont(new Font("Inter", Font.PLAIN, 25));
        timeField.setBounds(1040, 524, 270, 65);
        layeredPane.add(timeField, new Integer(3));

        
        // add scroll
        JLabel nextLabel = new JLabel();
        Image ScrollImage = new ImageIcon("image/submit_scroll.png").getImage();
        Image scaledScrollImage = ScrollImage.getScaledInstance(187, 100, Image.SCALE_SMOOTH);
        nextLabel.setIcon(new ImageIcon(scaledScrollImage));
        nextLabel.setBounds(1205, 660, 187, 100);
        layeredPane.add(nextLabel, new Integer(4));
        
        // Add MouseListener to move to the next frame when scrolling is pressed
        nextLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Move to the next frame
            	nextFrame();
            }
        });
        
        setFocusable(true);  // Set focus to receive key events
        requestFocusInWindow();  // As soon as the window opens, request focus
        
        // Add JLayeredPane to frame
        add(layeredPane);
        
        //  Set frame size
        setSize(1510, 880);
        setVisible(true);
    	}
    
    // Method to open the next frame
    private void nextFrame() {
    	try {
            // Parsing Input Values
            int numberOfDungeon = Integer.parseInt(partyField.getText());
            String inputText = timeField.getText();

            // Exception: NumberFormatException occurs if the user does not enter a number
            String[] timeStrings = inputText.split("\\)\\(");

            // Initialize study array of correct size
            Point[] study = new Point[timeStrings.length];

            for (int i = 0; i < timeStrings.length; i++) {
                // Remove parentheses before and after the string, and extract each number
                String[] input = timeStrings[i].replaceAll("\\(", "").replaceAll("\\)", "").split(" ");

                // Use i as an example
                study[i] = new Point(Integer.parseInt(input[0]) - 1, Integer.parseInt(input[1]) - 1);
            }

         // Sort in ascending order by start time,
         // If the start time is the same, sort in ascending order based on the end time.
            Arrays.sort(study, (l1, l2) -> l1.x == l2.x ? l1.y - l2.y : l1.x - l2.x);

            // Your existing logic for finding minimum classrooms
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.offer(study[0].y);

            for (int i = 1; i < numberOfDungeon; i++) {
            	// The smallest exit time in the priority queue and
            	// Compare the start time of the current study[i].
                if (pq.peek() <= study[i].x) {
                    pq.poll();
                }
                pq.offer(study[i].y);
            }

            int calculatedValue = pq.size();

            // Continue with the rest of your nextFrame() method
            Frame_Quest02_Output frame_Quest02_Output = new Frame_Quest02_Output(calculatedValue);
            frame_Quest02_Output.setVisible(true);

            // Hide current frame
            setVisible(false);
            dispose();  // Remove current frame from memory
        } catch (NumberFormatException e) {
            // Handle the case where parsing fails
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid numbers.");
        }
    }
    
    public static void main(String[] args) {
        new Frame_Quest02_1();
    }
}