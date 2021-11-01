package com.alamin.kotlincoroutine.viewModel

import androidx.lifecycle.*
import com.alamin.kotlincoroutine.model.User
import com.alamin.kotlincoroutine.model.UserRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel : ViewModel() {
    private var userRepository = UserRepository();
   /* var users  : MutableLiveData<List<User>> = MutableLiveData();
    fun getUserData(){
        viewModelScope.launch {
            var result : List<User> ? =null;
            withContext(IO){
                result = userRepository.getUsers();
            }
            users.value = result;
        }
    }*/

    var users : LiveData<List<User>> = liveData(IO) {
        var result = userRepository.getUsers();
        emit(result);
    }

}