package com.example.sheeba.myapp;



import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class  Data{

    public String N;
    public String P;
    public String K;
    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public Data() {
    }

    public Data(String N,String P,String K) {
        this.N=N;
        this.P=P;
        this.K=K;
    }


    public String getNN() {return N;}

    public String getPP() {return P;}

    public String getKK() {return K;}

}