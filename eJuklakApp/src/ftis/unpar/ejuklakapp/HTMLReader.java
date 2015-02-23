package ftis.unpar.ejuklakapp;

import java.io.*;

public class HTMLReader {
	BufferedReader reader;
	
	public HTMLReader(String file) throws FileNotFoundException{
		reader = new BufferedReader(new FileReader(new File(file)));
	}
	
	public String read() throws IOException{
		String res = new String();
		/*String text = reader.readLine();
		while(text!=null){
			res += text;
			text = reader.readLine();
		}*/
		reader.close();
		return res;
	}
}
