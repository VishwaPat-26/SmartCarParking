package com.example.smartcarparking

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chatbot.data.message
import com.example.chatbot.utils.BotResponse
import com.example.chatbot.utils.Time
import com.example.chatbot.utils.constants
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.coroutines.*

class MainActivity2 : AppCompatActivity() {
    private val TAG = "MainActivity2"

    //You can ignore this messageList if you're coming from the tutorial,
    // it was used only for my personal debugging
    var messagesList = mutableListOf<message>()

    private lateinit var adapter: messagingadapter
    private val botList = listOf("Vishwa")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        setContentView(R.layout.activity_main)
        recyclerView()

        clickEvents()

        val random = (0..3).random()
        customBotMessage("Hello! Today you're speaking with ${botList[random]}, how may I help?")
    }
    private fun clickEvents() {

        //Send a message
        btn_send.setOnClickListener {
            sendMessage()
        }

        //Scroll back to correct position when user clicks on text view
        et_message.setOnClickListener {
            GlobalScope.launch {
                delay(100)

                withContext(Dispatchers.Main) {
                    rv_messages.scrollToPosition(adapter.itemCount - 1)

                }
            }
        }
    }
    private fun recyclerView() {
        adapter = messagingadapter()
        rv_messages.adapter = adapter
        rv_messages.layoutManager = LinearLayoutManager(applicationContext)

    }

    override fun onStart() {
        super.onStart()
        //In case there are messages, scroll to bottom when re-opening app
        GlobalScope.launch {
            delay(100)
            withContext(Dispatchers.Main) {
                rv_messages.scrollToPosition(adapter.itemCount - 1)
            }
        }
    }

    private fun sendMessage() {
        val message = et_message.text.toString()
        val timeStamp = Time.timeStamp()

        if (message.isNotEmpty()) {
            //Adds it to our local list
            messagesList.add(message(message, constants.SEND_ID, timeStamp))
            et_message.setText("")

            adapter.insertMessage(message(message, constants.SEND_ID, timeStamp))
            rv_messages.scrollToPosition(adapter.itemCount - 1)

            botResponse(message)
        }
    }

    private fun botResponse(message: String) {
        val timeStamp = Time.timeStamp()

        GlobalScope.launch {
            //Fake response delay
            delay(1000)

            withContext(Dispatchers.Main) {
                //Gets the response
                val response = BotResponse.basicResponses(message)

                //Adds it to our local list
                messagesList.add(message(response, constants.RECEIVE_ID, timeStamp))

                //Inserts our message into the adapter
                adapter.insertMessage(message(response, constants.RECEIVE_ID, timeStamp))

                //Scrolls us to the position of the latest message
                rv_messages.scrollToPosition(adapter.itemCount - 1)

                //Starts Google
                when (response) {
                    constants.OPEN_GOOGLE -> {
                        val site = Intent(Intent.ACTION_VIEW)
                        site.data = Uri.parse("https://www.google.com/")
                        startActivity(site)
                    }
                    constants.OPEN_SEARCH -> {
                        val site = Intent(Intent.ACTION_VIEW)
                        val searchTerm: String? = message.substringAfterLast("search")
                        site.data = Uri.parse("https://www.google.com/search?&q=$searchTerm")
                        startActivity(site)
                    }

                }
            }
        }
    }

    private fun customBotMessage(message: String) {

        GlobalScope.launch {
            delay(1000)
            withContext(Dispatchers.Main) {
                val timeStamp = Time.timeStamp()
                messagesList.add(message(message, constants.RECEIVE_ID, timeStamp))
                adapter.insertMessage(message(message, constants.RECEIVE_ID, timeStamp))

                rv_messages.scrollToPosition(adapter.itemCount - 1)
            }
        }
    }
}