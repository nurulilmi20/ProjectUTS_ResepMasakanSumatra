package com.example.projectuts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailResep extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_resep);
        // Mengambil referensi ke ImageView dengan id imgresep dari layout XML.
        ImageView image = findViewById(R.id.imgresep);
        // Mengambil referensi ke TextView dengan id judul dari layout XML.
        TextView title = findViewById(R.id.judul);
        // Mengambil referensi ke TextView dengan id desc dari layout XML.
        TextView description = findViewById(R.id.desc);



        // Mengambil intent yang memulai aktivitas saat ini.
        Intent intent = getIntent();



        // Memeriksa apakah intent tidak null dan memiliki ekstra "Resep".
        if (intent != null && intent.hasExtra("Resep")) {
            // Mendapatkan objek Resep dari intent.
            Resep resep = intent.getParcelableExtra("Resep");

            // Mendapatkan judul makanan dari objek Resep.
            String judulMakanan = resep.getJudul();
            // Mendapatkan deskripsi makanan dari objek Resep.
            String deskripsiMakanan = resep.getDescription(); // Pastikan metode getDescription() tersedia dalam kelas Resep.
            // Mendapatkan id gambar makanan dari objek Resep.
            int gambarMakanan = resep.getImg();


            // Menggunakan Glide untuk memuat gambar makanan ke ImageView.
            Glide.with(this)
                    .load(gambarMakanan)
                    .into(image);
            // Menetapkan judul makanan ke TextView title.
            title.setText(judulMakanan);
            // Menetapkan deskripsi makanan ke TextView description.
            description.setText(deskripsiMakanan);
        }

        this.setTitle("Ayam Gulai");

        ImageView arrowBackImageView = findViewById(R.id.arrowBackImageView);
        arrowBackImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}