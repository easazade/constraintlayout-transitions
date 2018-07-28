package ir.alirezaisazade.advancedconstraintlayout

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.transition.ChangeBounds
import android.support.transition.TransitionManager
import android.support.v7.app.AppCompatActivity
import android.view.animation.AnticipateOvershootInterpolator
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Observable.just("nothing").delay(3000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    val constraintSet = ConstraintSet()
                    constraintSet.clone(this, R.layout.activity_main_2)

                    val transition = ChangeBounds()
                    transition.interpolator = AnticipateOvershootInterpolator(1.0f)
                    transition.duration = 1200

                    val constraintLayout: ConstraintLayout = findViewById(R.id.rootView)
                    TransitionManager.beginDelayedTransition(rootView, transition)
                    constraintSet.applyTo(constraintLayout)
                }


    }
}
