package smellsweeper;

public class LOC {
	int LineOfCode;
	String name;
	int CommentCount;
	boolean visited;
	
    public LOC(String name, int[] LineOfCode, boolean visited) 
    { 
    	this.visited = visited;
    	this.CommentCount = LineOfCode[1];
    	this.LineOfCode = LineOfCode[0]; 
        this.name = name;	
    }
        
}
