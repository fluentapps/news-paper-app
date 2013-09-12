package in.co.zoid;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Toast;
import android.content.Intent;

public class BarCode extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.barcode);
        IntentIntegrator.initiateScan(this);
        
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	switch(requestCode) {
    	case IntentIntegrator.REQUEST_CODE: {
    		if (resultCode != RESULT_CANCELED) {
    			IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
    			if (scanResult != null) {
    				String upc = scanResult.getContents();
    	 
    	//put whatever you want to do with the code here
    			Toast.makeText(this,upc,Toast.LENGTH_LONG).show();
    			Intent i=new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://www.flipkart.com/search/a/books?query="+upc));
            	startActivity(i);
            	finish();
    			}
    		}
    		break;
    	}
    }
}
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
