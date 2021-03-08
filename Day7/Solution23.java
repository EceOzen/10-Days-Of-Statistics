import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner input = new Scanner(System.in);
        
        // input parameters
        int n;
        n = input.nextInt();
        double X[] = new double[n];
        double Y[] = new double[n];
        
        for(int i = 0; i < n; i++){
            X[i] = input.nextDouble();
        }
        
        for(int j = 0; j < n; j++){
            Y[j] = input.nextDouble();
        }
        double mean_x = mean(X);
        double sd_x = sd(X);
        
        double mean_y = mean(Y);
        double sd_y = sd(Y);
        
        System.out.println(String.format("%.3f", Pearson(X, mean_x, sd_x, Y, mean_y, sd_y, n)));
    }
    public static double Pearson(double X[], double mean_x, double sd_x, double Y[],double mean_y, double sd_y, int n){
        double cov = 0;
        double x = 0;
        double y = 0;
        double a = 0;
        
        for(int i = 0; i < n; i++){
            x = X[i] - mean_x;
            y = Y[i] - mean_y;
            cov = cov + (x * y);
        }
        
        a = n * sd_x * sd_y;
        
        return cov/a;                
    }
    public static double mean(double arr[]){
        double sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        
        return sum / arr.length;
    }
    
    public static double sd(double arr[]){
        double mean = mean(arr);
        double sum = 0;
        
        for(int i = 0; i < arr.length; i++){
            sum = sum + Math.pow((arr[i] - mean), 2);
        }
        
        double variance = sum /arr.length;
        
        return Math.sqrt(variance);
    }
}
