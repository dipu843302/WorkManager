package com.example.workmanager

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.text.SimpleDateFormat
import java.util.*

class UploadWorker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {

    @SuppressLint("SimpleDateFormat")
    override fun doWork(): Result {
        return try {
            for (i in 0..100) {
                Log.i("MYTAG", "Uploading $i")
            }
            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }
}