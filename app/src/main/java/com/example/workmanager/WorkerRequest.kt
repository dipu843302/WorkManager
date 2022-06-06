package com.example.workmanager

import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkManager.getInstance
import java.util.concurrent.TimeUnit

class WorkerRequest {
    companion object {
        private lateinit var uploadRequest: OneTimeWorkRequest
        fun setWorkerRequest() {
            uploadRequest = OneTimeWorkRequest.Builder(UploadWorker::class.java)
                .setInitialDelay(15000, TimeUnit.MILLISECONDS).build()
            val workManager: WorkManager = getInstance()
            workManager.enqueue(uploadRequest)
        }

        fun cancelWorkRequest() {
            WorkManager.getInstance().cancelWorkById(uploadRequest.id)
        }
    }
}