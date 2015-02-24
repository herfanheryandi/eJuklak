package ftis.unpar.ejuklakapp;

import java.io.*;

public class HTMLReader {
	BufferedReader reader;
	
	public String read(String file) throws Exception{
		reader = new BufferedReader(new FileReader(new File(file)));
		String res = new String();
		String text = reader.readLine();
		while(text!=null){
			res += text;
			text = reader.readLine();
		}
		reader.close();
		return res;
	}
}
