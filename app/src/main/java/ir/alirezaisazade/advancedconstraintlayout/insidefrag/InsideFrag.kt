package ir.alirezaisazade.advancedconstraintlayout.insidefrag

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ir.alirezaisazade.advancedconstraintlayout.R

class InsideFrag : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inside_frag)

        supportFragmentManager.beginTransaction()
                .add(R.id.frag_place_holder, Frag1()).commit()

    }
}
