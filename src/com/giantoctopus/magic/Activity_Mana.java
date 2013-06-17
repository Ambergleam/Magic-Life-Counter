package com.giantoctopus.magic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Activity_Mana extends Activity {
	
	private ImageButton plusButton1, plusButton2, plusButton3, plusButton4, plusButton5, plusButton6, plusButton7, minusButton1, minusButton2, minusButton3, minusButton4, minusButton5, minusButton6, minusButton7;
	private TextView textView1, textView2, textView3, textView4, textView5, textView6, textView7;
	private LinearLayout rowLayout1, rowLayout2, rowLayout3, rowLayout4, rowLayout5, rowLayout6, rowLayout7;
	private final int CUSTOM_DIALOG = 0, maxMana = 99, minMana = 0;
	public static int choice, amount;
	
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.menu_mana, menu);
	    return true;
	} // creates menu
	
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
		    case R.id.menu_clear:
		    	clear();
		        return true;
		    default:
		    	return super.onOptionsItemSelected(item);
	    } // end switch
	} // assigns meaning to menu items
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mana);
        
        textView1 = (TextView)this.findViewById(R.id.textView1);
        textView2 = (TextView)this.findViewById(R.id.textView2);
        textView3 = (TextView)this.findViewById(R.id.textView3);
        textView4 = (TextView)this.findViewById(R.id.textView4);
        textView5 = (TextView)this.findViewById(R.id.textView5);
        textView6 = (TextView)this.findViewById(R.id.textView6);
        textView7 = (TextView)this.findViewById(R.id.textView7);
        
        plusButton1 = (ImageButton)this.findViewById(R.id.plusButton1);
        plusButton1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				edit(textView1, 1);
			}
        });
        
        plusButton2 = (ImageButton)this.findViewById(R.id.plusButton2);
        plusButton2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				edit(textView2, 1);
			}
        });
        
        plusButton3 = (ImageButton)this.findViewById(R.id.plusButton3);
        plusButton3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				edit(textView3, 1);
			}
        });
        
        plusButton4 = (ImageButton)this.findViewById(R.id.plusButton4);
        plusButton4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				edit(textView4, 1);
			}
        });
        
        plusButton5 = (ImageButton)this.findViewById(R.id.plusButton5);
        plusButton5.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				edit(textView5, 1);
			}
        });
        
        plusButton6 = (ImageButton)this.findViewById(R.id.plusButton6);
        plusButton6.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				edit(textView6, 1);
			}
        });
        
        plusButton7 = (ImageButton)this.findViewById(R.id.plusButton7);
        plusButton7.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				edit(textView7, 1);
			}
        });

        minusButton1 = (ImageButton)this.findViewById(R.id.minusButton1);
        minusButton1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				edit(textView1, -1);
			}
        });
        
        minusButton2 = (ImageButton)this.findViewById(R.id.minusButton2);
        minusButton2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				edit(textView2, -1);
			}
        });
        
        minusButton3 = (ImageButton)this.findViewById(R.id.minusButton3);
        minusButton3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				edit(textView3, -1);
			}
        });
        
        minusButton4 = (ImageButton)this.findViewById(R.id.minusButton4);
        minusButton4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				edit(textView4, -1);
			}
        });
        
        minusButton5 = (ImageButton)this.findViewById(R.id.minusButton5);
        minusButton5.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				edit(textView5, -1);
			}
        });
        
        minusButton6 = (ImageButton)this.findViewById(R.id.minusButton6);
        minusButton6.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				edit(textView6, -1);
			}
        });
        
        minusButton7 = (ImageButton)this.findViewById(R.id.minusButton7);
        minusButton7.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				edit(textView7, -1);
			}
        });
        
        rowLayout1 = (LinearLayout)this.findViewById(R.id.rowLayout1);
        rowLayout1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				choice = 1;
				amount = Integer.parseInt(textView1.getText().toString());
				launchDialog();
			}
        });
        
        rowLayout2 = (LinearLayout)this.findViewById(R.id.rowLayout2);
        rowLayout2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				choice = 2;
				amount = Integer.parseInt(textView2.getText().toString());
				launchDialog();
			}
        });
        
        rowLayout3 = (LinearLayout)this.findViewById(R.id.rowLayout3);
        rowLayout3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				choice = 3;
				amount = Integer.parseInt(textView3.getText().toString());
				launchDialog();
			}
        });
        
        rowLayout4 = (LinearLayout)this.findViewById(R.id.rowLayout4);
        rowLayout4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				choice = 4;
				amount = Integer.parseInt(textView4.getText().toString());
				launchDialog();
			}
        });
        
        rowLayout5 = (LinearLayout)this.findViewById(R.id.rowLayout5);
        rowLayout5.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				choice = 5;
				amount = Integer.parseInt(textView5.getText().toString());
				launchDialog();
			}
        });
        
        rowLayout6 = (LinearLayout)this.findViewById(R.id.rowLayout6);
        rowLayout6.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				choice = 6;
				amount = Integer.parseInt(textView6.getText().toString());
				launchDialog();
			}
        });
        
        rowLayout7 = (LinearLayout)this.findViewById(R.id.rowLayout7);
        rowLayout7.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				choice = 7;
				amount = Integer.parseInt(textView7.getText().toString());
				launchDialog();
			}
        });
        
    } // end method
    
    private void edit(TextView field, int delta) {
    	delta += Integer.parseInt(field.getText().toString());
    	if (delta > maxMana) delta = maxMana;
    	if (delta < minMana) delta = minMana;
    	field.setText(((Integer)delta).toString());
    } // end method
    
    private void clear() {
    	textView1.setText(R.string.zero);
    	textView2.setText(R.string.zero);
    	textView3.setText(R.string.zero);
    	textView4.setText(R.string.zero);
    	textView5.setText(R.string.zero);
    	textView6.setText(R.string.zero);
    	textView7.setText(R.string.zero);
    } // end method
    
    private void launchDialog() {
		Intent intent = new Intent(this, Activity_Mana_Dialog.class);
		startActivityForResult(intent, CUSTOM_DIALOG);
	} // end method
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		switch(requestCode) {
			case (CUSTOM_DIALOG) : {
				if (resultCode == Activity.RESULT_OK) {
					int new_value = Integer.parseInt(data.getStringExtra(Activity_Mana_Dialog.RESULT_MANA));
					switch(choice) {
						case(1):
							textView1.setText(((Integer)new_value).toString());
							break;
						case(2):
							textView2.setText(((Integer)new_value).toString());
							break;
						case(3):
							textView3.setText(((Integer)new_value).toString());
							break;
						case(4):
							textView4.setText(((Integer)new_value).toString());
							break;
						case(5):
							textView5.setText(((Integer)new_value).toString());
							break;
						case(6):
							textView6.setText(((Integer)new_value).toString());
							break;
						case(7):
							textView7.setText(((Integer)new_value).toString());
							break;
						default:
							break;
					} // end switch
				} // end if
				break;
			} // end case
		} // end switch
	} // end method
    
} // end class