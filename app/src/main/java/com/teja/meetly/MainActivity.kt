package com.teja.meetly

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import org.jitsi.meet.sdk.JitsiMeet
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val roomNameInput = findViewById<EditText>(R.id.roomNameInput)
        val joinButton = findViewById<Button>(R.id.joinButton)

        joinButton.setOnClickListener {
            val roomName = roomNameInput.text.toString().trim()

            if (roomName.isNotEmpty()) {
                val options = JitsiMeetConferenceOptions.Builder()
                    .setServerURL(java.net.URL("https://meet.jit.si"))
                    .setRoom(roomName)
                    .setAudioMuted(false)
                    .setVideoMuted(false)
                    .build()

                JitsiMeet.launch(this, options)
            }
        }
    }
}
