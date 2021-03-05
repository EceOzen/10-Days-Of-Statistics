import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        // If you check out the wikipedia page, you can find following formulas
        /*  Z-Test
            z = (x - mean) / sd
            
            PREDICTION INTERVALS
            P(L < Z < U) = gamma (it is interval w/ high probability)
            P(-z < Z < z) = gamma
            
            it follows
            
            -z = (L - mean) / sd  ->  L = mean - (z * sd)
             z = (U - mean) / sd  ->  U = mean + (z * sd)
             
            Let's calculate it!
        */
        /* Confidence Interval
            A = mean - z * (sd / Math.sqrt(n))
            B = mean + z * (sd / Math.sqrt(n));
        
        */
        
        // I have to learn difference between confidence and prediction intervals
        double mean = 500;
        double sd = 80;
        double z = 1.96;
        double n = 100;
        
        double A = mean - (z * (sd / Math.sqrt(n)));
        double B = mean + (z * (sd / Math.sqrt(n)));
        
        System.out.println(String.format("%.2f", A));
        System.out.println(String.format("%.2f", B));
    }
}
