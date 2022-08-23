/*package com.example.trader.database

import androidx.lifecycle.LiveData


interface UserRepository {

    fun addUser(user: User):Long

    fun addUserList(users: List<User>):List<Long>

    fun deleteUser(user: User)

    fun verifyLoginUser(email:String,password:String): User



}

class UserRepositoryImpl @Inject constructor(
    private  var userDao: UserDao,
   // private var apiService: ApiService

):UserRepository{

    override fun addUser(users:User): Long {
        return userDao.insertUser(user)
    }

    override fun addUserList(users:List<User>): List<Long> {
        return userDao.insertUserAll(users)
    }

    override fun deleteUser(users: User) {
        //TODO("Not yet implemented")
    }

    override fun verifyLoginUser(email:String,password:String): User {
        return userDao.readLoginData(email=email ,password = password )
    }

    override fun getUserDataDetails(id:Long): User {*/

    /*}




}*/