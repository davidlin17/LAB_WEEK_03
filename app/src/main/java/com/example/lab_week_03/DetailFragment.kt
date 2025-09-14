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
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val coffeeId = arguments?.getInt(COFFEE_ID, 0) ?: 0
        setCoffeeData(coffeeId)
    }

        fun setCoffeeData(id: Int) { /* (sama seperti Part 2) */ }

                companion object {
            private const val COFFEE_ID = "COFFEE_ID"
            fun newInstance(id: Int) = DetailFragment().apply {
                arguments = Bundle().apply { putInt(COFFEE_ID, id) }
            }
        }
    }