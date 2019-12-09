package com.example.mvvmlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        callApi()
    }

    private fun callApi() {
        val url = "api.openweathermap.org/data/2.5/weather"
        val requestParam = JSONObject()
        requestParam.put("Id", 123)
        requestParam.put("email", "dd@gmail.com")

        val request = Volley.newRequestQueue(this)

        val requestJson = object:JsonObjectRequest(Request.Method.POST, url, requestParam,
            Response.Listener<JSONObject> {
                val data=JSONObject()
                Log.e("Heandle Response","success")

            },

            Response.ErrorListener {
                Log.e("Heandle Response","Failed "+it)
                Toast.makeText(this,it.toString(),Toast.LENGTH_LONG).show()
            }){

            override fun getHeaders(): MutableMap<String, String> {
                val header=HashMap<String,String>()
                header.put("Authentication","dsds");
                return header
            }
        }
        request.add(requestJson)
    }
}
