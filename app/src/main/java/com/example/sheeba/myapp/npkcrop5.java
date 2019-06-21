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

public class npkcrop5 extends AppCompatActivity {
    TextView etnitrox5,etphos5,etpot5;

    Button btnSubmit5;


    TextView tvurn5,tvssp5,tvmop5 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_npkcrop5);

        etpot5 = (TextView) findViewById(R.id.etpot5);
        etphos5 = (TextView) findViewById(R.id.etphos5);
        etnitrox5 = (TextView) findViewById(R.id.etnitrox5);



        btnSubmit5 = (Button) findViewById(R.id.btnSubmit5);


        tvurn5 = (TextView) findViewById(R.id.tvurn5);
        tvssp5 = (TextView) findViewById(R.id.tvssp5);
        tvmop5 = (TextView) findViewById(R.id.tvmop5);

        DatabaseReference m= FirebaseDatabase.getInstance().getReference("Data");
        DatabaseReference p=m.child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        p.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String t=dataSnapshot.child("N").getValue(String.class);
                String g=dataSnapshot.child("P").getValue(String.class);
                String q=dataSnapshot.child("K").getValue(String.class);
                etpot5.setText(q);
                etphos5.setText(g);
                etnitrox5.setText(t);
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
                    urn = Double.valueOf(u) * 4.00;
                }
                else  {
                    urn = Double.valueOf(u) * 0.00;
                }
                if(s>0){
                    ssp = Double.valueOf(s) * 2.00;
                }
                else
                {
                    ssp = Double.valueOf(s) * 0.00;
                }
                if(m>0)
                {
                    mop = Double.valueOf(m) * 2.00;
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
                etnitrox5.setText(urn+"");
                etphos5.setText(String.valueOf(ssp)+"");
                etpot5.setText(String.valueOf(mop)+"");

//                tvurn4.setText("ಯೂರಿಯಾ " + urn);
//                tvssp4.setText("SSp " + String.valueOf(ssp));
//                tvmop4.setText("MOP " + String.valueOf(mop));


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        btnSubmit5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(etpot5.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Enter appropriate values", Toast.LENGTH_SHORT).show();
                }
                else if(etphos5.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Enter appropriate values", Toast.LENGTH_SHORT).show();

                }

                else   if(etnitrox5.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Enter appropriate values", Toast.LENGTH_SHORT).show();

                }

                else {


                    String nitrox = etnitrox5.getText().toString();
                    String phos = etphos5.getText().toString();

                    String pot = etpot5.getText().toString();


                    System.out.println("nitrox " + nitrox);
                    System.out.println("phos " + phos);

                    System.out.println("pot " + pot);
                    double urn,ssp,mop;
                    double u=180-Integer.valueOf(nitrox);
                    double s=10-Integer.valueOf(phos);
                    double m=125-Integer.valueOf(pot);
                    if(u > 0)
                    {
                        urn = Double.valueOf(u) * 4.00;
                    }
                    else  {
                        urn = Double.valueOf(u) * 0.00;
                    }
                    if(s>0){
                        ssp = Double.valueOf(s) * 2.00;
                    }
                    else
                    {
                        ssp = Double.valueOf(s) * 0.00;
                    }
                    if(m>0)
                    {
                        mop = Double.valueOf(m) * 2.00;
                    }
                    else
                    {
                        mop = Double.valueOf(m) * 0.00;
                    }



                    System.out.println("urn " + urn);
                    System.out.println("ssp " + ssp);

                    System.out.println("mop " + mop);

                    tvurn5.setText("ಯೂರಿಯಾ " + urn);
                    tvssp5.setText("SSp " + String.valueOf(ssp));
                    tvmop5.setText("MOP " + String.valueOf(mop));


                }



            }
        });
    }
}
