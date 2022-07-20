package com.example.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.notes.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private var binding:ActivityMainBinding? = null
    private val mBinding get() = binding!!
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_splash_note)
        CoroutineScope(Dispatchers.Main).launch {
            delay(3000)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(mBinding.root)
            APP = this@MainActivity
            navController = Navigation.findNavController(this@MainActivity,R.id.navFragment)

        }
    }
}