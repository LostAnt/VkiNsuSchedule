package com.nsu.ci.vkinsuschedule;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nsu.ci.vkinsuschedule.dto.ScheduleDTO;

import java.util.List;

/**
 * Created by Andrew on 22.09.2016.
 */
public class ScheduleListAdapter extends RecyclerView.Adapter<ScheduleListAdapter.ScheduleViewHolder> {

    private List<ScheduleDTO> data;

    public ScheduleListAdapter(List<ScheduleDTO> data) {
        this.data = data;
    }

    @Override
    public ScheduleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.schedule_item, parent, false);
        Log.d("---ADAPTER","ON CREATE---");
        return new ScheduleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ScheduleViewHolder holder, int position) {
        holder.title.setText(data.get(position).getTitle());
        holder.suppText.setText(data.get(position).getSuppText());
        holder.subTitle.setText(data.get(position).getSubTitle());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ScheduleViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView title;
        TextView subTitle;
        TextView suppText;

        public ScheduleViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.cardView);
            title = (TextView)itemView.findViewById(R.id.title);
            subTitle = (TextView)itemView.findViewById(R.id.subTitle);
            suppText = (TextView) itemView.findViewById(R.id.suppText);

        }

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
