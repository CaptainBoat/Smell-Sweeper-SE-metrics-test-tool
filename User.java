package smellsweeper;

import java.io.IOException;
import java.util.Scanner;

public class User {
	public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException
    {

		System.out.println("PLEASE ENTER A PATH FOR YOUR PACKAGE:");
        Scanner scanner = new Scanner(System.in);
        String filepath = scanner.nextLine();
        smellsweeper obj = new smellsweeper();
        obj.filereader(filepath);
        System.out.println("\n Please select a metric: \n" + "1. Line Of Code \n" + "2. Find methods \n");
        Scanner scan1 = new Scanner(System.in);
        String choice1 = scan1.nextLine();
		switch(choice1) {
		    case "1":		
		    	obj.LOCinit();
		    	LOCprocessor proc1 = new LOCprocessor();
		    	proc1.Menu();
		    break;
		    case "2":
		    	obj.RFCinit();
		    break;			    
		    default: 
			System.out.println("INVALID INPUT");   
				    			    		
    }	 

    }
}
