package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adaptors.invoiceAdapter;
import com.example.myapplication.Data.invoice;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class FragmentExpired extends Fragment {

    View v;
    private RecyclerView recyclerView;
    public static List<invoice> expiredInvoices;
    //Database
    DatabaseReference databaseReference;
    FirebaseUser firebaseUser;
    //information
    public static String name;
    public static String purchase_data;
    public static String expired_data;



    public FragmentExpired() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.expired_fragment,container,false);
        recyclerView = (RecyclerView)v.findViewById(R.id.expired_recyclerview);
        invoiceAdapter invoiceAdapter = new invoiceAdapter(getContext(),expiredInvoices);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(invoiceAdapter);
        return v;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        expiredInvoices = new ArrayList<>();
       // expiredInvoices.add(new invoice("bshayer","9/7/1998","9/7/1999"));

        databaseReference= FirebaseDatabase.getInstance().getReference().child("document");
        firebaseUser= FirebaseAuth.getInstance().getCurrentUser();

       // expiredInvoices.clear();
       // recyclerView.removeAllViews();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot datashot:dataSnapshot.getChildren()){
                    name= datashot.child("Name").getValue(String.class);
                    purchase_data=datashot.child("Expired_data").getValue(String.class);  //wrong data********
                    expired_data=datashot.child("Expired_data").getValue(String.class);

                    Calendar calendar = Calendar.getInstance();
                    String currentDate = DateFormat.getDateInstance().format(calendar.getTime());

                    if(expired_data.compareTo(currentDate)<0) { //less than currentDate

                    }

                    else if(expired_data.compareTo(currentDate)>0) { //greater than currentDate
                        expiredInvoices.add(new invoice (name,purchase_data,expired_data));
                    }

                    else if(expired_data.compareTo(currentDate)==0) { //both dates are equal

                    }

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {


            }
        });

    } //onCreate


}
