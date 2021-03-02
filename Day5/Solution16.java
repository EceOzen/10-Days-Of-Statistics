import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        double lambda = 0;
        int k = 0;
        double p = 0;
        
        Scanner input = new Scanner(System.in);
        
        lambda = input.nextDouble();
        k = input.nextInt();
        
        // I will use euler number with Math.exp()
        p = poissonDistribution(k, lambda);
        System.out.println(String.format("%.3f", p));
    }
    public static double poissonDistribution(int k, double lambda){
        double prob = 0;
        
        prob = (Math.pow(lambda, k) * Math.exp(-lambda)) / factorial(k); 
        
        return prob;
    }
    // suppose only positive x's are sending here -> it is a bug actually.
    public static int factorial(int x){
        int f = 1;
        int j = 1;
        if(x == 0){
            return 1;
        }else{
            while(j <= x){
                f = f * j;
                j++;
            }
        }
        return f;
    }
}
