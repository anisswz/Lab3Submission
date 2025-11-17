package com.example.s72591_lab3_task3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.SeekBar
import com.example.s72591_lab3_task3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var currentName: String = ""
    private var isGreetingEnabled: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {

        // 1. EditText Text Change Listener
        binding.edtName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                currentName = s?.toString()?.trim() ?: ""
                updateGreeting()
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        // 2. Switch Listener
        binding.switchEnable.setOnCheckedChangeListener { _, isChecked ->
            isGreetingEnabled = isChecked
            updateStatusText()
            updateGreeting()
        }

        // 3. CheckBox Listener (Shout Mode)
        binding.checkShout.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.txtGreeting.text =
                    binding.txtGreeting.text.toString().uppercase()
            } else {
                updateGreeting()
            }
        }

        // 4. SeekBar Listener (Text Size Adjustment)
        binding.seekTextSize.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

                // Minimum size rule
                val size = if (progress < 12) 12f else progress.toFloat()

                // Apply the computed size
                binding.txtGreeting.textSize = size
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // No action needed
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // No action needed
            }
        })
    }

    private fun updateStatusText() {
        binding.txtStatus.text =
            if (isGreetingEnabled)
                "Greeting is enabled."
            else
                "Greeting is disabled."
    }

    private fun updateGreeting() {
        binding.txtGreeting.text =
            when {
                isGreetingEnabled && currentName.isNotEmpty() ->
                    "Hello, $currentName!"

                isGreetingEnabled && currentName.isEmpty() ->
                    "Please type your name."

                else ->
                    ""
            }
    }
}