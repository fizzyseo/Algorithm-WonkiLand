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

        // Set the background image to be most backward Using the JLayerPane
        JLayeredPane layeredPane = new JLayeredPane();

        // Background Image Settings
        JLabel backgroundLabel = new JLabel();
        Image background = new ImageIcon("image/background.png").getImage();
        Image scaledbackground = background.getScaledInstance(1500, 840, Image.SCALE_SMOOTH);
        backgroundLabel.setIcon(new ImageIcon(scaledbackground));
        backgroundLabel.setBounds(0, 0, 1500, 840);
        layeredPane.add(backgroundLabel, new Integer(0)); // 앞 뒤 우선순위 조절 0 1 2 3 순으로 위로 올라감

     	// Add text
        JLabel titleLabel = new JLabel("Quest 1: Giving carrots to Lord Wonki's horse");
        titleLabel.setFont(new Font("Inter", Font.BOLD, 45));
        titleLabel.setBounds(160, 55, 1168, 115);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        layeredPane.add(titleLabel, new Integer(1));

        // Add image1
        JLabel storeLabel = new JLabel();
        Image store = new ImageIcon("image/icon_store.png").getImage();
        Image scaledstoreImage = store.getScaledInstance(115, 115, Image.SCALE_SMOOTH);
        storeLabel.setIcon(new ImageIcon(scaledstoreImage));
        storeLabel.setBounds(230, 221, 115, 115);
        layeredPane.add(storeLabel, new Integer(2));
        
        // Add image2
        JLabel lengthLabel = new JLabel();
        Image length = new ImageIcon("image/icon_length.png").getImage();
        Image scaledlengthImage = length.getScaledInstance(115, 115, Image.SCALE_SMOOTH);
        lengthLabel.setIcon(new ImageIcon(scaledlengthImage));
        lengthLabel.setBounds(230, 378, 115, 115);
        layeredPane.add(lengthLabel, new Integer(2));
        
        // Add image3
        JLabel carrotLabel = new JLabel();
        Image carrot = new ImageIcon("image/icon_carrot.png").getImage();
        Image scaledcarrotImage = carrot.getScaledInstance(115, 115, Image.SCALE_SMOOTH);
        carrotLabel.setIcon(new ImageIcon(scaledcarrotImage));
        carrotLabel.setBounds(230, 530, 115, 115);
        layeredPane.add(carrotLabel, new Integer(2));
        
        // Add text
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
        
        // Message window to be entered
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
        
        
        // Set next scroll
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
        
        // Set frame size
        setSize(1510, 880);
        setVisible(true);
       }

    // Method to open the next frame
    private void nextFrame() {
        // Value entered by user
    	int numberofstores = Integer.parseInt(storeField.getText()); // received the number of stores from storeField
    	String[] distanceinput = lengthField.getText().split(" ");
    	long[] distance = new long [distanceinput.length];
    	for (int i = 0; i < distanceinput.length; i++) {
    			distance[i] = Long.parseLong (distanceinput[i]); // distance received from lengthField
    	}
    	
    	String[] FuelPriceInput = carrotField.getText().split(" ");
    	long[] fuelprice = new long [FuelPriceInput. length];
    	for (int i = 0; i < FuelPriceInput.length; i++) {
    		fuelprice [i] = Long.parseLong (FuelPriceInput [i]); // Fuel price received from carrotField
    		}

    	Frame_Quest01_Output frame_Quest01_Output = new Frame_Quest01_Output (numberofstores, distance, fuelprice);
    	frame_Quest01_Output.setVisible(true);

    	// Hide current frame
    	setVisible(false);
    	dispose();  // Remove current frame from memory
    }

    
    public static void main(String[] args) {
        new Frame_Quest01_1();
    }
}