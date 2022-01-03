package com.example.restapimwsp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.example.restapimwsp.api.response.ApiConfig
import com.example.restapimwsp.api.response.Inresponse.InStatustResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InsertDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_data)
        val iNim= findViewById<EditText>(R.id.Enim)
        val iNama= findViewById<EditText>(R.id.Enama)
        val iprodi = findViewById<Spinner>(R.id.sp_prodi)
        val iGender =findViewById<RadioGroup>(R.id.inGender)
        val btnsmbt= findViewById<Button>(R.id.btnsubmit)

        btnsmbt.setOnClickListener {
            var nim = iNim.text.toString()
            var nama = iNama.text.toString()
            var prodi =iprodi.selectedItem.toString()
            var intSelectGender : Int =iGender.checkedRadioButtonId
            var rbGender = findViewById<RadioButton>(intSelectGender)
            var gender = rbGender.text.toString()
            insertData(
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

//    public data class data

    private fun insertData(
        nim: String,
        nama: String,
        jenisKelamin: String,
        prodi: String
    ){
        val client = ApiConfig.getService().insertWebinar(nim,nama,jenisKelamin,prodi)
        client.enqueue(object : Callback<InStatustResponse> {
            override fun onResponse(
                call: Call<InStatustResponse>,
                response: Response<InStatustResponse>
            ) {
                Log.e(MainActivity.TAG, response.body().toString())
            }

            override fun onFailure(call: Call<InStatustResponse>, t: Throwable) {
                Log.e(MainActivity.TAG, "onFailure: ${t.message}")
            }
        })
    }

}