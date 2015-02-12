package ftis.unpar.ejuklakapp;

import java.io.*;

public class HTMLReader {
	BufferedReader reader;
	
	public HTMLReader(String file) throws FileNotFoundException{
		reader = new BufferedReader(new FileReader(new File(file)));
	}
}
