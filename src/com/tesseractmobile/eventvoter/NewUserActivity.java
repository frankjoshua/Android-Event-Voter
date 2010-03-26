package com.tesseractmobile.eventvoter;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class NewUserActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newuser);
		
		final VoterApplication voterApp = (VoterApplication) getApplication();
		
		final EditText edtUser = (EditText) findViewById(R.id.edtUser);
		
		 Button btnNewUser = (Button) findViewById(R.id.btnNewUserSubmit);
	        btnNewUser.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					try {
						voterApp.getSrvClient().RegisterUser(edtUser.getText().toString());
					} catch (ClientProtocolException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} catch (JSONException e) {
						e.printStackTrace();
					}
					
				}
			});
	}

}
