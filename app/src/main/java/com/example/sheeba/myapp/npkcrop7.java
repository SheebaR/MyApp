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

public class npkcrop7 extends AppCompatActivity {
    TextView etnitrox7,etphos7,etpot7;

    Button btnSubmit7;


    TextView tvurn7,tvssp7,tvmop7 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_npkcrop7);
        etpot7 = (TextView) findViewById(R.id.etpot7);
        etphos7 = (TextView) findViewById(R.id.etphos7);
        etnitrox7 = (TextView) findViewById(R.id.etnitrox7);



        btnSubmit7 = (Button) findViewById(R.id.btnSubmit7);


        tvurn7 = (TextView) findViewById(R.id.tvurn7);
        tvssp7 = (TextView) findViewById(R.id.tvssp7);
        tvmop7 = (TextView) findViewById(R.id.tvmop7);

        DatabaseReference m= FirebaseDatabase.getInstance().getReference("Data");
        DatabaseReference p=m.child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        p.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String t=dataSnapshot.child("N").getValue(String.class);
                String g=dataSnapshot.child("P").getValue(String.class);
                String q=dataSnapshot.child("K").getValue(String.class);
                etpot7.setText(q);
                etphos7.setText(g);
                etnitrox7.setText(t);
                String nitrox = t;
                String phos = g;

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
                    urn = Double.valueOf(u) * 1.00;
                }
                else  {
                    urn = Double.valueOf(u) * 0.00;
                }
                if(s>0){
                    ssp = Double.valueOf(s) * 3.00;
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
                etnitrox7.setText(urn+"");
                etphos7.setText(String.valueOf(ssp)+"");
                etpot7.setText(String.valueOf(mop)+"");

//                tvurn4.setText("ಯೂರಿಯಾ " + urn);
//                tvssp4.setText("SSp " + String.valueOf(ssp));
//                tvmop4.setText("MOP " + String.valueOf(mop));


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        btnSubmit7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(etpot7.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Enter appropriate values", Toast.LENGTH_SHORT).show();
                }
                else if(etphos7.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Enter appropriate values", Toast.LENGTH_SHORT).show();

                }

                else   if(etnitrox7.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Enter appropriate values", Toast.LENGTH_SHORT).show();

                }

                else {


                    String nitrox = etnitrox7.getText().toString();
                    String phos = etphos7.getText().toString();

                    String pot = etpot7.getText().toString();


                    System.out.println("nitrox " + nitrox);
                    System.out.println("phos " + phos);

                    System.out.println("pot " + pot);
                    double urn,ssp,mop;
                    double u=180-Integer.valueOf(nitrox);
                    double s=10-Integer.valueOf(phos);
                    double m=125-Integer.valueOf(pot);
                    if(u > 0)
                    {
                        urn = Double.valueOf(u) * 1.00;
                    }
                    else  {
                        urn = Double.valueOf(u) * 0.00;
                    }
                    if(s>0){
                        ssp = Double.valueOf(s) * 3.00;
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

                    tvurn7.setText("ಯೂರಿಯಾ " + urn);
                    tvssp7.setText("SSp " + String.valueOf(ssp));
                    tvmop7.setText("MOP " + String.valueOf(mop));


                }



            }
        });

    }
}
