package com.example.svetofor

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import java.util.*

class MainActivity : Activity() {
    private var imageView: ImageView? = null
    private var imageButton: ImageButton? = null
    private var arraySvetofor: IntArray =
        intArrayOf(R.drawable.semafor_red, R.drawable.semafor_yellow, R.drawable.semafor_green)
    private var run: Boolean = false
    private var timer: Timer? = null
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView = findViewById(R.id.imageView)
    }

    fun onClickListener(view: View) {
        view as ImageButton
        if (!run) {
            counter = 0
            imageView?.setImageResource(R.drawable.semafor_grey)
            view.setImageResource(R.drawable.button_stop)
            startStop()
            run = true
        } else {
            run = false
            imageView?.setImageResource(R.drawable.semafor_grey)
            view.setImageResource(R.drawable.button_start)
            timer?.cancel()
        }
    }

    fun startStop() {
        timer = Timer()
        timer?.schedule(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    imageView?.setImageResource(arraySvetofor[counter])
                    counter++
                    if (counter == 3) counter = 0
                }
            }
        }, 0, 300)
    }
}

