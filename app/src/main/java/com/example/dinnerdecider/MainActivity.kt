package com.example.dinnerdecider

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dinnerdecider.ui.theme.DinnerDeciderTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {

    private val foodOptions = mutableListOf<String>("Hamburger", "Pizza", "Mexican", "American", "Chinese")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)
        
        val btnAddFood : Button = findViewById(R.id.btn_addFood)
        val btnDecide : Button = findViewById(R.id.btn_decideFood)
        val edtFood : EditText = findViewById(R.id.edit_food)
        val txtDisplay : TextView = findViewById(R.id.txtChosenFood)

        btnDecide.setOnClickListener {
            txtDisplay.text = selectFood(foodOptions);
        }

        btnAddFood.setOnClickListener{
            addFood(edtFood.text.toString())
            edtFood.text.clear()
        }
    }

    private fun selectFood (foods : List<String>): String{
        val selectedIndex = Random.nextInt(0, foods.size)
        return foodOptions[selectedIndex];
    }

    private fun addFood (foodItem : String){
        foodOptions.add(foodItem);
    }


}