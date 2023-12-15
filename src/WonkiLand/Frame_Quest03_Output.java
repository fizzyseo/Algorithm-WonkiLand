package WonkiLand;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Frame_Quest03_Output extends JFrame {
   
    private JLabel manLabel;
    private JLabel dialogLabel;
    private JLabel textLabel;
    private JLabel stampLabel;
    
    public Frame_Quest03_Output(int calculatedValue) {
    	
        super("Frame_Quest03_Output");
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

        // Put Titles on top
        JLabel titleLabel = new JLabel("Quest 3 : The cost of connecting a road ");
        titleLabel.setFont(new Font("Inter", Font.BOLD, 50));
        titleLabel.setBounds(160, 55, 1168, 115);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        layeredPane.add(titleLabel, new Integer(1));

        // Quest male image settings
        manLabel = new JLabel();
        Image manImage = new ImageIcon("image/quest03_man_smile.png").getImage();
        Image scaledManImage = manImage.getScaledInstance(385, 381, Image.SCALE_SMOOTH);
        manLabel.setIcon(new ImageIcon(scaledManImage));
        manLabel.setBounds(160, 153, 385, 381);
        layeredPane.add(manLabel, new Integer(1));
        
        // Message window background settings
        dialogLabel = new JLabel();
        Image dialogImage = new ImageIcon("image/dialog.png").getImage();
        Image scaledDialogImage = dialogImage.getScaledInstance(1042, 193, Image.SCALE_SMOOTH);
        dialogLabel.setIcon(new ImageIcon(scaledDialogImage));
        dialogLabel.setBounds(136, 530, 1042, 193);
        layeredPane.add(dialogLabel, new Integer(2));
        
      	// Stamp Image Settings
        stampLabel = new JLabel();
        Image stampImage = new ImageIcon("image/stamp02.png").getImage();
        Image scaledstampImage = stampImage.getScaledInstance(364, 371, Image.SCALE_FAST);
        stampLabel.setIcon(new ImageIcon(scaledstampImage));
        stampLabel.setBounds(857, 170, 364, 371);
        layeredPane.add(stampLabel, new Integer(3));
        
        
        // Message window text settings
        textLabel = new JLabel("<html>"
                + "Awesome!</html>");
        textLabel.setFont(new Font("Inter", Font.BOLD, 45));
        textLabel.setBounds(160, 500, 986, 142);
        layeredPane.add(textLabel, new Integer(3));
        
        
        textLabel = new JLabel("<html>"
                + "we can connect all the villages with " + calculatedValue + "G cost!</html>");
        textLabel.setFont(new Font("Inter", Font.BOLD, 35));
        textLabel.setBounds(160, 590, 986, 142);
        layeredPane.add(textLabel, new Integer(3));
        

        // Next scrolling settings
        JLabel nextLabel = new JLabel();
        Image ScrollImage = new ImageIcon("image/next_scroll.png").getImage();
        Image scaledScrollImage = ScrollImage.getScaledInstance(220, 128, Image.SCALE_SMOOTH);
        nextLabel.setIcon(new ImageIcon(scaledScrollImage));
        nextLabel.setBounds(1202, 565, 220, 128);
        layeredPane.add(nextLabel, new Integer(3));
        
        // Add MouseListener to move to the next frame when scrolling is pressed
        nextLabel.addMouseListener(new MouseAdapter() {
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
    
    // Next frame
    private void nextFrame() {
    	// Move to the next frame
        Frame_Quest04_Input frame_Quest04_Input = new Frame_Quest04_Input();
        frame_Quest04_Input.setVisible(true);

        // Hide current frame
        setVisible(false);
        dispose();  // Remove current frame from memory
    }
    
    public static void main(String[] args) {
        new Frame_Quest03_Output(123);
    }
}