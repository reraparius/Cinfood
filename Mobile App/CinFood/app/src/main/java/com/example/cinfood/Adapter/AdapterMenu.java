package com.example.cinfood.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.cinfood.Model.MenuModel;
import com.example.cinfood.R;

import java.util.ArrayList;

public class AdapterMenu extends RecyclerView.Adapter<AdapterMenu.HolderData>{
    private ArrayList<MenuModel> listMenu;

    public AdapterMenu(ArrayList<MenuModel> listMenu) {
        this.listMenu = listMenu;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_makanan,parent,false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override //meletakkan data
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        MenuModel menumodel = listMenu.get(position);
        holder.tvCatid.setText(menumodel.getCatid());

            holder.tvId.setText(menumodel.getId());

        holder.tvTitle.setText(menumodel.getTitle());
        holder.tvPrice.setText(menumodel.getNormalprice());
       Glide.with(holder.itemView)
               .load(menumodel.getPicture())
               .override(200,200)
               .centerCrop()
               .into(holder.Gambar);






    }

    @Override //menghitung banyk data yg di tarik
    public int getItemCount() {
       return listMenu.size();
    }

    public class HolderData extends RecyclerView.ViewHolder{
        TextView tvTitle,tvPrice,tvDescripsi,tvId, tvCatid;
        ImageView Gambar;


        public HolderData(@NonNull View itemView) {
            super(itemView);
            tvTitle= itemView.findViewById(R.id.namaMakanan);
            tvPrice= itemView.findViewById(R.id.harga);
            tvId = itemView.findViewById(R.id.TV_id);
            tvCatid = itemView.findViewById(R.id.TV_catid);
            Gambar = itemView.findViewById(R.id.fMakanan);


        }
    }
}

