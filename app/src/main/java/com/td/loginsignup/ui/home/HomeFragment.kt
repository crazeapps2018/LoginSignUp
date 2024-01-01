package com.example.mvvmtutorial.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.td.loginsignup.data.network.Resource
import com.td.loginsignup.data.network.UserApi
import com.td.loginsignup.data.responses.LoginResponse
import com.td.loginsignup.data.responses.User
import com.td.loginsignup.data.respository.UserRepository
import com.td.loginsignup.databinding.FragmentHomeBinding
import com.td.loginsignup.ui.base.BaseFragment
import com.td.loginsignup.ui.home.HomeViewModel
import com.td.loginsignup.ui.visible
import kotlinx.coroutines.runBlocking

/**
 * Fragment managing Logged-in user experience.
 * @param HomeViewModel ViewModel class to be instantiated
 * @param FragmentHomeBinding ViewBinding of [HomeFragment]
 * @param UserRepository Repository class
 */
class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding, UserRepository>() {

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.progressbar.visible(true)
    viewModel.getUser()

    viewModel.user.observe(viewLifecycleOwner, Observer {
      binding.progressbar.visible(false)
      when(it) {
        is Resource.Success<LoginResponse> -> {
          updateUI(it.value.user)
        }
        else -> {}
      }

    })

    binding.buttonLogout.setOnClickListener {
      logout()
    }
  }

  private fun updateUI(user: User) {
    with(binding) {
      textViewId.text = user.id.toString()
      textViewName.text = user.name
      textViewEmail.text = user.email

    }
  }

  override fun getViewModel(): Class<HomeViewModel> {
    return HomeViewModel::class.java
  }

  override fun getFragmentBinding(
    inflater: LayoutInflater,
    container: ViewGroup?
  ) = FragmentHomeBinding.inflate(inflater, container, false)

  override fun getFragmentRepository(): UserRepository {
    val authToken = runBlocking { userPreferences.getAuthToken() }
    val userApi = remoteDataSource.buildApi(UserApi::class.java, authToken)
    return UserRepository(userApi)
  }
}