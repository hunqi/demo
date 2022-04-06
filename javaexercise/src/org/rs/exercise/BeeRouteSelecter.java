package org.rs.exercise;

import org.rs.exercise.pojo.Position;
import org.rs.exercise.pojo.Route;
import org.rs.exercise.pojo.RouteDistance;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 蜜蜂采蜜路线选择器
 */
public class BeeRouteSelecter {
    public List<Route> getAvailableRoutes(List<Position> positions) {
        System.out.println("Input positions: " + positions);
        Route parentRoute = new Route();
        List<Route> availableRoutes = new ArrayList<>();
        addRoute(positions, parentRoute, availableRoutes);
        System.out.printf("%s routes found\n", availableRoutes.size());
        return availableRoutes;
    }

    public void addRoute(List<Position> availablePositions, Route parentRoute, List<Route> availableRoutes) {
        if (availablePositions.size() == 1) {
            Route route = Route.newInstance(parentRoute);
            route.add(availablePositions.get(0));
            availableRoutes.add(route);
            return;
        }

        availablePositions.forEach(p -> {
            Route route = Route.newInstance(parentRoute);
            route.add(p);
            List<Position> leftPositions = new ArrayList<>(availablePositions);
            leftPositions.remove(p);
            addRoute(leftPositions, route, availableRoutes);
        });
    }

    public RouteDistance calcDistanceOfRoute(Route route) {
        RouteDistance distance = new RouteDistance();
        distance.setRoute(route);

        List<Position> positions = new ArrayList<>();
        positions.add(new Position(0, 0));
        positions.addAll(route.getPositions());
        positions.add(new Position(0, 0));

        BigDecimal totalDistance = BigDecimal.ZERO;
        for (int i=1; i<positions.size(); i++) {
            Position start = positions.get(i - 1);
            Position end = positions.get(i);
            totalDistance = totalDistance.add(getDistanceBtw2Positions(start, end));
        }
        distance.setDistance(totalDistance.doubleValue());

        return distance;
    }

    private static final MathContext MATH_CONTEXT = new MathContext(2, RoundingMode.HALF_UP);
    private BigDecimal getDistanceBtw2Positions(Position start, Position end) {
        BigDecimal x2Delta = new BigDecimal(Math.pow(end.getX() - start.getX(), 2), MATH_CONTEXT);
        BigDecimal y2Delta = new BigDecimal(Math.pow(end.getY() - start.getY(), 2), MATH_CONTEXT);

        return x2Delta.add(y2Delta).sqrt(MATH_CONTEXT);
    }

    public List<RouteDistance> calDistancesOfRoutes(List<Route> routes) {
        return routes.stream().map(r -> calcDistanceOfRoute(r)).collect(Collectors.toList());
    }

    public RouteDistance getShortestRoute(List<RouteDistance> distances) {
        Collections.sort(distances, (d1, d2) -> (int) ((d1.getDistance() - d2.getDistance()) * 100));
        // print detail of route
        distances.stream().forEach(d -> System.out.println(d));
        return distances.get(0);
    }
}
