package com.torsunov.revive

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.google.android.gms.wearable.DataClient
import com.torsunov.revive.data.DataRepo
import com.torsunov.revive.data.WearMessageListenerService
import com.torsunov.revive.ui.theme.Test_android_wearTheme

class MainActivity : ComponentActivity() {
    private lateinit var dataClient: DataClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startService(Intent(this, WearMessageListenerService::class.java))
        setContent {
            Test_android_wearTheme {
                val data = DataRepo.data.collectAsState().value
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ){
                    Text(data)
                }
            }
        }
    }
}

