package in.co.zoid;

import java.util.List;
import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class RssReaderListAdapter extends ArrayAdapter<RssFeedStructure> {
List<RssFeedStructure> item =null;
public RssReaderListAdapter(Activity activity, List<RssFeedStructure> imageAndTexts) {
super(activity, 0, imageAndTexts);
item = imageAndTexts;
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {

Activity activity = (Activity) getContext();
LayoutInflater inflater = activity.getLayoutInflater();


View rowView = inflater.inflate(R.layout.feedlist, null);
TextView textView = (TextView) rowView.findViewById(R.id.feed_text);
TextView textViewdesc = (TextView) rowView.findViewById(R.id.feed_desc);
TextView textViewlink = (TextView) rowView.findViewById(R.id.feed_link);
        try {
        	textView.setText(item.get(position).getTitle());
        	textViewdesc.setText(item.get(position).getDescription());
        	textViewlink.setText(item.get(position).getUrl());
        	
        	if(item.get(position).getUrl().equals("") && item.get(position).getDescription().equals("")){
        		textView.setTextColor(Color.RED);
        		textView.setTextSize(50);
        		textViewdesc.setVisibility(View.GONE);
        		textViewlink.setVisibility(View.GONE);
        	}
        	if(item.get(position).getUrl().equals("")){
        		textViewlink.setVisibility(View.GONE);
        	}
        	if(item.get(position).getDescription().equals("")){
        		textViewdesc.setVisibility(View.GONE);
        	}
        	if(item.get(position).getTitle().equals("")){
        		textView.setVisibility(View.GONE);
        	}
        	
        } catch (Exception e) {
        	Toast.makeText(getContext(), e.toString(), Toast.LENGTH_LONG).show();
        }
        
        
     

return rowView;

}

}