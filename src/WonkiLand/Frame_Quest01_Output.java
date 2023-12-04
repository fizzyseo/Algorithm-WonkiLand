package WonkiLand;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Frame_Quest01_Output extends JFrame {

    private JLabel imageLabel;
    private JLabel manLabel;
    private JLabel dialogLabel;
    private JLabel textLabel;
    private JLabel stampLabel;

    private JTextField storeField;
    private JTextField lengthField;
    private JTextField carrotField;

    public Frame_Quest01_Output(int storeCount, long[] distances, long[] fuelPrices) {
        super("Frame_Quest03_Output");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLayeredPane layeredPane = new JLayeredPane();

        JLabel backgroundLabel = new JLabel();
        Image background = new ImageIcon("image/background.png").getImage();
        Image scaledBackground = background.getScaledInstance(1500, 840, Image.SCALE_SMOOTH);
        backgroundLabel.setIcon(new ImageIcon(scaledBackground));
        backgroundLabel.setBounds(0, 0, 1500, 840);
        layeredPane.add(backgroundLabel, new Integer(0));

        JLabel titleLabel = new JLabel("Quest 1: Giving carrots to Lord Wonki's horse ");
        titleLabel.setFont(new Font("Inter", Font.BOLD, 45));
        titleLabel.setBounds(160, 55, 1168, 115);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        layeredPane.add(titleLabel, new Integer(1));

        manLabel = new JLabel();
        Image manImage = new ImageIcon("image/quest01_man_smile.png").getImage();
        Image scaledManImage = manImage.getScaledInstance(385, 381, Image.SCALE_SMOOTH);
        manLabel.setIcon(new ImageIcon(scaledManImage));
        manLabel.setBounds(160, 153, 385, 381);
        layeredPane.add(manLabel, new Integer(1));


        // 메세지창 배경 설정
        dialogLabel = new JLabel();
        Image dialogImage = new ImageIcon("image/dialog.png").getImage();
        Image scaledDialogImage = dialogImage.getScaledInstance(1042, 193, Image.SCALE_SMOOTH);
        dialogLabel.setIcon(new ImageIcon(scaledDialogImage));
        dialogLabel.setBounds(136, 530, 1042, 193);
        layeredPane.add(dialogLabel, new Integer(2));

        stampLabel = new JLabel();
        Image stampImage = new ImageIcon("image/stamp02.png").getImage();
        Image scaledStampImage = stampImage.getScaledInstance(364, 371, Image.SCALE_FAST);
        stampLabel.setIcon(new ImageIcon(scaledStampImage));
        stampLabel.setBounds(857, 170, 364, 371);
        layeredPane.add(stampLabel, new Integer(3));
        
     // 메세지창 텍스트 설정
        textLabel = new JLabel("<html>"
                + "That's great!</html>");
        textLabel.setFont(new Font("Inter", Font.BOLD, 40));
        textLabel.setBounds(163, 505, 986, 142);
        layeredPane.add(textLabel, new Integer(3));
        
        textLabel = new JLabel("<html>" + calculateAndDisplayResult(storeCount, distances, fuelPrices) + "</html>");
        textLabel.setFont(new Font("Inter", Font.BOLD, 35));
        textLabel.setBounds(160, 580, 986, 142);
        layeredPane.add(textLabel, new Integer(3));

        JLabel nextLabel = new JLabel();
        Image scrollImage = new ImageIcon("image/next_scroll.png").getImage();
        Image scaledScrollImage = scrollImage.getScaledInstance(220, 128, Image.SCALE_SMOOTH);
        nextLabel.setIcon(new ImageIcon(scaledScrollImage));
        nextLabel.setBounds(1202, 565, 220, 128);
        layeredPane.add(nextLabel, new Integer(3));

        nextLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                nextFrame();
            }
        });

        setFocusable(true);
        requestFocusInWindow();
        add(layeredPane);
        setSize(1510, 880);
        setVisible(true);
    }

    private String calculateAndDisplayResult(int storeCount, long[] distances, long[] fuelPrices) {
        if (storeCount <= 1 || distances.length != storeCount - 1 || fuelPrices.length != storeCount) {
            return "Invalid input.";
        }

        long totalCost = 0;
        long minCost = fuelPrices[0];

        for (int i = 0; i < storeCount - 1; i++) {
            if (fuelPrices[i] < minCost) {
                minCost = fuelPrices[i];
            }
            totalCost += (minCost * distances[i]);
        }

        return "The minimum cost of carrots from the left to the right village is " + totalCost + " G.";
    }


    private void nextFrame() {
        Frame_Quest02_1 frame_Quest02_1 = new Frame_Quest02_1();
        frame_Quest02_1.setVisible(true);

        setVisible(false);
        dispose();
    }

    public static void main(String[] args) {
        // Assuming there are input values (you need to modify this part for actual or user input)
        int storeCount = 4;
        long[] distances = {2, 3, 1};
        long[] fuelPrices = {5, 2, 4, 1};

        SwingUtilities.invokeLater(() -> new Frame_Quest01_Output(storeCount, distances, fuelPrices));
    }
}