package com.torsunov.revive.data

import kotlinx.coroutines.flow.MutableStateFlow

object DataRepo {
    val data = MutableStateFlow<String>("")
}