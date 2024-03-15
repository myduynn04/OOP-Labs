package firstlab;
import java.util.Scanner;
public class AddMatrix {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Enter the number of rows for the matrices:");
	        int rows = scanner.nextInt();
	        System.out.println("Enter the number of columns for the matrices:");
	        int cols = scanner.nextInt();

	        System.out.println("Enter the elements of the first matrix:");
	        int[][] mat1 = inputMatrix(scanner, rows, cols);

	        System.out.println("Enter the elements of the second matrix:");
	        int[][] mat2 = inputMatrix(scanner, rows, cols);

	        int[][] result = addMatrices(mat1, mat2);
	        System.out.println("Result of matrix addition:");
	        printMatrix(result);

	        scanner.close();
	    }

	    public static int[][] inputMatrix(Scanner scanner, int rows, int cols) {
	        int[][] matrix = new int[rows][cols];
	        for (int i=0; i<rows; i++){
	            for (int j= 0; j < cols; j++) {
	                System.out.print("Enter element [" + (i + 1) + "][" + (j + 1) + "]: ");
	                matrix[i][j] = scanner.nextInt();
	            }
	        }
	        return matrix;
	    }

	    public static int[][] addMatrices(int[][] mat1, int[][] mat2) {
	        int rows = mat1.length;
	        int cols = mat1[0].length;
	        int[][] result = new int[rows][cols];

	        for (int i=0; i< rows; i++) {
	            for (int j = 0; j<cols; j++) {
	                result[i][j] = mat1[i][j] + mat2[i][j];
	            }
	        }

	        return result;
	    }

	    public static void printMatrix(int[][] matrix) {
	        for (int[] row : matrix) {
	            for (int element : row) {
	                System.out.print(element + " ");
	            }
	            System.out.println();
	        }
	    }
	}


