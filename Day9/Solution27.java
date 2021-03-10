import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        // let's take input
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        double [][] X = new double[n][m+1];
        double [][] Y = new double[n][1];
        
        for (int row = 0; row < n; row++) {
            X[row][0] = 1;
            for (int col = 1; col <= m; col++) {
                X[row][col] = input.nextDouble();
            }
            Y[row][0] = input.nextDouble();
        }
        
        int q = input.nextInt();

        // I need to find B now
        // B = (X^T * X)^(-1) * X^T * Y
        // I need to find inverse of matrix
        //                transpose of matrix
        //                multiply of matrices
        double [][] Xt = transpose(X);
        double [][] XtX = multiply(Xt, X);
        double [][] _XtX = invert(XtX);
        double [][] H = multiply(_XtX, Xt);
        double [][] B = multiply(H, Y);
        
        int sizeB = B.length;
        
        /* Calculate and print values for the "q" feature sets */
     
        
        for (int i = 0; i < q; i++) {
            double res = B[0][0];
            for (int row = 1; row < sizeB; row++) {
                res += input.nextDouble() * B[row][0];
            }
            System.out.println(res);
        }
    }
    /* Multiplies 2 matrices in O(n^3) time */
    public static double[][] multiply(double [][] A, double [][] B) {
        int aRows = A.length;
        int aCols = A[0].length;
        int bRows = B.length;
        int bCols = B[0].length;
        
        double [][] C = new double[aRows][bCols];
        int cRows = C.length;
        int cCols = C[0].length;
        
        for (int row = 0; row < cRows; row++) {
            for (int col = 0; col < cCols; col++) {
                for (int k = 0; k < aCols; k++) {
                    C[row][col] += A[row][k] * B[k][col];
                }
            }
        }
        return C;
    }
    /* Where was my mind??
    public static double[][] inverse(double T[][]){
        // first create identity matrix
        int Trow = T.length;
        int Tcol = T[0].length;
        double [][] I = new double[Trow][Tcol];
        // actually, matrix must be square otherwise we couldn't find inverse
        for(int i = 0; i < Trow; i++){
            for(int j = 0; j < Tcol; j++){
                if(i == j){
                    I[i][j] = 1;
                }else{
                    I[i][j] = 0;
                }
            }
        }
        return multiply(I, T);
    } */
    
     public static double[][] invert(double a[][]) 
    {
        int n = a.length;
        double x[][] = new double[n][n];
        double b[][] = new double[n][n];
        int index[] = new int[n];
        for (int i=0; i<n; ++i) 
            b[i][i] = 1;
 
         // Transform the matrix into an upper triangle
        gaussian(a, index);
 
         // Update the matrix b[i][j] with the ratios stored
        for (int i=0; i<n-1; ++i)
            for (int j=i+1; j<n; ++j)
                for (int k=0; k<n; ++k)
                    b[index[j]][k]
                            -= a[index[j]][i]*b[index[i]][k];
 
         // Perform backward substitutions
        for (int i=0; i<n; ++i) 
        {
            x[n-1][i] = b[index[n-1]][i]/a[index[n-1]][n-1];
            for (int j=n-2; j>=0; --j) 
            {
                x[j][i] = b[index[j]][i];
                for (int k=j+1; k<n; ++k) 
                {
                    x[j][i] -= a[index[j]][k]*x[k][i];
                }
                x[j][i] /= a[index[j]][j];
            }
        }
        return x;
    }
 
        // Method to carry out the partial-pivoting Gaussian
        // elimination.  Here index[] stores pivoting order.
 
    public static void gaussian(double a[][], int index[]) 
    {
        int n = index.length;
        double c[] = new double[n];
 
         // Initialize the index
        for (int i=0; i<n; ++i) 
            index[i] = i;
 
         // Find the rescaling factors, one from each row
        for (int i=0; i<n; ++i) 
        {
            double c1 = 0;
            for (int j=0; j<n; ++j) 
            {
                double c0 = Math.abs(a[i][j]);
                if (c0 > c1) c1 = c0;
            }
            c[i] = c1;
        }
 
         // Search the pivoting element from each column
        int k = 0;
        for (int j=0; j<n-1; ++j) 
        {
            double pi1 = 0;
            for (int i=j; i<n; ++i) 
            {
                double pi0 = Math.abs(a[index[i]][j]);
                pi0 /= c[index[i]];
                if (pi0 > pi1) 
                {
                    pi1 = pi0;
                    k = i;
                }
            }
 
           // Interchange rows according to the pivoting order
            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i=j+1; i<n; ++i)   
            {
                double pj = a[index[i]][j]/a[index[j]][j];
 
                 // Record pivoting ratios below the diagonal
                a[index[i]][j] = pj;
 
                 // Modify other elements accordingly
                for (int l=j+1; l<n; ++l)
                    a[index[i]][l] -= pj*a[index[j]][l];
            }
        }
    }
    public static double[][] transpose(double T[][]){
        int Trow = T.length;
        int Tcol = T[0].length;
        
        double [][] result = new double[Tcol][Trow];
        
        for(int i = 0; i < Trow; i++){
            for(int j = 0; j < Tcol; j++){
                result[j][i] = T[i][j];
            }
        }
        return result;
    }
    
}
