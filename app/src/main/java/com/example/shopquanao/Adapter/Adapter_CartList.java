package com.example.shopquanao.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopquanao.Model.Item;
import com.example.shopquanao.R;

import java.util.ArrayList;
import java.util.List;

public class Adapter_CartList extends RecyclerView.Adapter {
    private List callListResponses = new ArrayList<>();
    final List templist=new ArrayList<>();
    private Activity context;
    int lastPosition=0;

    public Adapter_CartList(Activity context, List callListResponses)
    {
        super();
        this.context = context;
        this.callListResponses=callListResponses;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.title_cart, parent, false);

        return new ViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Item call = (Item) callListResponses.get(position);

        holder.itemname.setText(call.getItemName());
        holder.itemprice.setText(call.getRate()+" Rs");
        holder.itemsize.setText(call.getSize());
        holder.tv_quantity.setText(call.getQuantity());

//        holder.cart_minus_img.setOnClickListener(new QuantityListener(context, holder.tv_quantity,call,false));
//        holder.cart_plus_img.setOnClickListener(new QuantityListener(context, holder.tv_quantity,call,true));
//        holder.img_deleteitem.setOnClickListener(new DeleteItemListener(context,call,this));
    }

    //Animating single element
//    private void setAnimation(View viewToAnimate, int position)
//    {
//        if (position > lastPosition) {
//            Animation animation = AnimationUtils.loadAnimation(context, R.anim.push_right_in);
//            viewToAnimate.startAnimation(animation);
//            lastPosition=position;
//        }
//        position++;
//    }

    @Override
    public int getItemCount() {
        //Log.d("Size List:",String.valueOf(callListResponses.size()));
        if(callListResponses!=null){
            return callListResponses.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView itemprice,itemname, itemsize,tv_quantity;
        ImageView cart_minus_img, cart_plus_img,img_deleteitem;


        public ViewHolder(View itemView) {
            super(itemView);
            cart_minus_img=(ImageView) itemView.findViewById(R.id.cart_minus_img);
            cart_plus_img=(ImageView) itemView.findViewById(R.id.cart_plus_img);
            img_deleteitem=(ImageView) itemView.findViewById(R.id.img_deleteitem);
            itemname=(TextView) itemView.findViewById(R.id.itemname);
            itemprice=(TextView) itemView.findViewById(R.id.itemprice);
            itemsize=(TextView) itemView.findViewById(R.id.itemsize);
            tv_quantity=(TextView) itemView.findViewById(R.id.tv_quantity);

        }
    }

}
