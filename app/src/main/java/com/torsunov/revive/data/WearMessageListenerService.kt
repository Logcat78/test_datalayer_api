package com.torsunov.revive.data

import android.content.Intent
import android.util.Log
import com.google.android.gms.wearable.MessageEvent
import com.google.android.gms.wearable.WearableListenerService
import com.torsunov.revive.MainActivity

class WearMessageListenerService : WearableListenerService() {
    private val tag = "DataLayerReviveApp" // Вставь его как фильтр в логкет

    override fun onCreate() {
        super.onCreate()
    }

    //Коллбек для получения сообщений
    override fun onMessageReceived(messageEvent: MessageEvent) {
        Log.d(tag, "Event received")
        //Указываем путь, как на часах
        if (messageEvent.path == "/revive") {
            // Сообщения приходят в виде байтов, поэтому декодируем их в строку
            val data = messageEvent.data.decodeToString()
            // Помещаем сообщение в флоу
            DataRepo.data.value = data
            Log.d(tag, data)
            // Открываем приложение
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
    }
}