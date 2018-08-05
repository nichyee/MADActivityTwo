package com.mad.exercise2;

import android.app.Activity;
import android.content.Intent;
import android.support.constraint.Constraints;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityTwo extends AppCompatActivity {

    public static final String NAME_EXTRA = "@string/your_name";
    public static final String PHONE_EXTRA = "@string/your_phone";
    public static final String EMAIL_EXTRA = "@string/your_email";
    public static final String TYPE_EXTRA = "@string/your_type";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        Intent intent = getIntent();

        //Sets all textViews to the information passed in from previous activity
        TextView name = findViewById(R.id.second_activity_name);
        name.setText(intent.getStringExtra(NAME_EXTRA));
        TextView phone = findViewById(R.id.second_activity_phone);
        phone.setText(intent.getStringExtra(PHONE_EXTRA));
        TextView email = findViewById(R.id.second_activity_email);
        email.setText(intent.getStringExtra(EMAIL_EXTRA));
        TextView type = findViewById(R.id.second_activity_type);
        type.setText(intent.getStringExtra(TYPE_EXTRA));

        Button submitBtn = findViewById(R.id.second_activity_submit);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox agreeCB = findViewById(R.id.second_activity_agree);
                boolean isAgree = agreeCB.isChecked();
                Intent result = new Intent();

                //Checks whether the box was checked and gives appropriate response
                if (isAgree) {
                    setResult(Activity.RESULT_OK, result);
                } else {
                    setResult(Activity.RESULT_CANCELED, result);
                }
                finish();
            }
        });
    }
}
