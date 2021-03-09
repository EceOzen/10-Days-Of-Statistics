import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        // let's take inputs
        Scanner input = new Scanner(System.in);
        
        int n;
        
        n = input.nextInt();
        
        double X[] = new double[n];
        double Y[] = new double[n];
        
        double _X[] = new double[n];
        double _Y[] = new double[n];
        
        for(int i = 0; i < n; i++){
            X[i] = input.nextDouble();
            _X[i] = X[i];
        }
        for(int i = 0; i < n; i++){
            Y[i] = input.nextDouble();
            _Y[i] = Y[i];
        }
        
        Arrays.sort(_X);
        Arrays.sort(_Y);
        
        // I have sorted arrays and normal arrays
        // I need to find ranks now, probably java has a function for it but I choose
        // manual labour way
        
        // first create rank arrays
        int RankX[] = new int[n];
        int RankY[] = new int[n];
        
        // i did this because, I know there are no duplicate element
        // if there is a duplication this loop will not work properly
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(X[i] == _X[j]){
                    RankX[i] = j + 1;
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(Y[i] == _Y[j]){
                    RankY[i] = j + 1;
                }
            }
        }
        
        System.out.println(String.format("%.3f", Spearsman(RankX, RankY, n)));
    }
    
    public static double diffPair(int RankX[], int RankY[]){
        double sum = 0;
        for(int i = 0; i < RankX.length; i++){
            sum = sum + Math.pow((RankX[i] - RankY[i]), 2);
        }
        return sum;
    }
    
    public static double Spearsman(int RankX[], int RankY[], int n){
        return 1 - ((6 * diffPair(RankX, RankY)) / (n * (Math.pow(n, 2) - 1)));
    }
}
