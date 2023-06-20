package xan.footballgame.windows.menu

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import xan.footballgame.MainActivity
import xan.footballgame.R
import xan.footballgame.databinding.FragmentMenuBinding
import xan.footballgame.utils.Parametres
import xan.footballgame.utils.Parametres.LINK_REMOTE
import xan.footballgame.utils.Parametres.MUSIC_STATE

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null



    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)

        val mediaPlayer = (activity as MainActivity).mediaPlayer
        if (MUSIC_STATE){
            mediaPlayer.start()
        }else{
            mediaPlayer.pause()
        }

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Parametres.GAME_TOTAL = 0
        Parametres.GAME_LIVE = 3

        binding.nextStart.setOnClickListener {
            findNavController().navigate(R.id.action_MenuFragment_to_gameFragment)
        }

        binding.nextSetting.setOnClickListener {
            findNavController().navigate(R.id.action_MenuFragment_to_settingsFragment)
        }
        binding.nextExit.setOnClickListener {
            activity?.finishAffinity()
        }

    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}