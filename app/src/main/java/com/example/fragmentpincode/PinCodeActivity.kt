package com.example.fragmentpincode



import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.example.fragmentpincode.MainActivity
import com.example.fragmentpincode.R
import com.example.fragmentpincode.databinding.PincodeLayoutBinding

class PinCodeActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: PincodeLayoutBinding
    private var listPin = mutableListOf<String>()
    private var oldListPin = mutableListOf("1","2","3","4")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PincodeLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

loadNumbers()

    }

    private fun loadNumbers() {
        binding.one.setOnClickListener(this)
        binding.two.setOnClickListener(this)
        binding.three.setOnClickListener(this)
        binding.four.setOnClickListener(this)
        binding.five.setOnClickListener(this)
        binding.six.setOnClickListener(this)
        binding.seven.setOnClickListener(this)
        binding.eight.setOnClickListener(this)
        binding.nine.setOnClickListener(this)
        binding.zero.setOnClickListener(this)
    }

    override fun onClick(it: View?) {
        val animationOut = AnimationUtils.loadAnimation(this, R.anim.shake)
        if (listPin.size < 4) {
            listPin.add(it!!.tag.toString())
            when (listPin.size) {
                1 -> binding.pin1.setBackgroundResource(R.drawable.dot)
                2 -> binding.pin2.setBackgroundResource(R.drawable.dot)
                3 -> binding.pin3.setBackgroundResource(R.drawable.dot)
                4 -> binding.pin4.setBackgroundResource(R.drawable.dot)
            }
        }
        if (listPin.size == 4) {
            if (oldListPin == listPin) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                binding.listPin.startAnimation(animationOut)
                Toast.makeText(
                    this,
                    "Wrong pin-code",
                    Toast.LENGTH_SHORT
                ).show()
                listPin.clear()
                binding.pin1.setBackgroundResource(R.drawable.dot)
                binding.pin2.setBackgroundResource(R.drawable.dot)
                binding.pin3.setBackgroundResource(R.drawable.dot)
                binding.pin4.setBackgroundResource(R.drawable.dot)
            }
        }
    }
}