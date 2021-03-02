import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        double boy, girl;
        double p_boy, p_girl;
        double probability = 0;
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);

        // take input
        boy = input.nextDouble();
        girl = input.nextDouble();

        // calculate probabilities
        p_boy = boy / (boy + girl);
        p_girl = girl / (boy + girl);

        // calculata binomial probabilty
        // number of trial -> n     number of success -> x
        int n = 6;
        int x;
        for(int i = 3; i <= n; i++){
            x = i;
            probability += binomialProbability(x,n,p_boy);
        }

        System.out.println(String.format("%.3f", probability));

    }

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
