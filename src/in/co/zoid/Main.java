package in.co.zoid;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.speech.RecognizerIntent;
import android.widget.ImageButton;
import android.widget.Toast;
import android.content.ActivityNotFoundException;
import java.util.ArrayList;

public class Main extends Activity {
	private ImageButton btnSpeak;
	protected static final int RESULT_SPEECH = 1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        
        Button balarm=(Button) findViewById(R.id.buttonbookmark);
        balarm.setOnClickListener(lbbookmark);
        
        Button bfeed=(Button) findViewById(R.id.buttonfeed);
        bfeed.setOnClickListener(lbfeed);
        
        Button bcalc=(Button) findViewById(R.id.buttoncalc);
        bcalc.setOnClickListener(lbcalc);
        
        btnSpeak = (ImageButton) findViewById(R.id.btnSpeak);
        btnSpeak.setOnClickListener(lblistner);
        
        Button bset=(Button) findViewById(R.id.buttonset);
        bset.setOnClickListener(lbset);
        
    }
   
 View.OnClickListener lblistner=new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			 Intent intent = new Intent(
                     RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

             intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");

             try {
                 startActivityForResult(intent, RESULT_SPEECH);
             } catch (ActivityNotFoundException a) {
                 Toast t = Toast.makeText(getApplicationContext(),
                         "Opps! Your device doesn't support Speech to Text",
                         Toast.LENGTH_SHORT);
                 t.show();
             }
		}
	};
	
	@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
 
        switch (requestCode) {
        case RESULT_SPEECH: {
            if (resultCode == RESULT_OK && null != data) {
 
                ArrayList<String> text = data
                        .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                
                Toast.makeText(this,text.get(0),Toast.LENGTH_LONG).show();
          
                if(text.get(0).contains("google")){
                	String s=text.get(0);
                	s=s.substring(6);
                	s.replace(" ", "+");
                	Intent i=new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://www.google.co.in/search?q="+s+"&oq="+s));
                	startActivity(i);
                }
                
                else if (text.get(0).contains("open")){
                	String s=text.get(0);
                	s=s.substring(4);
                	s.replace(" ", "+");
                	Uri site=Uri.parse("http://www.google.com");
                	if(s.contains("amazon"))
                		site=Uri.parse("http://www.amazon.com");
                	else if(s.contains("facebook"))
                		site=Uri.parse("http://www.facebook.com");
                	
                	Intent i=new Intent(android.content.Intent.ACTION_VIEW, site);
                	startActivity(i);
                	
                }
                else if(text.get(0).contains("bar") || text.get(0).contains("code")){
                	Intent i=new Intent(getBaseContext(), BarCode.class );
        			startActivity(i);
                }
                
                else if(text.get(0).contains("ca") || text.get(0).contains("ch")){
                	Intent i=new Intent(getBaseContext(), Calculator.class );
        			startActivity(i);
                }
                
                else if(text.get(0).contains("fe") || text.get(0).contains("new")){
                	Intent i=new Intent(getBaseContext(), Feed.class );
        			startActivity(i);
                } 
                
                else if(text.get(0).contains("ala")){
                	Intent i=new Intent(getBaseContext(), Bookmark.class );
        			startActivity(i);
                }
                
                else if(text.get(0).contains("do") || text.get(0).contains("to")){
                	Intent i=new Intent(getBaseContext(), Todo.class );
        			startActivity(i);
                }
                
                else if(text.get(0).contains("we") || text.get(0).contains("ag")){
                	Intent i=new Intent(getBaseContext(), Calculator.class );
        			startActivity(i);
                }
                
                else if(text.get(0).contains("ph") || text.get(0).contains("dial")){
                	Intent i=new Intent(android.content.Intent.ACTION_DIAL);
        			startActivity(i);
                }
                
                else if(text.get(0).contains("map") ){
                	Intent i=new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("geo:37.827500,-122.481670"));
        			startActivity(i);
                }
                
                else if(text.get(0).contains("face") || text.get(0).contains("book") ){
                	Intent i =  getPackageManager().getLaunchIntentForPackage("com.facebook.katana");
                	startActivity(i);
                }
                
                else if(text.get(0).contains("music") ){
                	Intent i =  getPackageManager().getLaunchIntentForPackage("com.sonyericsson.music");
                		startActivity(i);
                }
            }
            break;
        }
 
        }
	}
	
	View.OnClickListener lbbookmark=new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent i=new Intent(getBaseContext(), Bookmark.class );
			startActivity(i);
		}
	};
	
	View.OnClickListener lbfeed=new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent i=new Intent(getBaseContext(), Feed.class );
			startActivity(i);
		}
	};
	
	View.OnClickListener lbcalc=new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent i=new Intent(getBaseContext(), Calculator.class );
			startActivity(i);
		}
	};
	
	View.OnClickListener lbset=new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent i=new Intent(getBaseContext(), Settings.class );
			startActivity(i);
		}
	};
}
