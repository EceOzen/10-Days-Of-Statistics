import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int real_count = 0;
        int i = 0;
        int j;
        int temp = 0;
        Scanner input = new Scanner(System.in);

        int arr_count = input.nextInt();
        double[] numbers = new double[arr_count];
        double[] frequency = new double[arr_count];

        // create numbers and frequency arrays
        for(i = 0; i < arr_count; i++){
            numbers[i] = input.nextDouble();
        }
        for(i = 0; i < arr_count; i++){
            frequency[i] = input.nextDouble();
            // now I know real count of array
            real_count += frequency[i];
        }
        double[] real_numbers = new double[real_count];

        // create real array
        for(i = 0; i < arr_count; i++){
            for(j = 0; j < frequency[i]; j++){
                real_numbers[temp] = numbers[i];
                temp++;
            }
        }
        Arrays.sort(real_numbers);

        double[] quartiles_arr = new double[3];
        quartiles_arr = quartiles(real_count, real_numbers);

        // I need q3 - q1
        double result = quartiles_arr[2] - quartiles_arr[0];

        System.out.println(result);

    }
    public static double[] quartiles(int arr_count, double[] array){
        double[] result = new double[3];

        int quartile_size = arr_count / 2;
        double[] first_quartile = new double[arr_count / 2];
        double[] second_quartile = new double[arr_count / 2];

        double middle_quartile = 0;
        double f_quartile = 0;
        double s_quartile = 0;
        int f = 0;
        int s = 0;

        // if it is even
        if(arr_count % 2 == 0){
            for(int j = 0; j < arr_count; j++){
                if(j < arr_count / 2){
                    first_quartile[f] = array[j];
                    f++;
                }else{
                    second_quartile[s] = array[j];
                    s++;
                }

                middle_quartile = (first_quartile[f - 1] + second_quartile[0]) / 2;
            }
        // if it is odd
        }else{
            for(int j = 0; j < arr_count; j++){
                if(j < arr_count / 2){
                    first_quartile[f] = array[j];
                    f++;
                }else if(j == arr_count / 2){
                    middle_quartile = array[j];
                }else{
                    second_quartile[s] = array[j];
                    s++;
                }
            }
        }

        // quartile calculation
        if(quartile_size % 2 == 0){
            f_quartile = (first_quartile[(quartile_size / 2) - 1] + first_quartile[(quartile_size / 2)]) / 2;
            s_quartile = (second_quartile[(quartile_size / 2) - 1] + second_quartile[(quartile_size / 2)]) / 2;
        }else{
            f_quartile = first_quartile[quartile_size / 2];
            s_quartile = second_quartile[quartile_size / 2];
        }

        int q1 = (int)f_quartile;
        int q2 = (int)middle_quartile;
        int q3 = (int)s_quartile;

        result[0] = f_quartile;
        result[1] = middle_quartile;
        result[2] = s_quartile;

        return result;
    }
}
