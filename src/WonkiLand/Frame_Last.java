package WonkiLand;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Frame_Last extends JFrame{
	
	public Frame_Last() {
		super("Last");
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
                + "You did a great job.  Smart mercenary.<br><br>"
                + "Thanks to you, Wonki Land came back to life.<br><br>"
        		+ "Good bye.."+ "</html>");
        textLabel.setFont(new Font("Inter", Font.BOLD, 35));
        textLabel.setBounds(200, 175, 794, 243);
        layeredPane.add(textLabel, new Integer(2));
        
        // Gold Pouch picture
        JLabel imageLabel = new JLabel();
        Image image = new ImageIcon("image/Gold.png").getImage();
        Image scaledImage = image.getScaledInstance(311, 291, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaledImage));
        imageLabel.setBounds(355, 374, 311, 291);
        layeredPane.add(imageLabel, new Integer(3));
        
        // mission complete picture
        imageLabel = new JLabel();
        Image mission = new ImageIcon("image/stamp_com.png").getImage();
        Image scaledMissionImage = mission.getScaledInstance(666, 438, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaledMissionImage));
        imageLabel.setBounds(825, 5, 666, 438);
        layeredPane.add(imageLabel, new Integer(3));
        
        // close scroll
        imageLabel = new JLabel();
        Image close_image = new ImageIcon("image/close_scroll.png").getImage();
        Image scaledAcceptImage = close_image.getScaledInstance(315, 168, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaledAcceptImage));
        imageLabel.setBounds(908, 505, 315, 168);
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
	
	// Method to open the next frame
    private void nextFrame() {
        
    	// Hide current frame
    	setVisible(false);
    	dispose();  // Remove current frame from memory
    }
    
    public static void main(String[] args) {
    	new Frame_Last();
    }
}