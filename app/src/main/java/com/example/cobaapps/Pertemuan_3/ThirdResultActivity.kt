package com.example.cobaapps.pertemuan_3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cobaapps.R
import com.example.cobaapps.databinding.ActivityThirdResultBinding // Pastikan Binding-nya benar

class ThirdResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // 1. Inisialisasi Binding
        binding = ActivityThirdResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 2. Aktifkan Toolbar
        setSupportActionBar(binding.toolbarResult)
        supportActionBar?.apply {
            title = "Hasil Pengiriman"
            setDisplayHomeAsUpEnabled(true)
        }

        // 3. Handle padding buat status bar
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // Fungsi biar panah back di pojok kiri atas bisa diklik balik ke ThirdActivity
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}