package ir.alirezaisazade.advancedconstraintlayout

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.transition.TransitionManager
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView

class SingleViewPropertyChange : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_view_property_change)

        val imageView: ImageView = findViewById(R.id.singleImageView)
        val root: ConstraintLayout = findViewById(R.id.singleViewChangeRoot)
        var changed = false

        //TODO does not work
        imageView.setOnClickListener {
            if (!changed) {
                TransitionManager.beginDelayedTransition(root)
                imageView.minimumWidth = 250
                imageView.minimumHeight = 250
            } else {
                TransitionManager.beginDelayedTransition(root)
                imageView.minimumWidth = 100
                imageView.minimumHeight = 100
            }
            changed = !changed
        }
    }
}
