package firstlab;
import java.util.Scanner;
public class Days {

   public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	
	int month = getMonth(scan);
	int year = getYear(scan);
	int day = getDay(month, year);
	System.out.println("Num ber of days: "+ day);
	scan.close();
 }
   
   public static int getMonth(Scanner scan) {
	   String month;
	   while (true) {
		   System.out.println("Enter the month: ");
		   month = scan.nextLine().trim().toLowerCase();
		   switch(month) {
		   case "january":case "1": case "jan.": case "jan":
			   return 1;
		  
		   case "february":case "2":case "feb.":case "feb":
			   return 2;
			   
		   case "march":
		   case "3":
		   case "mar.":
		   case "mar":
			   return 3;
			   
		   case "April":
		   case "4":
		   case "apr.":
		   case "apr":
			   return 4;
		
		   case "may":case "5":  
			   return 5;
		  
		   case "june":case "6":case "jun.":case "jun":
			   return 6;
			   
		   case "july":case "7": case "jul.": case "jul":
			   return 7;
		  
		   case "august":case "8":case "aug.":case "aug":
			   return 8;
			
		   case "september":case "9": case "sep.": case "sep":
			   return 9;
		  
		   case "octorber":case "10":case "oct.":case "Oct":
			   return 10;
			   
		   case "november":case "11": case "nov.": case "nov":
			   return 11;
		  
		   case "december":case "12":case "dec.":case "dec":
			   return 12;
			   
		   default:
			   System.out.println("Invalid month!");
		 
		   
		   }
	   }
   }
   
   public static int getYear(Scanner scan) {
	  while (true) {
		  System.out.println("Enter year: ");
		  if (scan.hasNextInt()) {
			  int year = scan.nextInt();
			  if(year>=0) {
			  return year;}
		  }
		  System.out.println("Invalid year!");
		  scan.nextLine();		   
	  }	   
   }
   
   public static boolean isLeapYear(int year) {
	   if (year %4 ==0) {
		   if( year % 100 != 0 || year % 400 ==0) {
			   return true;
		   }
	   }
	   return false;
   }
   
   public static int getDay(int month, int year) {
	   
	    switch (month) {
	    case 1: case 3: case 5: case 7: case 8: case 10: case 12:
	    	return 31;
	    case 4: case 6: case 9: case 11:
	    	return 30;
	    case 2: 
	    	return isLeapYear(year)? 29: 28;
	    default:
	    	return -1;
	    }
	   
   }
   
}