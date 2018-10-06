package ir.alirezaisazade.advancedconstraintlayout.insidefragcustomview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ir.alirezaisazade.advancedconstraintlayout.R

class InsideCustomViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inside_custom_view)

        supportFragmentManager.beginTransaction()
                .add(R.id.frag_place_holder, CustomViewFrag()).commit()

    }
}
