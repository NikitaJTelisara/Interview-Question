public class arrayOfDoubles {
     /*
    Given an array of doubles, get the count of all pairs in the array where the pair’s sum is less than or equal to a given target sum.
    */
    public static void main(String[] args) {
        double[] d1 = {1.1, 1.2, 3.1, 3.2, 1.0, 1.3, 6.0};
        double sum = 4.3;
        int count = getCount(sum, d1);
        System.out.println("Count is " + count);

        double[] d2 = {1.0, 1.1, 1.2, 1.3, 3.1, 3.2, 6.0};
        sum = 4.3;
        count = getCountBetter(sum, d2);
        System.out.println("Count is " + count);

    }

    /* get count of pairs whose sum is > sum for unsorted array*/
    public static int getCount(double sum, double[] arr) {
        int count = 0;
        for (int i = 0; i <= arr.length - 1; i++) {
            for (int j = i + 1; j <= arr.length - 1; j++) {
                double d1 = arr[i];
                double d2 = arr[j];
                if (!(d1 > sum) || !(d2 > sum))
                    if (sum > (d1 + d2)) {
                        count++;
                    }
            }
        }
        return count;
    }

    /* get count of pairs whose sum is > sum for unsorted array*/
    public static int getCountBetter(double sum, double[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int j = i+1;
            while (sum > (arr[i] + arr[j]) && j < arr.length - 1) {
                count++;
                j++;
            }
        }
        return count;
    }
}
