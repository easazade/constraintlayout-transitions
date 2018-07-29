package ir.alirezaisazade.advancedconstraintlayout

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.transition.ChangeBounds
import android.support.transition.Transition
import android.support.transition.TransitionManager
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_single_view_property_change.*

class SingleViewPropertyChange : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_view_property_change)

        val root: ConstraintLayout = findViewById(R.id.singleViewChangeRoot)
        val img:ImageView = findViewById(R.id.singleImageView)
        var changed = false


        val t: Transition = ChangeBounds()
        TransitionManager.beginDelayedTransition(root, t)

        //TODO does not work
        btnSingle.setOnClickListener {
            if (!changed) {
                img.minimumWidth = 250
                img.minimumHeight = 250
//                imageView.visibility = View.INVISIBLE
                Toast.makeText(this, "250", Toast.LENGTH_SHORT).show()
            } else {
                img.minimumWidth = 100
                img.minimumHeight = 100
//                imageView.visibility = View.VISIBLE
                Toast.makeText(this, "100", Toast.LENGTH_SHORT).show()
            }
            changed = !changed
        }
    }
}
