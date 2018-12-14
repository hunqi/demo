package applet;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import java.util.Random;

/**
 * This program is provided to exam multiplication tables 9*9
 * 1x1 - 9x9
 * @author ray.sun
 * @since Dec 14th 2018
 */
public class ExamApplet extends JPanel
        implements PropertyChangeListener {

    //Values for the fields
    private int multiplier1 = 8;
    private int multiplier2 = 9;  //7.5%

    //Fields for data entry
    private JFormattedTextField mutiplier1Field;
    private JFormattedTextField multiplier2Field;
    private JTextField inputField;
    private JTextField resultField;

    //Formats to format and parse numbers
    private NumberFormat multiplier1Format;
    private NumberFormat multiplier2Format;
    private NumberFormat resultFormat;

    public ExamApplet() {
        super(new BorderLayout());
        setUpFormats();
//        int inputResult = compute(multiplier1, multiplier2);

        //Create the text fields and set them up.
        mutiplier1Field = new JFormattedTextField(multiplier1Format);
        mutiplier1Field.setValue(new Integer(multiplier1));
        mutiplier1Field.setEditable(false);
        mutiplier1Field.setColumns(5);
        mutiplier1Field.setFont(new Font("Black", 1, 20));
        mutiplier1Field.setHorizontalAlignment(0);
        mutiplier1Field.setBorder(null);

        multiplier2Field = new JFormattedTextField(multiplier2Format);
        multiplier2Field.setValue(new Integer(multiplier2));
        multiplier2Field.setEditable(false);
        multiplier2Field.setColumns(5);
        multiplier2Field.setFont(new Font("Black", 1, 20));
        multiplier2Field.setHorizontalAlignment(0);
        multiplier2Field.setBorder(null);

        inputField = new JFormattedTextField(resultFormat);
        inputField.setColumns(5);
        inputField.addPropertyChangeListener("value", this);
        inputField.setFont(new Font("Black", 1, 20));
        inputField.setHorizontalAlignment(0);

        resultField = new JTextField();
        resultField.setColumns(5);
        resultField.setEditable(false);
        resultField.setForeground(Color.red);
        resultField.setFont(new Font("Black", 1, 20));
        resultField.setHorizontalAlignment(0);

        JTextField multipleSign = new JTextField("x");
        multipleSign.setFont(new Font("Black", 1, 20));
        multipleSign.setEditable(false);
        multipleSign.setHorizontalAlignment(0);
        multipleSign.setBorder(null);

        //Layout the text fields in a panel.
        JPanel fieldPane = new JPanel(new GridLayout(0, 4));
        fieldPane.add(mutiplier1Field);
        fieldPane.add(multipleSign);
        fieldPane.add(multiplier2Field);
        fieldPane.add(inputField);

        //result panel
        JPanel resultPane = new JPanel(new GridLayout(0, 2));
        resultPane.add(resultField);
        JButton btnNextQ = new JButton("下一题");
        resultPane.add(btnNextQ);
        btnNextQ.addActionListener(event -> {
            generateMultipliersRandomly();
        });

        //Put the panels in this panel, labels on left,
        //text fields on right.
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(fieldPane, BorderLayout.NORTH);
        add(resultPane, BorderLayout.SOUTH);
    }

    private void generateMultipliersRandomly(){
        Random r = new Random();
        int m1 = 2 + r.nextInt(8);
        int m2 = 2 + r.nextInt(8);
        mutiplier1Field.setValue(m1);
        multiplier2Field.setValue(m2);
        inputField.setText("");
        resultField.setText("");
    }

    /**
     * Called when a field's "value" property changes.
     */
    public void propertyChange(PropertyChangeEvent e) {
        Object source = e.getSource();
        if (source == inputField && (inputField.getText() == null || inputField.getText().equals(""))) {
            resultField.setText("请输入答案");
            return;
        }

        multiplier1 = ((Number) mutiplier1Field.getValue()).intValue();
        multiplier2 = ((Number) multiplier2Field.getValue()).intValue();
        Integer rightResult = compute(multiplier1, multiplier2);

        Integer answer = Integer.parseInt(inputField.getText());
        if (answer == rightResult){
            resultField.setForeground(new Color(15, 150, 28));
            resultField.setText("正确");
        }else {
            resultField.setForeground(Color.RED);
            resultField.setText("错误");
        }
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("ExamApplet");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add contents to the window.
        frame.add(new ExamApplet());

        frame.setLocation(500, 200);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(() -> {
            UIManager.put("swing.boldMetal", Boolean.FALSE);
            createAndShowGUI();
        });
    }

    int compute(int multiplier1, int multiplier2) {
        return multiplier1 * multiplier2;
    }

    //Create and set up number formats. These objects also
    //parse numbers input by user.
    private void setUpFormats() {
        multiplier1Format = NumberFormat.getNumberInstance();
        multiplier2Format = NumberFormat.getNumberInstance();
        resultFormat = NumberFormat.getNumberInstance();
    }

}
