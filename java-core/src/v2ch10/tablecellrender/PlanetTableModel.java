package v2ch10.tablecellrender;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.*;

/**
 * The planet table model specifies the values, rendering and editing
 * properties for the planet data.
 */
public class PlanetTableModel extends AbstractTableModel {

    static final int PLANET_COLUMN = 0;
    static final int MOONS_COLUMN = 2;
    static final int GASEOUS_COLUMN = 3;
    static final int COLOR_COLUMN = 4;

    private Object[][] cells = {
            {"Mercury", 2440.0, 0, false, Color.YELLOW, new ImageIcon(getClass().getResource("/img/Mercury.jpg"))},
            {"Venus", 6052.0, 0, false, Color.YELLOW, new ImageIcon(getClass().getResource("/img/Venus.jpg"))},
            {"Earth", 6378.0, 1, false, Color.BLUE, new ImageIcon(getClass().getResource("/img/Earth.jpg"))},
            {"Mars", 3397.0, 2, false, Color.RED, new ImageIcon(getClass().getResource("/img/Mars.jpg"))},
            {"Jupiter", 71492.0, 16, true, Color.ORANGE, new ImageIcon(getClass().getResource("/img/Jupiter.jpg"))},
            {"Saturn", 60268.0, 18, true, Color.ORANGE, new ImageIcon(getClass().getResource("/img/Saturn.jpg"))},
            {"Uranus", 25559.0, 17, true, Color.BLUE, new ImageIcon(getClass().getResource("/img/Uranus.jpg"))},
            {"Neptune", 24766.0, 8, true, Color.BLUE, new ImageIcon(getClass().getResource("/img/Neptune.jpg"))},
            {"Pluto", 1137.0, 1, false, Color.BLACK, new ImageIcon(getClass().getResource("/img/Pluto.jpg"))}};

    private String[] columnNames = {"Planet", "Radius", "Moons", "Gaseous", "Color", "Image"};

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return cells[0][columnIndex].getClass();
    }

    @Override
    public int getRowCount() {
        return cells.length;
    }

    @Override
    public int getColumnCount() {
        return cells[0].length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return cells[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        cells[rowIndex][columnIndex] = aValue;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == PLANET_COLUMN || columnIndex == MOONS_COLUMN
                || columnIndex == GASEOUS_COLUMN || columnIndex == COLOR_COLUMN;
    }

}
