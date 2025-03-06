package com.torsunov.revive.data

import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.google.android.gms.wearable.Channel
import com.google.android.gms.wearable.DataEventBuffer

import com.google.android.gms.wearable.MessageEvent
import com.google.android.gms.wearable.Node
import com.google.android.gms.wearable.WearableListenerService
import com.torsunov.revive.MainActivity

class WearMessageListenerService : WearableListenerService() {

    override fun onCreate() {
        super.onCreate()
        Log.d("WearOS123", "Service created")
        Toast.makeText(this, "Сервис запущен", Toast.LENGTH_LONG).show()
    }


    override fun onMessageReceived(messageEvent: MessageEvent) {
        Log.d("WearOS123", "Получен запрос на открытие приложения")
        if (messageEvent.path == "/revive") {
            // Открываем приложение на телефоне
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            Log.d("WearOS123", "Получен запрос на открытие приложения")
            Toast.makeText(this, "Получен запрос на открытие приложения", Toast.LENGTH_LONG).show()
        }
    }
}