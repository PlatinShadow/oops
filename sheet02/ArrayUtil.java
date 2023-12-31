import java.util.Arrays;

public class ArrayUtil {

    public static void main(String[] args) {

        double[] arr1 = {1, 2, 3, 4, 5};
        double[] arr2 = {5, 4, 3, 2, 1};
        double[] arr3 = randomArray(10); //TODO CHANGE BACK TO 1000

        System.out.printf("arr1: %s%n", array2String(arr1));
        System.out.printf("arr2: %s%n", array2String(arr2));
        System.out.printf("arr3: %s%n", array2String(arr3));
        System.out.println();

        //a) sum
        System.out.printf("Sum: %.2f\t (should: %2.2f)%n", sum(arr1), Arrays.stream(arr1).sum());
        System.out.printf("Sum: %.2f\t (should: %2.2f)%n", sum(arr2), Arrays.stream(arr2).sum());
        System.out.printf("Sum: %.2f\t (should: %2.2f)%n", sum(arr3), Arrays.stream(arr3).sum());
        System.out.println();

        //b) avg
        System.out.printf("Average: %.2f\t (should: %2.2f)%n", avg(arr1), Arrays.stream(arr1).average().getAsDouble());
        System.out.printf("Average: %.2f\t (should: %2.2f)%n", avg(arr2), Arrays.stream(arr2).average().getAsDouble());
        System.out.printf("Average: %.2f\t (should: %2.2f)%n", avg(arr3), Arrays.stream(arr3).average().getAsDouble());
        System.out.println();

        //c) max
        System.out.printf("Max: %.2f\t (should: %2.2f)%n", max(arr1), Arrays.stream(arr1).max().getAsDouble());
        System.out.printf("Max: %.2f\t (should: %2.2f)%n", max(arr2), Arrays.stream(arr2).max().getAsDouble());
        System.out.printf("Max: %.2f\t (should: %2.2f)%n", max(arr3), Arrays.stream(arr3).max().getAsDouble());
        System.out.println();

        //c) min
        System.out.printf("Min: %.2f\t (should: %2.2f)%n", min(arr1), Arrays.stream(arr1).min().getAsDouble());
        System.out.printf("Min: %.2f\t (should: %2.2f)%n", min(arr2), Arrays.stream(arr2).min().getAsDouble());
        System.out.printf("Min: %.2f\t (should: %2.2f)%n", min(arr3), Arrays.stream(arr3).min().getAsDouble());
        System.out.println();

		//d) var
		System.out.printf("Var: %.2f\t (should: %2.2f)%n", var(new double[]{1.0,1.0,1.0,1.0,1.0}), 0.0);
		System.out.printf("Var: %.2f\t (should: %2.2f)%n", var(arr1), 2.5);
		System.out.printf("Var: %.2f\t (should: %2.2f)%n", var(new double[]{1.0,1.2,1.3,0.8,0.2,-0.1,3.0,2.2}), 1.02);
        System.out.println();
		
        //e) sort
        sort(arr1);
        sort(arr2);
        sort(arr3);
        System.out.printf("Sorted: %s%n", array2String(arr1));
        System.out.printf("Sorted: %s%n", array2String(arr2));
        System.out.printf("Sorted: %s%n", array2String(arr3));
        System.out.println();

        //g) isSorted
        double[] arrUnsorted = randomArray(1000);
        System.out.printf("isSorted arr1: %s%n", isSortedDesc(arr1));
        System.out.printf("isSorted arr2: %s%n", isSortedDesc(arr2));
        System.out.printf("isSorted arr3: %s%n", isSortedDesc(arr3));
        System.out.printf("isSorted arrUnsorted: %s%n", isSortedDesc(arrUnsorted));
    }

    //a)
    private static double sum(double[] arr) {
        double res = 0;
        for(double value : arr) {
            res += value;
        }

        return res;
    }

    //b)
    private static double avg(double[] arr) {

        if (arr == null || arr.length == 0) {
            return Double.NaN;
        }

        return sum(arr) / (double)arr.length;
    }

    //c)
    private static double max(double[] arr) {

        if (arr == null || arr.length == 0) {
            return Double.NaN;
        }


        double current_max = 0;
        for(double value : arr) {
            if(value > current_max) {
                current_max = value;
            }
        }

        return current_max;
    }

    //c)
    private static double min(double[] arr) {

        if (arr == null || arr.length == 0) {
            return Double.NaN;
        }

        double current_min = Double.MAX_VALUE;
        for(double value : arr) {
            if(value < current_min) {
                current_min = value;
            }
        }

        //TODO
        return current_min; //CHANGE ME
    }

	//d)
	private static double var(double[] arr) {
		
        if (arr == null || arr.length == 0) {
            return Double.NaN;
        }

        if(arr.length == 1) {
            return 0;
        }

        double avgerage = avg(arr);
        double s = 0;
        for(double value : arr) {
            double t = value - avgerage;
            s += t * t;
        }

        return (1.0 / (arr.length - 1)) * s;
	}


    //e)
    private static void sort(double[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = i+1; j < arr.length; j++) {
                if(arr[i] < arr[j]) {
                    double temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    //g)
    private static boolean isSortedDesc(double[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = i+1; j < arr.length; j++) {
                if(arr[i] < arr[j]) {
                    return false;
                }
            }
        }

        return true;
    }

    //|||||          |||||
    //vvvvv Blackbox vvvvv
    private static double[] randomArray(int n) {

        double[] arr = new double[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.random() - 0.5;
        }

        return arr;
    }

    private static String array2String(double[] arr) {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(String.format("%.4f", arr[i]));
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");

        return new String(sb);
    }
}