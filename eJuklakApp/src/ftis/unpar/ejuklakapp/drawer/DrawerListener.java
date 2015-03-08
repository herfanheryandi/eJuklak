package ftis.unpar.ejuklakapp.drawer;



public class DrawerListener implements ListView.OnItemClickListener {
    
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        selectItem(position);
    }
    
}