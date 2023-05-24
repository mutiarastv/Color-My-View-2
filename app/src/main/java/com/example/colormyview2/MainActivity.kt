package com.example.colormyview2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.colormyview2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()
    }
    private fun changeColor(view: View){
        when(view.id){
            R.id.box_one_text -> setColor("Biru", R.color.my_blue)
            R.id.box_two_text -> setColor("Merah", R.color.my_red)
            R.id.box_three_text -> setColor("Hijau",R.color.my_green)
            R.id.box_four_text -> setColor("Kuning",R.color.my_yellow)
            R.id.box_five_text -> setColor("Ungu",R.color.my_purple)
            R.id.box_six_text -> defaultColor()
        }
    }
    private fun setColor(warna: String, color: Int){
        binding.boxOneText.setBackgroundResource(color)
        binding.boxTwoText.setBackgroundResource(color)
        binding.boxThreeText.setBackgroundResource(color)
        binding.boxFourText.setBackgroundResource(color)
        binding.boxFiveText.setBackgroundResource(color)
        binding.boxSixText.setBackgroundResource(color)
        val toast = Toast.makeText(this, "Berhasil mengembalikan warna " +warna, Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.TOP, 0, 0)
        toast.show()
    }

    private fun defaultColor(){
        binding.boxOneText.setBackgroundResource(R.color.my_blue)
        binding.boxTwoText.setBackgroundResource(R.color.my_red)
        binding.boxThreeText.setBackgroundResource(R.color.my_green)
        binding.boxFourText.setBackgroundResource(R.color.my_yellow)
        binding.boxFiveText.setBackgroundResource(R.color.my_purple)
        binding.boxSixText.setBackgroundResource(R.color.my_grey)
        val toast = Toast.makeText(this, "Berhasil Mengenmbalikan warna default ", Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.TOP, 0, 0)
    }
    private fun setListeners(){
        val boxOneText = findViewById<TextView>(R.id.box_one_text)
        val boxTwoText = findViewById<TextView>(R.id.box_two_text)
        val boxThreeText = findViewById<TextView>(R.id.box_three_text)
        val boxFourText = findViewById<TextView>(R.id.box_four_text)
        val boxFiveText = findViewById<TextView>(R.id.box_five_text)
        val boxSixText = findViewById<TextView>(R.id.box_six_text)

        val rootConstraintLayout = findViewById<View>(R.id.constraint_layout)


        val clickableView: List<View> = listOf(boxOneText, boxTwoText, boxThreeText,
            boxFourText, boxFiveText, boxSixText, rootConstraintLayout)

        for (item in clickableView){
            item.setOnClickListener{changeColor(it)}
        }
    }
}



