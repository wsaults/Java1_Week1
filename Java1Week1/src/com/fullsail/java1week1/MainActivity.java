package com.fullsail.java1week1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	LinearLayout linearLayout;
	LinearLayout.LayoutParams layoutParams;
	EditText editText;
	TextView outputTextView;	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Setup the linear layout
		linearLayout = new LinearLayout(this);
		linearLayout.setOrientation(LinearLayout.VERTICAL);
		layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
		linearLayout.setLayoutParams(layoutParams);
		
		// Add the text view
		TextView textView = new TextView(this);
		textView.setText("Find the difference between the sum of the squares of the first 100 natural numbers and the square of the sum.");
		linearLayout.addView(textView);
		
		// Add the edit text view
		editText = new EditText(this);
		editText.setHint(R.string.HintText);
		linearLayout.addView(editText);
		
		// Add the button
		Button button = new Button(this);
		button.setText(R.string.ButtonText);
		linearLayout.addView(button);
		
		// Add the output text view
		outputTextView = new TextView(this);
		outputTextView.setText("The difference...");
		linearLayout.addView(outputTextView);
		
		// Button event handler
		button.setOnClickListener(new View.OnClickListener() { 
			
			@Override
			public void onClick(View v) {
				String input = (editText.getText().toString().equals("")) ? editText.getHint().toString() : editText.getText().toString();
				outputTextView.setText(sumOfSquares(input));
			}
		});
		
		
		
		// Add the a text view
		TextView conditionalTextView = new TextView(this);
		long timestamp = System.currentTimeMillis() / 1000L;
		if (timestamp % 2 == 0) {
			conditionalTextView.setText("The time is divisible by 2 \n the time is" + timestamp);
		} else if (timestamp % 5 == 0) {
			conditionalTextView.setText("The time is divisible by 5 \n the time is" + timestamp);
		} else {
			conditionalTextView.setText("The time is not divisible by 2 or 5 \n the time is" + timestamp);
		}
		
		// Add the nested layout
		LinearLayout nestedLayout = new LinearLayout(this);
		nestedLayout.setOrientation(LinearLayout.HORIZONTAL);
		nestedLayout.setLayoutParams(layoutParams);
		nestedLayout.addView(conditionalTextView);
		
		linearLayout.addView(nestedLayout);
		setContentView(linearLayout);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public String sumOfSquares(String input) {
		// This is my solution to project Euler problem 6.
		// http://projecteuler.net/
		/*
		* The sum of the squares of the first ten natural numbers is,
		*
		* 1^2 + 2^2 + ... + 10^2 = 385
		* The square of the sum of the first ten natural numbers is,
		*
		* (1 + 2 + ... + 10)^2 = 55^2 = 3025
		* Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 385 = 2640.
		*
		* Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
		*/
		
		int textNum = Integer.parseInt(input);
		int limit = (textNum <= 100) ? textNum : 100, sum1 = 0, sum2 = 0;
		for (int i = 1; i <= limit; i++) {
			sum1 += (int)Math.pow(i, 2);
			sum2 += i;
		}
		sum2 = (int)Math.pow(sum2, 2);
		
		return "The difference between the sum of the squares of the first " + limit + " natural numbers and the square of the sum is " + (sum2 - sum1);
	}

}
