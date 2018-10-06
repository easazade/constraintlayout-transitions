package ir.alirezaisazade.advancedconstraintlayout.insidefrag

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.transition.ChangeBounds
import android.support.transition.TransitionManager
import android.support.v4.app.Fragment
import android.support.v4.view.animation.FastOutSlowInInterpolator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ir.alirezaisazade.advancedconstraintlayout.R
import kotlinx.android.synthetic.main.frag1.*

class Frag1 : Fragment() {

    private var changed = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.frag1, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        square.setOnClickListener { _ ->
            val constraintSet1 = ConstraintSet()
            constraintSet1.clone(activity, R.layout.frag1)
            val constraintSet2 = ConstraintSet()
            constraintSet2.clone(activity, R.layout.frag1_big)

            val transition = ChangeBounds()
            transition.interpolator = FastOutSlowInInterpolator()
            transition.duration = 500

            val constraintLayout: ConstraintLayout = view.findViewById(R.id.frag1_root)
            TransitionManager.beginDelayedTransition(frag1_root, transition)
            val cs: ConstraintSet = if (changed) constraintSet1 else constraintSet2
            cs.applyTo(constraintLayout)
            changed = !changed
        }

    }

}