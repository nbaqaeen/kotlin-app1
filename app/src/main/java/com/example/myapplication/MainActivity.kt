package com.example.myapplication
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener, AdapterView.OnItemSelectedListener {
    private lateinit var myButton: Button
    private lateinit var mySpinner: Spinner
    private lateinit var colorLabel: TextView
    private lateinit var spinnerAdapter: ArrayAdapter<String>
    private val colors = listOf("Red", "Green", "Blue")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myButton = findViewById(R.id.my_button)
        myButton.setOnClickListener(this)

        mySpinner = findViewById(R.id.my_spinner2)
        colorLabel = findViewById(R.id.color_label)

        spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, colors)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        mySpinner.adapter = spinnerAdapter
        mySpinner.onItemSelectedListener = this
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.my_button -> {
                val selectedColor = mySpinner.selectedItem.toString()
                when (selectedColor) {
                    "Red" -> {
                        window.decorView.setBackgroundColor(Color.RED)
                        colorLabel.text = "Red"
                    }
                    "Green" -> {
                        window.decorView.setBackgroundColor(Color.GREEN)
                        colorLabel.text = "Green"
                    }
                    "Blue" -> {
                        window.decorView.setBackgroundColor(Color.BLUE)
                        colorLabel.text = "Blue"
                    }
                }
            }
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val selectedItem = colors[position]
        // Handle spinner item selection
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        // Handle spinner nothing selected
    }
}

