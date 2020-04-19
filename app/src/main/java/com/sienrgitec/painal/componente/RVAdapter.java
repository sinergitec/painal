package com.sienrgitec.painal.componente;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.pojo.entity.TtCtGiro_;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ListViewHolder> {

    private List<TtCtGiro_> list;

    public RVAdapter(List<TtCtGiro_> list){
        this.list = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler, parent, false);
        ListViewHolder lvh = new ListViewHolder(v);
        return lvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        holder.title.setText(list.get(position).getCGiro());
        holder.subTitle.setText("");
        holder.photo.setImageResource(R.drawable.ic_cafe);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView title;
        TextView subTitle;
        ImageView photo;

        ListViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            title = (TextView)itemView.findViewById(R.id.title);
            subTitle = (TextView)itemView.findViewById(R.id.subTitle);
            photo = (ImageView)itemView.findViewById(R.id.photo);
        }
    }
}
