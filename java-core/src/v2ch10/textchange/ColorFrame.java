package v2ch10.textchange;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.text.NumberFormat;

/**
 * A frame with three text fields to change the background color
 */
public class ColorFrame extends JFrame {

    private JPanel panel;
    private JTextField redField;
    private JTextField greenField;
    private JTextField blueField;

    public ColorFrame() throws HeadlessException {
        DocumentListener listener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                setColor();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                setColor();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        };

        panel = new JPanel();
        panel.add(new JLabel("Red:"));
        redField = new JTextField("255", 3);
        panel.add(redField);
        redField.getDocument().addDocumentListener(listener);

        panel.add(new JLabel("Green:"));
        greenField = new JTextField("255", 3);
        panel.add(greenField);
        greenField.getDocument().addDocumentListener(listener);

        panel.add(new JLabel("Blue:"));
        blueField = new JTextField("255", 3);
        panel.add(blueField);
        blueField.getDocument().addDocumentListener(listener);

        add(panel);
        pack();
    }

    /**
     * Set the background color to the value in the text field
     */
    private void setColor() {

        try {
            int red = Integer.parseInt(redField.getText().trim());
            int green = Integer.parseInt(greenField.getText().trim());
            int blue = Integer.parseInt(blueField.getText().trim());

            panel.setBackground(new Color(red, green, blue));
        } catch (NumberFormatException e) {
            System.out.println("Not update color since input value is invalid");
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ColorFrame();
            frame.setTitle("ColorFrame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

