package ftis.unpar.ejuklakapp.drawer;

public class DrawerAdapter extends ArrayAdapter<DrawerItem> {
	 
    Context context;
    int layoutResourceId;
    DrawerItem items[] = null;
 
    public DrawerAdapter(Context context, int layoutResourceId, DrawerItem[] items) {
 
        super(context, layoutResourceId, items);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.items = items;
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
 
        View listItem = convertView;
 
        LayoutInflater inflater = LayoutInflater.from(context);
        listItem = inflater.inflate(layoutResourceId, parent, false);
 
        ImageView imageViewIcon = (ImageView) listItem.findViewById(R.id.imageViewIcon);
        TextView textViewName = (TextView) listItem.findViewById(R.id.textViewName);
        
        DrawerItem folder = items[position];
 
        
        imageViewIcon.setImageResource(folder.icon);
        textViewName.setText(folder.name);
        
        return listItem;
    }
 
}