package com.techdecode.test;

import android.content.Context;

import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder> {

    private Context context;
    private List<PersonUtils> personUtils;


    public void clearApplications() {
        int size = this.personUtils.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                personUtils.remove(0);
            }

            this.notifyItemRangeRemoved(0, size);
        }
    }

    public CustomRecyclerAdapter(Context context, List personUtils) {
        this.context = context;
        this.personUtils = personUtils;
    }

        @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemView.setTag(personUtils.get(position));
        PersonUtils pu = personUtils.get(position);

        holder.pName.setText(pu.getEMPNAME());
        holder.pJobProfile.setText(pu.getREASON());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,MainActivity2.class);
                intent.putExtra("title",pu.getEMPNAME());
                intent.putExtra("reason",pu.getREASON());
                intent.putExtra("nodays",pu.getNO_OF_DAYS());
                intent.putExtra("leaveform",pu.getLEAVE_FROM());
                intent.putExtra("leaveto",pu.getLEAVE_TO());
                intent.putExtra("leaveid",pu.getLeave_id());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return personUtils.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView pName;
        public TextView pJobProfile;

        public ViewHolder(View itemView) {
            super(itemView);

            pName = (TextView) itemView.findViewById(R.id.pNametxt);
            pJobProfile = (TextView) itemView.findViewById(R.id.pJobProfiletxt);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                  //  PersonUtils cpu = (PersonUtils) view.getTag();

                //  Toast.makeText(view.getContext(), cpu.getEMPNAME()+" "+cpu.getEMPNAME()+" is "+ cpu.getREASON(), Toast.LENGTH_LONG).show();







                }
            });

        }
    }

}