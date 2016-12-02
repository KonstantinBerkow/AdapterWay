package me.berkow.adaptertest.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import me.berkow.adaptertest.R
import me.berkow.adaptertest.ui.fragment.AdapterFragment

/**
 * Created by konstantinberkov on 12/2/16.
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, AdapterFragment.newInstance())
                    .commit()
        }
    }
}
