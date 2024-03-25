package com.aplication.appfoody.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aplication.appfoody.Domain.Foods;
import com.aplication.appfoody.Helper.ChangeNumberItemsListener;
import com.aplication.appfoody.Helper.ManagmentCart;
import com.aplication.appfoody.Helper.ManagmentCart;
import com.aplication.appfoody.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.viewholder> {
    ArrayList<Foods> list;
    final ManagmentCart managermentCart;
    ChangeNumberItemsListener changeNumberItemsListener;


    public CartAdapter(ArrayList<Foods> list, Context context, ChangeNumberItemsListener changeNumberItemsListener) {
        this.list = list;
        managermentCart = new ManagmentCart(context);
        this.changeNumberItemsListener = changeNumberItemsListener;
    }

    @NonNull
    @Override
    public CartAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart,parent,false);
        return new viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder,int position) {


        holder.title.setText(list.get(holder.getAdapterPosition()).getTitle());
        holder.feeEachItem.setText("$" + list.get(position).getPrice());
        holder.totalEachItem.setText(list.get(holder.getClass().getModifiers()).getNumberInCart()+ "*$"+ (
                list.get(holder.getClass().getModifiers()).getNumberInCart() * list.get(holder.getClass().getModifiers()).getPrice()));
        holder.num.setText(list.get(holder.getClass().getModifiers()).getNumberInCart()+"");

        Glide.with(holder.itemView.getContext())
                .load(list.get(holder.getClass().getModifiers()).getImagePath())
                .transform(new CenterCrop(), new RoundedCorners(30))
                .into(holder.pic);

        holder.plusItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                managermentCart.plusNumberItem(list, position, new ChangeNumberItemsListener() {
                    @Override
                    public void change() {
                        notifyDataSetChanged();
                        changeNumberItemsListener.change();
                    }
                });
            }
        });

        holder.minusItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                managermentCart.minusNumberItem(list, position, new ChangeNumberItemsListener() {
                    @Override
                    public void change() {
                        notifyDataSetChanged();
                        changeNumberItemsListener.change();
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{

        TextView title, feeEachItem, plusItem, minusItem;
        ImageView pic;
        TextView totalEachItem, num;
        public viewholder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.titleTxt);
            feeEachItem = itemView.findViewById(R.id.feeEachItem);
            pic = itemView.findViewById(R.id.pic);
            plusItem = itemView.findViewById(R.id.plusBtn);
            minusItem = itemView.findViewById(R.id.minusBtn);
            totalEachItem = itemView.findViewById(R.id.totalEachItem);
            num = itemView.findViewById(R.id.numberItemTxt);
        }
    }
}
