import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        // I couldn't understand this problem actually. I think I will go over expectations
        /* Expectation for A is E[Xa], variance is Var(Xa)
           Expectation for B is E[Xb], variance is Var(Xb)
           E[Xa] = 160 + (40 * E[X^2])
           E[Xb] = 128 + (40 * E[X^2])
           E[X^2] = lambda + (lambda ^ 2)
           So:
           E[Xa] = 160 + 40(lambda + lambda^2)
           E[Xb] = 128 + 40(lambda + lambda^2)
        */
        double lambda_A, lambda_B;
        double cost_A, cost_B;
        Scanner input = new Scanner(System.in);
        
        lambda_A = input.nextDouble();
        lambda_B = input.nextDouble();
        
        cost_A = 160 + (40 * (lambda_A + Math.pow(lambda_A,2)));
        cost_B = 128 + (40 * (lambda_B + Math.pow(lambda_B,2)));
        
        System.out.println(String.format("%.3f", cost_A));
        System.out.println(String.format("%.3f", cost_B));
        
    }
}
