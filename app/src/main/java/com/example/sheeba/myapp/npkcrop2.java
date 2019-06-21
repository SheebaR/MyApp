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

public class npkcrop2 extends AppCompatActivity {

    TextView etnitrox2,etphos2,etpot2;

    Button btnSubmit2;


    TextView tvurn2,tvssp2,tvmop2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_npkcrop2);

        etpot2 = (TextView) findViewById(R.id.etpot2);
        etphos2 = (TextView) findViewById(R.id.etphos2);
        etnitrox2 = (TextView) findViewById(R.id.etnitrox2);



        btnSubmit2 = (Button) findViewById(R.id.btnSubmit2);


        tvurn2 = (TextView) findViewById(R.id.tvurn2);
        tvssp2 = (TextView) findViewById(R.id.tvssp2);
        tvmop2 = (TextView) findViewById(R.id.tvmop2);


        DatabaseReference m= FirebaseDatabase.getInstance().getReference("Data");
        DatabaseReference p=m.child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        p.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String t=dataSnapshot.child("N").getValue(String.class);
                String g=dataSnapshot.child("P").getValue(String.class);
                String q=dataSnapshot.child("K").getValue(String.class);
//                etpot2.setText(q);
//                etphos2.setText(g);
//                etnitrox2.setText(t);

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
                    urn = Double.valueOf(u) * 1.3;
                }
                else  {
                    urn = Double.valueOf(u) * 0.00;
                }
                if(s>0){
                    ssp = Double.valueOf(s) * 0.4;
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
                etnitrox2.setText(urn+"");
                etphos2.setText(String.valueOf(ssp)+"");
                etpot2.setText(String.valueOf(mop)+"");

//                tvurn2.setText("ಯೂರಿಯಾ " + urn);
//                tvssp2.setText("SSp " + String.valueOf(ssp));
//                tvmop2.setText("MOP " + String.valueOf(mop));

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        btnSubmit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(etpot2.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Enter appropriate values", Toast.LENGTH_SHORT).show();
                }
                else if(etphos2.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Enter appropriate values", Toast.LENGTH_SHORT).show();

                }

                else   if(etnitrox2.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Enter appropriate values", Toast.LENGTH_SHORT).show();

                }

                else {


                    String nitrox = etnitrox2.getText().toString();
                    String phos = etphos2.getText().toString();

                    String pot = etpot2.getText().toString();


                    System.out.println("nitrox " + nitrox);
                    System.out.println("phos " + phos);

                    System.out.println("pot " + pot);

                    double urn,ssp,mop;
                    double u=180-Integer.valueOf(nitrox);
                    double s=10-Integer.valueOf(phos);
                    double m=125-Integer.valueOf(pot);
                    if(u > 0)
                    {
                        urn = Double.valueOf(u) * 1.3;
                    }
                    else  {
                        urn = Double.valueOf(u) * 0.00;
                    }
                    if(s>0){
                        ssp = Double.valueOf(s) * 0.4;
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

                    tvurn2.setText("ಯೂರಿಯಾ " + urn);
                    tvssp2.setText("SSp " + String.valueOf(ssp));
                    tvmop2.setText("MOP " + String.valueOf(mop));


                }



            }
        });

    }
}
