package WonkiLand;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Frame_Setting extends JFrame{
	
	public Frame_Setting() {
		super("Frame_Setting");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Use the JLayerPane to set the background image to be most backward
        JLayeredPane layeredPane = new JLayeredPane();
        
        // Background image settings
        JLabel backgroundLabel = new JLabel();
        Image background = new ImageIcon("image/background.png").getImage();
        Image scaledbackground = background.getScaledInstance(1500, 840, Image.SCALE_SMOOTH);
        backgroundLabel.setIcon(new ImageIcon(scaledbackground));
        backgroundLabel.setBounds(0, 0, 1500, 840);
        layeredPane.add(backgroundLabel, new Integer(0)); // Adjust the priorities
        
        // Put a background picture
        JLabel backgroundLabel2 = new JLabel();
        Image background2 = new ImageIcon("image/background2.png").getImage();
        Image scaledbackground2 = background2.getScaledInstance(1315, 675, Image.SCALE_SMOOTH);
        backgroundLabel2.setIcon(new ImageIcon(scaledbackground2));
        backgroundLabel2.setBounds(95, 80, 1315, 675);
        layeredPane.add(backgroundLabel2, new Integer(1));
        
        // Add description at the top
        JLabel textLabel = new JLabel("<html>"
                + "You're a smart mercenary and you go around making money.<br><br>"
                + "The lord of WK Land became seriously ill and his administrative work was <br>"
                + "paralyzed. <br><br>"
        		+ "Help the village's request to bring stability to the town."+ "</html>");
        textLabel.setFont(new Font("Inter", Font.BOLD, 30));
        textLabel.setBounds(213, 80, 1186, 343);
        layeredPane.add(textLabel, new Integer(2));
        
        // Map picture
        JLabel imageLabel = new JLabel();
        Image image = new ImageIcon("image/WonkiLand.png").getImage();
        Image scaledImage = image.getScaledInstance(450, 297, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaledImage));
        imageLabel.setBounds(225, 408, 450, 297);
        layeredPane.add(imageLabel, new Integer(3));
        
        // Client : WonkiLand, Reward : 1000G
        JLabel titleLabel = new JLabel("Client : WonkiLand    Reward : 1000G");
        titleLabel.setFont(new Font("Inter", Font.BOLD, 30));
        titleLabel.setBounds(718, 441, 623, 69);
        titleLabel.setHorizontalAlignment(SwingConstants.RIGHT); // center alignment
        layeredPane.add(titleLabel, new Integer(4));
        
        // ACCEPT picture
        imageLabel = new JLabel();
        Image accept_image = new ImageIcon("image/accept.png").getImage();
        Image scaledAcceptImage = accept_image.getScaledInstance(177, 87, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaledAcceptImage));
        imageLabel.setBounds(961, 579, 177, 87);
        layeredPane.add(imageLabel, new Integer(5));
        
		// Add MouseListener to move to the next frame when scrolling is pressed
        imageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Move to the next frame
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
	
	// Method to open next frame Frame_Quest01_2
    private void nextFrame() {
    	Frame_Quest01_1 Frame_Quest01_1 = new Frame_Quest01_1();
    	Frame_Quest01_1.setVisible(true);
        
    	// Hide current frame
    	setVisible(false);
    	dispose();  // Remove current frame from memory
    }
    
    public static void main(String[] args) {
    	new Frame_Setting();
    }

}