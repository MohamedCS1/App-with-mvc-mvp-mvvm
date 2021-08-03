package ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pojo.DataBase
import pojo.NumberModel

class NumberViewModel:ViewModel() {

    val mutable_live_data = MutableLiveData<NumberModel>()

    fun get_data_from_model():NumberModel
    {
        return DataBase().getNumbers()
    }

    fun get_number_data()
    {
        mutable_live_data.value = get_data_from_model()
    }

}