package uz.name;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NameAdapter extends RecyclerView.Adapter<NameAdapter.TextViewHolder> {

    private ArrayList<Name> names;
    private Context mContext;

    public NameAdapter(ArrayList<Name> nameList, Context context) {
        this.mContext = context;
        this.names = nameList;
    }

    @NonNull
    @Override
    public TextViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView nameText = (TextView) LayoutInflater.from(mContext).inflate(R.layout.name_item, null, false);
        TextViewHolder textViewHolder = new TextViewHolder(nameText);
        return textViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TextViewHolder holder, int position) {
        holder.getTextView().setText(names.get(holder.getAdapterPosition()).getName());


        holder.getTextView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent narigiOynagaOtuvchi = new Intent(mContext, DescriptionActivity.class);
                narigiOynagaOtuvchi.putExtra("name", names.get(holder.getAdapterPosition()).toString());
                mContext.startActivity(narigiOynagaOtuvchi);
            }
        });
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    public static class TextViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public TextViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textView = (TextView) itemView;
        }

        public TextView getTextView() {
            return textView;
        }

    }
}
