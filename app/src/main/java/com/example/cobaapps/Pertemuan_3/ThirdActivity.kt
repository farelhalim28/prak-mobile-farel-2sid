package com.example.cobaapps.pertemuan_3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.cobaapps.R
import com.example.cobaapps.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Pakai Binding secara maksimal
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. AKTIFKAN TOOLBAR
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Pertemuan 3"
            setDisplayHomeAsUpEnabled(true)
        }

        // 2. Set onClickListener pakai Binding
        binding.btnKirim.setOnClickListener {
            val noTujuan = binding.inputNoTujuan.text.toString()

            if (noTujuan.isNotEmpty()) {
                Toast.makeText(
                    this, "Pesan berhasil dikirim ke $noTujuan", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, ThirdResultActivity::class.java)
                // Kalau mau kirim data ke halaman sebelah, tambahin ini:
                intent.putExtra("nomor", noTujuan)
                startActivity(intent)
            } else {
                binding.inputNoTujuan.error = "Nomor tidak boleh kosong!"
            }
        }
    }

    // Biar tombol back di toolbar jalan
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}