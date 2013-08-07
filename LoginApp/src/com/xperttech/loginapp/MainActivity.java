package com.xperttech.loginapp;

import com.xperttech.loginapp.MainActivity;

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

public class MainActivity extends Activity implements OnClickListener {


	static final String PREFS_NAME = "MyPrefsFile";
	//Intent i;
	Button newuser, login;
	EditText uname, pswd;
	String check, st, usernme, passwd;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		uname = (EditText) findViewById(R.id.editText1);
		pswd = (EditText) findViewById(R.id.editText2);

		newuser = (Button) findViewById(R.id.button1);
		login = (Button) findViewById(R.id.button2);

		newuser.setOnClickListener(this); 
		login.setOnClickListener(this);


		SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
		SharedPreferences.Editor editor = settings.edit();
		check = settings.getString("USERNAME", "");

		if(check.length()!=0){
			settings = getSharedPreferences(PREFS_NAME, 0);


			editor.commit();

			Intent intent = new Intent(this,RegiesterMainActivity.class);
			startActivityForResult(intent, 100);
		}
	}

	public void onClick(View v){

		//SharedPreferences settings = getSharedPreferences("Register", MODE_WORLD_WRITEABLE );

		usernme = uname.getText().toString();
		passwd = pswd.getText().toString();

		if(v==login)
		{

			if((uname.getText().toString().compareTo(usernme)==0)&&(pswd.getText().toString().compareTo(passwd)==0))
			{
				Toast.makeText(this, "Taking to the welcome page", Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(this, WelcomeActivity.class);
				startActivityForResult(intent, 100);
			}
			else
			{
				Toast.makeText(this, "You have to register first", Toast.LENGTH_SHORT).show();


			}
		}

		else if(v==newuser)
		{
			Intent intent = new Intent(this, RegiesterMainActivity.class);
			startActivityForResult(intent, 100);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
