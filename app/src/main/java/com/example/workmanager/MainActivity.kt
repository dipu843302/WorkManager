package com.example.workmanager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.work.*
import com.example.workmanager.WorkerRequest.Companion.cancelWorkRequest
import com.example.workmanager.WorkerRequest.Companion.setWorkerRequest
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
          setWorkerRequest()
        }

        button2.setOnClickListener {
           cancelWorkRequest()
        }
    }

}
