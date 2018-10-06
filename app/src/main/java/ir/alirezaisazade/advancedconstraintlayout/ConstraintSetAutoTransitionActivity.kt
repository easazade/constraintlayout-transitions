package ir.alirezaisazade.advancedconstraintlayout

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.transition.TransitionManager
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.constraint_set_auto_transition_activity.*

class ConstraintSetAutoTransitionActivity : AppCompatActivity() {

    private var changed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.constraint_set_auto_transition_activity)

        val container = findViewById<ConstraintLayout>(R.id.activityTransitionSet)
        val defaultState = ConstraintSet()
        val triggeredState = ConstraintSet()
        defaultState.clone(container)
        triggeredState.clone(container)

        activityTransitionSetSquare.setOnClickListener {

            defaultState.clear(R.id.activityTransitionSetSquare, ConstraintSet.END)

            triggeredState.connect(R.id.activityTransitionSetSquare, ConstraintSet.END,
                    ConstraintSet.PARENT_ID, ConstraintSet.END)

            /*
            the name of this sample is ConstraintSet AutoTransition is because we just create
            a new constraintSet for our current constraintlayout and then apply it to it
            note that this can happen without transition and the new constraintset will be set on
            the our constraintlayout
            but if we call TransitionManager.beginDelayedTransition(viewgroup) on our constraintlayout
            before setting the new ConstraintSet on it the changes inside the ConstraintSet will be applied
            by transition

            AutoTransition because TransitionManager.beginDelayedTransition(container,{secondParameter})
            has a second parameter of Transition Like Fade() ChangeBounds() Slide()
            and the default one is AutoTransition so our new constraintSet will be applied
            to our layout by AutoTransition
            */
            TransitionManager.beginDelayedTransition(container)
            if (changed) {
                changed = false
                defaultState.applyTo(container)
            } else {
                changed = true
                triggeredState.applyTo(container)
            }
        }
    }
}
