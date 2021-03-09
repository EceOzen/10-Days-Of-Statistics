import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        /* I will work on it later
        // let's take input
        // i will use ArrayList for this question because size of array is not defined
        ArrayList <Integer> X = new ArrayList<Integer>();
        ArrayList <Integer> Y = new ArrayList<Integer>();
        
        Scanner input = new Scanner(System.in);
        int count = 0;
        while(true){
            if(input.nextInt() == ""){
                break;
            }else{
                if(count % 2 == 0){
                    X.add(input.nextInt());
                }else{
                    Y.add(input.nextInt());
                }
                count++;
            }
        } */
        
        double [] X = {95, 85, 80, 70, 60};
        double [] Y = {85, 95, 70, 65, 70};
        double b;
        double a;
        double X_ = 80;
        double Y_;
        
        double mean_x = mean(X.length, X);
        double mean_y = mean(Y.length, Y);
        double sd_x = sd(X.length, X);
        double sd_y = sd(Y.length, Y);
        
        //let's find regression line
        // i'll use b = p * (sd_y/sd_x)
        
        b = b_coeff(Pearson(X, sd_x, Y, sd_y, X.length), sd_x, sd_y);
        a = mean_y - (b * mean_x);
        
        Y_ = a + (b * X_);
        
        System.out.println(String.format("%.3f", Y_));
        
        
        
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
      public static double Pearson(double X[], double sd_x, double Y[], double sd_y, int n){
        double cov = 0;
        double x = 0;
        double y = 0;
        double a = 0;
        
        double mean_x = mean(n, X);
        double mean_y = mean(n, Y);
        
        for(int i = 0; i < n; i++){
            x = X[i] - mean_x;
            y = Y[i] - mean_y;
            cov = cov + (x * y);
        }
        
        a = n * sd_x * sd_y;
        
        return cov/a;                
    }
    public static double b_coeff(double p, double sd_x, double sd_y){
        return p * (sd_y / sd_x); 
    }
}
