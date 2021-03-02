import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        double reject_prob;
        int piston_batch;
        int x;
        double p1 = 0;
        double p2 = 0;
        double p_tmp = 0;

        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);

        reject_prob = input.nextDouble();
        piston_batch = input.nextInt();
        // piston_batch is our n for this problem

        // input was percentage
        reject_prob = reject_prob / 100;

        // no more than 2 reject
        for(int i = 0; i < 3; i++){
            x = i;
            p1 += binomialProbability(x, piston_batch, reject_prob);
            // according to problem, I need to save 2 reject probability
            if(x == 2){
                p_tmp = binomialProbability(x, piston_batch, reject_prob);
            }
        }
        // I need to add 2 reject probability
        p2 = (1 - p1) + p_tmp;

        System.out.println(String.format("%.3f", p1));
        System.out.println(String.format("%.3f", p2));

    }
    // I will use same methods in Binomial I question
    public static double binomialProbability(int x, int n, double p){
        double binomial = 0;

        binomial = (factorial(n) / (factorial(n - x) * factorial(x))) * Math.pow(p,x) * Math.pow((1-p),(n-x));

        return binomial;
    }

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
