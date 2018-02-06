package me.jagdeep.papertrailtimber

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Timber.d("onCreate - called")
    }

    override fun onStart() {
        super.onStart()
        Timber.i("onStart - called")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("onStop - called")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("onResume - called")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("onPause - called")
    }

    override fun onDestroy() {
        super.onDestroy()

        val ex = Exception("Something really bad")
        Timber.e(ex, "onDestroy - called")
    }

}
