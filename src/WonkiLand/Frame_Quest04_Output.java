package WonkiLand;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Frame_Quest04_Output extends JFrame {
   
	private JLabel imageLabel;
    private JLabel manLabel;
    private JLabel dialogLabel;
    private JLabel textLabel;
    private JLabel stampLabel;

    public Frame_Quest04_Output(int calculatedValue) {
    	
        super("Frame_Quest04_Output");
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
        JLabel titleLabel = new JLabel("Quest 4 : The largest number of happy villagers ");
        titleLabel.setFont(new Font("Inter", Font.BOLD, 50));
        titleLabel.setBounds(160, 55, 1168, 115);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        layeredPane.add(titleLabel, new Integer(1));

        // Lord_Wonki picture
        manLabel = new JLabel();
        Image manImage = new ImageIcon("image/Lord_Wonki.png").getImage();
        Image scaledManImage = manImage.getScaledInstance(280, 315, Image.SCALE_SMOOTH);
        manLabel.setIcon(new ImageIcon(scaledManImage));
        manLabel.setBounds(117, 213, 280, 315);
        layeredPane.add(manLabel, new Integer(1));
        
        // Message window background settings
        dialogLabel = new JLabel();
        Image dialogImage = new ImageIcon("image/dialog.png").getImage();
        Image scaledDialogImage = dialogImage.getScaledInstance(776, 296, Image.SCALE_SMOOTH);
        dialogLabel.setIcon(new ImageIcon(scaledDialogImage));
        dialogLabel.setBounds(411, 230, 776, 296);
        layeredPane.add(dialogLabel, new Integer(2));
        
        // Stamp Image Settings
        stampLabel = new JLabel();
        Image stampImage = new ImageIcon("image/stamp02.png").getImage();
        Image scaledstampImage = stampImage.getScaledInstance(323, 326, Image.SCALE_FAST);
        stampLabel.setIcon(new ImageIcon(scaledstampImage));
        stampLabel.setBounds(1077, 309, 323, 326);
        layeredPane.add(stampLabel, new Integer(3));
        

        // Text window message settings
        textLabel = new JLabel("<html>"
                + "It's perfect!<br><br>"
                + calculatedValue + " residents became happy.<br><br>"
                + "Thanks, smart mercenary.</html>");
        textLabel.setFont(new Font("Inter", Font.BOLD, 37));
        textLabel.setBounds(441, 250, 720, 240);
        layeredPane.add(textLabel, new Integer(3));
        
        
        // Message window text settings
        JLabel textLabel1 = new JLabel("Lord Wonki");
        textLabel1.setFont(new Font("Palatino Linotype", Font.BOLD, 30));
        textLabel1.setBounds(156, 547, 200, 49);
        textLabel1.setHorizontalAlignment(SwingConstants.CENTER); // 가운데 정렬
        layeredPane.add(textLabel1, new Integer(3));
        

        // next scroll
        JLabel nextLabel = new JLabel();
        Image ScrollImage = new ImageIcon("image/next_scroll.png").getImage();
        Image scaledScrollImage = ScrollImage.getScaledInstance(220, 128, Image.SCALE_SMOOTH);
        nextLabel.setIcon(new ImageIcon(scaledScrollImage));
        nextLabel.setBounds(640, 596, 220, 128);
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

    // Method to open the next frame
    private void nextFrame() {
    	Frame_Last frame_Last = new Frame_Last();
    	frame_Last.setVisible(true);
        
    	// Hide current frame
    	setVisible(false);
    	dispose();  // Remove current frame from memory
    }
    
    
    	
    public static void main(String[] args) {
        new Frame_Quest04_Output(123);
    }
}