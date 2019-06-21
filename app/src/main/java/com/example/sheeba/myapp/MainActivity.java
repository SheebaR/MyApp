package com.example.sheeba.myapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button buttonRegister;
    private EditText edusrname;
    private EditText edpwdname;
    private EditText hint;
    private Button sign_in;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private Button already;
    String x;double y;
    int year;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() !=null){
            //to navigate to the profile activity
            finish();
            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
        }
        progressDialog = new ProgressDialog(this);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        edusrname = (EditText) findViewById(R.id.edusrname);
        edpwdname = (EditText) findViewById(R.id.edpwdname);
        hint= (EditText) findViewById(R.id.hint44);

         x=hint.getText().toString().trim();
//         y=Integer.parseInt(x);
        //int y;
        //y=Integer.parseInt(x);
        year=Calendar.getInstance().get(Calendar.YEAR);



        already=(Button)findViewById(R.id.sign_in) ;
        buttonRegister.setOnClickListener(this);
already.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Log.e("clicked","signin");
        startActivity(new Intent(MainActivity.this,LoginActivity.class));
    }
});

    }

    private void registerUser() {
        String email = edusrname.getText().toString().trim();
        String password = edpwdname.getText().toString().trim();
        String yr=hint.getText().toString().trim();
        if (TextUtils.isEmpty(email)) {
            //not entered email
            Toast.makeText(this, "ದಯಮಾಡಿ ಖಾತೆ ಐಡಿ ನಮೂದಿಸಿ", Toast.LENGTH_SHORT).show();
            //stop the function execution further
            return;
        }
        if (TextUtils.isEmpty(password)) {
            //password not entered
            Toast.makeText(this, "ದಯಮಾಡಿ ಪಾಸ್ವರ್ಡ್ ನಮೂದಿಸಿ", Toast.LENGTH_SHORT).show();
            //stop the function execution further
            return;
        }


        //if validations are ok
        //we will show a progressbar
        progressDialog.setMessage("ಬಳಕೆದಾರರನ್ನು ನೋಂದಾಯಿಸಲಾಗುತ್ತಿದೆ ......");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //user is successfully registered and login in
                            //we will start the profile activity here
                            //right now display a toast only
                            Toast.makeText(MainActivity.this, "ಯಶಸ್ವಿಯಾಗಿ ನೋಂದಾಯಿಸಲಾಗಿದೆ ", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(MainActivity.this, " ನೋಂದಾಯಿಸಲು ವಿಫಲವಾಗಿದೆ !!!. ಮತ್ತೆ ಪ್ರಯತ್ನಿಸಿ !! ", Toast.LENGTH_SHORT).show();

                            progressDialog.cancel();

                        }

                    }

                });
    }


    @Override
    public void onClick(View view) {
        if (view == buttonRegister) {
            if(hint.getText().toString().equalsIgnoreCase(""))
            {

                Toast.makeText(this, "ಮಣ್ಣಿನ ಕಾರ್ಡ್ ವರ್ಷವನ್ನು ನಮೂದಿಸಿ", Toast.LENGTH_SHORT).show();
            }
            else if((check(hint.getText().toString().trim(),String.valueOf(year))==0 ) )
            {
                Toast.makeText(this, "ಮಣ್ಣಿನ ಕಾರ್ಡ್ ಬದಲಾಯಿಸಿ", Toast.LENGTH_SHORT).show();
            }
            else
            {
                registerUser();
            }
                //y=new Double(x);
               // Toast.makeText(this, year+"working", Toast.LENGTH_SHORT).show();

        }

    }
    int check(String k,String l)
    {
        int i=Integer.parseInt(k);
        int m=Integer.parseInt(l);
        int v=i+3;
        if(v>=m && i<=m)
            return 1;
        else return 0;

    }
}