package com.alamin.kotlincoroutine

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

class MainActivity : AppCompatActivity() {
    @BindView(R.id.btnCount)
    lateinit var btnCount:Button;
    @BindView(R.id.btnDownloadUserData)
    lateinit var btnDownloadUserData:Button;
    @BindView(R.id.tvCount)
    lateinit var tvCount:TextView;
    @BindView(R.id.tvUserMessage)
    lateinit var tvUserMessage:TextView;

   /* @BindView(R.id.statusButton)
    lateinit var btnStatus:Button;
    @BindView(R.id.cancelButton)
    lateinit var btnCancel:Button;
    @BindView(R.id.textView)
    lateinit var textView:TextView;*/

    private var count = 0
    private var TAG : String = "MainActivity";
    private lateinit var job1 : Job;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this);

      /*   btnCount.setOnClickListener {
          tvCount.text = count++.toString()
      }
      btnDownloadUserData.setOnClickListener {
          CoroutineScope(Dispatchers.Main).launch {
              tvUserMessage.text = UserDataManager().getUserCount().toString();
          }
      }*/

       /* btnCount.setOnClickListener {
            tvCount.text = count++.toString()
        }
        btnDownloadUserData.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                downloadUserData();
            }
        }*/

  /*  CoroutineScope(Main).launch {
        Log.i(TAG,"Calculation Started")

        val  stock1 = async(IO) {
            getStockOne();
        }
        Log.i(TAG,"Second Calculation Started")
        val  stock2 = async (IO) {
            getStockTwo();
        }

        val total = stock1.await()+stock2.await();
        Toast.makeText(applicationContext,"Total is $total",Toast.LENGTH_SHORT).show();
        Log.i(TAG,"Total is $total")
    }*/

     /*  job1 =  CoroutineScope(Main).launch {
           downloadData()
        }

        btnCancel.setOnClickListener {
            job1.cancel();
        }
        btnStatus.setOnClickListener {
            if (job1.isActive){
                textView.text = "Active"
            }else if (job1.isCancelled){
                textView.text = "Cancelled"
            }else if (job1.isCompleted){
                textView.text = "Completed"
            }

        }
*/
    }

    private suspend fun downloadData (){
        withContext(IO){
            repeat(30){
                delay(1000)
                Log.i(TAG, "downloadData: $it")
            }
        }
    }

    private suspend fun getStockOne():Int{
        delay(10000)
        Log.i(TAG, "Stock 1 Returned")
        return 5500;
    }

    private suspend fun getStockTwo():Int{
        delay(8000)
        Log.i(TAG, "Stock 2 Returned")
        return 3500;
    }


    private suspend fun downloadUserData() {
        for (i in 1..200000) {
          //  Log.i("MyTag", "Downloading user $i in ${Thread.currentThread().name}")
           withContext(Dispatchers.Main){
               //tvUserMessage.text = "Downloading Data $i"
           }
            delay(1000)
        }
    }
}