package com.example.cobaapps.pertemuan_2 // Pastikan folder/package-nya kecil semua

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cobaapps.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Pertemuan 2"
            setDisplayHomeAsUpEnabled(true)
        }

        // Pakai binding.main agar sinkron dengan ID di XML lu
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnSubmit.setOnClickListener {
            val nama = binding.inputNama.text.toString()
            Log.e("Klik btnSubmit", "Tombol ditekan. Nama: $nama")

            if (nama.isNotEmpty()) {
                Toast.makeText(this, "Halo $nama, Voucher berhasil diklaim!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Silahkan isi nama dulu bro!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}