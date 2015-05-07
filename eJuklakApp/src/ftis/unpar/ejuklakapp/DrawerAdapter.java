package ftis.unpar.ejuklakapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DrawerAdapter extends ArrayAdapter<HTMLHeader> {	 
    private Context context;
    private int layoutResourceId;
    private HTMLHeader[] items = null;
 
    public DrawerAdapter(Context context, int layoutResourceId, HTMLHeader[] items) {
        super(context, layoutResourceId, items);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.items = items;
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        HTMLHeader selectedItem = items[position];
        LayoutInflater inflater = LayoutInflater.from(context);
        listItem = inflater.inflate(layoutResourceId, parent, false);
        RelativeLayout layoutNormal = (RelativeLayout) listItem.findViewById(R.id.layoutNormal);
    	RelativeLayout layoutPadding = (RelativeLayout) listItem.findViewById(R.id.layoutPadding);
       
    	if(selectedItem.getNumber()==1){	
        	layoutNormal.setVisibility(View.VISIBLE);
        	layoutPadding.setVisibility(View.INVISIBLE);
        	ImageView imageViewIcon = (ImageView) listItem.findViewById(R.id.imageViewIcon);
            TextView textViewName = (TextView) listItem.findViewById(R.id.textViewName);
            imageViewIcon.setImageResource(R.drawable.ic_paper2);
            textViewName.setText(selectedItem.getValue());
        }
        else {
        	layoutPadding.setVisibility(View.VISIBLE);
        	layoutNormal.setVisibility(View.INVISIBLE);
        	ImageView imageViewIcon = (ImageView) listItem.findViewById(R.id.imageViewIconPadding);
            TextView textViewName = (TextView) listItem.findViewById(R.id.textViewNamePadding);
            imageViewIcon.setImageResource(R.drawable.ic_paper);
            textViewName.setText(selectedItem.getValue());
        }
        	   
        return listItem;
    }
 
}
