package pojo

class NumberModel {
    var firstNum:Int? = null
    var secondNum:Int? = null

    constructor(firstNum:Int,secondNum:Int)
    {
        this.firstNum = firstNum
        this.secondNum = secondNum
    }
    fun get_first_num():Int
    {
        return firstNum!!
    }

    fun get_second_num():Int
    {
        return secondNum!!
    }

}