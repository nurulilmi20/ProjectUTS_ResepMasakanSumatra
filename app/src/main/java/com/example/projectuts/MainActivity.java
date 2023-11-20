package com.example.projectuts;

import static com.example.projectuts.R.id.arrowBackImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import de.hdodenhof.circleimageview.CircleImageView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CircleImageView profilImageView = findViewById(R.id.profile);
        profilImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });


        // Mendapatkan referensi ke RecyclerView dengan id rMenu dari layout XML.
        final RecyclerView rMenu = findViewById(R.id.rMenu);

        // Membuat ArrayList untuk menyimpan objek Resep.
        ArrayList<Resep> reseps = new ArrayList<>();

        // Mengatur Adapter RecyclerView dengan ArrayList reseps dan konteks saat ini.
        rMenu.setAdapter(new Adapter(reseps, this));

        // Menambahkan objek Resep ke dalam ArrayList reseps dengan data makanan, deskripsi dari resource string, dan gambar.
        reseps.add(new Resep("Ayam Gulai", getString(R.string.ayamgulai), R.drawable.ayamgulai));
        reseps.add(new Resep("Dendeng", getString(R.string.Dendeng), R.drawable.dendeng));
        reseps.add(new Resep("Ayam Pop", getString(R.string.Ayam_Pop), R.drawable.ayampop));
        reseps.add(new Resep("Ikan Asem Padeh", getString(R.string.Ikan_Asem_Padeh), R.drawable.asampade));
        reseps.add(new Resep("Sate Padang", getString(R.string.Sate_Padang), R.drawable.satepadang));
        reseps.add(new Resep("Rendang", getString(R.string.Rendang), R.drawable.rendang));
        reseps.add(new Resep("Mie Gomak", getString(R.string.Mie_Gomak), R.drawable.miegomak));
        reseps.add(new Resep("Tunjang", getString(R.string.Tunjang), R.drawable.tunjang));

        /// menetapkan objek reseps kedalam Grid Layout dengan 2 kolom
        rMenu.setLayoutManager(new GridLayoutManager(this,2));
        this.setTitle("Ayam Gulai");

    }
}