package com.example.myapplication.Empty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SearchView;

import com.example.myapplication.Adaptors.SearchAdapter;
import com.example.myapplication.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    EditText search;
    RecyclerView newrv;
    DatabaseReference databaseReference;
    FirebaseUser firebaseUser;
    ArrayList<String> namelist;
    ArrayList<String> datelist;
    SearchAdapter searchAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        //search
        search=(EditText) findViewById(R.id.searchView);
        newrv=(RecyclerView)findViewById(R.id.new_rv);
        namelist=new ArrayList<>();
        datelist=new ArrayList<>();


        databaseReference= FirebaseDatabase.getInstance().getReference();
        firebaseUser= FirebaseAuth.getInstance().getCurrentUser();

        newrv.setHasFixedSize(true);
        newrv.setLayoutManager(new LinearLayoutManager(this));
        newrv.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!s.toString().isEmpty()){
                    setAdapter(s.toString());
                }else {
                    namelist.clear();
                    datelist.clear();
                    newrv.removeAllViews();
                }
            }
        });


    }

    private void setAdapter(final String string) {

        databaseReference.child("document").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                namelist.clear();
                datelist.clear();
                newrv.removeAllViews();
                int count=0;

                for(DataSnapshot datashot:dataSnapshot.getChildren() ){
                    String uid=datashot.getKey();
                    String Name=datashot.child("Name").getValue(String.class);
                    String datee=datashot.child("Expired_data").getValue(String.class);
                    if(Name.toLowerCase().contains(string.toLowerCase())){
                        namelist.add(Name);
                        datelist.add(datee);
                        count++;

                    }else if(datee.toLowerCase().contains(string.toLowerCase())){
                        namelist.add(Name);
                        datelist.add(datee);
                        count++;
                    }
                    if(count==30){
                        break;
                    }
                    searchAdapter=new SearchAdapter(SearchActivity.this,namelist,datelist);
                    newrv.setAdapter(searchAdapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
