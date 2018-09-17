package com.example.felipeaboytes.twoactivities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_second.*


class SecondActivity : AppCompatActivity() {
    private var mReply: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        var intent = getIntent()
        var message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)
        var textView = findViewById(R.id.text_message) as TextView
        if (textView != null) {
            textView!!.setText(message)
    }


    }

    fun returnReply(view: View) {
        // Get the reply message from the edit text.
        val reply = mReply!!.getText().toString()

        // Create a new intent for the reply, add the reply message to it as an extra,
        // set the intent result, and close the activity.
        val replyIntent = Intent()
        replyIntent.putExtra(EXTRA_REPLY, reply)
        setResult(RESULT_OK, replyIntent)
        finish()
    }

    companion object {
        // Unique tag for the intent reply.
        val EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY"
    }
}
