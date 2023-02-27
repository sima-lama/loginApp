package com.example.myapplication

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.FragmentLoginBinding
import com.example.myapplication.databinding.FragmentRegistrationBinding

class LoginActivity:AppCompatActivity() {
    private lateinit var binding: FragmentLoginBinding
    var password= ""
    var email= ""
    var savedPassword= ""
    var savedEmail= ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=FragmentLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init(){
      var sharedPreferences = PrefManager.getInstance(this)
        savedEmail=sharedPreferences.getString("Email","")
        savedPassword=sharedPreferences.getString("Password","")
        binding.loginButton.setOnClickListener{
            onButtonClick()
        }
        binding.email.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                    email = s.toString()

                }


        })
        binding.password.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                password = s.toString()

            }


        })


    }

    private fun onButtonClick() {
        if(email ==savedEmail &&password ==savedPassword){
            goToMain()
        }else Toast.makeText(this,"Invalid Login Credentials", Toast.LENGTH_SHORT).show()


    }

    private fun goToMain(){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}