package ir.alirezaisazade.advancedconstraintlayout

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.transition.TransitionManager
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class Basic : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic)

        val constraintLayout: ConstraintLayout = findViewById(R.id.basicRoot)

        val constraintSet1 = ConstraintSet()
        constraintSet1.clone(constraintLayout)
        val constraintSet2 = ConstraintSet()
        constraintSet2.clone(this, R.layout.activity_basic_2)

        var changed = false
        findViewById<Button>(R.id.basic).setOnClickListener { _ ->
            TransitionManager.beginDelayedTransition(constraintLayout)
            val constraint = if (changed) constraintSet1 else constraintSet2
            constraint.applyTo(constraintLayout)
            changed = !changed
        }
    }

}
