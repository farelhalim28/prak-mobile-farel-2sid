package com.example.cobaapps

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cobaapps.pertemuan_2.SecondActivity
import com.example.cobaapps.pertemuan_3.ThirdActivity
import com.example.cobaapps.pertemuan_4.FourthActivity
import com.example.cobaapps.pertemuan_5.FifthActivity
import com.example.cobaapps.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // PERBAIKAN: Menggunakan binding.main (sesuai ID di XML lu)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // --- TOMBOL KE PERTEMUAN 2 ---
        binding.btnKedua.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        // --- TOMBOL KE PERTEMUAN 3 ---
        binding.btnKetiga.setOnClickListener {
            startActivity(Intent(this, ThirdActivity::class.java))
        }

        // --- TOMBOL KE PERTEMUAN 4 ---
        binding.btnKeempat.setOnClickListener {
            val intent = Intent(this, FourthActivity::class.java)
            intent.putExtra("nama", "Politeknik Caltex Riau")
            intent.putExtra("asal", "Rumbai")
            intent.putExtra("usia", 25)
            startActivity(intent)
        }

        // --- TOMBOL KE PERTEMUAN 5 ---
        binding.btnKelima.setOnClickListener {
            startActivity(Intent(this, FifthActivity::class.java))
        }
    }
}