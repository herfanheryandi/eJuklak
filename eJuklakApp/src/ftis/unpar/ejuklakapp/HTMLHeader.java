package ftis.unpar.ejuklakapp;

public class HTMLHeader {
	private int number;
	private String id;
	private String value;
	
	public HTMLHeader(int number, String id, String value){
		this.number = number;
		this.id = id;
		this.value = value;
	} 
	
	public int getNumber(){
		return this.number;
	}
	
	public String getID(){
		return this.id;
	}
	
	public String getValue(){
		return this.value;
	}
}
