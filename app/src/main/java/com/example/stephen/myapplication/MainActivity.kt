package com.example.stephen.myapplication

import android.app.Activity
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.stephen.myapplication.adapter.ForecastListAdatper
import com.example.stephen.myapplication.date.ForecastResult
import com.example.stephen.myapplication.domain.Command
import com.example.stephen.myapplication.domain.ForecastList
import com.example.stephen.myapplication.eneity.Person
import com.google.gson.Gson
import java.net.URL
import java.util.*
import kotlin.collections.ArrayList

//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val items = listOf(
        "Mon 6/23 - Sunny - 31/17",
        "Tue 6/24 - Foggy - 21/8",
        "Wed 6/25 - Cloudy - 22/17",
        "Thurs 6/26 - Rainy - 18/11",
        "Fri 6/27 - Foggy - 21/10",
        "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
        "Sun 6/29 - Sunny - 20/7"
    )

    private lateinit var forecastList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        forecastList = findViewById<RecyclerView>(R.id.forecast_list) as RecyclerView
//        val forecastList: RecyclerView = findViewById()
        forecastList.layoutManager = LinearLayoutManager(this)
//        forecastList.adapter = ForecastListAdatper(items)
        //message.text = "Hello Kotlin!"

//        val person = Person()
//        person.name = "name"
//        val name = person.name

        toast("Hello world!", Toast.LENGTH_LONG)

        val f1 = Forecast(Date(), 27.6f, "Sunny")
        val f2 = f1.copy(temperature = 30.0f)

        val (date, temperature, details) = f1

        for ((key, value) in mapOf<String, String>()) {
            Log.d("map", "key:$key, value:$value")
        }

//        val x = myList[1]
//        myList[2] = 4

        val container: ViewGroup = findViewById(R.id.action_container)
        val view = container.getChildAt(2)
    }

    fun add(x: Int, y: Int) : Int {
        return x + y
    }

    fun minus(x: Int, y: Int) : Int = x - y

    fun toast(message: String, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, length).show()
    }

    fun niceToast(message: String,
                  tag: String = javaClass.simpleName,
                  length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, "{$localClassName}$message", length).show()
    }

    fun toastAgain(message: String, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, length).show()
    }

    fun niceToastAgain(message: String,
                       tag: String = javaClass.simpleName,
                       length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, "{$localClassName}$message", length).show()
    }

    fun Context.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, duration).show()
    }

    val i = 12;
    val j: Int = 12
    val d: Double = i.toDouble()
    val c: Char = j.toChar()
    val c2: Char = 'c'
    val i2: Int = c2.toInt()
    val orx = i or j
    val andy = i and j
    val l = 3L

    fun dieDai() {
        val s = "Example"
        val c3 = s[2]
        for(c in s) {
            println(c3)
        }
    }

    val actionbar = supportActionBar
    val a: Any = 23
    val con: Context = this

    public var TextView.text: CharSequence
    get() = getText()
    set(value) = setText(value)

    class Request(val url: String) {
        fun run() {
            val forcastJsonStr = URL(url).readText() // readText kotlin标准库中的扩展函数
            Log.d(javaClass.simpleName, forcastJsonStr)
        }
    }

//    fun async() {
//        Request(url = "").run()
//        runOnUiThread { toast("Request Performed") }
//    }

    data class Forecast(val date: Date, val temperature: Float, val details: String)

    public class ForecastRequest(val zipCode: String) {
        companion object {
            private val app_id = "15646a06818f61f7b8d7823ca833e1ce"
            private val url = "http://api.openweathermap.org/data/2.5/" +
                    "forecast/daily?mode=json&units=metric&cnt=7"
            private val COMPLETE_URL = "$url&APPID=$app_id&q="
        }

        fun execute(): ForecastResult {
            val forecastJsonStr = URL(COMPLETE_URL + zipCode).readText()
            return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
        }
    }

    /*
      TODO 不理解这个地方的行为
     */
    class RequestForecastCommand(val zipCode: String): Command<ForecastList> {
        override fun execute(): ForecastList {
            val forecastRequest = ForecastRequest(zipCode)
            return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
        }

    }

    fun async() {
        val result = RequestForecastCommand("94043").execute()
        runOnUiThread {
            forecastList.adapter = ForecastListAdatper(result)
        }
    }

}
