package ru.ovi.testapp.presentation.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import ru.ovi.testapp.R
import ru.ovi.testapp.presentation.viewModel

class SplashFragment : Fragment(), KodeinAware {
    override val kodein: Kodein by kodein()
    private val viewModel: SplashViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.authorized.observe(viewLifecycleOwner, Observer {
            if (it) {
                findNavController().navigate(R.id.action_splash_to_transactions)
            } else {
                findNavController().navigate(R.id.action_splash_to_login)
            }
        })
    }
}