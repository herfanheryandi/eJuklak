package ftis.unpar.ejuklakapp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.text.Html;
import android.text.Html.ImageGetter;


public class MainActivity extends ActionBarActivity {

	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Code here
        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("file:///android_asset/MarkdownBab1.htm");
        /*TEXTVIEW
         * String htmlText = new String();  
		try {
			InputStream file = this.getAssets().open("file:///android_asset/MarkdownBab1.htm");
			htmlText = this.read(new InputStreamReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			htmlText = "Masih error file not found!";
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			htmlText = "Masih error";
			e.printStackTrace();
		}
        TextView htmlTextView = (TextView)findViewById(R.id.textView);
        htmlTextView.setText(Html.fromHtml(htmlText, null, null));
		*/
       
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
        return super.onOptionsItemSelected(item);
    }
    
    /*TEXTVIEW
     * public String read(InputStreamReader file) throws Exception{
    	BufferedReader reader = new BufferedReader(file);
		String res = new String();
		String text = reader.readLine();
		while(text!=null){
			res += text;
			text = reader.readLine();
		}
		reader.close();
		return res;
	}*/
}
