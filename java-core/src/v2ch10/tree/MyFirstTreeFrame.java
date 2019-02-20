package v2ch10.tree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class MyFirstTreeFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 300;

    public MyFirstTreeFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        DefaultMutableTreeNode world = new DefaultMutableTreeNode("World");
        DefaultMutableTreeNode china = new DefaultMutableTreeNode("China");
        world.add(china);
        DefaultMutableTreeNode guangDong = new DefaultMutableTreeNode("GuangDong");
        china.add(guangDong);
        DefaultMutableTreeNode shenZhen = new DefaultMutableTreeNode("ShenZhen");
        guangDong.add(shenZhen);

        DefaultTreeModel treeModel = new DefaultTreeModel(world);
        JTree tree = new JTree(treeModel);
        add(tree);
    }

    public static void main(String[] args) {
        JFrame frame = new MyFirstTreeFrame();
        frame.setTitle("MyFirstTreeFrame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
