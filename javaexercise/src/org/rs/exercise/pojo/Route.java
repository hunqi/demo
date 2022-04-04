package org.rs.exercise.pojo;

import java.util.ArrayList;
import java.util.List;

public class Route {

    private List<Position> positions;

    public Route() {
        positions = new ArrayList<>();
    }

    public static Route newInstance(Route route) {
        Route r = new Route();
        r.getPositions().addAll(route.getPositions());
        return r;
    }

    public void add(Position p){
        positions.add(p);
    }

    public void clear() {
        positions.clear();
    }

    public List<Position> getPositions() {
        return positions;
    }

    public int len(){
        return positions.size();
    }

    @Override
    public String toString() {
        return "Route " + positions;
    }
}
