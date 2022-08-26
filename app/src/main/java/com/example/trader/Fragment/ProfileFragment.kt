package com.example.trader.Fragment

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.trader.Activities.LoginActivity
import com.example.trader.Activities.UpdateActivity
import com.example.trader.Adapter.ProfileRVadapter
import com.example.trader.database.User
import com.example.trader.database.UserDao
import com.example.trader.database.UserDataBase
import com.example.trader.database.UserViewModel

import com.example.trader.databinding.FragmentProfileBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding
    lateinit var adapter:ProfileRVadapter
   var user: User?=null
    var userDao: UserDao?=null
    lateinit var dataBase: UserDataBase
    var profileViewModel: UserViewModel?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        profileViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        dataBase = UserDataBase.getappdatabase(context)!!
        binding = FragmentProfileBinding.inflate(layoutInflater)
        val sharedPreferences: SharedPreferences =
            requireActivity().getSharedPreferences("Data", Context.MODE_PRIVATE)
        val loggedEmail = sharedPreferences.getString("Email", Context.MODE_PRIVATE.toString())

        lifecycleScope.launch(Dispatchers.IO) {
            profileViewModel?.getAllUser()
            val name =
                UserDataBase.getappdatabase(context)?.userdao()?.findmyname(loggedEmail.toString())
            binding.textforcurrentloggedinname.setText(name)
        }
        binding.textforcurrentloggedinemail.setText(loggedEmail)

        profileViewModel!!.getAllUserObserver().observe(this)
        {
            Log.e("MainActivity", "UserList" + it?.get(0)?.id)
            if (it != null) {

                adapter = ProfileRVadapter(this@ProfileFragment)
                adapter.setdata(ArrayList(it))
                binding.recyclerview.adapter = adapter
            }
        }
        binding.buttonforlogout.setOnClickListener {
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
            val intent = Intent(context, LoginActivity::class.java)
            intent.putExtra("email", loggedEmail)
            startActivity(intent)

        }

        binding.buttonforupdate.setOnClickListener {
            val intent=Intent(activity,UpdateActivity::class.java)
            intent.putExtra("LoggedEmail",loggedEmail)

            updateActivity_launcher.launch(intent)


        }
        }
    var updateActivity_launcher =registerForActivityResult(ActivityResultContracts.StartActivityForResult())            //taking result from update activity
    { result ->
        val sharedPreferences: SharedPreferences =
            requireActivity().getSharedPreferences("Data", Context.MODE_PRIVATE)
        val loggedEmail = sharedPreferences.getString("Email", Context.MODE_PRIVATE.toString())

        if (result.resultCode == AppCompatActivity.RESULT_OK) {
            val new_Name: String = result.data?.getStringExtra("new_name").toString()

            val adapter = binding.recyclerview.adapter as ProfileRVadapter
            val itemList = adapter.getDataList()
            for(item in itemList)                                                                                       //comparing email with name in our list
            {
                if(item.email==loggedEmail){
                    item.name=new_Name
                    adapter.notifyDataSetChanged()                                                                      //updating recyclerview
                    break
                }
            }


            lifecycleScope.launch(Dispatchers.IO){
                dataBase.userdao().updateUser(new_Name,loggedEmail .toString())                                         //running a query to update user in database

                binding.textforcurrentloggedinname.setText(new_Name)
            }
        }
    }
 override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return binding.root
    }


}
