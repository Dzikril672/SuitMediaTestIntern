package com.dzikril.suitmediatest.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dzikril.suitmediatest.databinding.ActivityMainBinding
import com.dzikril.suitmediatest.local.entity.Users
import com.dzikril.suitmediatest.ui.listuser.ListUserActivity
import com.dzikril.suitmediatest.ui.palindrome.PalindromeActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupToolbar()
        getName()
        setupAction()
    }

    private fun getName(){
        val name = intent.getStringExtra(EXTRA_NAME)
        binding.tvName.text = name

        val selectedUser = intent.getParcelableExtra<Users>(EXTRA_DATA)
        binding.tvSelectedUser.text = selectedUser?.firstname
    }

    private fun setupAction(){
        binding.btnChooseUser.setOnClickListener{
            val intent = Intent(this, ListUserActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupToolbar(){
        toolbar = binding.appBar
        setSupportActionBar(toolbar)
        supportActionBar?.title = ""

        toolbar.setNavigationOnClickListener{
            val intent = Intent(this, PalindromeActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DATA = "extra_data"
    }
}