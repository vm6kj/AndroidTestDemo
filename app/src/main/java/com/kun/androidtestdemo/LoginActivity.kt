package com.kun.androidtestdemo

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife
import com.google.android.material.textfield.TextInputLayout


class LoginActivity : AppCompatActivity() {

    companion object {
        private const val ACCOUNT = "kc_hsu@htc.com"
        private const val PASSWORD = "123456"
    }

    private var isValidAccount = false
    private var isValidPassword = false

    @BindView(R.id.ed_account)
    lateinit var edAccount: EditText

    @BindView(R.id.ed_password)
    lateinit var edPassword: EditText

    @BindView(R.id.btn_login)
    lateinit var btnLogin: Button

    @BindView(R.id.account_layout)
    lateinit var userLayout: TextInputLayout

    @BindView(R.id.password_layout)
    lateinit var passwordLayout: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        ButterKnife.bind(this)

        edAccount.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                userLayout.error = ""
            }
        }

        edAccount.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s != null) {
                    if (Utils.isEmailValid(s.toString())) {
                        userLayout.error = ""
                        isValidAccount = true
                    } else {
                        userLayout.error = "Invalid email format"
                        isValidAccount = false
                    }
                }

                invalidateLoginButtonState()
            }
        })

        edPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s != null) {
                    when {
                        s.isNotEmpty() && s.length < 6 -> {
                            passwordLayout.error = "Password can't be less than 6 characters"
                            isValidPassword = false
                        }
                        s.isEmpty() -> {
                            passwordLayout.error = ""
                            isValidPassword = false
                        }
                        else -> {
                            passwordLayout.error = ""
                            isValidPassword = true
                        }
                    }
                }

                invalidateLoginButtonState()
            }
        })

        btnLogin.setOnClickListener {
            if (edAccount.text.toString() == ACCOUNT && edPassword.text.toString() == PASSWORD) {
                startActivity(Intent(this, HomeActivity::class.java))
            } else {
                AlertDialog.Builder(this)
                    .setTitle("Failed to login!")
                    .setMessage("Please check the account and the password.")
                    .show()
            }
        }

    }

    private fun invalidateLoginButtonState() {
        btnLogin.isEnabled = isValidAccount && isValidPassword
    }
}