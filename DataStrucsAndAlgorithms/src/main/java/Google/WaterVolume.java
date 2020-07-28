package Google;

public class WaterVolume {

    public static void main(String[] args) {
        System.out.println(findVolume(new int[] { 1, 3, 2, 4, 1, 3, 1, 4, 5, 2, 2, 1, 4, 2, 2 }));
    }

    public static int findVolume(int[] landMasses) {
        int currMaxLand = -1;
        int maxLandIdx = 0;
        int totalWaterVolume = 0;
        int currWaterVolume = 0;

        // this loop considers the volume of water stored on the left side of the
        // right-most maximum value in the array... i.e. the largest land mass

        for (int idx = 0; idx < landMasses.length; idx++) {
            int land = landMasses[idx];
            if (land >= currMaxLand) {
                currMaxLand = land;
                maxLandIdx = idx;
                if (currWaterVolume != 0) {
                    totalWaterVolume += currWaterVolume;
                    currWaterVolume = 0;
                }
            } else if (land < currMaxLand) {
                int diff = currMaxLand - land;
                currWaterVolume += diff;
            }
        }
        // this loop iterates backwards, accumulating water stored between the end of
        // the array and the largest, right-most land mass.
        currWaterVolume = 0;
        currMaxLand = -1;
        for (int idx = landMasses.length - 1; idx >= maxLandIdx; idx--) {
            int land = landMasses[idx];

            if (land >= currMaxLand) {
                currMaxLand = land;
                if (currWaterVolume > 0) {
                    totalWaterVolume += currWaterVolume;
                }
            } else {
                int diff = currMaxLand - land;
                currWaterVolume += diff;
            }
        }
        return totalWaterVolume;
    }
}