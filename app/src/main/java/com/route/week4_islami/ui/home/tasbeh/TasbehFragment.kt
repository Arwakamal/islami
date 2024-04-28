import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.week4_islami.R
import com.route.week4_islami.databinding.FragmentTasbehBinding

class TasbehFragment : Fragment() {

    lateinit var viewBinding: FragmentTasbehBinding

    var currentIndex = 0
    var counter = 0
    lateinit var azkarList: MutableList<String>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentTasbehBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        azkarList = resources.getStringArray(R.array.azkarList).toMutableList()
        viewBinding.btnZekrName.text = azkarList[currentIndex]
        viewBinding.tvZekrCount.text = counter.toString()
        onSebhaClick()
    }

    private fun onSebhaClick() {
        viewBinding.imvSebhaBody.setOnClickListener {
            viewBinding.imvSebhaBody.rotation += (360 / 33).toFloat()
            if (counter < 33) {
                counter++
            } else {
                counter = 0
                currentIndex =
                    if (currentIndex < azkarList.size - 1) ++currentIndex else 0
                viewBinding.btnZekrName.text = azkarList[currentIndex]
            }
            viewBinding.tvZekrCount.text = counter.toString()
        }
    }

}