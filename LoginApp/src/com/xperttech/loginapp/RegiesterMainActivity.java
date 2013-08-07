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

public class RegiesterMainActivity extends Activity implements OnClickListener {

	private static final String PREFS_NAME = null;
	Button register;
	EditText forname, forusername, forpassword, forconfirmpwd, foremail;
	String nme, uname, pwd, cpwd, email;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.regiester_main);

		register = (Button) findViewById(R.id.button1);
		forname = (EditText) findViewById(R.id.editText1);
		forusername = (EditText) findViewById(R.id.editText2);
		forpassword = (EditText) findViewById(R.id.editText3);
		forconfirmpwd = (EditText) findViewById(R.id.editText4);
		foremail = (EditText) findViewById(R.id.editText5);

		register.setOnClickListener(this);
	}

	public void onClick(View v)
	{
		
		//SharedPreferences settings = getSharedPreferences(MainActivity.PREFS_NAME, 0);
		nme = forname.getText().toString();
		uname = forusername.getText().toString();
		pwd = forpassword.getText().toString();
		cpwd = forconfirmpwd.getText().toString();
		email = foremail.getText().toString();
		
		if(v==register)
		{
			SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
			Editor editor = settings.edit();
			editor.putString("NAME", nme);
			editor.putString("PASSWORD", uname);
			editor.putString("USERNAME", pwd);
			editor.putString("CPWD", cpwd);
			editor.putString("EMAIL", email);
			
			editor.commit();

			Toast.makeText(this, "Registeration successful", Toast.LENGTH_SHORT).show();
			Intent intent = new Intent(this, WelcomeActivity.class);
			startActivityForResult(intent, 100);
		}
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.regiester_main, menu);
		return true;
	}

}
