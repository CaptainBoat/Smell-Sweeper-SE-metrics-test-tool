package smellsweeper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class smellsweeper {

public static List<classmetric> classlist = new ArrayList<classmetric>();	
public static List<LOC> LOClist = new ArrayList<LOC>();

	public void filereader(String path)
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

	
	public void LOCinit() throws IOException{
		for (classmetric obj :classlist) {			
			LOClist.add(new LOC(obj.name,obj.getLOC(),false));}
	}
	
	public void RFCinit() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException{
		for (classmetric obj :classlist) {			
			obj.getRFC();}
	//WIP
	
	}
	
	

}



	