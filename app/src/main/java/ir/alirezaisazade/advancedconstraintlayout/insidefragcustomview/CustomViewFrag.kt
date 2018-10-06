package ir.alirezaisazade.advancedconstraintlayout.insidefragcustomview

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ir.alirezaisazade.advancedconstraintlayout.R

class CustomViewFrag : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.customview_frag,container,false)

}