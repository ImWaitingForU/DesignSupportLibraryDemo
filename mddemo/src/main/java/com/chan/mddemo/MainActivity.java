package com.chan.mddemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

	private FloatingActionButton fab;

	private void initFab() {
		fab = (FloatingActionButton) findViewById(R.id.fab1);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Snackbar.make(findViewById(R.id.cLayout),
						"Hi i am a snackbar!", Snackbar.LENGTH_SHORT)
						.setAction("got it", null).show();
			}
		});
	}

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView (R.layout.activity_main);
		initFab();
	}
}
