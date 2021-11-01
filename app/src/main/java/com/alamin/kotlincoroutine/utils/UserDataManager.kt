package com.alamin.kotlincoroutine.utils

import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO

class UserDataManager {
    var count = 0;
    lateinit var differed : Deferred<Int> ;
    suspend fun getUserCount():Int{
        coroutineScope {
            launch (IO) {
                delay(1000)
                count = 50;
            }

             differed = async {
                delay(3000)
                return@async 70;
            }
        }
        return count+differed.await();

    }
}