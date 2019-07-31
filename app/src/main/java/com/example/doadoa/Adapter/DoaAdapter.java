package com.example.doadoa.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.doadoa.Entity.Doa;
import com.example.doadoa.R;

import java.util.List;

public class DoaAdapter extends RecyclerView.Adapter<DoaAdapter.ViewHolder> {

    List<Doa> doaList;
    private OnCallbackListener listener;

    public DoaAdapter(List<Doa> doaList) {
        this.doaList = doaList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_doa, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Doa doa = doaList.get(i);
        viewHolder.tview.setText(doa.getNamaDoa());
    }

    public void setOnCallbackListener(OnCallbackListener listener) {
        this.listener = listener;
    }



    @Override
    public int getItemCount() {
        return doaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
        TextView tview;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            tview = itemView.findViewById(R.id.namadoa);

        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onClick(doaList.get(getAdapterPosition()));
            }
        }
    }
    public interface OnCallbackListener {

        void onClick(Doa doa);
    }
}
