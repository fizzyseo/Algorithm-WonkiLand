package WonkiLand;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Frame_Quest01_1 extends JFrame {

    private JLabel titleLabel;
    private JLabel imageLabel;
    private JLabel manLabel;
    private JLabel dialogLabel;
    private JLabel textLabel;

    public Frame_Quest01_1() {
        super("Frame_Quest01_1");
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
        titleLabel = new JLabel("Quest 1 : Giving carrots to Lord Wonki's horse ");
        titleLabel.setFont(new Font("Inter", Font.BOLD, 45));
        titleLabel.setBounds(160, 55, 1168, 115);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER); // 가운데 정렬
        layeredPane.add(titleLabel, new Integer(1));

        // Quest01 image 
        imageLabel = new JLabel();
        Image image = new ImageIcon("image/quest01_image.png").getImage();
        Image scaledImage = image.getScaledInstance(745, 186, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaledImage));
        imageLabel.setBounds(533, 217, 745, 186);
        layeredPane.add(imageLabel, new Integer(1));
        
        // Quest01 man image 
        manLabel = new JLabel();
        Image manImage = new ImageIcon("image/quest01_man.png").getImage();
        Image scaledManImage = manImage.getScaledInstance(293, 300, Image.SCALE_SMOOTH);
        manLabel.setIcon(new ImageIcon(scaledManImage));
        manLabel.setBounds(164, 217, 293, 300);
        layeredPane.add(manLabel, new Integer(1));

        // Message window background settings
        dialogLabel = new JLabel();
        Image dialogImage = new ImageIcon("image/dialog.png").getImage();
        Image scaledDialogImage = dialogImage.getScaledInstance(1230, 228, Image.SCALE_SMOOTH);
        dialogLabel.setIcon(new ImageIcon(scaledDialogImage));
        dialogLabel.setBounds(137, 495, 1230, 228);
        layeredPane.add(dialogLabel, new Integer(2));

        // Message window text settings
        textLabel = new JLabel("<html>"
                + "Mercenaries must give 1km of carrots to the lord's horse of Wonki Land each time they move.<br>"
                + "There are several villages in Wonki Land.<br>"
                + "The price of carrots varies from village to village.</html>");
        textLabel.setFont(new Font("Inter", Font.BOLD, 27));
        textLabel.setBounds(186, 510, 1153, 198);
        layeredPane.add(textLabel, new Integer(3));


        // Next scrolling settings
        JLabel nextLabel = new JLabel();
        Image ScrollImage = new ImageIcon("image/next_scroll.png").getImage();
        Image scaledScrollImage = ScrollImage.getScaledInstance(167, 88, Image.SCALE_SMOOTH);
        nextLabel.setIcon(new ImageIcon(scaledScrollImage));
        nextLabel.setBounds(1245, 450, 167, 88);
        layeredPane.add(nextLabel, new Integer(3));
        
        // Add MouseListener to move to the next frame when scrolling is pressed
        nextLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Move to the next frame
            	nextFrame();
            }
        });
        
        // Add KeyListener to move to the next frame when any key is pressed
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Move to the next frame when you press any key
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
    	Frame_Quest01_2 frame_Quest01_2 = new Frame_Quest01_2();
    	frame_Quest01_2.setVisible(true);
        
    	// Hide current frame
    	setVisible(false);
    	dispose();  // Remove current frame from memory
    }
        
    public static void main(String[] args) {
        new Frame_Quest01_1();
    }
}