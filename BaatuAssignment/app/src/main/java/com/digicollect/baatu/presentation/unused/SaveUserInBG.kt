package com.digicollect.baatu.presentation.unused

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.baatu.assignment.data.model.UserItem
import com.digicollect.baatu.presentation.ui.UserViewModel
import com.digicollect.baatu.utility.UserConstant

/*class not used*/
class SaveUserInBG(context:Context, workerParams:WorkerParameters) : Worker(context, workerParams) {

    private lateinit var userViewModel :UserViewModel

    override fun doWork():Result {
        return try {
            userViewModel.saveUser(UserItem(
                inputData.getString(UserConstant.EMAIL)!!,
                inputData.getInt(UserConstant.ID,1),
                inputData.getString(UserConstant.NAME)!!,
                inputData.getString(UserConstant.PHONE)!!,
                inputData.getString(UserConstant.USERNAME)!!,
                inputData.getString(UserConstant.WEBSITE)!!
                                  ))
            Result.success()
        } catch (throwable: Throwable) {
            Result.failure()
        }
    }

    /*
        private lateinit var workManager: WorkManager        workManager = WorkManager.getInstance(requireContext())
    val saveData = OneTimeWorkRequestBuilder<SaveUserInBG>()
                .setInputData(createUserData(it))
                .build()
            workManager.enqueue(saveData)*/
}