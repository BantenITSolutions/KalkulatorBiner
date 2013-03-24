package dlmbg.pckg.kalkulator.biner;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class KalkulatorBinerActivity extends Activity {
    /** Called when the activity is first created. */
	EditText t_in,t_out;
	Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,b_hps,b_ke_desimal,b_biner;
	String var_in="";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.main);

        t_in = (EditText) findViewById(R.id.txt_in);
        t_out = (EditText) findViewById(R.id.txt_out);
        b0 = (Button) findViewById(R.id.btn0);
        b1 = (Button) findViewById(R.id.btn1);
        b2 = (Button) findViewById(R.id.btn2);
        b3 = (Button) findViewById(R.id.btn3);
        b4 = (Button) findViewById(R.id.btn4);
        b5 = (Button) findViewById(R.id.btn5);
        b6 = (Button) findViewById(R.id.btn6);
        b7 = (Button) findViewById(R.id.btn7);
        b8 = (Button) findViewById(R.id.btn8);
        b9 = (Button) findViewById(R.id.btn9);
        b_hps = (Button) findViewById(R.id.btn_hapus);
        b_ke_desimal = (Button) findViewById(R.id.btn_ke_desimal);
        b_biner = (Button) findViewById(R.id.btn_biner);
        
        b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if(var_in.trim().equals(""))
				{
					var_in = "1";
					t_in.setText(var_in);
				}
				else
				{
					var_in = t_in.getText().toString()+"1";
					t_in.setText(var_in);
				}
        	}
        });
        
        b2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if(var_in.trim().equals(""))
				{
					var_in = "2";
					t_in.setText(var_in);
				}
				else
				{
					var_in = t_in.getText().toString()+"2";
					t_in.setText(var_in);
				}
        	}
        });
        
        b3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if(var_in.trim().equals(""))
				{
					var_in = "3";
					t_in.setText(var_in);
				}
				else
				{
					var_in = t_in.getText().toString()+"3";
					t_in.setText(var_in);
				}
        	}
        });
        
        b4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if(var_in.trim().equals(""))
				{
					var_in = "4";
					t_in.setText(var_in);
				}
				else
				{
					var_in = t_in.getText().toString()+"4";
					t_in.setText(var_in);
				}
        	}
        });
        
        b5.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if(var_in.trim().equals(""))
				{
					var_in = "5";
					t_in.setText(var_in);
				}
				else
				{
					var_in = t_in.getText().toString()+"5";
					t_in.setText(var_in);
				}
        	}
        });
        
        b6.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if(var_in.trim().equals(""))
				{
					var_in = "6";
					t_in.setText(var_in);
				}
				else
				{
					var_in = t_in.getText().toString()+"6";
					t_in.setText(var_in);
				}
        	}
        });
        
        b7.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if(var_in.trim().equals(""))
				{
					var_in = "7";
					t_in.setText(var_in);
				}
				else
				{
					var_in = t_in.getText().toString()+"7";
					t_in.setText(var_in);
				}
        	}
        });
        
        b8.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if(var_in.trim().equals(""))
				{
					var_in = "8";
					t_in.setText(var_in);
				}
				else
				{
					var_in = t_in.getText().toString()+"8";
					t_in.setText(var_in);
				}
        	}
        });
        
        b9.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if(var_in.trim().equals(""))
				{
					var_in = "9";
					t_in.setText(var_in);
				}
				else
				{
					var_in = t_in.getText().toString()+"9";
					t_in.setText(var_in);
				}
        	}
        });
        
        b0.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if(var_in.trim().equals(""))
				{
					var_in = "0";
					t_in.setText(var_in);
				}
				else
				{
					var_in = t_in.getText().toString()+"0";
					t_in.setText(var_in);
				}
        	}
        });
        
        b_hps.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				t_in.setText("");
				t_out.setText("");
        	}
        });
        
        b_biner.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if(var_in!="")
				{
					String hasil = DesimalKeBiner(Integer.parseInt(var_in));
					t_out.setText(hasil);
					var_in="";
				}
				
        	}
        });
        
        b_ke_desimal.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				t_in.setText("");
				t_out.setText("");
				var_in="";
				Intent i = new Intent(getApplicationContext(), KalkulatorDesimalActivity.class);
				startActivity(i);
        	}
        });
    }
    
    public String DesimalKeBiner(int angka_desimal)
    {
    	int sisa_bagi=0, i=0; 
    	boolean ulang=true; 
    	int[] arr_simpan = new int[10000];
    	sisa_bagi=angka_desimal;
    	
    	String hasil="";
    	while (ulang==true)
    	{ 
    		sisa_bagi = angka_desimal%2; 
	    	angka_desimal= angka_desimal/2;
	    	arr_simpan[i]=sisa_bagi; 
	    	i++;
	    	if((angka_desimal==0)||(angka_desimal==1))
	    	{ 
	    		ulang=false; 
	    		arr_simpan[i]=angka_desimal; 
	    	}
    	}
    	for (int a=i; a>=0;a--)
    	{ 
    		hasil += arr_simpan[a];
    	}
    	return hasil;
    }
    
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.opt_menu, menu);
        return true;
    }
    
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        	case R.id.tentang:
        		AlertDialog alertDialog;
        		alertDialog = new AlertDialog.Builder(this).create();
        		alertDialog.setTitle("Sekilas Biner");
        		alertDialog.setMessage("Bilangan biner adalah salah satu sistem bilangan yang digunakan pada komputer. " +
        				"Berbeda dengan sistem bilangan desimal yang sering kita gunakan sehari-hari, " +
        				"sistem bilangan biner hanya menggunakan dua bilangan yaitu 0 (nol) dan 1 (satu). " +
        				"\n\nSalam, Gede Lumbung\nhttp://gedelumbung.com");
        		alertDialog.setButton("#OKOK", new DialogInterface.OnClickListener() {
        		    @Override
        		    public void onClick(DialogInterface dialog, int which) {
        		        dialog.dismiss();
        		    }
        		});
        		alertDialog.show();
        		return true;
        	case R.id.keluar:	
				Intent exit = new Intent(Intent.ACTION_MAIN);
				exit.addCategory(Intent.CATEGORY_HOME); exit.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				KalkulatorBinerActivity.this.finish();
				startActivity(exit);
        		return true;
        	default:
        		return super.onOptionsItemSelected(item);
        }
    }
}