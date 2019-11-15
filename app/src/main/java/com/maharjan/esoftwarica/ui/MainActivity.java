package com.maharjan.esoftwarica.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.maharjan.esoftwarica.R;

public class MainActivity extends AppCompatActivity {
    Button btn_login;
    EditText log_name, log_password;
    ImageView log_name_img, log_pass_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_login = findViewById(R.id.btnlogin);
        log_name = findViewById(R.id.Logname);
        log_password = findViewById(R.id.password);
        log_name_img = findViewById(R.id.true1img);

        log_pass_img = findViewById(R.id.true2img);
        log_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count > 0) {
                    log_name_img.setImageResource(R.drawable.ic_check_box);
                } else if(start==0) {
                    log_name_img.setImageResource(R.drawable.ic_wrong_access);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        log_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count > 0) {
                    log_pass_img.setImageResource(R.drawable.ic_check_box);
                } else if(start==0) {
                    log_pass_img.setImageResource(R.drawable.ic_wrong_access);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(log_name.getText().toString().equals("raja") && log_password.getText().toString().equals("1234")){
                        Intent itent = new Intent(MainActivity.this, Display.class);
                        startActivity(itent);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Wrong Data", Toast.LENGTH_SHORT).show();
                    }
                }
        });
    }
}
