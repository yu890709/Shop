package com.yu.shop;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText email;
    private EditText password;
    private ImageView username_image;
    private ImageView password_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        findView();
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void signup(View view){
        int username_length=username.getText().toString().length();
        int password_length=password.getText().toString().length();
        username_image.setVisibility(View.GONE);
        password_image.setVisibility(View.GONE);
        String message="註冊成功";
        if(username_length<4&&password_length<6) {
            message = "UserName需大於4個字\nPassword需大於6個字";
            username_image.setVisibility(View.VISIBLE);
            password_image.setVisibility(View.VISIBLE);
        }else if(username_length<4&&password_length>6){
            message = "UserName需大於4個字";
            username_image.setVisibility(View.VISIBLE);
        }else if(username_length>4&&password_length<6){
            message="Password需大於6個字";
            password_image.setVisibility(View.VISIBLE);
        }
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("訊息")
                .setMessage(message)
                .setPositiveButton("確定",null)
                .show();
    }

    private void findView() {
        username = findViewById(R.id.user_name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        username_image = findViewById(R.id.username_image);
        password_image = findViewById(R.id.password_image);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
