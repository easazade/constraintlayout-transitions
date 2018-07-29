package ir.alirezaisazade.advancedconstraintlayout

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.transition.ChangeBounds
import android.support.transition.TransitionManager
import android.support.v4.view.animation.FastOutSlowInInterpolator
import android.support.v7.app.AppCompatActivity
import android.view.animation.AnticipateOvershootInterpolator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var changed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView.setOnClickListener {
            val constraintSet1 = ConstraintSet()
            constraintSet1.clone(this,R.layout.activity_main)
            val constraintSet2 = ConstraintSet()
            constraintSet2.clone(this, R.layout.activity_main_2)

            val transition = ChangeBounds()
            transition.interpolator = FastOutSlowInInterpolator()
            transition.duration = 500

            val constraintLayout: ConstraintLayout = findViewById(R.id.rootView)
            TransitionManager.beginDelayedTransition(rootView, transition)
            val cs:ConstraintSet = if (changed) constraintSet1 else constraintSet2
            cs.applyTo(constraintLayout)
            changed = !changed
        }

    }
}
