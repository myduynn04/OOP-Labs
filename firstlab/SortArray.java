package firstlab;
import java.util.Arrays;
import java.util.Scanner;
public class SortArray {
	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		 System.out.println("Enter the size: ");
		 int size = scanner.nextInt();
		 int[] array = new int[size];
		 System.out.println("Enter the elements of the array:");
		 for (int i=0; i<size; i++) {
			 System.out.print("Enter element " + (i + 1) + ":");
			 array[i]=scanner.nextInt();
		 }
		 Arrays.sort(array);
		 System.out.println("Sorted array: "+Arrays.toString(array));
		 CalSum(array);
		 
		 
		
	}
	
	public static void  CalSum(int[] array) {
		int sum=0;
		for (int num:array) {
			sum+=num;
		}
		double avg= (double)sum/array.length;
		System.out.println("Sum of the array elemnts: "+ sum);
		System.out.println("Averange of the array elemnts: "+ avg);
		
	}

}
