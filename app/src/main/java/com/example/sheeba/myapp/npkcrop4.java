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

public class npkcrop4 extends AppCompatActivity {

    TextView etnitrox4,etphos4,etpot4;

    Button btnSubmit4;


    TextView tvurn4,tvssp4,tvmop4 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_npkcrop4);

        etpot4 = (TextView) findViewById(R.id.etpot4);
        etphos4 = (TextView) findViewById(R.id.etphos4);
        etnitrox4 = (TextView) findViewById(R.id.etnitrox4);



        btnSubmit4 = (Button) findViewById(R.id.btnSubmit4);


        tvurn4 = (TextView) findViewById(R.id.tvurn4);
        tvssp4 = (TextView) findViewById(R.id.tvssp4);
        tvmop4 = (TextView) findViewById(R.id.tvmop4);

        DatabaseReference m= FirebaseDatabase.getInstance().getReference("Data");
        DatabaseReference p=m.child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        p.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String t=dataSnapshot.child("N").getValue(String.class);
                String g=dataSnapshot.child("P").getValue(String.class);
                String q=dataSnapshot.child("K").getValue(String.class);
                etpot4.setText(q);
                etphos4.setText(g);
                etnitrox4.setText(t);
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
                    ssp = Double.valueOf(s) * 6.00;
                }
                else
                {
                    ssp = Double.valueOf(s) * 0.00;
                }
                if(m>0)
                {
                    mop = Double.valueOf(m) * 4.00;
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
                etnitrox4.setText(urn+"");
                etphos4.setText(String.valueOf(ssp)+"");
                etpot4.setText(String.valueOf(mop)+"");

//                tvurn4.setText("ಯೂರಿಯಾ " + urn);
//                tvssp4.setText("SSp " + String.valueOf(ssp));
//                tvmop4.setText("MOP " + String.valueOf(mop));


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        btnSubmit4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(etpot4.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Enter appropriate values", Toast.LENGTH_SHORT).show();
                }
                else if(etphos4.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Enter appropriate values", Toast.LENGTH_SHORT).show();

                }

                else   if(etnitrox4.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Enter appropriate values", Toast.LENGTH_SHORT).show();

                }

                else {


                    String nitrox = etnitrox4.getText().toString();
                    String phos = etphos4.getText().toString();

                    String pot = etpot4.getText().toString();


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
                        ssp = Double.valueOf(s) * 6.00;
                    }
                    else
                    {
                        ssp = Double.valueOf(s) * 0.00;
                    }
                    if(m>0)
                    {
                        mop = Double.valueOf(m) * 4.00;
                    }
                    else
                    {
                        mop = Double.valueOf(m) * 0.00;
                    }



                    System.out.println("urn " + urn);
                    System.out.println("ssp " + ssp);

                    System.out.println("mop " + mop);

                    tvurn4.setText("ಯೂರಿಯಾ " + urn);
                    tvssp4.setText("SSp " + String.valueOf(ssp));
                    tvmop4.setText("MOP " + String.valueOf(mop));


                }



            }
        });

    }

}
