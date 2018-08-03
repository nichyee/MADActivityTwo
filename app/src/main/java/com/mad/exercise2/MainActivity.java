package com.mad.exercise2;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button submitBtn = findViewById(R.id.main_activity_submit_btn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Submit button clicked!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button clearBtn = findViewById(R.id.main_activity_clear_all_btn);
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = findViewById(R.id.name_tf);
                name.setText("");
                EditText email = findViewById(R.id.email_tf);
                email.setText("");
                EditText number = findViewById(R.id.phone_number);
                number.setText("");
                Spinner phoneType = findViewById(R.id.phoneSpinner);
                phoneType.setSelection(0);
            }
        });

        Button exitBtn = findViewById(R.id.main_activity_exit_btn);
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                moveTaskToBack(true);
            }
        });
    }

}
