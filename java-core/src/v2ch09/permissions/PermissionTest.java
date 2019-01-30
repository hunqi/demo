package v2ch09.permissions;

import javax.swing.*;
import java.awt.*;

/**
 * This class demonstrates the customer WordCheckPermission
 */
public class PermissionTest {

    public static void main(String[] args) {
        System.setProperty("java.security.policy", "src/v2ch09/permissions/PermissionTest.policy");
        System.setSecurityManager(new SecurityManager());

        EventQueue.invokeLater(() -> {
            JFrame frame = new PermissionTestFrame();
            frame.setTitle("PermissionTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/**
 * This frame contains a text field for inserting works into a text area that is protected from bad words
 */
class PermissionTestFrame extends JFrame {

    private JTextField textField;
    private WordCheckTextArea textArea;
    private static final int TEXT_ROWS = 20;
    private static final int TEXT_COLUMNS = 20;

    public PermissionTestFrame() {
        textField = new JTextField(20);
        JPanel panel = new JPanel();
        panel.add(textField);

        JButton openButton = new JButton("Insert");
        panel.add(openButton);
        openButton.addActionListener(event -> insertWords(textField.getText()));

        add(panel, BorderLayout.NORTH);

        textArea = new WordCheckTextArea();
        textArea.setRows(TEXT_ROWS);
        textArea.setColumns(TEXT_COLUMNS);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        pack();
    }

    /**
     * Tries to insert the words into the text area.Display a dialog if the attempt fails.
     *
     * @param words the words to insert
     */
    private void insertWords(String words) {
        try {
            textArea.append(words + "\n");
        } catch (SecurityException e) {
            JOptionPane.showMessageDialog(this, "I am sorry, but i can't do that.");
            e.printStackTrace();
        }
    }


}

/**
 * A text area whose append method makes a security check to see that no bad words are added
 */
class WordCheckTextArea extends JTextArea {

    @Override
    public void append(String str) {
        WordCheckPermission p = new WordCheckPermission(str, "insert");
        SecurityManager manager = System.getSecurityManager();
        if (manager != null) manager.checkPermission(p);
        super.append(str);
    }
}
























