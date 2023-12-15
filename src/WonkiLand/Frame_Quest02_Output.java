package WonkiLand;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Frame_Quest02_Output extends JFrame {

    private JLabel titleLabel;
    private JLabel imageLabel;
    private JLabel manLabel;
    private JLabel stampLabel;
    private JLabel dialogLabel;
    private JLabel textLabel;

    public Frame_Quest02_Output(int calculatedValue) {
        super("Frame_Quest02_Output");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Use JLayeredPane to ensure the background image is placed at the back
        JLayeredPane layeredPane = new JLayeredPane();

        // Set the background image
        JLabel backgroundLabel = new JLabel();
        Image background = new ImageIcon("image/background.png").getImage();
        Image scaledbackground = background.getScaledInstance(1500, 840, Image.SCALE_SMOOTH);
        backgroundLabel.setIcon(new ImageIcon(scaledbackground));
        backgroundLabel.setBounds(0, 0, 1500, 840);
        layeredPane.add(backgroundLabel, new Integer(0)); // 앞 뒤 우선순위 조절 0 1 2 3 순으로 위로 올라감

        // Place the title at the top
        titleLabel = new JLabel("Quest 2 : Minimum number of dungeons ");
        titleLabel.setFont(new Font("Inter", Font.BOLD, 50));
        titleLabel.setBounds(160, 55, 1168, 115);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER); // 가운데 정렬
        layeredPane.add(titleLabel, new Integer(1));
        
        // Set the quest man image
        manLabel = new JLabel();
        Image manImage = new ImageIcon("image/quest02_man_smile.png").getImage();
        Image scaledManImage = manImage.getScaledInstance(360, 354, Image.SCALE_SMOOTH);
        manLabel.setIcon(new ImageIcon(scaledManImage));
        manLabel.setBounds(164, 217, 360, 354);
        layeredPane.add(manLabel, new Integer(1));

        // Set the stamp image
        stampLabel = new JLabel();
        Image stampImage = new ImageIcon("image/stamp02.png").getImage();
        Image scaledstampImage = stampImage.getScaledInstance(364, 371, Image.SCALE_FAST);
        stampLabel.setIcon(new ImageIcon(scaledstampImage));
        stampLabel.setBounds(874, 170, 364, 371);
        layeredPane.add(stampLabel, new Integer(3));
        
        // Set the message box background
        dialogLabel = new JLabel();
        Image dialogImage = new ImageIcon("image/dialog.png").getImage();
        Image scaledDialogImage = dialogImage.getScaledInstance(1042, 193, Image.SCALE_SMOOTH);
        dialogLabel.setIcon(new ImageIcon(scaledDialogImage));
        dialogLabel.setBounds(136, 530, 1042, 193);
        layeredPane.add(dialogLabel, new Integer(2));

        
        // Set the message box text
        textLabel = new JLabel("<html>"
                + "Good job!</html>");
        textLabel.setFont(new Font("Inter", Font.BOLD, 40));
        textLabel.setBounds(163, 505, 986, 142);
        layeredPane.add(textLabel, new Integer(3));
        
        // Set additional message box text with calculated value
        textLabel = new JLabel("<html>The minimum number of dungeons is " + calculatedValue + "<br>"
        		+ "Thanks to you, adventurers will be able to easily attack Dungeon!</html>");
        textLabel.setFont(new Font("Inter", Font.BOLD, 27));
        textLabel.setBounds(163, 595, 986, 142);
        layeredPane.add(textLabel, new Integer(3));


        // Set up the next scroll button
        JLabel nextLabel = new JLabel();
        Image ScrollImage = new ImageIcon("image/next_scroll.png").getImage();
        Image scaledScrollImage = ScrollImage.getScaledInstance(220, 128, Image.SCALE_SMOOTH);
        nextLabel.setIcon(new ImageIcon(scaledScrollImage));
        nextLabel.setBounds(1200, 560, 220, 128);
        layeredPane.add(nextLabel, new Integer(3));
        
        // Add a MouseListener to move to the next frame when the scroll is clicked
        nextLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	// Move to the next frame
            	nextFrame();
            }
        });
        
        
        setFocusable(true);  // Enable receiving key events
        requestFocusInWindow();  // Request focus as the window opens
        
        // Add the JLayeredPane to the frame
        add(layeredPane);
        
        // Set the frame size
        setSize(1510, 880);
        setVisible(true);
    	}

    // Method to open the next frame
    private void nextFrame() {
    	Frame_Quest03_Input frame_Quest03_Input = new Frame_Quest03_Input();
    	frame_Quest03_Input.setVisible(true);
        
    	// Hide the current frame
    	setVisible(false);
    	dispose();  // Remove the current frame from memory
    }
        
    public static void main(String[] args) {
        new Frame_Quest02_Output(123);
    }
}