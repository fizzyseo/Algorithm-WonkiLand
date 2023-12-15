package WonkiLand;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Frame_Main extends JFrame{
	
	public Frame_Main() {
		super("Frame_Main");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    // Use the JLayerPane to set the background image to be most backward
	    JLayeredPane layeredPane = new JLayeredPane();

	    // Background image settings
	    JLabel backgroundLabel = new JLabel();
	    Image background = new ImageIcon("image/background.png").getImage();
	    Image scaledbackground = background.getScaledInstance(1500, 840, Image.SCALE_SMOOTH);
	    backgroundLabel.setIcon(new ImageIcon(scaledbackground));
	    backgroundLabel.setBounds(0, 0, 1500, 840);
	    layeredPane.add(backgroundLabel, new Integer(0)); // 앞 뒤 우선순위 조절 0 1 2 3 순으로 위로 올라감
	    
	    // Add description at the top
        JLabel titleLabel = new JLabel("<html>"
        		+ "Welcome <br>"
        		+ "To <br>"
        		+ "WonkiLand" );
        titleLabel.setFont(new Font("Inter", Font.BOLD, 80));
        titleLabel.setBounds(221, 125, 473, 312);
        layeredPane.add(titleLabel, new Integer(1));
        
        // Main Photo
        JLabel imageLabel = new JLabel();
        Image image = new ImageIcon("image/MainPhoto.png").getImage();
        Image scaledImage = image.getScaledInstance(480, 587, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaledImage));
        imageLabel.setBounds(903, 126, 480, 587);
        layeredPane.add(imageLabel, new Integer(2));
        
        // close scroll
        JLabel nextLabel = new JLabel();
        Image ScrollImage = new ImageIcon("image/start_scroll.png").getImage();
        Image scaledScrollImage = ScrollImage.getScaledInstance(335, 177, Image.SCALE_SMOOTH);
        nextLabel.setIcon(new ImageIcon(scaledScrollImage));
        nextLabel.setBounds(457, 533, 335, 177);
        layeredPane.add(nextLabel, new Integer(3));
        
        // Add MouseListener to move to the next frame when scrolling is pressed
        nextLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	// Move to the next frame
            	nextFrame();
            }
        });
        
        setFocusable(true);		// Set focus to receive key events
        requestFocusInWindow();  // Request focus as soon as the window opens
        
        // Adding JLayerPane to the Frame
        add(layeredPane);
        
        // Setting the Frame Size
        setSize(1510, 880);
        setVisible(true);
    	}
	
	// Method to open the next frame
    private void nextFrame() {
    	Frame_Setting Frame_Setting = new Frame_Setting();
    	Frame_Setting.setVisible(true);
        
    	// Hide current frame
    	setVisible(false);
    	dispose();  // Remove current frame from memory
    }

	
    
	public static void main(String[] args) {
        new Frame_Main();
	}  
}