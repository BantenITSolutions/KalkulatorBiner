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

public class KalkulatorDesimalActivity extends Activity {
    /** Called when the activity is first created. */
	EditText t_in,t_out;
	Button b0,b1,b_hps,b_ke_biner,b_desimal;
	String var_in="";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.second);

        t_in = (EditText) findViewById(R.id.txt_in);
        t_out = (EditText) findViewById(R.id.txt_out);
        b0 = (Button) findViewById(R.id.btn0);
        b1 = (Button) findViewById(R.id.btn1);
        b_hps = (Button) findViewById(R.id.btn_hapus);
        b_ke_biner = (Button) findViewById(R.id.btn_ke_biner);
        b_desimal = (Button) findViewById(R.id.btn_desimal);
        
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
        
        b_desimal.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if(var_in!="")
				{
					int hasil = BinerKeDesimal(Integer.parseInt(var_in));
					t_out.setText(Double.toString(hasil));
					var_in="";
				}
				
        	}
        });
        
        b_ke_biner.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				KalkulatorDesimalActivity.this.finish();
        	}
        });
    }
    
    public int BinerKeDesimal(int angka_desimal)
    {
    	String bil = Integer.toString(angka_desimal);
    	int[] arr_simpan= new int[10000];
    	String[] str= new String[10000];
    	double hasil=0;
    	int hasil_akhir=0;
    	int a=0;
    	char t;
    	
    	for(int i=0;i < bil.length();i++)
    	{
	    	t = bil.charAt(i);
	    	str[i]=Character.toString(t);
    	}
    	
    	for(int i=bil.length()-1; i>=0;i--)
    	{
    		arr_simpan[a]=Integer.parseInt(str[i]);
	    	hasil= arr_simpan[a]* (Math.pow(2,a));
	    	hasil_akhir=hasil_akhir+(int)hasil;
	    	a++;
    	}
    	return hasil_akhir;
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
				KalkulatorDesimalActivity.this.finish();
				startActivity(exit);
        		return true;
        	default:
        		return super.onOptionsItemSelected(item);
        }
    }
}