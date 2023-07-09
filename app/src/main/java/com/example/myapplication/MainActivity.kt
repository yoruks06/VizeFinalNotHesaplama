package com.example.myapplication

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnHesapla = findViewById<Button>(R.id.btnHesapla)
        val etVize = findViewById<EditText>(R.id.etVize)
        val etVizeAgirlik = findViewById<EditText>(R.id.etVizeAgirlik)
        val etOdev = findViewById<EditText>(R.id.etOdev)
        val etOdevAgirlik = findViewById<EditText>(R.id.etOdevAgirlik)
        val etYilSonu = findViewById<EditText>(R.id.etYilSonu)
        val yilSonuAgirlik = findViewById<EditText>(R.id.etYilSonuAgirlik)

        btnHesapla.setOnClickListener {
            val vize = etVize.text.toString().toDoubleOrNull()
            val vizeAgirlik = etVizeAgirlik.text.toString().toDoubleOrNull()
            val odev = etOdev.text.toString().toDoubleOrNull()
            val odevAgirlik = etOdevAgirlik.text.toString().toDoubleOrNull()
            val yilSonu = etYilSonu.text.toString().toDoubleOrNull()
            val yilSonuAgirlik = yilSonuAgirlik.text.toString().toDoubleOrNull()

            if (vize == null || vizeAgirlik == null || odev == null || odevAgirlik == null || yilSonu == null || yilSonuAgirlik == null) {
                Toast.makeText(this, "Tüm alanları doldurunuz", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (vize !in 0.0..100.0 || vizeAgirlik !in 0.0..100.0 || odev !in 0.0..100.0 || odevAgirlik !in 0.0..100.0 || yilSonu !in 0.0..100.0 || yilSonuAgirlik !in 0.0..100.0) {
                Toast.makeText(this, "Notlar 0-100 arasında olmalıdır", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (vizeAgirlik + odevAgirlik + yilSonuAgirlik != 100.0) {
                Toast.makeText(this, "Ağırlıkların toplamı 100 olmalıdır", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(etVizeAgirlik==null ||etOdevAgirlik==null ||yilSonuAgirlik==null)
            {
                val  vize=20.toString().toIntOrNull()
                val  odev=20.toString().toIntOrNull()
                val  yilSonu=60.toString().toIntOrNull()

                return@setOnClickListener
            }

            val gecmeNotu = (vize * vizeAgirlik / 100) + (odev * odevAgirlik / 100) + (yilSonu * yilSonuAgirlik / 100)
            val harfNotu = when {
                gecmeNotu >= 90 -> "AA"
                gecmeNotu >= 85 -> "BA"
                gecmeNotu >= 80 -> "BB"
                gecmeNotu >= 75 -> "CB"
                gecmeNotu >= 70 -> "CC"
                gecmeNotu >= 65 -> "DC"
                gecmeNotu >= 60 -> "DD"
                else -> "FF"
            }

            val sonuc = "Geçme Notu: $gecmeNotu, Harf Notu: $harfNotu"
            Toast.makeText(this, sonuc, Toast.LENGTH_LONG).show()
        }
    }
}
