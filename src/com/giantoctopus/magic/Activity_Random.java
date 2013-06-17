package com.giantoctopus.magic;

import java.util.Random;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_Random extends Activity {
	
	private Button coin, die, d3, d4, d6, d8, d10, d12, d20, d30, d100;
	private ImageView coin_imageButton, die_imageButton, d3_imageButton, d4_imageButton, d6_imageButton, d8_imageButton, d10_imageButton, d12_imageButton, d20_imageButton, d30_imageButton, d100_imageButton;
	private Random random;
	private Dialog dialog;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_random);
        
        random = new Random();
        
        this.coin = (Button)this.findViewById(R.id.coin);
        this.coin.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				launchDialog("coin", rng(2));
			}
        });
        
        this.die = (Button)this.findViewById(R.id.die);
        this.die.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				launchDialog("die", rng(6));
			}
        });
        
        this.d3 = (Button)this.findViewById(R.id.d3);
        this.d3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				launchDialog("3", rng(3));
			}
        });
        
        this.d4 = (Button)this.findViewById(R.id.d4);
        this.d4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				launchDialog("4", rng(4));
			}
        });
        
        this.d6 = (Button)this.findViewById(R.id.d6);
        this.d6.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				launchDialog("6", rng(6));
			}
        });
        
        this.d8 = (Button)this.findViewById(R.id.d8);
        this.d8.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				launchDialog("8", rng(8));
			}
        });
        
        this.d10 = (Button)this.findViewById(R.id.d10);
        this.d10.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				launchDialog("10", rng(10));
			}
        });
        
        this.d12 = (Button)this.findViewById(R.id.d12);
        this.d12.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				launchDialog("12", rng(12));
			}
        });
        
        this.d20 = (Button)this.findViewById(R.id.d20);
        this.d20.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				launchDialog("20", rng(20));
			}
        });
        
        this.d30 = (Button)this.findViewById(R.id.d30);
        this.d30.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				launchDialog("30", rng(30));
			}
        });
        
        this.d100 = (Button)this.findViewById(R.id.dPercent);
        this.d100.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				launchDialog("100", rng(100));
			}
        });
        
        this.coin_imageButton = (ImageView)this.findViewById(R.id.coin_imageButton);
        this.coin_imageButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				launchDialog("coin", rng(2));
			}
        });
        
        this.die_imageButton = (ImageView)this.findViewById(R.id.die_imageButton);
        this.die_imageButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				launchDialog("die", rng(6));
			}
        });
        
        this.d3_imageButton = (ImageView)this.findViewById(R.id.d3_imageButton);
        this.d3_imageButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				launchDialog("3", rng(3));
			}
        });
        
        this.d4_imageButton = (ImageView)this.findViewById(R.id.d4_imageButton);
        this.d4_imageButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				launchDialog("4", rng(4));
			}
        });
        
        this.d6_imageButton = (ImageView)this.findViewById(R.id.d6_imageButton);
        this.d6_imageButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				launchDialog("6", rng(6));
			}
        });
        
        this.d8_imageButton = (ImageView)this.findViewById(R.id.d8_imageButton);
        this.d8_imageButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				launchDialog("8", rng(8));
			}
        });
        
        this.d10_imageButton = (ImageView)this.findViewById(R.id.d10_imageButton);
        this.d10_imageButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				launchDialog("10", rng(10));
			}
        });
        
        this.d12_imageButton = (ImageView)this.findViewById(R.id.d12_imageButton);
        this.d12_imageButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				launchDialog("12", rng(12));
			}
        });
        
        this.d20_imageButton = (ImageView)this.findViewById(R.id.d20_imageButton);
        this.d20_imageButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				launchDialog("20", rng(20));
			}
        });
        
        this.d30_imageButton = (ImageView)this.findViewById(R.id.d30_imageButton);
        this.d30_imageButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				launchDialog("30", rng(30));
			}
        });
        
        this.d100_imageButton = (ImageView)this.findViewById(R.id.dPercent_imageButton);
        this.d100_imageButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				launchDialog("%", rng(100));
			}
        });

    } // end method
    
    private void launchDialog(String title, String value) {
    	dialog = new Dialog(this, R.style.Dialog_Random);
    	dialog.setContentView(R.layout.layout_random_dialog);
    	dialog.setCancelable(true);
    	if (title.equals("coin")) {
    		dialog.setTitle(R.string.coinToss);
        	ImageView image = (ImageView) dialog.findViewById(R.id.image);
        	if (value.equals("1")) {
        		image.setImageResource(R.drawable.random_heads_large);
        	} else {
        		image.setImageResource(R.drawable.random_tails_large);
        	} // end if
        	image.setOnClickListener(new OnClickListener() {
    			public void onClick(View v) {
    				dialog.dismiss();
    			}
        	});
        	image.setPadding(15, 5, 5, 25);
        	image.setVisibility(View.VISIBLE);
    	} else if (title.equals("die")) {
    		dialog.setTitle(R.string.dieRoll);
        	TextView text = (TextView) dialog.findViewById(R.id.text);
        	text.setText(value);
        	text.setTextColor(Color.WHITE);
        	text.setOnClickListener(new OnClickListener() {
    			public void onClick(View v) {
    				dialog.dismiss();
    			}
        	});
        	text.setVisibility(View.VISIBLE);
    	} else {
    		dialog.setTitle("Result of (d" + title + ") Roll");
        	TextView text = (TextView) dialog.findViewById(R.id.text);
        	text.setText(value);
        	text.setTextColor(Color.WHITE);
        	text.setOnClickListener(new OnClickListener() {
    			public void onClick(View v) {
    				dialog.dismiss();
    			}
        	});
        	text.setVisibility(View.VISIBLE);
    	} // end if
    	dialog.show();
    } // end method
    
    private String rng(int input) {
    	return(((Integer)(random.nextInt(input)+1)).toString());
    } // end method
    
} // end class