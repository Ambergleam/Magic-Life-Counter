package com.giantoctopus.magic;

import com.giantoctopus.magic.R;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class Main extends TabActivity{
	
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    TabHost host = getTabHost();
	    Resources res = getResources();
        host.addTab(host.newTabSpec("life").setIndicator("Life", res.getDrawable(R.drawable.tab_life)).setContent(new Intent(this, Activity_Life.class)));
        host.addTab(host.newTabSpec("mana").setIndicator("Mana", res.getDrawable(R.drawable.tab_mana)).setContent(new Intent(this, Activity_Mana.class)));
        host.addTab(host.newTabSpec("random").setIndicator("Random", res.getDrawable(R.drawable.tab_random)).setContent(new Intent(this, Activity_Random.class)));
	}
	
}
