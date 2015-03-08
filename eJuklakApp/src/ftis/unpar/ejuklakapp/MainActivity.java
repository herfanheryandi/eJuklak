package ftis.unpar.ejuklakapp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.text.Html;
import android.text.Html.ImageGetter;


public class MainActivity extends ActionBarActivity {
	private WebView webView;
	private String[] drTitle;
	private DrawerLayout drLayout;
	private ListView drList;
	private ActionBarDrawerToggle drToggle;
	private CharSequence openTitle;
	private CharSequence closeTitle;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        closeTitle = getTitle();
        openTitle = getTitle();
        //Code here
        
        /*webview*/
        webView = (WebView) findViewById(R.id.webview);
        webView.loadUrl("file:///android_asset/MarkdownBab1.htm");
        
        /*navigation drawer*/ 
        drLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drList = (ListView) findViewById(R.id.left_drawer);
        //bisa diinisialisasi dengan hasil baca 
        DrawerItem[] drItem = new DrawerItem[3];
        drItem[0] = new DrawerItem(R.drawable.ic_paper, "Create");
        drItem[1] = new DrawerItem(R.drawable.ic_paper, "Read");
        drItem[2] = new DrawerItem(R.drawable.ic_paper, "Help");
        
        DrawerAdapter drAdapter = new DrawerAdapter(this, R.layout.listview_item_row, drItem);
        drList.setAdapter(drAdapter);
       
        drList.setOnItemClickListener(new DrawerListener());
        
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
                getActionBar().setTitle(closeTitle);
            }
         
            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActionBar().setTitle(openTitle);
            }
        };
         
        drLayout.setDrawerListener(drToggle);
         
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
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
        if (drToggle.onOptionsItemSelected(item)) {
            return true;
        }
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
     
     
    private void selectItem(int position) {
        
        Fragment fragment = null;
        
        switch (position) {
        case 0:
            fragment = new CustomFragment();
            break;
        case 1:
            fragment = new CustomFragment();
            break;
        case 2:
            fragment = new CustomFragment();
            break;
     
        default:
            break;
        }
        
        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
     
            drList.setItemChecked(position, true);
            drList.setSelection(position);
            setTitle(drTitle[position]);
            drLayout.closeDrawer(drList);
            
        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
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
