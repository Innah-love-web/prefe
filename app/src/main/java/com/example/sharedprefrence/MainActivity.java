package com.example.sharedprefrence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edittext1;
    private EditText edittext2;
    private Button button1;
    private Button button2;
    private TextView textview1;
    private TextView textview2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edittext1 = (EditText) findViewById(R.id.edittext1);
        edittext2 = (EditText) findViewById(R.id.edittext2);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        textview1 = (TextView) findViewById(R.id.textview1);
        textview2 = (TextView) findViewById(R.id.textview2);

        SharedPreferences prefs = getSharedPreferences("myprefs", Context.MODE_PRIVATE);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editpref = prefs.edit();

                String user = edittext1.getText().toString();
                String pass = edittext2.getText().toString();

                editpref.putString("user_name",user);
                editpref.putString("pass_word",pass);

                editpref.apply();

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usr = prefs.getString("user_name","null");
                String pswrd = prefs.getString("pass_word","null");

                textview1.setText(usr);
                textview2.setText(pswrd);

            }
        });



    }
}