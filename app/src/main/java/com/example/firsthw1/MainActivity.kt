package com.example.firsthw1

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView

//MainActivity.kt
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    private fun retrofitWork() {

        RetrofitClass.getInstance()?.getBitResponse("bpi")
            ?.enqueue(object : retrofit2.Callback<BitResponse> {
                override fun onResponse(
                    call: retrofit2.Call<BitResponse>,
                    response: retrofit2.Response<BitResponse>
                ) {

                    var txt1 = findViewById<TextView>(R.id.txt)

                    if (response.isSuccessful) {
                        // 정상적으로 통신이 성고된 경우
                        var result: BitResponse? = response.body()
                        Log.d("cm", "onResponse2 성공: " + result?.toString());
                        txt1.setText(result.toString())

                    } else {
                        // 통신이 실패한 경우(응답코드 3xx, 4xx 등)
                        Log.d("cm", "onResponse2 실패")
                    }
                }

                override fun onFailure(call: retrofit2.Call<BitResponse>, t: Throwable) {
                    // 통신 실패 (인터넷 끊킴, 예외 발생 등 시스템적인 이유)
                    Log.d("cm", "onFailure2 에러: " + t.message.toString());
                }
            })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        var mInflater = menuInflater
        mInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.i(ContentValues.TAG,"onOptionsItemSelected()가 실행됨.")

        val textView: TextView = findViewById(R.id.txt)

        when(item.itemId) {
            R.id.action_load -> retrofitWork()
        }
        return super.onOptionsItemSelected(item)
    }


}