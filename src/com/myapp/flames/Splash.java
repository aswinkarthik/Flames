package com.myapp.flames;

import java.util.LinkedList;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Splash extends Activity {

	EditText name1, name2;
	TextView result;
	MediaPlayer buttonSound, introMusic;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		name1 = (EditText) findViewById(R.id.etName1);
		name2 = (EditText) findViewById(R.id.etName2);
		result = (TextView) findViewById(R.id.tvResult);
		buttonSound = MediaPlayer.create(Splash.this, R.raw.button1);
		introMusic = MediaPlayer.create(Splash.this, R.raw.bgm1);
		introMusic.setLooping(true);
		introMusic.setVolume(0.5f, 0.5f);
		introMusic.start();
		
		
		// Action Begins

		Button bGen = (Button) findViewById(R.id.bGenerate);
		bGen.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				buttonSound.start();
				String resultString = null;
				resultString = Splash.getFlameResult(name1.getText(),
						name2.getText());
				result.setText(resultString);
				
			}
		});

	}
	
	



	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		introMusic.pause();
	}
	
	





	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		introMusic.start();
	}





	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		
		
	}





	protected static String getFlameResult(Editable text1, Editable text2) {
		// TODO Auto-generated method stub

		String inp1, inp2, resultString = null;
		inp1 = text1.toString().trim().toUpperCase();
		inp2 = text2.toString().trim().toUpperCase();
		inp1 = inp1.replaceAll(" ", "");
		inp2 = inp2.replaceAll(" ", "");
		if (inp1.equals("") || inp2.equals(""))
			return "Enter the Names Idiot!";
		char name1[], name2[];
		name1 = new char[inp1.length()];
		name2 = new char[inp2.length()];
		name1 = inp1.toCharArray();
		name2 = inp2.toCharArray();

		for (int i = 0; i < name1.length; i++) {
			for (int j = 0; j < name2.length; j++) {
				if (name1[i] == name2[j]) {
					name1[i] = name2[j] = ' ';
				}
			}

		}

		/*
		 * "Checking If it worked Correctly" Code for (char i:name1)
		 * System.out.print(i); System.out.println("\nNext Name :"); for (char
		 * i:name2) System.out.print(i);
		 */

		String out1 = new String(name1);
		out1 = out1.replaceAll(" ", "");
		String out2 = new String(name2);
		out2 = out2.replaceAll(" ", "");
		int flameCount = out1.length() + out2.length();
		// String result = "FLAMES";
		// System.out.println("\n" + out1 + "\n" + out2 + "\n" + flameCount);
		int i = 0, n = 6;
		LinkedList<String> list = new LinkedList<String>();
		/*
		 * for(char[] resChar = {'F','L','A','M','E','S'};i < 6; i++ ) {
		 * list.addLast(resChar[i]); }
		 */

		list.add("F");
		list.addLast("L");
		list.addLast("A");
		list.addLast("M");
		list.addLast("E");
		list.addLast("S");
		int count = 0;
		// flameCount = 5;
		try {
			while (n != 1) {
				count = i + flameCount;
				if (count <= n || (count) % n == 0) {
					if ((count) % n == 0) {
						i = n - 1;
						list.remove(i);
					} else {
						list.remove(i = (count - 1));

					}
					if (i == n - 1)
						i = 0;
				} else {
					list.remove(i = ((count) % n - 1));
				}
				n--;

			}
		} catch (Exception e) {
			System.out.println(" THE EXCEPTION ");
		}

		switch (list.get(0).charAt(0)) {

		case 'F':
			resultString = "Friend";
			break;
		case 'L':
			resultString = "Love";
			break;
		case 'A':
			resultString = "Affection";
			break;
		case 'M':
			resultString = "Marriage";
			break;
		case 'E':
			resultString = "Enemy";
			break;
		case 'S':
			resultString = "Sister";
			break;
		}

		return resultString;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub

		super.onCreateOptionsMenu(menu);
		MenuInflater aboutMenu = getMenuInflater();
		aboutMenu.inflate(R.menu.mainmenu, menu);
		return true;

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
	buttonSound.start();
		startActivity(new Intent("com.myapp.flames.ABOUT"));
		return true;

	}
	
	
	
}