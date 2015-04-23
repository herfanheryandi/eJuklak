package ftis.unpar.ejuklakapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DrawerItemCustomAdapter extends ArrayAdapter<DrawerItem> {	 
    private Context context;
    private int layoutResourceId;
    private DrawerItem items[] = null;
 
    public DrawerItemCustomAdapter(Context context, int layoutResourceId, DrawerItem[] items) {
        super(context, layoutResourceId, items);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.items = items;
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
 
        LayoutInflater inflater =LayoutInflater.from(context);
        listItem = inflater.inflate(layoutResourceId, parent, false);
 
        ImageView imageViewIcon = (ImageView) listItem.findViewById(R.id.imageViewIcon);
        TextView textViewName = (TextView) listItem.findViewById(R.id.textViewName);
        
        DrawerItem selectedItem = items[position];

        imageViewIcon.setImageResource(selectedItem.getIcon());
        textViewName.setText(selectedItem.getName());
        
        return listItem;
    }
 
}
