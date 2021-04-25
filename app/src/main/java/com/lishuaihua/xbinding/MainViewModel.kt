package com.lishuaihua.xbinding

import android.os.Parcel
import android.os.Parcelable
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*



class MainViewModel : ViewModel() {
    val inputnNumber = ObservableField<String>()

    private val _imgLiveData = MutableLiveData<String>()
    val imgLiveData: LiveData<String> = _imgLiveData

    private val _userLiveData = MutableLiveData<User>()
    val userLiveData: LiveData<User> = _userLiveData

    /**
     * 将 inputnNumber 和 AppCompatTextView 通过 android:text="@={mainViewModel.inputnNumber}" 进行双向绑定，
     * 当 inputnNumber 变更的时候，AppCompatTextView 也会跟着一起变化
     */
    fun generateTimber() {
        val timer = Timer()
        timer.schedule(
            object : TimerTask() {
                override fun run() {
                    inputnNumber.set("ObservableField 双向绑定示例 \n Time: " + System.currentTimeMillis())
                }
            },
            0, 500
        )
    }

    fun bindImage(url: String) {
        _imgLiveData.value = url
    }

    fun bindUser() {
        val user = User(name = "dhl", account = "公众号：ByteCode")
        _userLiveData.value = user
    }

    fun bindAccount(): Account {
        val account = Account()
        account.name = "i am BaseObservable"
        return account
    }

}

data class User(val name: String, val account: String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(account)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }


}

class Account : BaseObservable() {

    @get:Bindable
    var name: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }

    @get:Bindable
    var avator: String = ""
        set(avator) {
            field = avator
            notifyPropertyChanged(BR.avator)
        }

}