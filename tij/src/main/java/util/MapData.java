package util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapData {
    public static <K, V> Map<? extends K, ? extends V> map(
            List<K> list, V i) {

        Map<K, V> m = new HashMap<>();

        for (K t : list) {
            m.put(t, i);
        }

        return m;
    }
}
