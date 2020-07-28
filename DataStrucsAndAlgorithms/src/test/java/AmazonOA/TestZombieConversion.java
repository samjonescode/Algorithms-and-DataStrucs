package AmazonOA;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestZombieConversion {

    @Test
    public void testGivenExample() {
        List<Integer> row1 = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
        List<Integer> row2 = new ArrayList<Integer>(Arrays.asList(0, 1, 0, 0, 0));
        List<Integer> row3 = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 1));
        List<Integer> row4 = new ArrayList<Integer>(Arrays.asList(0, 1, 0, 0, 0));
        List<List<Integer>> grid = new ArrayList<List<Integer>>(Arrays.asList(row1, row2, row3, row4));

        int expected = 3;
        int observed = ZombieConversion.numberOfHours(grid);
        Assert.assertEquals(expected, observed);
    }

}
