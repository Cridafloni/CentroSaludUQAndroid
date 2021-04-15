package com.uq.centro_salud.presentacion.activities

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.uq.centro_salud.R
import kotlinx.android.synthetic.main.activity_splash_screen.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class Splash_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        imageView_splash_logo.startAnimation(animateImage())

        GlobalScope.launch {
            delay(2000)
            startActivity(Intent(this@Splash_screen, LoginActivity::class.java))
            finish()
        }


    }

    private fun animateImage(): Animation {
        val animation = AnimationUtils.loadAnimation(
            this,
            R.anim.blink
        )
        animation.interpolator = LinearInterpolator()
        animation.repeatCount = Animation.INFINITE
        animation.duration = 700
        return animation
    }
}