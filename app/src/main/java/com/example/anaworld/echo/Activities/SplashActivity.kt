package com.example.anaworld.echo.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Handler
import android.support.v4.app.ActivityCompat
import android.widget.Toast
import com.example.anaworld.echo.R

class SplashActivity : AppCompatActivity() {

    var pms = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.MODIFY_AUDIO_SETTINGS,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.PROCESS_OUTGOING_CALLS,
            Manifest.permission.RECORD_AUDIO)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        if (!haspms(this@SplashActivity, *pms)) {

            ActivityCompat.requestPermissions(this@SplashActivity, pms, 131)

        } else {
            sta()
        }

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            131 -> {
                if (grantResults.isNotEmpty()
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED
                        && grantResults[2] == PackageManager.PERMISSION_GRANTED
                        && grantResults[3] == PackageManager.PERMISSION_GRANTED
                        && grantResults[4] == PackageManager.PERMISSION_GRANTED) {

                    sta()
                } else {
                    Toast.makeText(this@SplashActivity, "Permission dede!!", Toast.LENGTH_SHORT).show()
                    this.finish()
                }
                return
            }
            else -> {
                Toast.makeText(this@SplashActivity, "Wrong!!", Toast.LENGTH_SHORT).show()
                this.finish()
                return
            }
        }

    }

    fun haspms(context: Context, vararg pm: String): Boolean {
        var allpm = true
        for (p in pm) {
            val res = context.checkCallingOrSelfPermission(p)
            if (res != PackageManager.PERMISSION_GRANTED) {
                allpm = false
            }
        }
        return allpm
    }

    fun sta() {
        Handler().postDelayed({
            val stact = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(stact)
            this.finish()
        }, 1000)
    }

}
