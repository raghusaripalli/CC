package LC.divide_and_conquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class SkylineProblem {

    static class Point implements Comparable<Point> {
        int coordinate;
        int height;
        boolean isStart;


        @Override
        public int compareTo(Point o) {
            if (this.coordinate != o.coordinate) {
                return this.coordinate - o.coordinate;
            } else {
                return (this.isStart ? -this.height : this.height) - (o.isStart ? -o.height : o.height);
            }
        }
    }


    public List<List<Integer>> getSkyline(int[][] buildings) {
        int noOfBuildings = buildings.length;
        Point[] points = new Point[2 * noOfBuildings];

        int idx = 0;
        for (int[] building : buildings) {
            points[idx] = new Point();
            points[idx].coordinate = building[0];
            points[idx].height = building[2];
            points[idx].isStart = true;

            points[idx + 1] = new Point();
            points[idx + 1].coordinate = building[1];
            points[idx + 1].height = building[2];
            points[idx + 1].isStart = false;
            idx += 2;
        }

        // sort the building points
        Arrays.sort(points);

        TreeMap<Integer, Integer> maxPriorityQueue = new TreeMap<>();

        // Building height is 0 and it occurred 1 time
        maxPriorityQueue.put(0, 1);

        int prevMaxHeight = 0;

        List<List<Integer>> result = new ArrayList<>();

        for (Point point : points) {
            if (point.isStart) {
                maxPriorityQueue.compute(point.height, (key, value) -> {
                    if (value != null) {
                        return value + 1;
                    }
                    return 1;
                });
            } else {
                maxPriorityQueue.compute(point.height, (key, value) -> {
                    if (value == null || value == 1) {
                        return null;
                    }
                    return value - 1;
                });
            }

            int currentMaxHeight = maxPriorityQueue.lastKey();

            if (prevMaxHeight != currentMaxHeight) {
                result.add(Arrays.asList(point.coordinate, currentMaxHeight));
                prevMaxHeight = currentMaxHeight;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        SkylineProblem skylineProblem = new SkylineProblem();
        List<List<Integer>> result = skylineProblem.getSkyline(buildings);
        System.out.println(result);
    }
}
