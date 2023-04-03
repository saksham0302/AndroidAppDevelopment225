package com.example.cse225_notes.unit_2

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.cse225_notes.R

class JobSchedulerExample : AppCompatActivity() {
    var jobScheduler: JobScheduler? = null

    //@SuppressLint("ServiceCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_scheduler_example)
        val stopJob = findViewById<Button>(R.id.stopJob)
        val startJob = findViewById<Button>(R.id.startJob)

        startJob.setOnClickListener {
            jobScheduler = getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler
            val componentName = ComponentName(this, MyJobService::class.java)
            val builder = JobInfo.Builder(123, componentName)
            builder.setMinimumLatency(1000)
            builder.setOverrideDeadline(3000)
            builder.setPersisted(true)
            builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
            builder.setRequiresCharging(false)
            jobScheduler!!.schedule(builder.build())
        }

        stopJob.setOnClickListener {
            if (jobScheduler != null) {
                jobScheduler!!.cancel(123)
                jobScheduler = null
                Toast.makeText(this, "Job Cancelled", Toast.LENGTH_SHORT).show()
            }

        }
    }
}