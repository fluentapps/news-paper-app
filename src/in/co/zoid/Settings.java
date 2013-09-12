package in.co.zoid;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.regex.*;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.telephony.TelephonyManager;
import android.text.InputType;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class Settings extends Activity {

	String error="";
	String imei="";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.settings);
        
        Button bCode=(Button) findViewById(R.id.textView1);
        Button bRegister=(Button) findViewById(R.id.textView2);
        Button bTransfer=(Button) findViewById(R.id.textView3);
        bCode.setOnClickListener(lbCode);
        bRegister.setOnClickListener(lbRegister);
        bTransfer.setOnClickListener(lbTransfer);
    }
    View.OnClickListener lbCode=new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			try{
				TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
			    String device_id = tm.getDeviceId();
				
			    String s=device_id;
			    MessageDigest m=MessageDigest.getInstance("MD5");
			    m.update(s.getBytes(),0,s.length());
			    device_id=new BigInteger(1,m.digest()).toString(16);
			    imei=device_id.substring(0, 5);
			    device_id="Your mobile code is:\n"+imei;
			    
				AlertDialog ad = new AlertDialog.Builder(Settings.this).create();
				ad.setCancelable(false); // This blocks the 'BACK' button
				ad.setMessage(device_id);
				ad.setButton("OK", new DialogInterface.OnClickListener() {
				    @Override
				    public void onClick(DialogInterface dialog, int which) {
				        dialog.dismiss();                    
				    }
				});
				ad.show();
			}
			catch(Exception e){
				Toast.makeText(getBaseContext(),e.toString(),Toast.LENGTH_LONG).show();
			}

		}
	};
	
	 View.OnClickListener lbRegister=new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try{
					ScrollView sv=new ScrollView(Settings.this);
					LinearLayout ll=new LinearLayout(Settings.this);
					ll.setOrientation(android.widget.LinearLayout.VERTICAL);
					
					  AlertDialog.Builder alert = new AlertDialog.Builder(Settings.this);                 
					  alert.setTitle("Register");  
					  alert.setMessage("Register from here or register at i.zoid.in");
					   // Set an EditText view to get user input   
					  
				      final TextView tvemail=new TextView(Settings.this);
					  tvemail.setText("Enter Email ID:");
					  tvemail.setTextColor(Color.WHITE);
					  tvemail.setPadding(5, 5, 5, 5);
					  final EditText email = new EditText(Settings.this);

					  final TextView tvname=new TextView(Settings.this);
					  tvname.setText("Enter Name:");
					  tvname.setTextColor(Color.WHITE);
					  tvname.setPadding(5, 5, 5, 5);
					  final EditText name = new EditText(Settings.this);
					  
					  final TextView tvpassword=new TextView(Settings.this);
					  tvpassword.setText("Enter Password:");
					  tvpassword.setTextColor(Color.WHITE);
					  tvpassword.setPadding(5, 5, 5, 5);
					  final EditText password = new EditText(Settings.this);
					  password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
					  
					  final TextView tvconfirm=new TextView(Settings.this);
					  tvconfirm.setText("Confirm Password:");
					  tvconfirm.setTextColor(Color.WHITE);
					  tvconfirm.setPadding(5, 5, 5, 5);
					  final EditText confirm = new EditText(Settings.this);
					  confirm.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
					  
					   ll.addView(tvemail);
					   ll.addView(email);
					   ll.addView(tvname);
					   ll.addView(name);
					   ll.addView(tvpassword);
					   ll.addView(password);
					   ll.addView(tvconfirm);
					   ll.addView(confirm);
					   
					   sv.addView(ll);
					   alert.setView(sv);

					      alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {  
					      public void onClick(DialogInterface dialog, int whichButton) {  
					          String semail = email.getText().toString();
					          String sname = name.getText().toString();
					          String spassword = password.getText().toString();
					          String sconfirm = confirm.getText().toString();
					        		  
					          if(!spassword.equals(sconfirm))
					        	  error="The passwords do not match";
					          
					          Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
					          Matcher m = p.matcher(semail);
					          boolean matchFound = m.matches();
					          if(!matchFound)
					        	  error=error+"\n"+"The entered email address is not valid";
					          
					          if(spassword.length()<6)
					        	  error=error+"\n"+"The password should be atleast 6 characters long";
					          
					          Pattern p1 = Pattern.compile("^[a-zA-z ]+$");
					          Matcher m1 = p1.matcher(sname);
					          boolean matchFound1 = m1.matches();
					          if(!matchFound1)
					        	  error=error+"\n"+"The entered name is not valid";
					          
					          AlertDialog.Builder msg = new AlertDialog.Builder(Settings.this);
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
				        	  WebView webview = new WebView(Settings.this);
				        	  webview.setWebViewClient(new WebViewClient()); 
				        	  setContentView(webview);
				        	  webview.loadUrl("http://i.zoid.in/mregister.php?name="+sname+"&email="+semail+"&password="+spassword+"&confirm="+sconfirm+"&imei="+imei);
				        	  }
				        	  return;                  
					         }  
					       });  

					      alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

					          public void onClick(DialogInterface dialog, int which) {
					              // TODO Auto-generated method stub
					              return;   
					          }
					      });
					              alert.show();
				}
				catch(Exception e){
					Toast.makeText(getBaseContext(),e.toString(),Toast.LENGTH_LONG).show();
				}
			}
		};
		
		View.OnClickListener lbTransfer=new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try{
					ScrollView sv=new ScrollView(Settings.this);
					LinearLayout ll=new LinearLayout(Settings.this);
					ll.setOrientation(android.widget.LinearLayout.VERTICAL);
					
					  AlertDialog.Builder alert = new AlertDialog.Builder(Settings.this);                 
					  alert.setTitle("Transfer data here");  
					  alert.setMessage("Fill the information below to reterieve your previous phone data");
					   // Set an EditText view to get user input   
					  
				      final TextView tvemail=new TextView(Settings.this);
					  tvemail.setText("Enter Email ID:");
					  tvemail.setTextColor(Color.WHITE);
					  tvemail.setPadding(5, 5, 5, 5);
					  final EditText email = new EditText(Settings.this);
					  
					  final TextView tvpassword=new TextView(Settings.this);
					  tvpassword.setText("Enter Password:");
					  tvpassword.setTextColor(Color.WHITE);
					  tvpassword.setPadding(5, 5, 5, 5);
					  final EditText password = new EditText(Settings.this);
					  password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
					
					  
					   ll.addView(tvemail);
					   ll.addView(email);
					   ll.addView(tvpassword);
					   ll.addView(password);
					   
					   sv.addView(ll);
					   alert.setView(sv);

					      alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {  
					      public void onClick(DialogInterface dialog, int whichButton) {  
					          String semail = email.getText().toString();
					          String spassword = password.getText().toString();

					          
					          Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
					          Matcher m = p.matcher(semail);
					          boolean matchFound = m.matches();
					          if(!matchFound)
					        	  error=error+"\n"+"The entered email address is not valid";
					          
					          if(spassword.length()<6)
					        	  error=error+"\n"+"The password should be atleast 6 characters long";
					          
					          AlertDialog.Builder msg = new AlertDialog.Builder(Settings.this);
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
				        	  WebView webview = new WebView(Settings.this);
				        	  webview.setWebViewClient(new WebViewClient()); 
				        	  setContentView(webview);
				        	  webview.loadUrl("");
				        	  return;                  
					         } 
					      }
					       });  

					      alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

					          public void onClick(DialogInterface dialog, int which) {
					              // TODO Auto-generated method stub
					              return;   
					          }
					      });
					              alert.show();
				}
				catch(Exception e){
					Toast.makeText(getBaseContext(),e.toString(),Toast.LENGTH_LONG).show();
				}
			}
		};
}
