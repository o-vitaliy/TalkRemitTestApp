package ru.ovi.testapp.presentation.auth.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_auth_login.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import ru.ovi.testapp.R
import ru.ovi.testapp.domain.common.Result
import ru.ovi.testapp.presentation.common.hideKeyboard
import ru.ovi.testapp.presentation.common.showSnackBar
import ru.ovi.testapp.presentation.common.visible
import ru.ovi.testapp.presentation.viewModel

class LoginFragment : Fragment(), KodeinAware {
    override val kodein: Kodein by kodein()
    private val viewModel: LoginViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_auth_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.loginButton).setOnClickListener {
            viewModel.login()
        }

        loginEmail.editText?.addTextChangedListener { viewModel.emailChange(it.toString()) }
        loginPassword.editText?.addTextChangedListener { viewModel.passwordChange(it.toString()) }

        viewModel.emailError.observe(viewLifecycleOwner, Observer { loginEmail.error = it })
        viewModel.passwordError.observe(viewLifecycleOwner, Observer { loginPassword.error = it })

        viewModel.login.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Result.Loading -> loginProgressBar.visible = true
                is Result.Error -> {
                    loginProgressBar.visible = false
                    showSnackBar(it.message)
                }
                is Result.Success -> {
                    loginProgressBar.visible = false
                    findNavController().navigate(R.id.action_login_to_transactions)
                }
            }
        })
    }

    override fun onPause() {
        super.onPause()
        activity?.let { hideKeyboard(it) }
    }


}