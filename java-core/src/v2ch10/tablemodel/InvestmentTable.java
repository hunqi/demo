package v2ch10.tablemodel;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.*;

/**
 * This program shows how to build a table from a table model.
 */
public class InvestmentTable {

    public static void main(String[] args) {

        JFrame frame = new InvestmentTableFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("InvestmentTable");
        frame.setVisible(true);
    }

}

/**
 * This frame contains the investment table.
 */
class InvestmentTableFrame extends JFrame {

    public InvestmentTableFrame() throws HeadlessException {
        TableModel model = new InvestmentTableModel(30, 5, 10);
        JTable table = new JTable(model);
        add(new JScrollPane(table));
        pack();
    }
}

/**
 * This table model computes the cell entries each time they are requested. The
 * table contents shows the growth of an investment for a number of years under different interest
 * rates.
 */
class InvestmentTableModel extends AbstractTableModel {

    private static double INITIAL_BALANCE = 100000.0;

    private int years;
    private int minRate;
    private int maxRate;

    /**
     * Constructs an investment table model.
     *
     * @param years   the number of years
     * @param minRate the lowest interest rate to tabulate
     * @param maxRate the highest interest rate to tabulate
     */
    public InvestmentTableModel(int years, int minRate, int maxRate) {
        this.years = years;
        this.minRate = minRate;
        this.maxRate = maxRate;
    }

    @Override
    public int getRowCount() {
        return years;
    }

    @Override
    public int getColumnCount() {
        return maxRate - minRate + 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        double rate = (columnIndex + minRate) / 100.0;
        int nperiods = rowIndex;
        double futureBalance = INITIAL_BALANCE * Math.pow(1 + rate, nperiods);

        return String.format("%.2f", futureBalance);
    }

    @Override
    public String getColumnName(int column) {
        return (column + minRate) + "%";
    }
}
