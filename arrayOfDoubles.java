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
    /* best solution
     public static int getCount(double sum, double[] arr) {
        // get all numbers smaller < sum numbers on front side of the array
        int i = 0;
        int count = 0;
        int j = arr.length - 1;
        while (i < j) {
            while (arr[i] < sum && i < arr.length - 1) {
                i++;
            }
            while (arr[j] > sum && j > 0) {
                j--;
            }
            if (i < j) {
                double temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }       
        // sort all the number <= sum which are in the front side of the array
        doQuickSort(arr, 0, j);          
        // get all the pairs from a[0] to a[j] that make the sum
       int k = 0;
        while (k < j) {
            if (arr[k] + arr[j] > sum) {
                j--;
            } else if (arr[k] + arr[j] == sum) {                     
                count++;
                j--;
                k++;
            } else if (arr[k] + arr[j] < sum) {
                k++;
            }
        }
        return count;
    }
    */
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
    
    /* better
    public static void moveZero(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            if (arr[i] == 0) {
                while (arr[j] != 1 && j < arr.length-1) {
                    j++;
                }
                swap(arr, i, j);
            }
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    } 
    */

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
    
    /* better
    
    public static void moveZero(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            if (arr[i] == 1) {
                while (arr[j] != 0 && j < arr.length-1) {
                    j++;
                }
                swap(arr, i, j);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }*/

    /* 2. Given an int[] multiply all numbers except index I/p {1,2,3,4} O/P [24, 12, 4, 1]  */
    public static int[] arrayOfMultiples(int[] inputArr) {
        int[] map = new int[inputArr.length];
        map[inputArr.length-1] = 1;
        for(int i=inputArr.length-2; i>=0;i--){
            map[i] = inputArr[i+1] * map[i+1];
        }
        return map;
    }
    
    public static int getPrimeCount(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
              if(isPrime(i)){
                  count ++;
              }
        }
        return count;
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
