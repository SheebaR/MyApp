package com.example.sheeba.myapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
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

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonSignin;
    private EditText edusrname1;
    private EditText edpwdname1;
    private TextView sign_up;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();
Log.e("login","entered login");
        if(firebaseAuth.getCurrentUser() !=null){
            //to navigate to the profile activity
            finish();
            startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
        }
      //  else
        //{
          //  Toast.makeText(this, "ಅಮಾನ್ಯವಾದ ಲಾಗಿನ್", Toast.LENGTH_SHORT).show();
        //}

        buttonSignin = (Button) findViewById(R.id.buttonSignin);
        edusrname1 = (EditText) findViewById(R.id.edusrname1);
        edpwdname1 = (EditText) findViewById(R.id.edpwdname1);
        sign_up = (TextView) findViewById(R.id.sign_up);

        progressDialog= new ProgressDialog(this);

        buttonSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("login","entered  on clicklogin");
                userLogin();
            }
        });
        sign_up.setOnClickListener(this);
    }
    private void userLogin(){
        String email =edusrname1.getText().toString().trim();
        String password =edpwdname1.getText().toString().trim();
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
        progressDialog.setMessage("ದಯಮಾಡಿ ನಿರೀಕ್ಷಿಸಿ ......");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()){
                            //start the profile activity
                            finish();
                            Log.e("login","entered login");
                            startActivity(new Intent(LoginActivity.this, ProfileActivity.class));
                        }
                        else {
                            Toast.makeText(LoginActivity.this, " ಅಮಾನ್ಯವಾದ ಲಾಗಿನ್ ", Toast.LENGTH_SHORT).show();

                            progressDialog.cancel();

                        }


                    }
                });
    }
    @Override
    public void onClick(View view) {
        Log.e("login","entered  on clicklogin");
        if (view == buttonSignin) {
            Log.e("login","entered entered if");
            //userLogin();
        }
        if (view == sign_up) {
            finish();
            startActivity(new Intent(this,MainActivity.class));
        }

    }

}
