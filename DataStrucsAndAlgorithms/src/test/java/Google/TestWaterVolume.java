package Google;

import org.junit.Assert;
import org.junit.Test;

import static Google.WaterVolume.findVolume;

public class TestWaterVolume {

    @Test
    public void testGivenExample() {
        int[] testData = new int[] { 1, 3, 2, 4, 1, 3, 1, 4, 5, 2, 2, 1, 4, 2, 2 };
        int expected = 15;
        int observed = findVolume(testData);
        Assert.assertEquals(expected, observed);
    }
}
