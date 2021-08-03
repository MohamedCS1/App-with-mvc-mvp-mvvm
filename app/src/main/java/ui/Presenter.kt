package ui
import pojo.DataBase
import pojo.NumberModel

class Presenter {
    var view:Interface_data_display? = null

    fun get_data():NumberModel
    {
        return DataBase().getNumbers()
    }

    constructor(view:Interface_data_display)
    {
        this.view = view
    }

    fun pass_data()
    {
        view!!.on_get_data(get_data())
    }

}