package in.co.zoid;

import android.net.Uri;
import java.math.*;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.app.*;
import android.content.*;

public class Calculator extends Activity {

	String op1="a0",op2="a",op="a";
	int resultBit=0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.calculator);
        
        EditText editTextResult=(EditText) findViewById(R.id.editTextResult);
        editTextResult.setText("0");
        
        Button b1=(Button) findViewById(R.id.button1);
        Button b2=(Button) findViewById(R.id.button2);
        Button b3=(Button) findViewById(R.id.button3);
        Button b4=(Button) findViewById(R.id.button4);
        Button b5=(Button) findViewById(R.id.button5);
        Button b6=(Button) findViewById(R.id.button6);
        Button b7=(Button) findViewById(R.id.button7);
        Button b8=(Button) findViewById(R.id.button8);
        Button b9=(Button) findViewById(R.id.button9);
        Button b0=(Button) findViewById(R.id.button0);
        Button bc=(Button) findViewById(R.id.buttonc);
        Button bdot=(Button) findViewById(R.id.buttondot);
        Button bequal=(Button) findViewById(R.id.buttonequalto);
        Button bp=(Button) findViewById(R.id.buttonplus);
        Button bm=(Button) findViewById(R.id.buttonminus);
        Button bx=(Button) findViewById(R.id.buttonmultiply);
        Button bd=(Button) findViewById(R.id.buttondivide);
        Button bcall=(Button) findViewById(R.id.buttoncall);
        
        b1.setOnClickListener(lb1);
        b2.setOnClickListener(lb2);
        b3.setOnClickListener(lb3);
        b4.setOnClickListener(lb4);
        b5.setOnClickListener(lb5);
        b6.setOnClickListener(lb6);
        b7.setOnClickListener(lb7);
        b8.setOnClickListener(lb8);
        b9.setOnClickListener(lb9);
        b0.setOnClickListener(lb0);
        bc.setOnClickListener(lbc);
        bdot.setOnClickListener(lbdot);
        bequal.setOnClickListener(lbequal);
        bp.setOnClickListener(lbp);
        bm.setOnClickListener(lbm);
        bx.setOnClickListener(lbx);
        bd.setOnClickListener(lbd);    
        bcall.setOnClickListener(lbcall);
        
        lbc.onClick(bc);
       
    }
    View.OnClickListener lb1 = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub	
			EditText editTextResult=(EditText) findViewById(R.id.editTextResult);
			if(resultBit==1){
				editTextResult.setText("");
				resultBit=0;
			}
			String temp1=editTextResult.getText().toString();
			if(temp1.equals("0") || temp1.equals("0.0")){
				temp1="";
			}
			editTextResult.setText(temp1 + "1");
		}
	};
	View.OnClickListener lb2 = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub	
			EditText editTextResult=(EditText) findViewById(R.id.editTextResult);
			if(resultBit==1){
				editTextResult.setText("");
				resultBit=0;
			}
			String temp1=editTextResult.getText().toString();
			if(temp1.equals("0") || temp1.equals("0.0")){
				temp1="";
			}
			editTextResult.setText(temp1 + "2");
		}
	};
	View.OnClickListener lb3 = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub	
			EditText editTextResult=(EditText) findViewById(R.id.editTextResult);
			if(resultBit==1){
				editTextResult.setText("");
				resultBit=0;
			}
			String temp1=editTextResult.getText().toString();
			if(temp1.equals("0") || temp1.equals("0.0")){
				temp1="";
			}
			editTextResult.setText(temp1 + "3");
		}
	};
	View.OnClickListener lb4 = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub	
			EditText editTextResult=(EditText) findViewById(R.id.editTextResult);
			if(resultBit==1){
				editTextResult.setText("");
				resultBit=0;
			}
			String temp1=editTextResult.getText().toString();
			if(temp1.equals("0") || temp1.equals("0.0")){
				temp1="";
			}
			editTextResult.setText(temp1 + "4");
		}
	};
	View.OnClickListener lb5 = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub	
			EditText editTextResult=(EditText) findViewById(R.id.editTextResult);
			if(resultBit==1){
				editTextResult.setText("");
				resultBit=0;
			}
			String temp1=editTextResult.getText().toString();
			if(temp1.equals("0") || temp1.equals("0.0")){
				temp1="";
			}
			editTextResult.setText(temp1 + "5");
		}
	};
	View.OnClickListener lb6 = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub	
			EditText editTextResult=(EditText) findViewById(R.id.editTextResult);
			if(resultBit==1){
				editTextResult.setText("");
				resultBit=0;
			}
			String temp1=editTextResult.getText().toString();
			if(temp1.equals("0") || temp1.equals("0.0")){
				temp1="";
			}
			editTextResult.setText(temp1 + "6");
		}
	};
	View.OnClickListener lb7 = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub	
			EditText editTextResult=(EditText) findViewById(R.id.editTextResult);
			if(resultBit==1){
				editTextResult.setText("");
				resultBit=0;
			}
			String temp1=editTextResult.getText().toString();
			if(temp1.equals("0") || temp1.equals("0.0")){
				temp1="";
			}
			editTextResult.setText(temp1 + "7");
		}
	};
	View.OnClickListener lb8 = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub	
			EditText editTextResult=(EditText) findViewById(R.id.editTextResult);
			if(resultBit==1){
				editTextResult.setText("");
				resultBit=0;
			}
			String temp1=editTextResult.getText().toString();
			if(temp1.equals("0") || temp1.equals("0.0")){
				temp1="";
			}
			editTextResult.setText(temp1 + "8");
		}
	};
	View.OnClickListener lb9 = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub	
			EditText editTextResult=(EditText) findViewById(R.id.editTextResult);
			if(resultBit==1){
				editTextResult.setText("");
				resultBit=0;
			}
			String temp1=editTextResult.getText().toString();
			if(temp1.equals("0") || temp1.equals("0.0")){
				temp1="";
			}
			editTextResult.setText(temp1 + "9");
		}
	};
	View.OnClickListener lb0 = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub	
			EditText editTextResult=(EditText) findViewById(R.id.editTextResult);
			if(resultBit==1){
				editTextResult.setText("");
				resultBit=0;
			}
			String temp1=editTextResult.getText().toString();
			if(temp1.equals("0") || temp1.equals("0.0")){
				temp1="";
			}
			editTextResult.setText(temp1 + "0");
		}
	};
	View.OnClickListener lbdot = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub	
			EditText editTextResult=(EditText) findViewById(R.id.editTextResult);
			if(editTextResult.getText().toString().contains("."))
					;
			else{	
				String temp1=editTextResult.getText().toString();
				editTextResult.setText(temp1 + ".");
			}
		}
	};
	View.OnClickListener lbc = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub	
			op1="a";
			op2="a";
			op="a";
			EditText editTextResult=(EditText) findViewById(R.id.editTextResult);
			TextView editMid=(TextView) findViewById(R.id.editMid);
			editTextResult.setText("0");
			editMid.setText("");
		}
	};

	View.OnClickListener lbp = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub	
			EditText editTextResult=(EditText) findViewById(R.id.editTextResult);
			if(editTextResult.getText().toString().equals("-")){
				lbc.onClick(v);
			}
			else{
			TextView editMid=(TextView) findViewById(R.id.editMid);
			if(op.equals("a")) //If + - are pressed after each other
				op1=editTextResult.getText().toString();
			op="+";
			editTextResult.setText("");
			editMid.setText(op1 + " " + op);
			}
		}
	};
	
	View.OnClickListener lbm = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub	
			EditText editTextResult=(EditText) findViewById(R.id.editTextResult);
			if(editTextResult.getText().toString().equals("-")){
				lbc.onClick(v);
			}
			else{
			if(op.equals("a")&&op1.equals("a")&&op2.equals("a")&&editTextResult.getText().toString().equals("0")){
				editTextResult.setText("-");
			}
			else{
				TextView editMid=(TextView) findViewById(R.id.editMid);
				if(op.equals("a"))
					op1=editTextResult.getText().toString();
				op="-";
				editTextResult.setText("");
				if(editMid.getText().toString().equals("-"))
					editMid.setText(editMid.getText().toString()+op1 + " " + op);
				else
					editMid.setText(op1 + " " + op);
			}
		}}
	};
	
	View.OnClickListener lbx = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub	
			EditText editTextResult=(EditText) findViewById(R.id.editTextResult);
			if(editTextResult.getText().toString().equals("-")){
				lbc.onClick(v);
			}
			else{
			TextView editMid=(TextView) findViewById(R.id.editMid);
			if(op.equals("a"))
				op1=editTextResult.getText().toString();
			op="x";
			editTextResult.setText("");
			editMid.setText(op1 + " " + op);
		}
		}
	};
	View.OnClickListener lbd = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub	
			EditText editTextResult=(EditText) findViewById(R.id.editTextResult);
			if(editTextResult.getText().toString().equals("-")){
				lbc.onClick(v);
			}
			else{
			TextView editMid=(TextView) findViewById(R.id.editMid);
			if(op.equals("a"))
				op1=editTextResult.getText().toString();
			op="/";
			editTextResult.setText("");
			editMid.setText(op1 + " " + op);
			}
		}
	};
	
	View.OnClickListener lbequal = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			double ans=0;
			String answer="";
			// TODO Auto-generated method stub
			try{
				EditText editTextResult=(EditText) findViewById(R.id.editTextResult);
				TextView editMid=(TextView) findViewById(R.id.editMid);
				op2=editTextResult.getText().toString();
				if(op.equals("a")){
					ans=Double.parseDouble(editTextResult.getText().toString());
				}
				else if (op2.equals("")){
					ans=Double.parseDouble(op1.toString());
				}
				else if(op2.equals("a")){
					;
				}
				else{
					if(op.equals("+"))
						ans=Double.parseDouble(op1.toString())+Double.parseDouble(op2.toString());
					if(op.equals("-"))
						ans=Double.parseDouble(op1.toString())-Double.parseDouble(op2.toString());
					if(op.equals("x"))
						ans=Double.parseDouble(op1.toString())*Double.parseDouble(op2.toString());
					if(op.equals("/"))
						ans=Double.parseDouble(op1.toString())/Double.parseDouble(op2.toString());
				}
				answer=Double.toString(ans);
				editTextResult.setText(String.valueOf(ans));
				answer=editTextResult.getText().toString();
				if(answer.length()>14)
					answer=answer.substring(0, 14);
				answer=String.format("%.10f", Double.parseDouble(answer));
				editTextResult.setText(answer);
				editMid.setText("");
				op="a";
				resultBit=1;
			}
			catch(Exception e)
			{
				Toast.makeText(getBaseContext(), e.toString(), Toast.LENGTH_LONG).show();
			}
			
		}
	};
	
	View.OnClickListener lbcall = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			BigInteger preNumber;
			EditText editTextResult=(EditText) findViewById(R.id.editTextResult);
			try 
			{
			if (editTextResult.getText().toString().equals(""))
				preNumber=new BigInteger("0");
			else{
				String s=editTextResult.getText().toString();
				if(s.contains(".") ){
					Exception e=new Exception("Invalid Number");
					throw(e);
				}
				else if(s.length()<10 || s.length() >11){
					Exception e=new Exception("Invalid Number");
					throw(e);
				}
				else{
					preNumber=new BigInteger(s);
				}
			}
			String number= preNumber.toString();
			editTextResult.setText(number);
			Intent i = new Intent(android.content.Intent.ACTION_DIAL,Uri.parse("tel:" + number));
			startActivity(i);
			lbc.onClick(v);
			}
			catch (Exception e)
			{
				Toast.makeText(getBaseContext(),"Invalid Number",Toast.LENGTH_LONG).show();
			}
		}
	};	
}