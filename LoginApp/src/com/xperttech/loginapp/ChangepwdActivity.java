package com.xperttech.loginapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangepwdActivity extends Activity implements OnClickListener {

	private static final String PREFS_NAME = null;
	EditText oldpwd, newpwd;
	String passwd;
	Button changeit, back;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_changepwd);

		oldpwd = (EditText) findViewById(R.id.editText1);
		newpwd = (EditText) findViewById(R.id.editText2);

		SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
		Editor editor = settings.edit();
		passwd = settings.getString("PASSWORD", "");
		oldpwd.setText(passwd);
		changeit = (Button) findViewById(R.id.button1);
		back = (Button) findViewById(R.id.button2);

		changeit.setOnClickListener(this);
		back.setOnClickListener(this);



	}
	public void onClick(View v)
	{
		String passnd = newpwd.getText().toString();

		SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
		Editor editor = settings.edit();

		if(v==changeit)
		{
			editor.putString("PASSWORD", passnd);
			editor.commit();

			Toast.makeText(this, "Congrats !! Changed Password", Toast.LENGTH_SHORT).show();
			Intent intent = new Intent(this, WelcomeActivity.class);
			startActivityForResult(intent, 100);

		}
		else if(v==back)
		{
			Toast.makeText(this, "You are going back on Welcome Page", Toast.LENGTH_SHORT).show();
			Intent intent = new Intent(this, WelcomeActivity.class);
			startActivityForResult(intent, 100);

		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.changepwd, menu);
		return true;
	}

}
