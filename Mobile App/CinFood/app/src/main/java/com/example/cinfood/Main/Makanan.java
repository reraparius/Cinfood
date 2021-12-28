package com.example.cinfood.Main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.cinfood.API.ApiClient;
import com.example.cinfood.API.ApiInterface;
import com.example.cinfood.Adapter.AdapterMenu;
import com.example.cinfood.Model.MenuModel;
import com.example.cinfood.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Makanan extends AppCompatActivity {
    private RecyclerView rvMenu;
    AdapterMenu adapter;
    private RecyclerView.Adapter admenu;
    private RecyclerView.LayoutManager lmMenu;
    private ArrayList<MenuModel> listmenu;
    ApiInterface apiInterface;
    Button btnBeli;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makanan);
        rvMenu = findViewById(R.id.rv_makanan);
        lmMenu = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvMenu.setLayoutManager(lmMenu);
        GetDataMenu();

        btnBeli = findViewById(R.id.btnBeli);
        btnBeli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Makanan.this,editprofile.class);
                startActivity(intent);
            }
        });


    }

    public void GetDataMenu() {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<List<MenuModel>> call = apiInterface.GetDataMenu();

        call.enqueue(new Callback<List<MenuModel>>() {
            @Override
            public void onResponse(Call<List<MenuModel>> call, Response<List<MenuModel>> response) {
               Log.i("Json", response.body().toString());
                listmenu = new ArrayList<>(response.body());
                adapter = new AdapterMenu(listmenu);
                rvMenu.setAdapter(adapter);
                rvMenu.setLayoutManager(new LinearLayoutManager(Makanan.this));

            }

            @Override
            public void onFailure(Call<List<MenuModel>> call, Throwable t) {
        Toast.makeText(Makanan.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}