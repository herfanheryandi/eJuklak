package ftis.unpar.ejuklakapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class ViewFragment extends Fragment{
	String HTMLPath;
	WebView webView;
	
	public ViewFragment(String HTMLPath) {
		this.HTMLPath = HTMLPath;
	}

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.webview_fragment, container, false);
        webView = (WebView) rootView.findViewById(R.id.webview); 
        webView.getSettings().setBuiltInZoomControls(true);
        webView.loadUrl(HTMLPath); 
        return rootView;
    }
	
	public void viewID(String namePath){
		webView.loadUrl(HTMLPath+"#"+namePath); 
	}
	
	
}
