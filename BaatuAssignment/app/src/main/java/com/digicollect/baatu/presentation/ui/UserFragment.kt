package com.digicollect.baatu.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.work.*
import com.baatu.assignment.data.model.User
import com.baatu.assignment.data.model.UserItem
import com.digicollect.baatu.HomeActivity
import com.digicollect.baatu.R
import com.digicollect.baatu.databinding.FragmentUserBinding
import com.digicollect.baatu.utility.Resource
import com.digicollect.baatu.utility.UserConstant
import java.lang.StringBuilder

class UserFragment : Fragment() {


    private lateinit var mBinding:FragmentUserBinding
    private lateinit var userViewModel:UserViewModel

    override fun onCreateView(@NonNull inflater:LayoutInflater, container:ViewGroup?, savedInstanceState:Bundle?):View? {
        // Inflate the layout for this fragment
        mBinding = FragmentUserBinding.inflate(inflater, container, false)
        userViewModel = (activity as HomeActivity).userViewModel

        setObserverForPhotos()
        onStartClick();
        return mBinding.root
    }

    /*on start button click*/
    private fun onStartClick() {
        mBinding.btnStart.setOnClickListener(View.OnClickListener {
            apigetUsers()
        })
    }

    /*api to get photos*/
    private fun apigetUsers() {
        userViewModel.getUserData()
    }

    /*observer for getting photos*/
    private fun setObserverForPhotos() {
        userViewModel.getAlbumListApiResponse.observe(viewLifecycleOwner, Observer {
            if(it != null){
                when(it){
                    is Resource.Success -> {
                        if(it.data != null) {
                            populateUsers(it.data)
                            setStatusMessage(getString(R.string.successful))
                        }
                    }
                    is Resource.Error -> {
                        setStatusMessage(getString(R.string.unsuccessful))
                    }
                }
                userViewModel.clearLivedata()
            }
        })
    }

    /*to populate users*/
    private fun populateUsers(user:User) {
        val builder = StringBuilder();
        user.forEach {
            builder.append(it.name).append(",")
            userViewModel.saveUser(it)
        }
        mBinding.btnStart.text = builder
    }

    /*to create data to send it to work manager class*/
    private fun createUserData(userItem:UserItem):Data {
        val builder = Data.Builder()
        builder.putString(UserConstant.EMAIL, userItem.toString())
        builder.putString(UserConstant.ID, userItem.toString())
        builder.putString(UserConstant.NAME, userItem.toString())
        builder.putString(UserConstant.PHONE, userItem.toString())
        builder.putString(UserConstant.USERNAME, userItem.toString())
        builder.putString(UserConstant.WEBSITE, userItem.toString())
        return builder.build()
    }

    /*to set status message for corner texts*/
    private fun setStatusMessage(message:String) {
       mBinding.statusTopLeft.text = message
       mBinding.statusTopRight.text = message
       mBinding.statusBottomLeft.text = message
       mBinding.statusBottomRight.text = message
    }
}
