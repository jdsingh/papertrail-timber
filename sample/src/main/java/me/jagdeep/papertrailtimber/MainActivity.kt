package me.jagdeep.papertrailtimber

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import timber.log.Timber

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listOf<Button>(
            findViewById(R.id.info),
            findViewById(R.id.debug),
            findViewById(R.id.warning),
            findViewById(R.id.error)
        ).forEach { btn ->
            btn.setOnClickListener(this)
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.info -> {
                Timber.i("Info")
            }
            R.id.debug -> {
                Timber.d("Debug")
            }
            R.id.warning -> {
                Timber.w("Warning")
            }
            R.id.error -> {
                val ex = Exception("Something really bad")
                Timber.e(ex, "Error")
            }
        }
    }

}
