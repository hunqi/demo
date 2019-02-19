package v2ch10.tablerowcolumn;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

/**
 * This frame contains a table of planet data.
 */
public class PlanetTableFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 500;

    private static final int COLOR_COLUMN = 4;
    private static final int IMAGE_COLUMN = 5;

    private JTable table;
    private HashSet<Integer> removedRowIndices;
    private ArrayList<TableColumn> removedColumns;
    private JCheckBoxMenuItem rowsItem;
    private JCheckBoxMenuItem columnsItem;
    private JCheckBoxMenuItem cellsItem;

    private String[] columnNames = {"Planet", "Radius", "Moons", "Gaseous",
            "Color", "Image"};
    private Object[][] cells = {
            {"Mercury", 2440.0, 0, false, Color.YELLOW, new ImageIcon(getClass().getResource("/img/Mercury.jpg"))},
            {"Venus", 6052.0, 0, false, Color.YELLOW, new ImageIcon(getClass().getResource("/img/Venus.jpg"))},
            {"Earth", 6378.0, 1, false, Color.BLUE, new ImageIcon(getClass().getResource("/img/Earth.jpg"))},
            {"Mars", 3397.0, 2, false, Color.RED, new ImageIcon(getClass().getResource("/img/Mars.jpg"))},
            {"Jupiter", 71492.0, 16, true, Color.ORANGE, new ImageIcon(getClass().getResource("/img/Jupiter.jpg"))},
            {"Saturn", 60268.0, 18, true, Color.ORANGE, new ImageIcon(getClass().getResource("/img/Saturn.jpg"))},
            {"Uranus", 25559.0, 17, true, Color.BLUE, new ImageIcon(getClass().getResource("/img/Uranus.jpg"))},
            {"Neptune", 24766.0, 8, true, Color.BLUE, new ImageIcon(getClass().getResource("/img/Neptune.jpg"))},
            {"Pluto", 1137.0, 1, false, Color.BLACK, new ImageIcon(getClass().getResource("/img/Pluto.jpg"))}
    };

    public PlanetTableFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        TableModel model = new DefaultTableModel(cells, columnNames) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return cells[0][columnIndex].getClass();
            }
        };

        table = new JTable(model);
        table.setRowHeight(100);
        table.getColumnModel().getColumn(COLOR_COLUMN).setMinWidth(250);
        table.getColumnModel().getColumn(IMAGE_COLUMN).setMinWidth(100);

        final TableRowSorter<TableModel> sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);
        sorter.setComparator(COLOR_COLUMN, Comparator.comparing(Color::getBlue)
                .thenComparing(Color::getGreen)
                .thenComparing(Color::getRed));

        sorter.setSortable(COLOR_COLUMN, false);
        add(new JScrollPane(table), BorderLayout.CENTER);

        removedRowIndices = new HashSet<>();
        removedColumns = new ArrayList<>();

        final RowFilter<TableModel, Integer> filter = new RowFilter<TableModel, Integer>() {
            @Override
            public boolean include(Entry<? extends TableModel, ? extends Integer> entry) {
                return !removedRowIndices.contains(entry.getIdentifier());
            }
        };

        // create menu
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu selectionMenu = new JMenu("Selection");
        menuBar.add(selectionMenu);

        rowsItem = new JCheckBoxMenuItem("Rows");
        columnsItem = new JCheckBoxMenuItem("Columns");
        cellsItem = new JCheckBoxMenuItem("Cells");

        selectionMenu.add(rowsItem);
        selectionMenu.add(columnsItem);
        selectionMenu.add(cellsItem);

        rowsItem.addActionListener(event -> {
            table.clearSelection();
            table.setRowSelectionAllowed(rowsItem.isSelected());
            upDateCheckboxMenuItems();
        });

        columnsItem.addActionListener(event -> {
            table.clearSelection();
            table.setRowSelectionAllowed(columnsItem.isSelected());
            upDateCheckboxMenuItems();
        });

        cellsItem.addActionListener(event -> {
            table.clearSelection();
            table.setRowSelectionAllowed(cellsItem.isSelected());
            upDateCheckboxMenuItems();
        });

        JMenu tableMenu = new JMenu("Edit");
        menuBar.add(tableMenu);

        JMenuItem hideColumnsItem = new JMenuItem("Hide Columns");
        hideColumnsItem.addActionListener(event -> {
            int[] selected = table.getSelectedColumns();
            TableColumnModel columnModel = table.getColumnModel();

            // remove columns from view, starting at the last
            // index so that column numbers aren't affected
            for (int i = selected.length - 1; i >= 0; i--) {
                TableColumn column = columnModel.getColumn(selected[i]);
                table.removeColumn(column);

                // store removed columns for "show columns" command
                removedColumns.add(column);
            }
        });
        tableMenu.add(hideColumnsItem);

        JMenuItem showColumnsItem = new JMenuItem("Show Columns");
        showColumnsItem.addActionListener(event -> {
            // restore all removed columns
            for (TableColumn tc : removedColumns)
                table.addColumn(tc);
            removedColumns.clear();
        });
        tableMenu.add(showColumnsItem);

        JMenuItem hideRowsItem = new JMenuItem("Hide Rows");
        hideRowsItem.addActionListener(event -> {
            int[] selected = table.getSelectedRows();
            for (int i : selected) {
                removedRowIndices.add(table.convertRowIndexToModel(i));
            }

            sorter.setRowFilter(filter);
        });
        tableMenu.add(hideRowsItem);

        JMenuItem showRowsItem = new JMenuItem("Show Rows");
        showRowsItem.addActionListener(event -> {
            removedRowIndices.clear();
            sorter.setRowFilter(filter);
        });
        tableMenu.add(showRowsItem);

        JMenuItem printSelectionItem = new JMenuItem("Print Selection");
        printSelectionItem.addActionListener(event -> {
            int[] selected = table.getSelectedRows();
            System.out.println("Selected rows : " + Arrays.toString(selected));

            selected = table.getSelectedColumns();
            System.out.println("Selected columns : " + Arrays.toString(selected));
        });
        tableMenu.add(printSelectionItem);
    }

    private void upDateCheckboxMenuItems() {
        rowsItem.setSelected(table.getRowSelectionAllowed());
        columnsItem.setSelected(table.getColumnSelectionAllowed());
        cellsItem.setSelected(table.getCellSelectionEnabled());
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new PlanetTableFrame();
            frame.setTitle("PlanetTableFrame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
