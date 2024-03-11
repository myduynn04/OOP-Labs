package firstlab;
import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("First num: ");
		String strnum1 = scanner.nextLine();
		double num1 = Double.parseDouble(strnum1);
		
		System.out.print("Second num: ");
		String strnum2 = scanner.nextLine();
		double num2 = Double.parseDouble(strnum2);
		
        double sum = num1+num2;
        double diff = num1 - num2;
        double product = num1 * num2;
        System.out.print("Result: " );
        System.out.println("Sum: "+ sum);
        System.out.println("Difference: "+ diff);
        System.out.println("Product: "+ product);

        if( num2==0){
            System.out.println("Error: Division by zero");
        }
        else{
           double q= num1/num2;
            System.out.println("Quotient: " + q);
        }
        
		scanner.close();

	}


		

	}


