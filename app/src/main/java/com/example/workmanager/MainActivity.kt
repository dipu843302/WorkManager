package com.example.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.work.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            setOneTimeWorkerRequest()
        }
    }

    private fun setOneTimeWorkerRequest() {
        val workManager: WorkManager = WorkManager.getInstance(applicationContext)

        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresCharging(true)
            .build()

        val filtering=OneTimeWorkRequest.Builder(Filtering::class.java)
            .build()

        val compressing=OneTimeWorkRequest.Builder(Compressing::class.java).setInitialDelay(5000,TimeUnit.MILLISECONDS)
            .build()

        val uploadRequest: OneTimeWorkRequest = OneTimeWorkRequest.Builder(UploadWorker::class.java).setInitialDelay(5000,TimeUnit.MILLISECONDS)
           // .setConstraints(constraints)
            .build()

        workManager.enqueue(uploadRequest)

        workManager.getWorkInfoByIdLiveData(uploadRequest.id)
            .observe(this, Observer {
                textView.text = it.state.name
            })
    }
}
