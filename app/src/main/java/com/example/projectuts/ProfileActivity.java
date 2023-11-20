package com.example.projectuts;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projectuts.R;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Panggil metode untuk menginisialisasi profil
        initializeProfile();

        // Inisialisasi arrowBackImageView dan menangani klik tombol kembali
        ImageView arrowBackImageView = findViewById(R.id.arrowBackImageView);
        arrowBackImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void initializeProfile() {
        // Inisialisasi komponen UI dari layout
        ImageView profileImage = findViewById(R.id.profileImage);
        TextView usernameTextView = findViewById(R.id.usernameTextView);

        // Set nilai-nilai profil sesuai kebutuhan
        profileImage.setImageResource(R.drawable.duo); // Ganti dengan sumber gambar profil Anda
    }
}

