package com.example.cse225_notes.unit_2

import android.content.BroadcastReceiver
import android.content.Context

import android.content.Intent
import android.media.MediaPlayer


import android.util.Log
import android.widget.Toast
import com.example.cse225_notes.R

class AlarmManagerBroadcast : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        var mp = MediaPlayer.create(context, R.raw.alarm)
        Log.d("Hello", "repeating alarm")
        mp.start()
        Toast.makeText(context, "Alarm Ringing", Toast.LENGTH_LONG).show()
    }
}