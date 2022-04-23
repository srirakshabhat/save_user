package com.digicollect.baatu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.digicollect.baatu.databinding.ActivityHomeBinding
import com.digicollect.baatu.presentation.ui.UserViewModel
import com.digicollect.baatu.presentation.ui.UserViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding:ActivityHomeBinding

    @Inject
    lateinit var userViewModelFactory:UserViewModelFactory
    lateinit var userViewModel:UserViewModel

    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userViewModel = ViewModelProvider(this, userViewModelFactory).get(UserViewModel::class.java)

    }
}