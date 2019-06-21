package com.example.sheeba.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class npkcrop1 extends AppCompatActivity {

    TextView etnitrox1,etphos1,etpot1;

    Button btnSubmit1;


    TextView tvurn1,tvssp1,tvmop1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_npkcrop1);

        etpot1 = (TextView) findViewById(R.id.etpot1);
        etphos1 = (TextView) findViewById(R.id.etphos1);
        etnitrox1 = (TextView) findViewById(R.id.etnitrox1);



        btnSubmit1 = (Button) findViewById(R.id.btnSubmit1);


        tvurn1 = (TextView) findViewById(R.id.tvurn1);
        tvssp1 = (TextView) findViewById(R.id.tvssp1);
        tvmop1 = (TextView) findViewById(R.id.tvmop1);


        DatabaseReference m= FirebaseDatabase.getInstance().getReference("Data");
        DatabaseReference p=m.child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        p.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               String t=dataSnapshot.child("N").getValue(String.class);
               String g=dataSnapshot.child("P").getValue(String.class);
                String q=dataSnapshot.child("K").getValue(String.class);
//                etpot1.setText(q);
//                etphos1.setText(g);
//                etnitrox1.setText(t);

                //newlyadded



                String nitrox = t;
                String phos =g;

                String pot = q;


                System.out.println("nitrox " + nitrox);
                System.out.println("phos " + phos);

                System.out.println("pot " + pot);
                double urn,ssp,mop;
                double u=180-Integer.valueOf(nitrox);
                double s=10-Integer.valueOf(phos);
                double m=125-Integer.valueOf(pot);
                if(u > 0)
                {
                    urn = Double.valueOf(u) * 3.00;
                }
                else  {
                    urn = Double.valueOf(u) * 0.00;
                }
                if(s>0){
                    ssp = Double.valueOf(s) * 1.5;
                }
                else
                {
                    ssp = Double.valueOf(s) * 0.00;
                }
                if(m>0)
                {
                    mop = Double.valueOf(m) * 1.00;
                }
                else
                {
                    mop = Double.valueOf(m) * 0.00;
                }

                System.out.println("urn " + urn);
                System.out.println("ssp " + ssp);

                System.out.println("mop " + mop);
                if(t.isEmpty())
                {
                    urn=0.0;
                }
                if(g.isEmpty())
                {
                    ssp=0.0;
                }
                if(q.isEmpty())
                {
                    mop=0.0;
                }

                etnitrox1.setText(urn+"");
                etphos1.setText(String.valueOf(ssp)+"");
                etpot1.setText(String.valueOf(mop)+"");
//                tvurn1.setText("ಯೂರಿಯಾ " + urn);
//                tvssp1.setText("SSp " + String.valueOf(ssp));
//                tvmop1.setText("MOP " + String.valueOf(mop));




            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        btnSubmit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(etpot1.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Enter appropriate values", Toast.LENGTH_SHORT).show();
                }
                else if(etphos1.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Enter appropriate values", Toast.LENGTH_SHORT).show();

                }

                else   if(etnitrox1.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Enter appropriate values", Toast.LENGTH_SHORT).show();

                }


                else {


                    String nitrox = etnitrox1.getText().toString();
                    String phos = etphos1.getText().toString();

                    String pot = etpot1.getText().toString();


                    System.out.println("nitrox " + nitrox);
                    System.out.println("phos " + phos);

                    System.out.println("pot " + pot);
                    double urn,ssp,mop;
                    double u=180-Integer.valueOf(nitrox);
                    double s=10-Integer.valueOf(phos);
                    double m=125-Integer.valueOf(pot);
                    if(u > 0)
                    {
                        urn = Double.valueOf(u) * 3.00;
                    }
                    else  {
                         urn = Double.valueOf(u) * 0.00;
                    }
                    if(s>0){
                        ssp = Double.valueOf(s) * 1.5;
                    }
                    else
                    {
                         ssp = Double.valueOf(s) * 0.00;
                    }
                    if(m>0)
                    {
                         mop = Double.valueOf(m) * 1.00;
                    }
                    else
                    {
                         mop = Double.valueOf(m) * 0.00;
                    }

                    System.out.println("urn " + urn);
                    System.out.println("ssp " + ssp);

                    System.out.println("mop " + mop);

                    tvurn1.setText("ಯೂರಿಯಾ " + urn);
                    tvssp1.setText("SSp " + String.valueOf(ssp));
                    tvmop1.setText("MOP " + String.valueOf(mop));


                }



            }
        });

    }
}
