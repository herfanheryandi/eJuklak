package ftis.unpar.ejuklakapp;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;

import org.apache.commons.lang3.StringUtils;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ListView;



public class MainActivity extends ActionBarActivity {
	private WebView webView;
	HTMLHeader[] headers;
	private String[] mNavigationDrawerItemTitles;
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	ActionBarDrawerToggle mDrawerToggle;
	private CharSequence mDrawerTitle;
	private CharSequence mTitle;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTitle = mDrawerTitle = getTitle();
        //Code here
        
        /*webview*/
        webView = (WebView) findViewById(R.id.webview);
        webView.loadUrl("file:///android_asset/BAB-1.html");
        
        /*navigation drawer*/ 
        headers = this.getHTMLHeaders();
        mNavigationDrawerItemTitles= new String[headers.length];
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        
        DrawerItem[] drawerItem = new DrawerItem[headers.length];
        for(int i = 0; i < drawerItem.length; i++){
        	mNavigationDrawerItemTitles[i] =  headers[i].getValue();
        	drawerItem[i] = new DrawerItem(R.drawable.ic_paper, headers[i].getValue());
        }
        DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this, R.layout.listview_item_row, drawerItem);
        mDrawerList.setAdapter(adapter);
        
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                R.drawable.ic_menu, 
                R.string.drawer_open, 
                R.string.drawer_close 
                ) {
            
            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getActionBar().setTitle(mTitle);
            }
         
            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActionBar().setTitle(mDrawerTitle);
            }
        };
         
        mDrawerLayout.setDrawerListener(mDrawerToggle);
         
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        
        
    }
    
    public HTMLHeader[] getHTMLHeaders(){
		 AssetManager assetManager = getAssets();
		 String text = new String();
	     InputStream input;
	       try {
		       input = assetManager.open("BAB-1.html");
		       int size = input.available();
		       byte[] buffer = new byte[size];
		       input.read(buffer);
		       input.close();
		       text = new String(buffer);
	       } catch (IOException e) {
	           // TODO Auto-generated catch block
	           //e.printStackTrace();
	       }
	       LinkedList<HTMLHeader> headerList = new LinkedList<HTMLHeader>();
	       String content = StringUtils.substringBetween(text, "<body>", "</body>");
           String[] headers = StringUtils.substringsBetween(content, "<h", "/h");
           for (String header : headers) {
				String number  = StringUtils.substringBetween(header, "", " id");
              	String id  = StringUtils.substringBetween(header, "id=\"", "\">");
              	String value  = StringUtils.substringBetween(header, ">", "<");
              	headerList.add(new HTMLHeader(Integer.parseInt(number),id,value));
		   }
           HTMLHeader[] headerArr = headerList.toArray(new HTMLHeader[headerList.size()]);
	       return headerArr;
    }
    
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
        
    }
     
    private void selectItem(int position) {
    	webView.loadUrl("file:///android_asset/BAB-1.html#" + headers[position].getID());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getActionBar().setTitle(mTitle);
    }
    
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }
}


