package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.FragmentRegistrationBinding
import java.time.Duration

class RegistrationActivity : AppCompatActivity() {
    private lateinit var binding: FragmentRegistrationBinding

    var name = ""
    var age = ""
    var password = ""
    var email = ""

    private var sharedPreferences:PrefManager?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentRegistrationBinding.inflate(layoutInflater)

        setContentView(binding.root)
        init()
    }

    private fun init() {
        sharedPreferences = PrefManager.getInstance(this)
        binding.registerButton.setOnClickListener {
            onButtonClick()
        }

        binding.name.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (isEmptyString(s.toString())) {
                    name = s.toString()

                }
            }

        })

        binding.age.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (isEmptyString(s.toString())) {
                    age = s.toString()

                }
            }

        })

        binding.password.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (isEmptyString(s.toString())) {
                    password = s.toString()

                }
            }

        })
        binding.email.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (isEmptyString(s.toString())) {
                    email = s.toString()

                }
            }
        })


    }

    private fun onButtonClick() {

        sharedPreferences?.putString("Name", name)
        sharedPreferences?.putString("Email", email)
        sharedPreferences?.putString("Age", age)
        sharedPreferences?.putString("Password", password)

        if (isEmptyString(name) && isEmptyString(age) && isEmptyString(password) && isEmptyString(
                email
            )
        ) {
            goToLogin()
        } else Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show()

    }

    private fun isEmptyString(text: String): Boolean {
        return text.isNotEmpty()

    }

    private fun goToLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }


}