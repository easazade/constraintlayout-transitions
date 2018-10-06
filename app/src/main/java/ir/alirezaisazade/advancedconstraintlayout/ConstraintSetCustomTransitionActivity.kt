package ir.alirezaisazade.advancedconstraintlayout

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.transition.ChangeBounds
import android.support.transition.Fade
import android.support.transition.TransitionManager
import android.support.transition.TransitionSet
import android.support.v4.view.animation.FastOutSlowInInterpolator
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_constraint_set_custom_transition.*

class ConstraintSetCustomTransitionActivity : AppCompatActivity() {

    private var changedState = false
    private lateinit var defaultState: ConstraintSet
    private lateinit var triggeredState: ConstraintSet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint_set_custom_transition)
        val container = findViewById<ConstraintLayout>(R.id.constraintSetCustomTransition_root)

        defaultState = ConstraintSet().apply { clone(container) }
        triggeredState = ConstraintSet().apply { clone(container) }
        triggeredState.connect(R.id.customTransitionSquare1, ConstraintSet.START,
                ConstraintSet.PARENT_ID, ConstraintSet.START)
        triggeredState.setVisibility(R.id.customTransitionSquare1, View.INVISIBLE)
        triggeredState.connect(R.id.customTransitionSquare2, ConstraintSet.END,
                ConstraintSet.PARENT_ID, ConstraintSet.END)
        triggeredState.connect(R.id.customTransitionSquare3, ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
        triggeredState.constrainHeight(R.id.customTransitionSquare3, 500)
        triggeredState.constrainWidth(R.id.customTransitionSquare3, 500)

        customTransitionSquare1.setOnClickListener {
            val transitionSet = TransitionSet()
                    .addTransition(Fade())
                    .addTarget(R.id.customTransitionSquare1)
                    .setDuration(300)
                    .addTransition(ChangeBounds())
                    .addTarget(R.id.customTransitionSquare1)
                    .addTarget(R.id.customTransitionSquare2)
                    .addTarget(R.id.customTransitionSquare3)
                    .setDuration(300)
                    .setInterpolator(FastOutSlowInInterpolator())

            TransitionManager.beginDelayedTransition(container, transitionSet)

            triggeredState.applyTo(container)
        }

        customTransitionSquare2.setOnClickListener {
            val transitionSet = TransitionSet()
                    .addTransition(Fade())
                    .addTarget(R.id.customTransitionSquare1)
                    .setDuration(300)
                    .addTransition(ChangeBounds())
                    .addTarget(R.id.customTransitionSquare1)
                    .addTarget(R.id.customTransitionSquare2)
                    .addTarget(R.id.customTransitionSquare3)
                    .setDuration(300)
                    .setInterpolator(FastOutSlowInInterpolator())

            TransitionManager.beginDelayedTransition(container, transitionSet)

            defaultState.applyTo(container)
        }

    }
}
