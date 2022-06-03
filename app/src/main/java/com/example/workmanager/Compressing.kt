package com.example.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class Compressing(context: Context, workerParams: WorkerParameters) :Worker(context, workerParams) {
    override fun doWork(): Result {
       return try {
           for (i in 0..5){
               Log.d("MYTAG","Compressing $i")
           }
           return Result.success()
       }catch (e:Exception){
           return Result.failure()
       }
    }
}