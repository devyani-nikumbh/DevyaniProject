package com.example.devyaniproject.myDemo.coroutines

import android.util.Log
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/*// Kotlin Program For better understanding of launch
@OptIn(DelicateCoroutinesApi::class)
fun GFG() {
    var resultOne = "Android"
    var resultTwo = "Kotlin"
    Log.i("Launch", "Before")
    GlobalScope.launch(Dispatchers.IO) { resultOne = function1() }
    GlobalScope.launch(Dispatchers.IO) { resultTwo = function2() }
    Log.i("Launch", "After")
    val resultText = resultOne + resultTwo
    Log.i("Launch", resultText)
}

suspend fun function1(): String {
    delay(1000L)
    val message = "function1"
    Log.i("Launch", message)
    return message
}

suspend fun function2(): String {
    delay(100L)
    val message = "function2"
    Log.i("Launch", message)
    return message
}

fun main (args:Array<String>){
    GFG()
}*/


// kotlin program for demonstration of async
suspend fun GFG()
{
    Log.i("Async", "Before")
    val resultOne = GlobalScope.async(Dispatchers.IO) { function1() }
    val resultTwo = GlobalScope.async(Dispatchers.IO) { function2() }
    Log.i("Async", "After")
    val resultText = resultOne.await() + resultTwo.await()
    Log.i("Async", resultText)
}

suspend fun function1(): String
{
    delay(1000L)
    val message = "function1"
    Log.i("Async", message)
    return message
}

suspend fun function2(): String
{
    delay(100L)
    val message = "function2"
    Log.i("Async", message)
    return message
}


