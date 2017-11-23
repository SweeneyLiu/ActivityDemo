package com.lsw.demo;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener , View.OnLongClickListener{

    private Button mButton;
    private static final String TAG = "FirstActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        if (savedInstanceState != null) {
            Log.i(TAG, "onCreate:" + savedInstanceState.getString("saveData"));
        }

        mButton = (Button)findViewById(R.id.button1);
        mButton.setOnClickListener(this);
        mButton.setOnLongClickListener(this);
        /*mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });*/

        Log.i(TAG, "onCreate: "+getTaskId());
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.i(TAG, "onConfigurationChanged: ");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (!(savedInstanceState == null)) {
            Log.i(TAG, "onRestoreInstanceState: ");
            Log.i(TAG, "onRestoreInstanceState: " + savedInstanceState.getString("saveData"));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("saveData","test");
        Log.i(TAG, "onSaveInstanceState: ");
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "onClick: ");
    }

    @Override
    public boolean onLongClick(View v) {
        Log.i(TAG, "onLongClick: ");
        return true;
    }
}
