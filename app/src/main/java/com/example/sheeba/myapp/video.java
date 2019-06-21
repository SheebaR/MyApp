package com.example.sheeba.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class video extends AppCompatActivity {
    EditText a,b,c;
    TextView d;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        a=(EditText)findViewById(R.id.insert1);
        b=(EditText)findViewById(R.id.insert2);
        c=(EditText)findViewById(R.id.insert3);
        submit=(Button)findViewById(R.id.btn1);
        d=(TextView) findViewById(R.id.insert4);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!a.getText().toString().equalsIgnoreCase("") && !b.getText().toString().equalsIgnoreCase("") &&!c.getText().toString().equalsIgnoreCase(""))
                {

                    DatabaseReference m= FirebaseDatabase.getInstance().getReference("Data");
                    DatabaseReference p=m.child(FirebaseAuth.getInstance().getCurrentUser().getUid());
                    p.child("N").setValue(a.getText().toString().trim());
                    p.child("P").setValue(b.getText().toString().trim());
                    p.child("K").setValue(c.getText().toString().trim());
                    a.setText("");
                    b.setText("");
                    c.setText("");
                }
                else
                {
                    Toast.makeText(video.this, "ಎಲ್ಲಾ ಮೌಲ್ಯಗಳನ್ನು ನಮೂದಿಸಿ", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
