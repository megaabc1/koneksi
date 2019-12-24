package com.lepji.koneksidatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private val listFakultas = ArrayList<FakultasModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ryFakultas.layoutManager = LinearLayoutManager(this)
        ryFakultas.setHasFixedSize(true)

        AndroidNetworking.get(ApiEndPoint.SELECT)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object: JSONObjectRequestListener{
                override fun onResponse(response: JSONObject?) {
                    listFakultas.clear()
                    val daftarFakultas = response?.optJSONArray("result")
                    for(i in 0 until daftarFakultas?.length()!!){
                        val tiapFakultas = daftarFakultas.optJSONObject(i)
                        val model = FakultasModel(tiapFakultas.getInt("id_fakultas"),
                            tiapFakultas.getString("kode_fakultas"),
                            tiapFakultas.getString("nama_fakultas"))

                        listFakultas.add(model)

                        if(daftarFakultas.length()-1 == i){
                            val adapter = FakultasAdapter(this@MainActivity, listFakultas)

                            ryFakultas.adapter = adapter
                        }

                    }
                }

                override fun onError(anError: ANError?) {
                    Log.d("Error", anError?.errorDetail.toString())
                    Toast.makeText(this@MainActivity,
                        "Connection Failure", Toast.LENGTH_SHORT).show()
                }

            })
    }
}
