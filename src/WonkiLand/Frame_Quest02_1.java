package WonkiLand;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Frame_Quest02_1 extends JFrame {

    private JLabel titleLabel;
    private JLabel imageLabel;
    private JLabel manLabel;
    private JLabel dialogLabel;
    private JLabel textLabel;

    public Frame_Quest02_1() {
        super("Frame_Quest02_1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the background image to be most backward Using the JLayerPane 
        JLayeredPane layeredPane = new JLayeredPane();

        // Background Image Settings
        JLabel backgroundLabel = new JLabel();
        Image background = new ImageIcon("image/background.png").getImage();
        Image scaledbackground = background.getScaledInstance(1500, 840, Image.SCALE_SMOOTH);
        backgroundLabel.setIcon(new ImageIcon(scaledbackground));
        backgroundLabel.setBounds(0, 0, 1500, 840);
        layeredPane.add(backgroundLabel, new Integer(0)); //Front and back priority adjustment (up to 0,1,2,3 in order)

        // Add text
        titleLabel = new JLabel("Quest 2 : Minimum number of dungeons ");
        titleLabel.setFont(new Font("Inter", Font.BOLD, 50));
        titleLabel.setBounds(160, 55, 1168, 115);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER); // 가운데 정렬
        layeredPane.add(titleLabel, new Integer(1));

        // Add Quest image
        imageLabel = new JLabel();
        Image image = new ImageIcon("image/quest02_image.png").getImage();
        Image scaledImage = image.getScaledInstance(838, 246, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaledImage));
        imageLabel.setBounds(473, 204, 838, 246);
        layeredPane.add(imageLabel, new Integer(1));
        
        // Add image of man
        manLabel = new JLabel();
        Image manImage = new ImageIcon("image/quest02_man.png").getImage();
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
                + "The adventurers of the original land are only required to participate at a fixed time when attacking Dungeon.<br><br>"
                + "Let's find the minimum number of dungeons required when each party is given attack start and end time.</html>");
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
        
        // Add KeyListener to move to the next frame when any key is pressed
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Move to the next frame when you press any key
            	nextFrame();
            }
        });
        
        setFocusable(true);		// Set focus to receive key events
        requestFocusInWindow();  //  As soon as the window opens, request focus
        
        // Add JLayeredPane to frame
        add(layeredPane);
        
        // Set frame size
        setSize(1510, 880);
        setVisible(true);
        
    }

    // Method to open the next frame
    private void nextFrame() {
    	Frame_Quest02_Input frame_Quest02_Input = new Frame_Quest02_Input();
    	frame_Quest02_Input.setVisible(true);
        
    	// Hide current frame
    	setVisible(false);
    	dispose();  // Remove current frame from memory
    }
        
    public static void main(String[] args) {
        new Frame_Quest02_1();
    }
}