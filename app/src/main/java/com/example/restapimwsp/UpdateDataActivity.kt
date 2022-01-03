package com.example.restapimwsp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.example.restapimwsp.api.response.ApiConfig
import com.example.restapimwsp.api.response.Inresponse.ParticipantResponse
import com.example.restapimwsp.api.response.Inresponse.UpdateResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateDataActivity : AppCompatActivity() {
    private val mainAdapter = MainAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_data)
        val iNim= findViewById<EditText>(R.id.Enim)
        val iNama= findViewById<EditText>(R.id.Enama)
        val iprodi = findViewById<Spinner>(R.id.sp_prodi)
        val iGender =findViewById<RadioGroup>(R.id.inGender)
        val btnsmbt= findViewById<Button>(R.id.btnsubmit)

        var nim = intent.getStringExtra("Key_Nim")
        var name = intent.getStringExtra("Key_Nama")
        var prodi = intent.getStringExtra("Key_Kampus")
        var gender = intent.getStringExtra("Key_Gender")

        iNim.setText(nim)
        iNama.setText(name)

        btnsmbt.setOnClickListener {

            var nim = iNim.text.toString()
            var nama = iNama.text.toString()
            var prodi =iprodi.selectedItem.toString()
            var intSelectGender : Int =iGender.checkedRadioButtonId
            var rbGender = findViewById<RadioButton>(intSelectGender)
            var gender = rbGender.text.toString()

            updateData(
//                id=5,
                nim = nim,
                nama = nama,
                jenisKelamin = gender,
                prodi = prodi
            )
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    private fun updateData(
//        id : Int,
        nim: String,
        nama: String,
        jenisKelamin: String,
        prodi: String
    ){
        val client = ApiConfig.getService().updateWebinar(nim,nama,jenisKelamin,prodi)
        client.enqueue(object : Callback<UpdateResponse> {
            override fun onResponse(
                call: Call<UpdateResponse>,
                response: Response<UpdateResponse>
            ) {
                Log.e(MainActivity.TAG, response.body().toString())
            }

            override fun onFailure(call: Call<UpdateResponse>, t: Throwable) {
                Log.e(MainActivity.TAG, "onFailure: ${t.message}")
            }
        })
    }

}