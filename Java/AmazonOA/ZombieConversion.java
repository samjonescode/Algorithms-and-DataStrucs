package Java.AmazonOA;

import java.util.*;

public class ZombieConversion {
    public static void main(String[] args) {
        List<Integer> row1 = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
        List<Integer> row2 = new ArrayList<>(Arrays.asList(0, 1, 0, 0, 0));
        List<Integer> row3 = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 1));
        List<Integer> row4 = new ArrayList<>(Arrays.asList(0, 1, 0, 0, 0));

        row1.set(0, 1);
        System.out.println(row1);
        List<List<Integer>> grid = new ArrayList<>(Arrays.asList(row1, row2, row3, row4));

        System.out.println(numberOfHours(grid));
    }

    static int numberOfHours(List<List<Integer>> grid) {
        List<Integer[]> soonToBeZombies = new ArrayList<>();
        int numberOfHours = 0;
        boolean atLeast1Survivor = true;
        while (atLeast1Survivor) {
            atLeast1Survivor = false;
            for (int row = 0; row < grid.size(); row++) {
                for (int col = 0; col < grid.get(0).size(); col++) {
                    if (isHuman(row, col, grid)) {
                        // check neighbors
                        atLeast1Survivor = true;
                        checkNeighbors(row, col, grid, soonToBeZombies);
                    }
                }
            }
            if (!atLeast1Survivor)
                break;
            convertToZombies(grid, soonToBeZombies);
            numberOfHours++;
        }
        return numberOfHours;
    }

    static void convertToZombies(List<List<Integer>> grid, List<Integer[]> soonToBeZombies) {

        for (Integer[] human : soonToBeZombies) {
            grid.get(human[0]).set(human[1], 1);
        }
    }

    static void checkNeighbors(int row, int col, List<List<Integer>> grid, List<Integer[]> soonToBeZombies) {
        List<Integer[]> directions = new ArrayList<Integer[]>();
        Integer[] up = { -1, 0 };
        Integer[] down = { 1, 0 };
        Integer[] left = { 0, -1 };
        Integer[] right = { 0, 1 };
        directions.add(up);
        directions.add(down);
        directions.add(left);
        directions.add(right);

        for (Integer[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newCol >= 0 && newCol < grid.get(0).size() && newRow < grid.size()) {
                if (grid.get(newRow).get(newCol) == 1) {
                    soonToBeZombies.add(new Integer[] { row, col });
                }
            }
        }

    }

    static boolean isHuman(int row, int col, List<List<Integer>> grid) {
        return grid.get(row).get(col) == 0;
    }
}