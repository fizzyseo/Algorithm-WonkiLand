package WonkiLand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;


public class HintTextField extends JTextField implements FocusListener {
	private final String hint;
    private boolean showingHint;

    public HintTextField(String hint) {
        super(hint);
        this.hint = hint;
        this.showingHint = true;
        super.addFocusListener(this);
        setForeground(Color.GRAY); // 힌트 색상 설정
        showHint(); // 초기에 힌트 표시
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (this.getText().isEmpty()) {
            showingHint = false;
            setForeground(Color.BLACK); // 텍스트를 입력받을 때는 색상을 검정색으로 변경
            super.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (this.getText().isEmpty()) {
            showingHint = true;
            setForeground(Color.GRAY); // 포커스를 잃으면 다시 힌트 색상으로 변경
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
