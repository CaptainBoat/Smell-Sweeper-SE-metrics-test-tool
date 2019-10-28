package smellsweeper;

import java.util.Scanner;

public class LOCprocessor {
	
	public void Menu() {
		char ochoice = 'y';
    	Scanner console1 = new Scanner(System.in);
		do {
		System.out.println("\n Please select: \n" + "1. Generate Line of Code (LOC) reports \n" + "2. Find the location of potential Blob code smell \n" + "3. Exit \n");
		ochoice = console1.next().charAt(0);
    	switch(ochoice) {
    		case '1':
    			GenerateReport();
    			break;
    		case '2':						    						    			    	
		    	char inchoice = 'y';
		    	Scanner console2 = new Scanner(System.in);
		    	while (inchoice=='Y'|| inchoice=='y') {
		    	findLargeLOC(); 
		    	findLargeLOC(); 
		    	findLargeLOC(); 
		    	System.out.println("\n Find the next group of potential Blob? (y/n)");		    	
		    	inchoice = console2.next().charAt(0);
		    	}
		    	break;
	
		}
		}while(ochoice != '3');
	}
	
		
	public  void findLargeLOC() {
		int maxtemp = 0;
		for (LOC obj :smellsweeper.LOClist) {			
			if (obj.visited == false && obj.LineOfCode > maxtemp)
				maxtemp = obj.LineOfCode;					}
		for (LOC obj :smellsweeper.LOClist) {			
			if (maxtemp == obj.LineOfCode) {
				System.out.println("The next potential Blob is: "+ obj.name +"\n Non-Comment Lines: " + obj.LineOfCode + "\n Comment Lines: " + obj.CommentCount);
	    		obj.visited = true;
	    	}
	}
			
	
}
	public  void GenerateReport() {
		int totalnc = 0;
		int totalc = 0;
		int count = smellsweeper.LOClist.size();				
		System.out.println("\n Line of Code (LOC) summary for your project: ");
		for (LOC obj :smellsweeper.LOClist) {
			totalnc += obj.LineOfCode; 
			totalc += obj.CommentCount;
		}
		System.out.println("\n ######################################################### ");
		System.out.println("\n Total Line of Code (LOC): " + (totalnc + totalc));
		System.out.println("\n Non-Comment Line of Code: " + totalnc);
		System.out.println("\n Comment Lines: " + totalc);
		System.out.println("\n Ratio of Comment Lines/Total LOC: " + totalc/(totalnc + totalc));
		System.out.println("\n Your average Line of Code (LOC): " + (totalnc + totalc)/count);
		System.out.println("\n Your average Non-Comment Line of Code (LOC): " + totalnc/count);
		System.out.println("\n ######################################################### ");
	}
}