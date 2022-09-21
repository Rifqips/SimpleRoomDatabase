package com.rifqipadisiliwangi.roomdemo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.rifqipadisiliwangi.roomdemo.db.RoomAppDb
import com.rifqipadisiliwangi.roomdemo.db.UserEntity

class MainActivityViewModel(app : Application): AndroidViewModel(app) {
    lateinit var allUser : MutableLiveData<List<UserEntity>>

    init {
        allUser = MutableLiveData()
    }

    fun getAllUsersObservers(): MutableLiveData<List<UserEntity>>{
        return allUser
    }

    fun getAllUser(){
        val userDao = RoomAppDb.getAppDatabase((getApplication()))?.userDao()
        val list = userDao?.getAllUserInfo()

        allUser.postValue(list)
    }

    fun inserUserInfo(entity: UserEntity){
        val userDao = RoomAppDb.getAppDatabase(getApplication())?.userDao()
        userDao?.insertUser(entity)
        getAllUser()

    }

    fun updateUserInfo(entity: UserEntity){
        val userDao = RoomAppDb.getAppDatabase(getApplication())?.userDao()
        userDao?.updateUser(entity)
        getAllUser()

    }

    fun deleteUserInfo(entity: UserEntity){
        val userDao = RoomAppDb.getAppDatabase(getApplication())?.userDao()
        userDao?.deleteUser(entity)
        getAllUser()

    }
}