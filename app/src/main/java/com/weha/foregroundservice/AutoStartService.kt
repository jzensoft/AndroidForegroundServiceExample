package com.weha.foregroundservice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AutoStartService : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        p0?.let {
            ForegroundService.startService(it, "Foreground Service is running...")
        }
    }
}