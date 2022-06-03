package com.example.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import kotlin.contracts.Returns
import kotlin.math.log

class Filtering(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    override fun doWork(): Result {
        return try {
            for (i in 0..5){
                Log.d("MYTAG","filtering $i")
            }
            Result.success()
        }catch (e:Exception){
            Result.failure()
        }
    }

}