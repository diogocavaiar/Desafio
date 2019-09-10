package com.example.desafio.feature.login

import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.desafio.R
import com.example.desafio.feature.base.BaseActivity
import com.example.desafio.feature.sendtransfer.view.SendTransferActivity
import com.example.desafio.feature.transferhistory.view.TransferHistoryActivity
import com.example.desafio.util.collapse
import com.example.desafio.util.show
import com.example.desafio.util.showMessageWithSnackBar
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity() {

    private val mViewModel: LoginViewModel by viewModel()

    override fun getLayoutRes(): Int {
        return R.layout.activity_login
    }

    override fun initValues() {
        loadLogin()
        initListener()
    }

    private fun loadLogin() {
        mViewModel.loadLogin(getString(R.string.name), getString(R.string.email))
    }

    private fun initListener() {
        btnSendTransfer.setOnClickListener {
            SendTransferActivity.newInstance(this@LoginActivity)
        }
        btnTransferHistory.setOnClickListener {
            TransferHistoryActivity.newInstance(this@LoginActivity)
        }
    }

    override fun initObserver() {
        mViewModel.getStateLogin().observe(this, Observer { state ->
            checkState(state)
        })
    }

    private fun checkState(state: LoginViewState?) {
        when(state) {
            is Loading -> {
                progressBar.show()
            }
            is Success -> {
                progressBar.collapse()
                updateUi()
            }
            is Error -> {
                progressBar.collapse()
                showMessageWithSnackBar(message = state.error)
            }
        }
    }

    private fun updateUi() {
        setTextName()
        setTextEmail()
        loadImage()
    }

    private fun setTextName() {
        tvName.text = getString(R.string.name)
    }

    private fun setTextEmail() {
        tvEmail.text = getString(R.string.email)
    }

    private fun loadImage() {
        Glide.with(this)
            .load(R.drawable.blank_person)
            .apply(RequestOptions.circleCropTransform())
            .into(imageViewClient)
    }
}