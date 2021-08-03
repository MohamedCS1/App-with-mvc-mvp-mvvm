package ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.work.R
import pojo.DataBase
import pojo.NumberModel

class MainActivity : AppCompatActivity(),View.OnClickListener,Interface_data_display {

    var bu_plus:Button? = null
    var bu_Div:Button? = null
    var bu_multi:Button? = null
    var tv_result_plus:TextView? = null
    var tv_result_div:TextView? = null
    var tv_result_multi:TextView? = null
    var presenter:Presenter? = null
    var numberviewmodel:NumberViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bu_plus = findViewById<Button>(R.id.plus_button)
        bu_Div = findViewById<Button>(R.id.div_button)
        bu_multi = findViewById<Button>(R.id.mul_button)

        tv_result_plus = findViewById<TextView>(R.id.plus_result_textView)
        tv_result_div = findViewById<TextView>(R.id.div_result_textView)
        tv_result_multi = findViewById<TextView>(R.id.mul_result_textView)

        bu_multi!!.setOnClickListener(this)
        bu_plus!!.setOnClickListener(this)
        bu_Div!!.setOnClickListener(this)


        presenter = Presenter(this)

        numberviewmodel = ViewModelProvider(this).get(NumberViewModel::class.java)

        numberviewmodel!!.mutable_live_data.observe(this,object :Observer<NumberModel>{
            override fun onChanged(t: NumberModel?) {
                tv_result_multi!!.text = (t!!.firstNum!! * t.secondNum!!).toString()
            }

        })
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        when (v!!.id){
            bu_plus!!.id -> {
                tv_result_plus!!.text =  (DataBase().getNumbers().firstNum!! + DataBase().getNumbers().secondNum!!).toString()
            }

            bu_Div!!.id -> {
                presenter!!.pass_data()
            }

            bu_multi!!.id -> {
                numberviewmodel!!.get_number_data()
            }
        }
    }

    override fun on_get_data(number: NumberModel) {

        tv_result_div!!.text = (number.firstNum!! / number.secondNum!!).toString()

    }




}
