package com.example.cinfood.Main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.cinfood.API.ApiClient;
import com.example.cinfood.API.ApiInterface;
import com.example.cinfood.Adapter.CustomAdapter;
import com.example.cinfood.Model.Menu;
import com.example.cinfood.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Makanan extends AppCompatActivity {
    private CustomAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //recyclerView.setAdapter();
        progressDialog = new ProgressDialog(Makanan.this);
        progressDialog.setMessage("Sedang Memproses");
        progressDialog.show();

        ApiInterface service = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Menu>> call = service.getAllMenu(); //memanggil data
        call.enqueue(new Callback<List<Menu>>() {
            @Override
            public void onResponse(Call<List<Menu>> call, Response<List<Menu>> response) {
                progressDialog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<Menu>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(Makanan.this, "Ada kesalahan, mohon coba lagi", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateDataList(List<Menu> detailData){
        recyclerView = findViewById(R.id.rcView);
        adapter = new CustomAdapter(this, detailData);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}