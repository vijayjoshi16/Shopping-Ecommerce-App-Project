package com.example.smartkartapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.String;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ImageViewHolder> {
    private int[] images;
    private String[] details;
    int[] prices;
    String sna,sph,spa,callingActivity;
    private Context context;
    public  RecyclerAdapter(int[] images,String[] details,int[] prices,Context context,String sna,String sph,String spa,String callingActivity){
        this.images=images;
        this.details=details;
        this.prices=prices;
        this.context=context;
        this.sna=sna;
        this.sph=sph;
        this.spa=spa;
        this.callingActivity=callingActivity;
    }
    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        ImageViewHolder imageViewHolder=new ImageViewHolder(view,context,images,details,prices,sna,sph,spa,callingActivity);
        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        int image_id=images[position];
        holder.img.setImageResource(image_id);
        holder.img_det.setText(details[position]);
        holder.img_price.setText(Integer.toString(prices[position]));
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{
        ImageView img;
        TextView img_det,img_price;
        Context context;
        int[] images;
        String[] details;
        int[] prices;
        String sna,sph,spa,callingActiity;
        public ImageViewHolder(@NonNull View itemView,Context context,int[] images,String[] details,int[] prices,String sna,String sph,String spa,String callingActivity) {
            super(itemView);
            img=itemView.findViewById(R.id.item_image);
            img_det=itemView.findViewById(R.id.item_details);
            img_price=itemView.findViewById(R.id.item_price);
            itemView.setOnClickListener(this);
            this.context=context;
            this.images=images;
            this.details=details;
            this.prices=prices;
            this.sna=sna;
            this.sph=sph;
            this.spa=spa;
            this.callingActiity=callingActivity;
        }

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(context,DisplayItem.class);
            System.out.println(sna+sph+spa+callingActiity);
            intent.putExtra("image_id",images[getAdapterPosition()]);
            intent.putExtra("item_details",details[getAdapterPosition()]);
            intent.putExtra("item_price",prices[getAdapterPosition()]);
            intent.putExtra("NAME",sna);
            intent.putExtra("PHONE",sph);
            intent.putExtra("PASSWORD",spa);
            intent.putExtra("CALLING_ACTIVITY",callingActiity);
            context.startActivity(intent);
        }

    }
}
