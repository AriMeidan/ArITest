package ari.meidan.contactsari;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button btnAdd = (Button)findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				AddContactDialog contactDialog = new AddContactDialog(MainActivity.this);
				contactDialog.show();
						
			}
		});
        
        Button btnDel = (Button)findViewById(R.id.btnDelete);
        btnDel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.d(MainActivity.this.getClass().getSimpleName(), "btnDel not implemented");
			}
		});
        
        
    }
    
}
