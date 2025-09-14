import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

interface CoffeeListener { fun onSelected(id: Int) }
import androidx.fragment.app.FragmentContainerView

class MainActivity : AppCompatActivity(), CoffeeListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.fragment_container)) { v, insets ->
                val sb = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(sb.left, sb.top, sb.right, sb.bottom); insets
            }
            if (savedInstanceState == null) {
                findViewById<FragmentContainerView>(R.id.fragment_container).let { container ->
                    supportFragmentManager.beginTransaction()
                        .add(container.id, ListFragment())
                        .commit()
                }
            }
        }

        override fun onSelected(id: Int) {
            val detail = supportFragmentManager.findFragmentById(R.id.fragment_detail) as DetailFragment
            detail.setCoffeeData(id)
            findViewById<FragmentContainerView>(R.id.fragment_container).let { container ->
                val detail = DetailFragment.newInstance(id)
                supportFragmentManager.beginTransaction()
                    .replace(container.id, detail)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }