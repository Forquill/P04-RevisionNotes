package com.myapplicationdev.android.p04_revisionnotes;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

	ArrayAdapter aa;
	ListView lv;
	ArrayList<Note> note;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//TODO implement the Custom ListView

		setContentView(R.layout.activity_second);

		lv = (ListView) findViewById(R.id.lv);

		DBHelper db = new DBHelper(SecondActivity.this);

		ArrayList<Note> data = db.getAllNotes();
		db.close();

		note = new ArrayList<Note>();

		for (int i = 0; i < data.size(); i++){
			note.add(data.get(i));
		}

		ArrayAdapter aa = new RevisionNotesArrayAdapter(SecondActivity.this,R.layout.row,note);
		lv.setAdapter(aa);

	}


}
