import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        double a, b;
        int n;
        double p = 0;

        Scanner input = new Scanner(System.in);

        a = input.nextDouble();
        b = input.nextDouble();
        n = input.nextInt();

        // in input they give us probability seperated
        p = a / b;
        //System.out.println(p);

        // call geometric distribution
        System.out.println(String.format("%.3f" , geometricDistribution(n,p)));
    }

    public static double geometricDistribution(int n, double p){
        return p * Math.pow((1 - p), (n - 1));
    }
}
