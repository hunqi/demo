package org.rs.exercise.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.rs.exercise.BeeRouteSelecter;
import org.rs.exercise.pojo.Position;
import org.rs.exercise.pojo.Route;
import org.rs.exercise.pojo.RouteDistance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * BeeRouteSelecter responses for selecting a shortest route to collecting honey for honeybee
 * It works as follow:
 * 1. Generate all the available routes according to the input positions
 * 2. Calculate the distance of every route
 * 3. Get the shortest distance
 * 4. Output the route having the shortest distance
 */
public class BeeRouteSelecterTest {

    private BeeRouteSelecter beeRouteSelecter = new BeeRouteSelecter();

    @DisplayName("拿到可能的路径")
    @Test
    void testGetAvailableRoutes(){
        List<Position> positions = Arrays.asList(
                new Position(1, 3), new Position(2, 5), new Position(-6, 9),
                new Position(11, 6), new Position(6, 13));
        List<Route> routes = beeRouteSelecter.getAvailableRoutes(positions);
        Assertions.assertNotNull(routes);
        Assertions.assertEquals(120, routes.size());
    }

    @DisplayName("计算多条路径长度")
    @Test
    void testCalcDistancesOfRoutes(){
        List<Position> positions = Arrays.asList(
                new Position(1, 3), new Position(2, 5), new Position(-6, 9),
                new Position(11, 6), new Position(6, 13));
        List<Route> routes = beeRouteSelecter.getAvailableRoutes(positions);
        Assertions.assertNotNull(routes);
        Assertions.assertEquals(120, routes.size());

        List<RouteDistance> distances = beeRouteSelecter.calDistancesOfRoutes(routes);
        Assertions.assertEquals(120, distances.size());
    }

    @DisplayName("获取最短路线")
    @Test
    void testGetShortestRoute(){
        List<Position> positions = Arrays.asList(
                new Position(1, 3), new Position(2, 5), new Position(-6, 9),
                new Position(11, 6), new Position(6, 13));
        List<Route> routes = beeRouteSelecter.getAvailableRoutes(positions);
        Assertions.assertNotNull(routes);
        Assertions.assertEquals(120, routes.size());

        List<RouteDistance> distances = beeRouteSelecter.calDistancesOfRoutes(routes);
        Assertions.assertEquals(120, distances.size());

        RouteDistance routeDistance = beeRouteSelecter.getShortestRoute(distances);
        Assertions.assertNotNull(routeDistance);
        System.out.println("最短路线是： " + routeDistance);
    }

    @DisplayName("计算一条路径长度")
    @Test
    void testCalcDistanceOfRoute(){
        Route route = new Route();
        route.add(new Position(1, 3));
        route.add(new Position(2, 5));
        route.add(new Position(-6, 9));
        route.add(new Position(11, 6));
        route.add(new Position(6, 13));

        RouteDistance routeDistance = beeRouteSelecter.calcDistanceOfRoute(route);
        Assertions.assertNotNull(routeDistance);
        Assertions.assertNotNull(routeDistance.getDistance());
        System.out.println(routeDistance);
    }

    @DisplayName("计算可能的路径")
    @Test
    void testAddRoute() {
        List<Position> positions = Arrays.asList(
                new Position(1, 3), new Position(2, 5), new Position(-6, 9),
                new Position(11, 6), new Position(6, 13));
        Route parentRoute = new Route();
        List<Route> availableRoutes = new ArrayList<>();

        beeRouteSelecter.addRoute(positions, parentRoute, availableRoutes);

        Assertions.assertEquals(120, availableRoutes.size());
        availableRoutes.stream().forEach(r -> {
            Assertions.assertEquals(5, r.getPositions().size());
            System.out.println(r);
        });

    }

}
