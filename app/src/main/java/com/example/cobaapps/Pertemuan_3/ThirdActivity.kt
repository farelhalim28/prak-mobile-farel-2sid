package com.example.cobaapps.Pertemuan_3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import com.example.cobaapps.R
import com.example.cobaapps.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

        private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inisialisasi komponen
        val btnKirim = findViewById<Button>(R.id.btnKirim)
        val inputNoTujuan = findViewById<EditText>(R.id.inputNoTujuan)

        // Set onClickListener
        binding.btnKirim.setOnClickListener {

            val noTujuan = binding.inputNoTujuan.text.toString()

            Toast.makeText(
                this, "Pesan berhasil dikirim ke $noTujuan", Toast.LENGTH_SHORT).show()
        }
    }
}