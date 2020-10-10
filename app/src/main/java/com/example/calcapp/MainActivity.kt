package com.example.calcapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import kotlinx.android.synthetic.main.activity_main.*
import android.support.design.widget.Snackbar
import android.util.Log

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addButton.setOnClickListener(this)
        mulButton.setOnClickListener(this)
        subButton.setOnClickListener(this)
        divButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent = Intent(this, SecondActivity::class.java)

        try {
            val value1:Double = editText1.text.toString().toDouble()
            val value2:Double = editText2.text.toString().toDouble()
            var answer:Double = 0.0

            if(v?.id == R.id.addButton) {
                answer = value1 + value2
            } else if (v?.id == R.id.mulButton) {
                answer = value1 - value2
            } else if (v?.id == R.id.subButton) {
                answer = value1 * value2
            } else if (v?.id == R.id.divButton) {
                answer = value1 / value2
            }
            intent.putExtra("ANSWER", answer)
            startActivity(intent)

        } catch (e: Exception) {
            Snackbar.make(findViewById(android.R.id.content), "数値を入力してください", Snackbar.LENGTH_INDEFINITE)
                .setAction("閉じる") {
                }.show()

        }
    }
}
