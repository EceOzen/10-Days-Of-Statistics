import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);

        int arr_count = input.nextInt();
        double[] numbers = new double[arr_count];

        // create numbers array
        for(int i = 0; i < arr_count; i++){
            numbers[i] = input.nextDouble();
        }

        // print standard deviation
        System.out.println(String.format("%.1f", sd(arr_count, numbers)));
    }
    public static double mean(int arr_count, double[] numbers){
        double sum = 0;
        double mean = 0;

        for(int i = 0; i < arr_count; i++){
            sum += numbers[i];
        }

        mean = sum / arr_count;

        return mean;
    }

    public static double sd(int arr_count, double[] numbers){
        double mean = mean(arr_count, numbers);
        double sum = 0;
        double variance = 0;
        double sd = 0;

        for(int i = 0; i < arr_count; i++){
            sum += Math.pow((numbers[i] - mean),2);
        }

        variance = sum / arr_count;
        sd = Math.sqrt(variance);

        return sd;

    }
}
