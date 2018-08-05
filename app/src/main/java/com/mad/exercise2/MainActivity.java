package com.mad.exercise2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;

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

                EditText name = findViewById(R.id.name_tf);
                EditText email = findViewById(R.id.email_tf);
                EditText phone = findViewById(R.id.phone_number);
                Spinner type = findViewById(R.id.phoneSpinner);


                Intent intent = new Intent(MainActivity.this, ActivityTwo.class);
                intent.putExtra(ActivityTwo.NAME_EXTRA, name.getText().toString());
                intent.putExtra(ActivityTwo.EMAIL_EXTRA, email.getText().toString());
                intent.putExtra(ActivityTwo.TYPE_EXTRA, type.getSelectedItem().toString());
                intent.putExtra(ActivityTwo.PHONE_EXTRA, phone.getText().toString());

                startActivityForResult(intent, REQUEST_CODE);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        View view = getCurrentFocus();

        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Snackbar.make(view, R.string.i_agree, Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            } else {
                Snackbar.make(view, R.string.i_disagree, Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        }
    }

}
