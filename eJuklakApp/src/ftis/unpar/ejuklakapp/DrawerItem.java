package ftis.unpar.ejuklakapp;

public class DrawerItem {
	private int icon;
    private String name;
 
    // Constructor.
    public DrawerItem(int icon, String name) {
        this.icon = icon;
        this.name = name;
    }
    
    public int getIcon(){
    	return icon;	
    }
    
    public String getName(){
    	return name;	
    }
}
