package kg.example.khanayim

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kg.example.khanayim.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initClickers()
    }

    private fun initClickers() {
        binding.edTextS.setText(intent.getStringExtra("toto"))

        binding.btnClick2.setOnClickListener {
            if (binding.edTextS.text.toString().isEmpty()) {
                Toast.makeText(this, "The field cannot be empty", Toast.LENGTH_SHORT).show()
            } else {
                sendData()
            }
        }
    }

    private fun sendData() {
        Intent(this, MainActivity::class.java).apply {
            putExtra("toto1", binding.edTextS.text.toString())
            setResult(Activity.RESULT_OK, this)
        }
        finish()
    }
}

