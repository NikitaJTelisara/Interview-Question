public class arrayOfDoubles {
    /*
    Given an array of doubles, get the count of all pairs in the array where the pair’s sum is less than or equal to a given target sum.
    */
    public static void main(String[] args) {
        double[] d1 = {1.1, 1.2, 3.1, 3.2, 1.0, 1.3, 6.0};
        double sum = 4.3;
        int count = getCount(sum, d1);
        System.out.println("Count is " + count);
    }

    /* get count of pairs whose sum is > sum */
    public static int getCount(double sum, double[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            double d1 = arr[i];
            double d2 = arr[i + 1];
            if (!(d1 > sum) || !(d2 > sum))
                if (sum > (d1 + d2)) {
                    count++;
                }
        }
        return count;
    }
}
