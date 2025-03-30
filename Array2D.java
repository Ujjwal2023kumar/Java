package Arrays2D;
import java.util.*;
public class Array2D {
    public static void printSpiral(int matrix2[][]){
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix2.length-1;
        int endCol = matrix2[0].length -1;

        while(startRow <= endRow && startCol<= endCol){
            // top
            for(int j= startCol;j<=endCol;j++){
                System.out.print(matrix2[startRow][j] + " ");
            }
            // right
            for(int i= startRow+1;i<=endRow;i++){
                System.out.print(matrix2[i][endCol] + " ");
            }
            // bottom
            for(int j= endCol-1;j>=startCol;j--){
                if(startRow == endRow){
                    break;
                }
                System.out.print(matrix2[endRow][j] + " ");
            }
            // left
            for(int i= endRow-1;i>=startRow+1;i--){
                if(startCol == endCol){
                    break;
                }
                System.out.print(matrix2[i][startCol] + " ");
            }
            startCol++;
            startRow++;
            endCol--;
            endRow--;
        }
        System.out.println();
    }
    public static int diagonalSum(int matrix2[][]){
        int sum = 0;
        // for(int i= 0;i<matrix2.length; i++){
        //     for(int j= 0; j<matrix2[0].length; j++){
        //         if(i == j){
        //             sum += matrix2[i][j];
        //         }
        //         else if(i+j == matrix2.length-1){
        //             sum += matrix2[i][j];
        //         }
        //     }
        // }

        for(int i= 0;i<matrix2.length; i++){
            //primary diagonal
            sum += matrix2[i][i];
            //secondary diagonal 
            if(i!= matrix2.length-1-i)
            sum += matrix2[i][matrix2.length-1-i];
        }
        return sum;
    }
    public static void staircaseSearch(int matrix3[][], int key){
        int row = 0, col = matrix3.length-1;
        while( row < matrix3.length && col >= 0){
            if(matrix3[row][col] == key){
                System.out.println("Key found at ("+ row + "," + col + ")");
                return;
            } else if(key < matrix3[row][col]){
                col--;
            }else{
                row++;
            }
        }
        System.out.println("Key not found!");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int matrix[][] = new int[3][3];
        int matrix2[][] = {{1,2,3,4},
                            {5,6,7,8},
                            {9,10,11,12},
                            {13,14,15,16}};
        int matrix3[][] = {{10,20,30,40},
                            {15,25,35,45},
                            {27,29,37,48},
                            {32,33,39,50}};
        int n = matrix.length , m = matrix[0].length;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        printSpiral(matrix2);
        int DiagonalSum = diagonalSum(matrix2);
        System.out.println(DiagonalSum);

        int key = 33;
        staircaseSearch(matrix3, key);
        sc.close();
    }
}
