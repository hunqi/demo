package v2ch07.dateformat;

import javax.swing.*;
import java.time.format.FormatStyle;
import java.util.Map;
import java.util.TreeMap;

/**
 * A combo box that lets users choose from among static field values whose names
 * are given in the constructor
 */
public class EnumCombo<T> extends JComboBox<String> {

    private Map<String, T> table = new TreeMap<>();

    /**
     * Constructs an EnumCombo yielding values of type T
     *
     * @param cl     a class
     * @param labels labels an array of strings describing static field names
     *               20 of cl that have type T
     */
    public EnumCombo(Class<?> cl, String... labels) {
        for (String l : labels) {
            String name = l.toUpperCase().replace(" ", "_");
            try {
                java.lang.reflect.Field f = cl.getField(name);
                T value = (T) f.get(cl);
                table.put(l, value);
            } catch (Exception e) {
                l = "(" + l + ")";
                table.put(l, null);
            }
            addItem(l);
        }
        setSelectedItem(labels[0]);
    }

    public T getValue() {
        return table.get(getSelectedItem());
    }
}




















