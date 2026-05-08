package com.example.cobaapps.Home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.cobaapps.AuthActivity
import com.example.cobaapps.Home.Pertemuan_7.SeventhActivity
import com.example.cobaapps.Home.pertemuan_2.SecondActivity
import com.example.cobaapps.R
import com.example.cobaapps.databinding.FragmentHomeBinding
import com.example.cobaapps.pertemuan_3.ThirdActivity
import com.example.cobaapps.pertemuan_4.FourthActivity
import com.example.cobaapps.pertemuan_5.FifthActivity

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Home"
        }

        binding.btnKedua.setOnClickListener {
            startActivity(Intent(requireContext(), SecondActivity::class.java))
        }

        binding.btnKetiga.setOnClickListener {
            startActivity(Intent(requireContext(), ThirdActivity::class.java))
        }

        binding.btnKeempat.setOnClickListener {
            val intent = Intent(requireContext(), FourthActivity::class.java)
            intent.putExtra("nama", "Politeknik Caltex Riau")
            intent.putExtra("asal", "Rumbai")
            intent.putExtra("usia", 25)
            startActivity(intent)
        }

        binding.btnKelima.setOnClickListener {
            startActivity(Intent(requireContext(), FifthActivity::class.java))
        }

        binding.btnKetujuh.setOnClickListener {
            startActivity(Intent(requireContext(), SeventhActivity::class.java))
        }


        // =========================
        // LOGOUT FIX MODUL
        // =========================
        binding.btnLogout.setOnClickListener {

            AlertDialog.Builder(requireContext())
                .setTitle("Logout")
                .setMessage("Apakah Anda yakin ingin logout?")
                .setPositiveButton("Ya") { _, _ ->

                    val sharedPref = requireContext().getSharedPreferences("user_pref", MODE_PRIVATE)
                    sharedPref.edit().clear().apply()

                    startActivity(Intent(requireContext(), AuthActivity::class.java))
                    requireActivity().finish()
                }
                .setNegativeButton("Batal", null)
                .show()
        }
    }
    }


