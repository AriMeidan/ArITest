package ari.meidan.contactsari;

import android.app.Dialog;
import android.content.Context;
import android.widget.RelativeLayout;

public class AddContactDialog extends Dialog{

	public AddContactDialog(Context context) {
		super(context);
		
		RelativeLayout contactView = new AddContactView(context);
		this.setContentView(contactView);
		this.setTitle("Add Contact");
		this.setCancelable(true);
		
	}

}
