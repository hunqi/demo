package org.rs.exercise.pojo;

public class RouteDistance {
    private Double distance;
    private Route route;

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return "RouteDistance{" +
                "distance=" + distance +
                ", route=" + route +
                '}';
    }
}
