package typeinfo;

public class ClassCasts {
    public static void main(String[] args) {
        Building b = new Building();
//        Class<House> h = House.class;
//        h.cast(b);
        House h = null;
        if (b instanceof House)
            h = (House) b;
    }
}

class Building {
}

class House extends Building {
}