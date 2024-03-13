package firstlab;
import java.util.Scanner;

public class EquationSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c;
        do {
            System.out.println("Equation Solver Menu:");
            System.out.println("1. Solve first-degree equation (ax + b = 0)");
            System.out.println("2. Solve system of first-degree equations (linear system) with two variables");
            System.out.println("3. Solve second-degree equation (ax^2 + bx + c = 0)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            c = scanner.nextInt();
            switch (c) {
                case 1:
                    solveFirstDegreeEquation(scanner);
                    break;
                case 2:
                    solveLinearSystem(scanner);
                    break;
                case 3:
                    solveSecondDegreeEquation(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please choose again.");
            }
        } while (c!=4);
        
        scanner.close();
    }
    //The first-degree equation (linear equation) with one variable
    private static void solveFirstDegreeEquation(Scanner scanner) {
        System.out.println("Solving first-degree equation: ax + b = 0");
        System.out.print("Enter coefficient a: ");
        double a=scanner.nextDouble();
        System.out.print("Enter coefficient b: ");
        double b=scanner.nextDouble();
        if (a==0) {
            if (b==0) {
                System.out.println("Infinite solutions");
            } else {
                System.out.println("No solution");
            }
        } 
        else {
            double sol= -b/a;
            System.out.println("Solution: x = " + sol);
            System.out.println( );
        }
    }
    //The system of first-degree equations (linear system) with two variables
    private static void solveLinearSystem(Scanner scanner) {
        System.out.println("Solving system of first-degree equations (linear system) with two variables");
        System.out.println("Enter coefficients for the first equation (ax + by = c):");
        System.out.print("Enter a: ");
        double a= scanner.nextDouble();
        System.out.print("Enter b: ");
        double b= scanner.nextDouble();
        System.out.print("Enter c: ");
        double c= scanner.nextDouble();
        System.out.println("Enter coefficients for the second equation (dx + ey = f):");
        System.out.print("Enter d: ");
        double d= scanner.nextDouble();
        System.out.print("Enter e: ");
        double e= scanner.nextDouble();
        System.out.print("Enter f: ");
        double f= scanner.nextDouble();

        double determinant =  a*e- d*b;
        if (determinant == 0 && (a* f- d*c == 0 && b*f - e*c == 0)) {
            System.out.println("Infinite solutions");
            System.out.println( );

        } else if (determinant == 0) {
            System.out.println("No solution");
            System.out.println( );

        } else {
            double x1 = (c*e - f*b) /determinant;
            double x2 = (a*f - d*c) / determinant;
            System.out.println("Solution: x1 = " + x1 + ", x2 = " + x2);
            System.out.println( );

        }
    }
    //The second-degree equation with one variable
    private static void solveSecondDegreeEquation(Scanner scanner) {
        System.out.println("Solving second-degree equation: ax^2 + bx + c = 0");
        System.out.print("Enter a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter c: ");
        double c = scanner.nextDouble();

        
        double delta = b*b - 4*a*c;
            if (delta > 0) {
                double root1 = (-b +Math.sqrt(delta))/(2 * a);
                double root2 = (-b -Math.sqrt(delta)) / (2 * a);
                System.out.println("Two distinct roots: x1 = "+root1+ ", x2 = "+root2);
            } 
            else if (delta == 0) {
                double root = -b/(2*a);
                System.out.println("Double roots: x = " + root);
                System.out.println( );

            } 
            else {
                System.out.println("There is no root");
                System.out.println( );

            }
        
    }
}
