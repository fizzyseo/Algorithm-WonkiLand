package WonkiLand;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Frame_Quest01_2 extends JFrame {

    private JLabel titleLabel;
    private JLabel imageLabel;
    private JLabel manLabel;
    private JLabel dialogLabel;
    private JLabel textLabel;

    public Frame_Quest01_2() {
        super("Frame_Quest01_2");
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
        titleLabel = new JLabel("Quest 1 : Giving carrots to Lord Wonki's horse ");
        titleLabel.setFont(new Font("Inter", Font.BOLD, 45));
        titleLabel.setBounds(160, 55, 1168, 115);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER); // 가운데 정렬
        layeredPane.add(titleLabel, new Integer(1));

        // Add Quest image
        imageLabel = new JLabel();
        Image image = new ImageIcon("image/quest01_image.png").getImage();
        Image scaledImage = image.getScaledInstance(745, 186, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaledImage));
        imageLabel.setBounds(533, 217, 745, 186);
        layeredPane.add(imageLabel, new Integer(1));
        
        // Add image of man
        manLabel = new JLabel();
        Image manImage = new ImageIcon("image/quest01_man.png").getImage();
        Image scaledManImage = manImage.getScaledInstance(293, 300, Image.SCALE_SMOOTH);
        manLabel.setIcon(new ImageIcon(scaledManImage));
        manLabel.setBounds(164, 217, 293, 300);
        layeredPane.add(manLabel, new Integer(1));

        // Set the message window background
        dialogLabel = new JLabel();
        Image dialogImage = new ImageIcon("image/dialog.png").getImage();
        Image scaledDialogImage = dialogImage.getScaledInstance(1230, 228, Image.SCALE_SMOOTH);
        dialogLabel.setIcon(new ImageIcon(scaledDialogImage));
        dialogLabel.setBounds(137, 495, 1230, 228);
        layeredPane.add(dialogLabel, new Integer(2));

        // Set the message window text
        textLabel = new JLabel("<html>"
                + "There is a store every 1km from the village on the left to the village on the right.<br><br>"
                + "Let's find the minimum cost of getting carrot food from the village on the left to the village on the right.");
        textLabel.setFont(new Font("Inter", Font.BOLD, 27));
        textLabel.setBounds(186, 510, 1153, 198);
        layeredPane.add(textLabel, new Integer(3));


        // Set next scroll
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
        
        setFocusable(true);  // Set focus to receive key events
        requestFocusInWindow();  //  As soon as the window opens, request focus
        
        // Add JLayeredPane to frame
        add(layeredPane);
        
        // Set frame size
        setSize(1510, 880);
        setVisible(true);
    	}

    // Method to open the next frame
    private void nextFrame() {
    	Frame_Quest01_Input frame_Quest01_Input = new Frame_Quest01_Input();
    	frame_Quest01_Input.setVisible(true);
        
    	// Hide current frame
    	setVisible(false);
    	dispose();  // Remove current frame from memory
    }

    public static void main(String[] args) {
        new Frame_Quest01_2();
    }
}