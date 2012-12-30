package ari.meidan.contactsari;

import java.util.ArrayList;
import java.util.Random;

import android.content.ContentProviderOperation;
import android.content.Context;
import android.provider.ContactsContract;
import android.provider.ContactsContract.RawContacts;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class AddContactView extends RelativeLayout{

	private Random randomId;
	EditText lstNameField,  fstNameField,  phoneField,  emailField;

	
	public AddContactView(Context context) {
		super(context);
		
		randomId = new Random();
		
		RelativeLayout.LayoutParams thisViewParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		this.setLayoutParams(thisViewParams);
		
		fstNameField = new EditText(context);
		fstNameField.setHint("Enter First Name");
		fstNameField.setId(randomId.nextInt());
		RelativeLayout.LayoutParams fstNameFieldLP = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT); 
		fstNameFieldLP.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		
	
		
		lstNameField = new EditText(context);
		lstNameField.setHint("Enter Last Name");
		lstNameField.setId(randomId.nextInt());
		RelativeLayout.LayoutParams lstNameFieldLP = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT); 
		lstNameFieldLP.addRule(RelativeLayout.BELOW, fstNameField.getId());

		phoneField = new EditText(context);
		phoneField.setHint("Enter Phone Number");
		phoneField.setId(randomId.nextInt());
		phoneField.setInputType(InputType.TYPE_CLASS_PHONE);
		
		RelativeLayout.LayoutParams phoneFieldLP = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT); 
		phoneFieldLP.addRule(RelativeLayout.BELOW, lstNameField.getId());
		
		emailField = new EditText(context);
		emailField.setHint("Enter e-mail");
		emailField.setId(randomId.nextInt());
		emailField.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
		
		RelativeLayout.LayoutParams emailFieldLP = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT); 
		emailFieldLP.addRule(RelativeLayout.BELOW, phoneField.getId());
		
		RelativeLayout buttonsLayout = new RelativeLayout(context);
		
		RelativeLayout.LayoutParams buttonsLP = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT); 
		buttonsLP.addRule(RelativeLayout.BELOW, emailField.getId());		
		
		Button btnAdd = new Button(context);
		btnAdd.setText("Add");
		
		btnAdd.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				final String givenName = fstNameField.getText().toString();
				final String familyName = lstNameField.getText().toString();
				
				ArrayList<ContentProviderOperation> ops = new ArrayList<ContentProviderOperation>();
				int rawContactInsertIndex = ops.size();
				 
				ops.add(ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI)
				.withValue(RawContacts.ACCOUNT_TYPE, null)
				.withValue(RawContacts.ACCOUNT_NAME, null)
				.build());
				
				 ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
						 .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID,rawContactInsertIndex)
						 .withValue(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)
						 .withValue(ContactsContract.CommonDataKinds.StructuredName.FAMILY_NAME, givenName) // Name of the person
						 .withValue(ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME, familyName) // Name of the person
						 .build());
			}
		});
		
		RelativeLayout.LayoutParams btnAddLP = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT); 
		btnAddLP.addRule(RelativeLayout.ALIGN_PARENT_LEFT);

		Button btnCancel = new Button(context);
		btnCancel.setText("Cancel");
		RelativeLayout.LayoutParams btnCancelLP = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT); 
		btnCancelLP.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		
		buttonsLayout.addView(btnAdd, btnAddLP);
		buttonsLayout.addView(btnCancel, btnCancelLP);
		
		
		this.addView(fstNameField, fstNameFieldLP);
		this.addView(lstNameField, lstNameFieldLP);
		this.addView(phoneField, phoneFieldLP);
		this.addView(emailField, emailFieldLP);
		this.addView(buttonsLayout, buttonsLP);
		
		
	}

}
