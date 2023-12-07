package com.bogareksa.ui.auth

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.bogareksa.MainActivity
import com.bogareksa.R
import com.bogareksa.databinding.ActivityLoginBinding
import com.bogareksa.io.retrofit.ApiService
import com.bogareksa.ui.auth.component.LoginViewModel
import com.bogareksa.ui.penjual.homePage.HomePageContent
import com.bogareksa.ui.penjual.homePage.HomePageSeller


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private var animationPlayed = false

    private lateinit var viewModel: LoginViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel =ViewModelProvider(this,ViewModelProvider.NewInstanceFactory())[LoginViewModel::class.java]

        viewModel.authData.observe(this){
            if(it.desc == "Successfully signed in!"){
                Log.d("Result Auth",it.desc.toString())
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }else{
                Log.d("Result Auth fail",it.desc.toString())
            }

        }

        setupView()
        setupAction()
        playAnimation()

        if (!animationPlayed) {
            playAnimation()
            animationPlayed = true
        }
    }

    private fun setupView() {
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        supportActionBar?.hide()
    }

    private fun setupAction() {
        binding.register.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
        binding.signinButton.setOnClickListener{
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            if (email.isBlank()) {
                binding.emailEditText.error = getString(R.string.error_empty_email)
            }
            else if (password.isBlank()) {
                binding.passwordEditText.error = getString(R.string.error_empty_password)
            }
            else if (password.length < 8){
                binding.passwordEditText.error = getString(R.string.error_password_more_7)
            }
            else{

                viewModel.getAuthLogin(email,password)

//                AlertDialog.Builder(this).apply {
//                    setTitle("Yeah!")
//                    setMessage("Anda berhasil login. Sudah tidak sabar untuk belajar ya?")
//                    setPositiveButton("Lanjut") { _, _ ->
//                        val intent = Intent(context, MainActivity::class.java)
//                        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
//                        startActivity(intent)
//                        finish()
//                    }
//                    create()
//                    show()
//                }
            }



        }
    }



    private fun playAnimation() {
        ObjectAnimator.ofFloat(binding.imageView, View.ALPHA, 0f, 1f).apply {
            duration = 3000
        }.start()
        val title =
            ObjectAnimator.ofFloat(binding.titleTextView, View.ALPHA, 1f).setDuration(100)
        val message =
            ObjectAnimator.ofFloat(binding.messageTextView, View.ALPHA, 1f).setDuration(100)
        val emailTextView =
            ObjectAnimator.ofFloat(binding.emailTextView, View.ALPHA, 1f).setDuration(100)
        val emailEditTextLayout =
            ObjectAnimator.ofFloat(binding.emailEditTextLayout, View.ALPHA, 1f).setDuration(100)
        val passwordTextView =
            ObjectAnimator.ofFloat(binding.passwordTextView, View.ALPHA, 1f).setDuration(100)
        val passwordEditTextLayout =
            ObjectAnimator.ofFloat(binding.passwordEditTextLayout, View.ALPHA, 1f).setDuration(100)
        val registerTextView =
            ObjectAnimator.ofFloat(binding.registerTextView, View.ALPHA, 1f).setDuration(100)
        val register =
            ObjectAnimator.ofFloat(binding.register, View.ALPHA, 1f).setDuration(100)
        val login =
            ObjectAnimator.ofFloat(binding.signinButton, View.ALPHA, 1f).setDuration(100)
        val loginGoogle =
            ObjectAnimator.ofFloat(binding.loginGoogle, View.ALPHA, 1f).setDuration(100)

        AnimatorSet().apply {
            playSequentially(
                title,
                message,
                emailTextView,
                emailEditTextLayout,
                passwordTextView,
                passwordEditTextLayout,
                registerTextView,
                register,
                login,
                loginGoogle
            )
            startDelay = 100
        }.start()
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

}