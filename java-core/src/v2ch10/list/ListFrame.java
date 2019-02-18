package v2ch10.list;

import javax.swing.*;
import java.awt.*;

/**
 * This frame contains a word list and a label that shows a sentence made up
 * from the chosen words.
 * Note that you can select multiple words with Ctrl+click and Shift+click.
 */
public class ListFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 300;

    private JPanel listPanel;
    private JList<String> wordList;
    private JLabel label;
    private JPanel buttonPanel;
    private ButtonGroup group;
    private String prefix = "The ";
    private String suffix = "fox jumps over the lazy dog.";

    public ListFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        String[] words = {"quick", "brown", "hungry", "wild", "silent", "huge", "private", "abstract", "static", "final"};
        wordList = new JList<>(words);
        wordList.setVisibleRowCount(4);
        JScrollPane scrollPane = new JScrollPane(wordList);

        listPanel = new JPanel();
        listPanel.add(scrollPane);
        wordList.addListSelectionListener(event -> {
            StringBuilder text = new StringBuilder(prefix);
            for (String value : wordList.getSelectedValuesList()) {
                text.append(value).append(" ");
            }
            text.append(suffix);
            label.setText(text.toString());
        });

        buttonPanel = new JPanel();
        group = new ButtonGroup();
        makeButton("Vertical", JList.VERTICAL);
        makeButton("Vertical Wrap", JList.VERTICAL_WRAP);
        makeButton("Horizontal Wrap", JList.HORIZONTAL_WRAP);

        add(listPanel, BorderLayout.NORTH);
        label = new JLabel(prefix + suffix);
        add(label, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * Makes a radio button to set the layout orientation.
     *
     * @param label       the button label
     * @param orientation the orientation for the list
     */
    private void makeButton(String label, int orientation) {
        JRadioButton button = new JRadioButton(label);
        buttonPanel.add(button);
        if (group.getButtonCount() == 0) button.setSelected(true);
        group.add(button);
        button.addActionListener(event -> {
            wordList.setLayoutOrientation(orientation);
            listPanel.revalidate();
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ListFrame();
            frame.setTitle("ListFrame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
