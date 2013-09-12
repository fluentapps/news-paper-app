package in.co.zoid;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Bookmark extends Activity {
    /** Called when the activity is first created. */
	
	String error="";
	String imei="";
	ListView _rssFeedListView;
	List<JSONObject> jobs ;
	List<RssFeedStructure> rssStr ;
	private RssReaderListAdapter _adapter;
	String sorti = "";
	String mode = "";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.bookmark);
       _rssFeedListView = (ListView)findViewById(R.id.rssfeed_listview);
       
       RssFeedTask rssTask = new RssFeedTask();
       rssTask.execute();
    }
    private class RssFeedTask extends AsyncTask<String, Void, String> {
		// private String Content;
		private ProgressDialog Dialog;
		String response = "";

		@Override
		protected void onPreExecute() {
			Dialog = new ProgressDialog(Bookmark.this);
			Dialog.setMessage("Loading bookmarks...");
			Dialog.show();
		
		}

		@Override
		protected String doInBackground(String... urls) {		 	 
				try{
						TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
					    String device_id = tm.getDeviceId();
						
					    String s=device_id;
					    MessageDigest m=MessageDigest.getInstance("MD5");
					    m.update(s.getBytes(),0,s.length());
					    device_id=new BigInteger(1,m.digest()).toString(16);
					    imei=device_id.substring(0, 5);
					    
					}
					catch(Exception e){
						Toast.makeText(getBaseContext(),e.toString(),Toast.LENGTH_LONG).show();
					}
				  
				  String feed = "http://i.zoid.in/bookmark.php?imei="+imei;
				 	  
				  XmlHandler rh = new XmlHandler();
				  rssStr = rh.getLatestArticles(feed);	        
			return response;
		}

		@Override
		protected void onPostExecute(String result) {			  
			  if(rssStr != null){
			    _adapter = new RssReaderListAdapter(Bookmark.this,rssStr);
		        _rssFeedListView.setAdapter(_adapter);
			  }
		        Dialog.dismiss();
		}
	}
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bookmark, menu);
        return true;
    }
    
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_bookmark:
            	ScrollView sv=new ScrollView(Bookmark.this);
            	LinearLayout ll=new LinearLayout(Bookmark.this);
            	ll.setOrientation(android.widget.LinearLayout.VERTICAL);
            	 
            	AlertDialog.Builder ad=new AlertDialog.Builder(Bookmark.this);
            	  ad.setTitle("Add Bookmark");
				  
				  final TextView tvurl=new TextView(Bookmark.this);
				  tvurl.setText("Enter URL:");
				  tvurl.setTextColor(Color.WHITE);
				  tvurl.setPadding(5, 5, 5, 5);
				  final EditText url = new EditText(Bookmark.this);

				  final TextView tvtitle=new TextView(Bookmark.this);
				  tvtitle.setText("Title:");
				  tvtitle.setTextColor(Color.WHITE);
				  tvtitle.setPadding(5, 5, 5, 5);
				  final EditText title = new EditText(Bookmark.this);
	  
				  final TextView tvcat=new TextView(Bookmark.this);
				  tvcat.setText("Category:");
				  tvcat.setTextColor(Color.WHITE);
				  tvcat.setPadding(5, 5, 5, 5);
				  final Spinner sp=new Spinner(Bookmark.this);
				  List<String> list = new ArrayList<String>();
					list.add("News");
					list.add("Work");
					list.add("Video");
					list.add("Reminder");
				  ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
							android.R.layout.simple_spinner_item, list);
				  dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				  sp.setAdapter(dataAdapter);
				  
				   ll.addView(tvurl);
				   ll.addView(url);
				   ll.addView(tvtitle);
				   ll.addView(title);
				   ll.addView(tvcat);
				   ll.addView(sp);
				   
				   sv.addView(ll);
				   ad.setView(sv);
				   
            	ad.setPositiveButton("Add", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						String surl = url.getText().toString();
				        String stitle = title.getText().toString();
				        String scategory=sp.getSelectedItem().toString();
				        
				        if(stitle.equals("")){
				        	error="Please enter a title";
				        }
				        AlertDialog.Builder msg = new AlertDialog.Builder(Bookmark.this);
			        	  msg.setTitle("Error");
			        	  msg.setMessage(error);
			        	  msg.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								// TODO Auto-generated method stub
								
							}
						  });
				     
			        	  TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
						  String device_id = tm.getDeviceId();
							
						  String s=device_id;
						  try{
						  MessageDigest md=MessageDigest.getInstance("MD5");
						  md.update(s.getBytes(),0,s.length());
						  device_id=new BigInteger(1,md.digest()).toString(16);
						  imei=device_id.substring(0, 5);
						  }
						  catch(Exception e){
							  Toast.makeText(getBaseContext(),e.toString(),Toast.LENGTH_LONG).show();
						  }
			        	  if(!error.equals(""))
			        	  	msg.show();
			        	  else{
			        	  WebView webview = new WebView(Bookmark.this);
			        	  webview.setWebViewClient(new WebViewClient()); 
			        	  webview.loadUrl("http://i.zoid.in/work.php?imei="+imei+"&url="+surl+"&title="+stitle+"&category="+scategory);
			        	  Toast.makeText(getBaseContext(), "Bookmark added", Toast.LENGTH_LONG).show();
			        	  }
			        	  return;                  
				         } 

            	});
            	
            	ad.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

			          public void onClick(DialogInterface dialog, int which) {
			              // TODO Auto-generated method stub
			              return;   
			          }
			      });
            	ad.show();
            	
            
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}