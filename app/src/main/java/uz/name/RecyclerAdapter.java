package uz.name;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerHolder> {

    private ArrayList<NameAdapter> nameAdapters;
    private Context mContext;

    public RecyclerAdapter(ArrayList<NameAdapter> nameList, Context context) {
        this.mContext = context;
        this.nameAdapters = nameList;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView nameText = (RecyclerView) LayoutInflater.from(mContext).inflate(R.layout.horizontal, null, false);
        RecyclerHolder textViewHolder = new RecyclerHolder(nameText);
        return textViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {
        holder.getRecyclerView().setAdapter(nameAdapters.get(holder.getAdapterPosition()));

    }

    @Override
    public int getItemCount() {
        return nameAdapters.size();
    }

    public static class RecyclerHolder extends RecyclerView.ViewHolder {
        private RecyclerView recyclerView;

        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);
            this.recyclerView = (RecyclerView) itemView;
        }

        public RecyclerView getRecyclerView() {
            return recyclerView;
        }

    }
}
