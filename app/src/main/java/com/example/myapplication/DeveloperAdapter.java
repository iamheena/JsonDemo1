package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class DeveloperAdapter extends RecyclerView.Adapter<DeveloperAdapter.ViewHolder> {
    @NonNull
    private Context context;
    private List<ListItem> listItems;
    public DeveloperAdapter(Context context,List<ListItem> listItems)
    {
        this.context=context;
        this.listItems=listItems;
    }
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
       // ViewHolder viewHolder=new ViewHolder(v);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       // holder.itemView.setTag(listItems.get(position));
        ListItem lst=listItems.get(position);
        holder.pName.setText(lst.getName());
        holder.ptitle.setText(lst.getTitle());
        holder.pDesc.setText(lst.getDescription());
        Glide.with(context)
                .load(lst.getImage())
                .into(holder.image);



    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView pName,ptitle,pDesc;
        public ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pName=(TextView)itemView.findViewById(R.id.txtnm);
            ptitle=(TextView)itemView.findViewById(R.id.txttitle);
            pDesc=(TextView)itemView.findViewById(R.id.txtdes);
            image=(ImageView)itemView.findViewById(R.id.imgview);
            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ListItem clist=(ListItem)view.getTag();
                    Toast.makeText(context, clist.getName()+" "+clist.getTitle()+" is "+ clist.getDescription(), Toast.LENGTH_SHORT).show();
                }
            });*/
        }
    }
}
