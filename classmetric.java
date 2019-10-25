package smellsweeper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class classmetric {

	String path;
	String name;
    public classmetric(String path,String name) 
    { 
        this.path = path; 
        this.name = name;
    }

public int LOC() throws IOException    {
    int line_count = 0;
	BufferedReader reader = null;
	String line;
	reader = new BufferedReader(new FileReader(this.path));
	while ((line = reader.readLine()) != null) {
		line_count++; 
	}
	reader.close();
	System.out.println(this.name);
	System.out.println("Total number of lines: "+ line_count);
	return line_count;
}
}
