package com.example.fragmentapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ProductInterface {
    List<Product> listProduct = new ArrayList<>();
    ProductAdapter productAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void sentData(Product product) {
        fragmentThongTinSanPham fragmentThongTinSanPham = (com.example.fragmentapplication.fragmentThongTinSanPham) getFragmentManager().findFragmentById(R.id.fragment_thongtinsanpham);
        Configuration configuration = getResources().getConfiguration();
        if(fragmentThongTinSanPham != null && configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            fragmentThongTinSanPham.setThongTinSP(product);
        } else {
            Intent intent = new Intent(MainActivity.this, ChiTietSanPhamActivity.class);
            intent.putExtra("Product", product);
            startActivity(intent);
        }

    }
}