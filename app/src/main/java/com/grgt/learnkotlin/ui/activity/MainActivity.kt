package com.grgt.learnkotlin.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.UiThread
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.grgt.learnkotlin.ui.adapter.ForecastListAdapter
import com.grgt.learnkotlin.R
import com.grgt.learnkotlin.data.server.ForecastRequest
import com.grgt.learnkotlin.data.server.ForecastResult
import com.grgt.learnkotlin.domain.commands.RequestForecastCommand
import com.grgt.learnkotlin.domain.model.Forecast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_forecast.view.*
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        forecast_list.layoutManager = LinearLayoutManager(this)
        doAsync{
            Log.i("tag","start")
            val result = RequestForecastCommand(94043).execute()
            Log.i("tag", result.toString())
            uiThread {
//                forecast_list.adapter = ForecastListAdapter(result,
//                    object : ForecastListAdapter.OnItemClickListener{
//                        override fun invoke(forecast: Forecast) {
//                            toast(forecast.date.toString())
//                        }
//                    })}
                forecast_list.adapter = ForecastListAdapter(result){
                    forecast -> toast(forecast.date.toString())
                }
            }


        }

    }
}
