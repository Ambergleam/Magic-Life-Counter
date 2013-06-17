package com.giantoctopus.magic;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
//import android.widget.ScrollView;
import android.widget.TextView;

public class Activity_Life extends Activity {
	
	private TextView temp;
    private LinearLayout playerLifeLayout, opponentLifeLayout, playerPoisonLayout, opponentPoisonLayout;
	private int startingLife, textSize;
	public static int delta, maxPoison;
	public static int playerLife, opponentLife, playerPoison, opponentPoison;
	private boolean isOkay;
	public static boolean poisonBoolean, selectedPlayer;
	private final int CUSTOM_DIALOG = 0, maxLife = 999, minLife = -99, minPoison = 0;
	
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.menu_life, menu);
	    return true;
	} // creates menu
	
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
		    case R.id.menu_clear:
		        reset();
		        return true;
		    default:
		    	return super.onOptionsItemSelected(item);
	    } // end switch
	} // assigns meaning to menu items
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_life);
        
        // Constants
        startingLife = 20;
        maxPoison = 10;
        textSize = 25;
        
        // Setup
        this.playerLifeLayout = (LinearLayout)this.findViewById(R.id.lifeLayout1);
        this.playerLifeLayout.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				selectedPlayer = true;
				poisonBoolean = false;
				delta = playerLife;
				launchDialog();
			}
        });
        
        this.opponentLifeLayout = (LinearLayout)this.findViewById(R.id.lifeLayout2);
        this.opponentLifeLayout.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				selectedPlayer = false;
				poisonBoolean = false;
				delta = opponentLife;
				launchDialog();
			}
        });
        
        this.playerPoisonLayout = (LinearLayout)this.findViewById(R.id.poisonLayout1);
        this.playerPoisonLayout.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				selectedPlayer = true;
				poisonBoolean = true;
				delta = playerPoison;
				launchDialog();
			}
        });
        
        this.opponentPoisonLayout = (LinearLayout)this.findViewById(R.id.poisonLayout2);
        this.opponentPoisonLayout.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				selectedPlayer = false;
				poisonBoolean = true;
				delta = opponentPoison;
				launchDialog();
			}
        });
        
        // Initializations
        reset();
        
    } // end onCreate
	
	private void edit(LinearLayout layout, String str) {
		if (temp != null && layout.getChildCount() > 0) ((TextView)layout.getChildAt(layout.getChildCount()-1)).setPaintFlags(temp.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);  // Strike out previous text
		temp = new TextView(this);
		temp.setText(str);
		if (layout.getId() == R.id.lifeLayout1 || layout.getId() == R.id.lifeLayout2) {
			temp.setTextColor(Color.WHITE);
		} else {
			temp.setTextColor(Color.rgb(0, 128, 0));
		} // end if
		temp.setTextSize(textSize);
		temp.setGravity(Gravity.CENTER_HORIZONTAL);
		layout.addView(temp);
	} // alter the player array of values
	
	private void reset() {
		playerLifeLayout.removeAllViews();
		opponentLifeLayout.removeAllViews();
		playerPoisonLayout.removeAllViews();
		opponentPoisonLayout.removeAllViews();
        playerLife = startingLife;
        opponentLife = startingLife;
        playerPoison = 0;
        opponentPoison = 0;
        edit(playerLifeLayout, ((Integer)startingLife).toString());
        edit(opponentLifeLayout, ((Integer)startingLife).toString());
        edit(playerPoisonLayout, "0");
        edit(opponentPoisonLayout, "0");
	} // reset the game
	
	private void launchDialog() {
		Intent intent = new Intent(this, Activity_Life_Dialog.class);
		startActivityForResult(intent, CUSTOM_DIALOG);
	} // end method
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		switch(requestCode) {
			case (CUSTOM_DIALOG) : {
				if (resultCode == Activity.RESULT_OK) {
					isOkay = true;
					delta = Integer.parseInt(data.getStringExtra(Activity_Life_Dialog.RESULT_VALUE));
				} else {
					isOkay = false;
				} // end if
				break;
			} // end case
		} // end switch
		evaluateDialog();
	} // end method
	
	private void evaluateDialog() {
		if (isOkay) {
			if (selectedPlayer) {
				if (poisonBoolean) {
					playerPoison = delta;
					if (playerPoison < minPoison) playerPoison = minPoison;
					if (playerPoison > maxPoison) playerPoison = maxPoison;
					edit(playerPoisonLayout, ((Integer)playerPoison).toString());
				} else {
					playerLife = delta;
					if (playerLife < minLife) playerLife = minLife;
					if (playerLife > maxLife) playerLife = maxLife;
					edit(playerLifeLayout, ((Integer)playerLife).toString());
				} // end if
			} else {
				if (poisonBoolean) {
					opponentPoison = delta;
					if (opponentPoison < minPoison) opponentPoison = minPoison;
					if (opponentPoison > maxPoison) opponentPoison = maxPoison;
					edit(opponentPoisonLayout, ((Integer)opponentPoison).toString());
				} else {
					opponentLife = delta;
					if (opponentLife < minLife) opponentLife = minLife;
					if (opponentLife > maxLife) opponentLife = maxLife;
					edit(opponentLifeLayout, ((Integer)opponentLife).toString());
				} // end if
			} // end if
		} // end if
	} // end method
	
} // end class