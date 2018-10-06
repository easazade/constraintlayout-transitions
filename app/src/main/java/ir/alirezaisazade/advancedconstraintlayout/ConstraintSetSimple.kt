package ir.alirezaisazade.advancedconstraintlayout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class ConstraintSetSimple : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint_set_simple)

        //TODO sometimes we have 2 layouts that we want to transition between them
        //and they are huge and big and we don't want to have the same id for the similar elements
        //like a fab button should have different ids we can achieve this by
        // giving them transition names

    }


}
