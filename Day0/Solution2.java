import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution2 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);

        int arr_count = input.nextInt();
        double[] numbers = new double[arr_count];
        double[] weights = new double[arr_count];

        // create numbers array
        for(int i = 0; i < arr_count; i++){
            numbers[i] = input.nextDouble();
        }
        // create weights array
        for(int j = 0; j < arr_count; j++){
            weights[j] = input.nextDouble();
        }

        // Weighted Mean
        System.out.println(weighted_mean(arr_count, numbers, weights));

    }

    public static String weighted_mean(int arr_count, double[] numbers, double[] weights){
        double sum = 0;
        double w_sum = 0;
        double mean = 0;

        for(int i = 0; i < arr_count; i++){
            sum += numbers[i] * weights[i];
            w_sum += weights[i];
        }

        mean = sum / w_sum;

        // precision point error occured, so I found this solution.
        // now this function returns String, don't forget
        return String.format("%.1f", mean);
    }
}
