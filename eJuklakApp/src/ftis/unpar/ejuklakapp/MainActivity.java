package ftis.unpar.ejuklakapp;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;



public class MainActivity extends ActionBarActivity {
	private ViewFragment webViewer;
	private String HTMLPath;
	private String HTMLName;
	private HTMLHeader[] headers;
	private DrawerLayout drLayout;
	private ListView drList;
	private ActionBarDrawerToggle drToggle;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*WEBVIEW*/
        HTMLName = "eJuklak_FTIS.html";
        HTMLPath = "file:///android_asset/" + HTMLName;
        webViewer = new ViewFragment();
        webViewer.setHTMLPath(HTMLPath);
        getFragmentManager().beginTransaction().replace(R.id.content_frame, webViewer).commit();
        
        /*NAVIGATION DRAWER*/ 
        if(savedInstanceState==null){
	        try {
				headers = this.getHTMLHeaders();
			} catch (IOException e) {
				e.printStackTrace();
			}
	        drLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
	        drList = (ListView) findViewById(R.id.left_drawer);
	        
	        /*SET DRAWER ITEM*/
	        DrawerAdapter adapter = new DrawerAdapter(this, R.layout.listview_item_row, headers);
	        drList.setAdapter(adapter);
	        drList.setOnItemClickListener(new DrawerItemClickListener());
	        
	        drLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
	        drToggle = new ActionBarDrawerToggle(
	                this,
	                drLayout,
	                R.drawable.ic_menu, 
	                R.string.drawer_open, 
	                R.string.drawer_close 
	                ) {
	            
	            /** Called when a drawer has settled in a completely closed state. */
	            public void onDrawerClosed(View view) {
	                super.onDrawerClosed(view);
	            }
	         
	            /** Called when a drawer has settled in a completely open state. */
	            public void onDrawerOpened(View drawerView) {
	                super.onDrawerOpened(drawerView);
	            }
	        };
	         
	        drLayout.setDrawerListener(drToggle);
        }
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
    }
    
    
    private HTMLHeader[] getHTMLHeaders() throws IOException{
    	AssetManager assetManager = getAssets();
		//String text = new String();
	    InputStream input = assetManager.open(HTMLName);
	   /* try {
		    input = assetManager.open(HTMLName);
			int size = input.available();
		    byte[] buffer = new byte[size];
		    input.read(buffer);
		    input.close();
		    text = new String(buffer);
	    } catch (IOException e) {
           e.printStackTrace();
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
	    headerList.addFirst(new HTMLHeader(1,"","HOME"));
	    HTMLHeader[] headerArr = headerList.toArray(new HTMLHeader[headerList.size()]);
	    return headerArr;*/
    	LinkedList<HTMLHeader> headerList = new LinkedList<HTMLHeader>();
    	Document doc =  Jsoup.parse(input,"utf-8","");
        Elements heads = doc.select("h1,h2,h3");
        for(Element head:heads){
        	char tagNum = head.tag().toString().charAt(1);
        	headerList.add(new HTMLHeader(Integer.parseInt(tagNum+""),head.id(),head.text()));
        }
        headerList.addFirst(new HTMLHeader(1,"","HOME"));
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
    	//webView.loadUrl(HTMLPath+ "#" + headers[position].getID());
    	//Fragment fragment = new ViewFragment(HTMLPath+"#"+headers[position].getID());
    	webViewer.viewID(headers[position].getID());
    	getFragmentManager().beginTransaction().replace(R.id.content_frame, webViewer).commit();
        drList.setItemChecked(position, true);
        drList.setSelection(position);
    	drLayout.closeDrawers();
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
        //int id = item.getItemId();
        /*if (id == R.id.action_settings) {
            return true;
        }*/
        if (drToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    } 
    
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drToggle.syncState();
    }
    
    @Override
    protected void onSaveInstanceState(Bundle outState )
    {
    	super.onSaveInstanceState(outState);
    	webViewer.getWebView().saveState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
    	super.onRestoreInstanceState(savedInstanceState);
    	webViewer.getWebView().restoreState(savedInstanceState);
    }
}


