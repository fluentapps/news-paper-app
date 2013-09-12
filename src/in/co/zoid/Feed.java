package in.co.zoid;

import java.util.List;
import org.json.JSONObject;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ListView;
import android.widget.Toast;

public class Feed extends Activity {
    /** Called when the activity is first created. */
	
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
        setContentView(R.layout.feed);
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
			Dialog = new ProgressDialog(Feed.this);
			Dialog.setMessage("Loading news feeds...");
			Dialog.show();
			
		}

		@Override
		protected String doInBackground(String... urls) {
			  try {
				  SharedPreferences prefs;
				  prefs=getSharedPreferences("zoid",MODE_PRIVATE);
				  
				  boolean b1=prefs.getBoolean("Sports", false);
				  boolean b2=prefs.getBoolean("Business", false);
				  boolean b3=prefs.getBoolean("Science", false);
				 
				  int sports=0;
				  int business=0;
				  int science=0;
		
				  if(String.valueOf(b1).equals("true"))
					  sports=1;
				  else
					  sports=0;
				  
				  if(String.valueOf(b2).equals("true"))
					  business=1;
				  else
					  business=0;
				  
				  if(String.valueOf(b3).equals("true"))
					  science=1;
				  else
					  science=0;
				  
				  String feed = "http://www.kashmirlife.net/feed/";
				 
				  XmlHandler rh = new XmlHandler();
				  rssStr = rh.getLatestArticles(feed);
			        } catch (Exception e) {
			        }
			return response;

		}

		@Override
		protected void onPostExecute(String result) {			  
			  if(rssStr != null){
			    _adapter = new RssReaderListAdapter(Feed.this,rssStr);
		        _rssFeedListView.setAdapter(_adapter);
			  }
		        Dialog.dismiss();
		}
	}
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.feed, menu);
        return true;
    }
    
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_feed:
            	AlertDialog.Builder ad=new AlertDialog.Builder(Feed.this);
            	ad.setTitle("Feed Settings");
            	
            	final CharSequence[] items ={"Sports","Business","Science"};
            	final boolean[] itemsChecked= new boolean[items.length];
            	
            	SharedPreferences prefs;
				prefs=getSharedPreferences("zoid",MODE_PRIVATE);
            	boolean b1=prefs.getBoolean("Sports", false);
				boolean b2=prefs.getBoolean("Business", false);
				boolean b3=prefs.getBoolean("Science", false);

				  if(String.valueOf(b1).equals("true"))
					  itemsChecked[0]=true;
				  else
					  itemsChecked[0]=false;
				  
				  if(String.valueOf(b2).equals("true"))
					  itemsChecked[1]=true;
				  else
					  itemsChecked[1]=false;
				  
				  if(String.valueOf(b3).equals("true"))
					  itemsChecked[2]=true;
				  else
					  itemsChecked[2]=false;
            	
            	ad.setMultiChoiceItems(items, itemsChecked, new DialogInterface.OnMultiChoiceClickListener() {
		
					@Override
					public void onClick(DialogInterface dialog, int which, boolean isChecked) {
						// TODO Auto-generated method stub
						SharedPreferences prefs;
						prefs=getSharedPreferences("zoid",MODE_PRIVATE);
						
						SharedPreferences.Editor editor=prefs.edit();
						editor.putBoolean(items[which].toString(), isChecked);
						editor.commit();
						
						boolean b=prefs.getBoolean(items[which].toString(), false);
						Toast.makeText(getBaseContext(), items[which].toString()+":"+ String.valueOf(b) , Toast.LENGTH_SHORT).show();
					}
				});
            	
            	ad.setPositiveButton("Done", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Toast.makeText(getBaseContext(), "Settings saved", Toast.LENGTH_LONG).show();						
					}
            	});
            	ad.show();
            	
            
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}