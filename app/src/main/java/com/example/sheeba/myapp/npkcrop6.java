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
public class npkcrop6 extends AppCompatActivity {
    TextView etnitrox6,etphos6,etpot6;

    Button btnSubmit6;


    TextView tvurn6,tvssp6,tvmop6 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_npkcrop6);
        etpot6 = (TextView) findViewById(R.id.etpot6);
        etphos6 = (TextView) findViewById(R.id.etphos6);
        etnitrox6 = (TextView) findViewById(R.id.etnitrox6);



        btnSubmit6 = (Button) findViewById(R.id.btnSubmit6);


        tvurn6 = (TextView) findViewById(R.id.tvurn6);
        tvssp6 = (TextView) findViewById(R.id.tvssp6);
        tvmop6 = (TextView) findViewById(R.id.tvmop6);

        DatabaseReference m= FirebaseDatabase.getInstance().getReference("Data");
        DatabaseReference p=m.child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        p.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String t=dataSnapshot.child("N").getValue(String.class);
                String g=dataSnapshot.child("P").getValue(String.class);
                String q=dataSnapshot.child("K").getValue(String.class);
                etpot6.setText(q);
                etphos6.setText(g);
                etnitrox6.setText(t);
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
                    urn = Double.valueOf(u) * 7.00;
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
                etnitrox6.setText(urn+"");
                etphos6.setText(String.valueOf(ssp)+"");
                etpot6.setText(String.valueOf(mop)+"");

//                tvurn4.setText("ಯೂರಿಯಾ " + urn);
//                tvssp4.setText("SSp " + String.valueOf(ssp));
//                tvmop4.setText("MOP " + String.valueOf(mop));


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        btnSubmit6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(etpot6.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Enter appropriate values", Toast.LENGTH_SHORT).show();
                }
                else if(etphos6.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Enter appropriate values", Toast.LENGTH_SHORT).show();

                }

                else   if(etnitrox6.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Enter appropriate values", Toast.LENGTH_SHORT).show();

                }

                else {


                    String nitrox = etnitrox6.getText().toString();
                    String phos = etphos6.getText().toString();

                    String pot = etpot6.getText().toString();


                    System.out.println("nitrox " + nitrox);
                    System.out.println("phos " + phos);

                    System.out.println("pot " + pot);
                    double urn,ssp,mop;
                    double u=180-Integer.valueOf(nitrox);
                    double s=10-Integer.valueOf(phos);
                    double m=125-Integer.valueOf(pot);
                    if(u > 0)
                    {
                        urn = Double.valueOf(u) * 7.00;
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
                        mop = Double.valueOf(m) * 1.00;
                    }
                    else
                    {
                        mop = Double.valueOf(m) * 0.00;
                    }



                    System.out.println("urn " + urn);
                    System.out.println("ssp " + ssp);

                    System.out.println("mop " + mop);

                    tvurn6.setText("ಯೂರಿಯಾ " + urn);
                    tvssp6.setText("SSp " + String.valueOf(ssp));
                    tvmop6.setText("MOP " + String.valueOf(mop));


                }



            }
        });

    }
}
