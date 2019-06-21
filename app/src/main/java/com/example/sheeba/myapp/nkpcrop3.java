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

public class nkpcrop3 extends AppCompatActivity {

    TextView etnitrox3,etphos3,etpot3;

    Button btnSubmit3;


    TextView tvurn3,tvssp3,tvmop3 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nkpcrop3);

        etpot3 = (TextView) findViewById(R.id.etpot3);
        etphos3 = (TextView) findViewById(R.id.etphos3);
        etnitrox3 = (TextView) findViewById(R.id.etnitrox3);



        btnSubmit3 = (Button) findViewById(R.id.btnSubmit3);


        tvurn3 = (TextView) findViewById(R.id.tvurn3);
        tvssp3 = (TextView) findViewById(R.id.tvssp3);
        tvmop3 = (TextView) findViewById(R.id.tvmop3);

        DatabaseReference m= FirebaseDatabase.getInstance().getReference("Data");
        DatabaseReference p=m.child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        p.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String t=dataSnapshot.child("N").getValue(String.class);
                String g=dataSnapshot.child("P").getValue(String.class);
                String q=dataSnapshot.child("K").getValue(String.class);
                etpot3.setText(q);
                etphos3.setText(g);
                etnitrox3.setText(t);
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
                etnitrox3.setText(urn+"");
                etphos3.setText(String.valueOf(ssp)+"");
                etpot3.setText(String.valueOf(mop)+"");
//                tvurn3.setText("ಯೂರಿಯಾ " + urn);
//                tvssp3.setText("SSp " + String.valueOf(ssp));
//                tvmop3.setText("MOP " + String.valueOf(mop));

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        btnSubmit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(etpot3.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Enter appropriate values", Toast.LENGTH_SHORT).show();
                }
                else if(etphos3.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Enter appropriate values", Toast.LENGTH_SHORT).show();

                }

                else   if(etnitrox3.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Enter appropriate values", Toast.LENGTH_SHORT).show();

                }

                else {


                    String nitrox = etnitrox3.getText().toString();
                    String phos = etphos3.getText().toString();

                    String pot = etpot3.getText().toString();


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

                    tvurn3.setText("ಯೂರಿಯಾ " + urn);
                    tvssp3.setText("SSp " + String.valueOf(ssp));
                    tvmop3.setText("MOP " + String.valueOf(mop));


                }



            }
        });

    }
}
