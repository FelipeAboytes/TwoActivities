package com.example.felipeaboytes.twoactivities

import android.app.Activity
import android.app.PendingIntent
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var EXTRA_MESSAGE: String = "com.example.felipeaboytes.twoactivities.extra.MESSAGE"
    // EditText view for the message
    private var mMessageEditText: EditText? = null
    private var mReplyHeadTextView: TextView? = null
    private var mReplyTextView: TextView? = null
    private val LOG_TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize all the view variables.
        mMessageEditText = findViewById(R.id.editText_main) as EditText
        mReplyHeadTextView = findViewById(R.id.text_header_reply) as TextView
        mReplyTextView = findViewById(R.id.text_message_reply) as TextView
    }

    fun launchSecondActivity(v: View){
          Log.d(LOG_TAG, "Button Clicked!")
          val intent = Intent(this, SecondActivity::class.java)
          val message: String = mMessageEditText!!.text.toString()

           intent.putExtra(EXTRA_MESSAGE, message)
           startActivityForResult(intent, TEXT_REQUEST)

      }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // Test for the right intent reply
        if (requestCode == TEXT_REQUEST) {
            // Test to make sure the intent reply result was good.
            if (resultCode == Activity.RESULT_OK) {
                val reply = data!!.getStringExtra(SecondActivity.EXTRA_REPLY)

                // Make the reply head visible.
                mReplyHeadTextView!!.visibility = View.VISIBLE

                // Set the reply and make it visible.
                mReplyTextView!!.text = reply
                mReplyTextView!!.visibility = View.VISIBLE
            }
        }
    }



    companion object {
        // Class name for Log tag
        private val LOG_TAG = MainActivity::class.java!!.getSimpleName()
        // Unique tag required for the intent extra
        val EXTRA_MESSAGE = "com.example.felipeaboytes.twoactivities.extra.MESSAGE"
        // Unique tag for the intent reply
        val TEXT_REQUEST = 1
    }
}
