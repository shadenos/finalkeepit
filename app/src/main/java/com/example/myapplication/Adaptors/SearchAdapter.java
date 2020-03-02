package com.example.myapplication.Adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplication.R;

import java.util.ArrayList;
//-----------------------------------------------------------------------

//----------------------------------------------------------------------------



public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {
    Context context;
    ArrayList<String> namelist;
    ArrayList<String> datelist;

    public SearchAdapter(Context context, ArrayList<String> namelist, ArrayList<String> datelist) {
        this.context = context;
        this.namelist = namelist;
        this.datelist = datelist;
    }

    @NonNull
    @Override
    public SearchAdapter.SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.searchlist,parent,false);

        return new SearchAdapter.SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.SearchViewHolder holder, int position) {
        holder.namein.setText(namelist.get(position));
        holder.datein.setText(datelist.get(position));


    }


    @Override
    public int getItemCount() {
        return namelist.size();
    }

    class SearchViewHolder extends RecyclerView.ViewHolder{
        TextView namein;
        TextView datein;

        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);
            namein=(TextView) itemView.findViewById(R.id.nameinf);
            datein=(TextView) itemView.findViewById(R.id.dateinf);


        }
    }
}
