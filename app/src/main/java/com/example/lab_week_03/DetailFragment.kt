package com.example.lab_week_03

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {

    private val coffeeTitle get() = view?.findViewById<TextView>(R.id.coffee_title)
    private val coffeeDesc  get() = view?.findViewById<TextView>(R.id.coffee_desc)

    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_detail, container, false)

    fun setCoffeeData(id: Int) {
        when (id) {
            R.id.affogato -> {
                coffeeTitle?.text = getString(R.string.affogato_title)
                coffeeDesc?.text  = getString(R.string.affogato_desc)
            }
            R.id.americano -> {
                coffeeTitle?.text = getString(R.string.americano_title)
                coffeeDesc?.text  = getString(R.string.americano_desc)
            }
            R.id.latte -> {
                coffeeTitle?.text = getString(R.string.latte_title)
                coffeeDesc?.text  = getString(R.string.latte_desc)
            }
            R.id.cappuccino -> {
                coffeeTitle?.text = getString(R.string.cappuccino_title)
                coffeeDesc?.text  = getString(R.string.cappuccino_desc)
            }
            R.id.mocha -> {
                coffeeTitle?.text = getString(R.string.mocha_title)
                coffeeDesc?.text  = getString(R.string.mocha_desc)
            }
        }
    }
}