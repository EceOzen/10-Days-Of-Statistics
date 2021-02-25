import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        double middle_quartile = 0;
        double f_quartile = 0;
        double s_quartile = 0;
        int f = 0;
        int s = 0;
        Scanner input = new Scanner(System.in);

        int arr_count = input.nextInt();
        double[] numbers = new double[arr_count];
        int quartile_size = arr_count/2;
        double[] first_quartile = new double[arr_count / 2];
        double[] second_quartile = new double[arr_count / 2];

        // create numbers array
        for(int i = 0; i < arr_count; i++){
            numbers[i] = input.nextDouble();
        }

        // sort the array
        Arrays.sort(numbers);

        // calculation will different according to number of elements
        // if it is even
        if(arr_count % 2 == 0){
            for(int j = 0; j < arr_count; j++){
                if(j < arr_count / 2){
                    first_quartile[f] = numbers[j];
                    f++;
                }else{
                    second_quartile[s] = numbers[j];
                    s++;
                }

                middle_quartile = (first_quartile[f - 1] + second_quartile[0]) / 2;
            }
        // if it is odd
        }else{
            for(int j = 0; j < arr_count; j++){
                if(j < arr_count / 2){
                    first_quartile[f] = numbers[j];
                    f++;
                }else if(j == arr_count / 2){
                    middle_quartile = numbers[j];
                }else{
                    second_quartile[s] = numbers[j];
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


        // Q1
        System.out.println(q1);

        //Q2
        System.out.println(q2);

        //Q3
        System.out.println(q3);


    }
}
