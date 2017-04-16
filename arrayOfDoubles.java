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

        int[] arr = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
        int[] a = moveZeroToEnd(arr);
        System.out.println("Move 0 to end");
        for (int a1 : a) {
            System.out.println(a1);
        }

        int[] arr1 = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
        int[] a2 = moveZeroToStart(arr1);
        System.out.println("Move 0 to start");
        for (int a3 : a2) {
            System.out.println(a3);
        }

        System.out.println("array of multiples");
        int[] arr2 = {1, 2, 3, 4, 5};
        int[] a3 = arrayOfMultiples(arr2);
        for (int a4 : a3) {
            System.out.println(a4);
        }
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
            int j = i + 1;
            while (sum > (arr[i] + arr[j]) && j < arr.length - 1) {
                count++;
                j++;
            }
        }
        return count;
    }

    /* Exp Ques
    1.Move all zeros to end input  */
    public static int[] moveZeroToEnd(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[count] = arr[i];
                count++;
            }
        }
        while (count < arr.length) {
            arr[count] = 0;
            count++;
        }
        return arr;
    }

    /* Move all zeros to start input  */
    /* bad solution */
    public static int[] moveZeroToStart(int[] arr) {
        int count = 0;
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                res[count] = 0;
                count++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                res[count] = arr[i];
                count++;
            }
        }

        return res;
    }

    /* 2. Given an int[] multiply all numbers except index I/p {1,2,3,4} O/P [24, 12, 4, 1]  */
    public static int[] arrayOfMultiples(int[] inputArr) {
        int[] map = new int[inputArr.length];
        int count = inputArr.length - 1;
        map[count] = 1;
        count--;
        while (count >= 0) {
            map[count] = inputArr[count + 1] * map[count + 1];
            count--;
        }
        return map;
    }
}
