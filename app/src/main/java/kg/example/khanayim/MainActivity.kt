package kg.example.khanayim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import kg.example.khanayim.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var lunchForResult = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == RESULT_OK) {
                binding.edTextF.setText(result.data?.getStringExtra("toto1"))
            }
        }

      binding.btnClick.setOnClickListener(){
          if (binding.edTextF.text.toString().isEmpty()) {
              Toast.makeText(this, "The field cannot be empty", Toast.LENGTH_SHORT).show()
          }else{
              val intent = Intent(this,SecondActivity::class.java)
              intent.putExtra("toto",binding.edTextF.text.toString())
              lunchForResult .launch(intent)
          }
      }
    }
}