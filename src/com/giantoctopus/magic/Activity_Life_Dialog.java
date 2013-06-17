package com.giantoctopus.magic;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class Activity_Life_Dialog extends Activity {

	public static final String RESULT_VALUE = "RESULT_VALUE_KEY";
	private TextView value, dialogTitle;
	private Button okayButton, clearButton, cancelButton, plusFiveButton, plusOneButton, minusFiveButton, minusOneButton;
	private int number, maxPoison, maxLife = 999, minLife = -99, minPoison = 0;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.layout_life_dialog);
		
		number = Activity_Life.delta;
		maxPoison = Activity_Life.maxPoison;
		
		value = (TextView)this.findViewById(R.id.valueTextView);
		value.setTextColor(Color.WHITE);
		value.setText(((Integer)number).toString());
		
		dialogTitle = (TextView)this.findViewById(R.id.titleTextView);
		dialogTitle.setTextColor(Color.WHITE);
		
		okayButton = (Button)findViewById(R.id.dialogOkayButton);
		okayButton.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				okay();
			}
		});
		
		clearButton = (Button)findViewById(R.id.dialogClearButton);
		clearButton.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				clear();
			}
		});
		
		cancelButton = (Button)findViewById(R.id.dialogCancelButton);
		cancelButton.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				cancel();
			}
		});
		
		plusFiveButton = (Button)findViewById(R.id.plus5Button);
		plusFiveButton.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				update(5);
			}
		});
		
		plusOneButton = (Button)findViewById(R.id.plus1Button);
		plusOneButton.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				update(1);
			}
		});
		
		minusFiveButton = (Button)findViewById(R.id.minus5Button);
		minusFiveButton.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				update(-5);
			}
		});
		
		minusOneButton = (Button)findViewById(R.id.minus1Button);
		minusOneButton.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				update(-1);
			}
		});
		
		setup();
	} // end method
	
	private void setup() {
		if (Activity_Life.poisonBoolean && Activity_Life.selectedPlayer) {
			dialogTitle.setText(R.string.player_poison);
			dialogTitle.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_poison, 0, 0, 0);
		} else if (!Activity_Life.poisonBoolean && Activity_Life.selectedPlayer) {
			dialogTitle.setText(R.string.player_life);
			dialogTitle.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_life, 0, 0, 0);
		} else if (Activity_Life.poisonBoolean && !Activity_Life.selectedPlayer) {
			dialogTitle.setText(R.string.opponent_poison);
			dialogTitle.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_poison, 0, 0, 0);
		} else {
			dialogTitle.setText(R.string.opponent_life);
			dialogTitle.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_life, 0, 0, 0);
		} // end if
	} // end method
	
	private void clear() {
		number = 0;
		value.setText(((Integer)number).toString());
	} // end method
	
	private void update(int input) {
		number += input;
		if (Activity_Life.poisonBoolean) {
			if (number > maxPoison) number = maxPoison;
			if (number < minPoison) number = minPoison;
		} else {
			if (number > maxLife) number = maxLife;
			if (number < minLife) number = minLife;
		}
		value.setText(((Integer)number).toString());
	} // end method
	
	private void okay(){
		Intent resultIntent = new Intent(this, Activity_Life_Dialog.class);
		resultIntent.putExtra(RESULT_VALUE, ((Integer)number).toString());
		setResult(Activity.RESULT_OK, resultIntent);
		finish();
	} // end method
	
	private void cancel(){
		Intent resultIntent = new Intent(this, Activity_Life_Dialog.class);
		setResult(Activity.RESULT_CANCELED, resultIntent);
		finish();
	} // end method
	
} // end class