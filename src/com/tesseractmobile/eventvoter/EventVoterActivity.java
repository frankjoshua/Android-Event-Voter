package com.tesseractmobile.eventvoter;

import java.net.URISyntaxException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class EventVoterActivity extends Activity {
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        VoterApplication voterApp = (VoterApplication) getApplication();
        try {
			voterApp.setSrvClient(new ServiceClient());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
        
        
        Button btnNewUser = (Button) findViewById(R.id.btnnewuser);
        btnNewUser.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent newUserIntent = new Intent(EventVoterActivity.this, NewUserActivity.class);
				startActivity(newUserIntent);
			}
		});
        
        Button btnNewEvent = (Button) findViewById(R.id.btnnewevent);
        btnNewEvent.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent newUserIntent = new Intent(EventVoterActivity.this, NewEventActivity.class);
				startActivity(newUserIntent);
			}
		});
        
        Button btnVote = (Button) findViewById(R.id.btnvote);
        btnVote.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent newUserIntent = new Intent(EventVoterActivity.this, VoteActivity.class);
				startActivity(newUserIntent);
			}
		});
    }

}