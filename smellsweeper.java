package smellsweeper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class smellsweeper {

static List<classmetric> classlist = new ArrayList<classmetric>();	
static List<LOC> LOClist = new ArrayList<LOC>();
	private static void filereader(String path)
    {	File folder = new File(path); 
        File[] files = folder.listFiles();

        for (File file : files)
        {
            if (file.isFile() && file.getName().endsWith(".java"))
            {
            	classlist.add(new classmetric(file.getAbsolutePath(),file.getName()));
            	System.out.println(file.getAbsolutePath());
            }
            else if (file.isDirectory())
            {
                filereader(file.getAbsolutePath());
            }
        }
    }
 
	
	private static void LOCinit() throws IOException{
		for (classmetric obj :classlist) {			
			LOClist.add(new LOC(obj.name,obj.LOC()));}
	}
	
	private static void findMAXLOC() {
		int maxtemp = 0;
		for (LOC obj :LOClist) {			
			maxtemp = Math.max(maxtemp,obj.LineOfCode);					}
		for (LOC obj :LOClist) {			
			if (maxtemp == obj.LineOfCode)
		    	System.out.println("The Class with greatest LOC is: "+ obj.name +"\n LOC:" + obj.LineOfCode);}
	}
	
public static void main(String[] args) throws IOException
    {
    	System.out.println("PLEASE ENTER A PATH FOR YOUR PACKAGE:");
        Scanner scanner = new Scanner(System.in);
        String filepath = scanner.nextLine();
		filereader(filepath);
        System.out.println("\n Please select a metric: \n" + "1. Line Of Code \n");
        Scanner scan1 = new Scanner(System.in);
        String choice1 = scan1.nextLine();
		switch(choice1) {
		    case "1":		
		    	LOCinit();
		    	System.out.println("\n Please select: \n" + "1. Find the class with greatest LOC \n");
		        Scanner scan2 = new Scanner(System.in);
		        String choice2 = scan2.nextLine();
		    	switch(choice2) {
				    case "1":		findMAXLOC(); 
				    				break;
				    default: 
				    	System.out.println("INVALID INPUT");
				        break; 	}	
		    break;
		default: 
			System.out.println("INVALID INPUT");   
				    			    		
    }	 
}
}


	