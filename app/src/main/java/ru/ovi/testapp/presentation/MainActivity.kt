package ru.ovi.testapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance
import ru.ovi.testapp.R
import ru.ovi.testapp.data.auth.AuthApi

class MainActivity : AppCompatActivity(), KodeinAware {
    override val kodein: Kodein by kodein()


    private val api: AuthApi by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        print(api)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
    }


}
