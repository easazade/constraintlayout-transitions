package ir.alirezaisazade.advancedconstraintlayout.insidefragcustomview

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.transition.ChangeBounds
import android.support.transition.TransitionManager
import android.support.v4.view.animation.FastOutSlowInInterpolator
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.ImageView
import ir.alirezaisazade.advancedconstraintlayout.R
import kotlinx.android.synthetic.main.customview1.view.*

class CustomView : FrameLayout {

    private var changed = false
    private val mSquare: ImageView

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    init {
        inflate(context, R.layout.customview1, this)
        mSquare = findViewById(R.id.customView_square)
        mSquare.setOnClickListener {
            val constraintSet1 = ConstraintSet()
            constraintSet1.clone(context, R.layout.customview1)
            val constraintSet2 = ConstraintSet()
            constraintSet2.clone(context, R.layout.customview1_state1)

            val transition = ChangeBounds()
            transition.interpolator = FastOutSlowInInterpolator()
            transition.duration = 500

            TransitionManager.beginDelayedTransition(customview_root, transition)
            val cs: ConstraintSet = if (changed) constraintSet1 else constraintSet2
            cs.applyTo(customview_root)
            changed = !changed
        }
    }


}