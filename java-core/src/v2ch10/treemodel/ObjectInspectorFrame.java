package v2ch10.treemodel;

import javax.swing.*;
import java.awt.*;

/**
 * This frame holds the object tree.
 */
public class ObjectInspectorFrame extends JFrame {

    private JTree tree;
    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 300;

    public ObjectInspectorFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // we inspect the frame object
        Variable v = new Variable(getClass(), "this", this);
        ObjectTreeModel model = new ObjectTreeModel();
        model.setRoot(v);

        //construct and show tree
        tree = new JTree(model);
        add(new JScrollPane(tree), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ObjectInspectorFrame();
            frame.setTitle("ObjectInspectorFrame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
