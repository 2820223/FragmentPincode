package com.example.fragmentpincode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmentpincode.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)




         setContentView(binding.root)


        supportFragmentManager.beginTransaction()
            .add(R.id.main, BlankFragment())
            .addToBackStack("blank")
            .commit()



        binding.homeButton.setOnClickListener {

            supportFragmentManager.beginTransaction()
                .replace(R.id.main,HomeFragment())
                .addToBackStack("home")
                .commit()
        }
        binding.orderButton.setOnClickListener {

            supportFragmentManager.beginTransaction()
                .replace(R.id.main,OrderFragment())
                .addToBackStack("order")
                .commit()
        }
        binding.setButton.setOnClickListener {

            supportFragmentManager.beginTransaction()
                .replace(R.id.main,SetFragment())
                .addToBackStack("set")
                .commit()
        }

    }
}