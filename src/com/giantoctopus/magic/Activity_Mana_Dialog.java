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

public class Activity_Mana_Dialog extends Activity {

	public static final String RESULT_MANA = "RESULT_MANA_KEY";
	private TextView titleTextView, valueTextView;
	private Button okayButton, clearButton, cancelButton, plusFiveButton, plusOneButton, minusFiveButton, minusOneButton;
	private final int maxMana = 99, minMana = 0;
	private int amount;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.layout_mana_dialog);
		
		amount = Activity_Mana.amount;
		
		valueTextView = (TextView)this.findViewById(R.id.valueTextView);
		valueTextView.setTextColor(Color.WHITE);
		valueTextView.setText(((Integer)Activity_Mana.amount).toString());
		
		titleTextView = (TextView)this.findViewById(R.id.titleTextView);
		titleTextView.setTextColor(Color.WHITE);
		
		setDialogTitle(Activity_Mana.choice);
		
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
		
	} // end method
	
	private void setDialogTitle(int choice) {
		switch(choice) {
			case(1):
				titleTextView.setText(R.string.mana_white);
				titleTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.mana_white, 0, 0, 0);
				break;
			case(2):
				titleTextView.setText(R.string.mana_black);
				titleTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.mana_black, 0, 0, 0);
				break;
			case(3):
				titleTextView.setText(R.string.mana_blue);
				titleTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.mana_blue, 0, 0, 0);
				break;
			case(4):
				titleTextView.setText(R.string.mana_red);
				titleTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.mana_red, 0, 0, 0);
				break;
			case(5):
				titleTextView.setText(R.string.mana_green);
				titleTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.mana_green, 0, 0, 0);
				break;
			case(6):
				titleTextView.setText(R.string.mana_colorless);
				titleTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.mana_colorless, 0, 0, 0);
				break;
			case(7):
				titleTextView.setText(R.string.mana_any);
				titleTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.mana_any, 0, 0, 0);
				break;
			default:
				titleTextView.setText(R.string.blank);
				titleTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
				break;
		} // end switch
	} // end method
	
	private void update(int input) {
		amount += input;
		if (amount > maxMana) amount = maxMana;
    	if (amount < minMana) amount = minMana;
		valueTextView.setText(((Integer)amount).toString());
	} // end method
	
	private void clear() {
		amount = 0;
		valueTextView.setText(((Integer)amount).toString());
	} // end method
	
	private void okay(){
		Intent resultIntent = new Intent(this, Activity_Mana_Dialog.class);
		resultIntent.putExtra(RESULT_MANA, ((Integer)amount).toString());
		setResult(Activity.RESULT_OK, resultIntent);
		finish();
	} // end method
	
	private void cancel(){
		Intent resultIntent = new Intent(this, Activity_Mana_Dialog.class);
		setResult(Activity.RESULT_CANCELED, resultIntent);
		finish();
	} // end method
	
}
