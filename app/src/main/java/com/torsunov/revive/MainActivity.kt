package com.torsunov.revive

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.google.android.gms.wearable.DataClient
import com.torsunov.revive.data.WearMessageListenerService
import com.torsunov.revive.ui.theme.Test_android_wearTheme

class MainActivity : ComponentActivity() {
    private lateinit var dataClient: DataClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startService(Intent(this, WearMessageListenerService::class.java))
        setContent {
            Test_android_wearTheme {

            }
        }
    }
}

