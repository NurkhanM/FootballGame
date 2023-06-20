package xan.footballgame.windows.settings.rules

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import xan.footballgame.databinding.FragmentRulesBinding

class RulesFragment : Fragment() {

    private var _binding: FragmentRulesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentRulesBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backStack.setOnClickListener {
            activity?.onBackPressed()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}