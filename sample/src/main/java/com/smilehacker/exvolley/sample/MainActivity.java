package com.smilehacker.exvolley.sample;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;

import com.smilehacker.exvolley.Request;
import com.smilehacker.exvolley.Response;
import com.smilehacker.exvolley.VolleyError;
import com.smilehacker.exvolley.ex.ExVolley;

public class MainActivity extends ActionBarActivity {

    private final static String TAG = MainActivity.class.getName();

    private Button mBtnConn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnConn = (Button) findViewById(R.id.connect);

        mBtnConn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "test api");
                ExVolley.with(MainActivity.this).load("https://api.douban.com/v2/commodity/shows").method(Request.Method.GET).setParam("tag_id", "39")
                        .setResponseListener(new Response.Listener<String>() {

                            /**
                             * Called when a response is received.
                             *
                             * @param response
                             */
                            @Override
                            public void onResponse(String response) {
                                Log.i(TAG, response);
                            }
                        }, String.class)
                        .setErrorListener(new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.d(TAG, error.toString());
                            }
                        }).excute();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
