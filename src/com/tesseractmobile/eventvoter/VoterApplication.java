package com.tesseractmobile.eventvoter;

import android.app.Application;

public class VoterApplication extends Application {
	private ServiceClient srvClient;

	public void setSrvClient(ServiceClient srvClient) {
		this.srvClient = srvClient;
	}

	public ServiceClient getSrvClient() {
		return srvClient;
	}
}
