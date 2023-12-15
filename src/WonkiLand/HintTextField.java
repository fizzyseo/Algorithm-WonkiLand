package WonkiLand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

// Show hint message
public class HintTextField extends JTextField implements FocusListener {
	private final String hint;
    private boolean showingHint;

    public HintTextField(String hint) {
        super(hint);
        this.hint = hint;
        this.showingHint = true;
        super.addFocusListener(this);
        setForeground(Color.GRAY); // Hint Color Settings
        showHint(); // Show initial hints
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (this.getText().isEmpty()) {
            showingHint = false;
            setForeground(Color.BLACK); // Change color to black when text is entered
            super.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (this.getText().isEmpty()) {
            showingHint = true;
            setForeground(Color.GRAY); // If you lose focus, change the hint color again
            showHint();
        }
    }

    private void showHint() {
        super.setText(hint);
    }

    @Override
    public String getText() {
        return showingHint ? "" : super.getText();
    }
}
