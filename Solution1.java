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

        for(int i = 0; i < arr_count; i++){
            numbers[i] = input.nextDouble();
        }

        //Mean
        System.out.println(mean(arr_count, numbers));
        //Median
        System.out.println(median(arr_count, numbers));
        //Mode
        System.out.println(mode(arr_count, numbers));

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

    public static double median(int arr_count, double[] numbers){
        double median = 0;
        // first sort the array
        Arrays.sort(numbers);

        if(arr_count % 2 == 0){
            median = (numbers[(arr_count/2) - 1] + numbers[(arr_count/2)]) / 2;
        }else{
            median = (numbers[arr_count/2] + numbers[(arr_count/2)+1]) / 2;
        }

        return median;
    }

    public static double mode(int arr_count, double[] numbers){
        double most = 0;
        int max_count = 0;
        int count = 0;
        for(int i = 0; i < arr_count; i++){
            for(int j = 0; j < arr_count; j++){
                if(numbers[i] == numbers[j]){
                    count += 1;
                }
            }
            if(max_count < count){
                max_count = count;
                most = numbers[i];
            }
            count = 0;
        }

        return most;
    }
}
