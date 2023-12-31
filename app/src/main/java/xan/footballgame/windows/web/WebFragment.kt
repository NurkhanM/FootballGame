package xan.footballgame.windows.web

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import xan.footballgame.MyApp
import xan.footballgame.databinding.FragmentWebBinding
import xan.footballgame.utils.Parametres

class WebFragment : Fragment() {
    private var _binding: FragmentWebBinding? = null
    private val binding get() = _binding!!

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWebBinding.inflate(inflater, container, false)
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR
        return binding.root
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mediaPlayer = (requireActivity().application as MyApp).mediaPlayer
        mediaPlayer.pause()
        Parametres.MUSIC_STATE = false

        binding.webview.settings.javaScriptEnabled = true
        binding.webview.webViewClient = WebViewClient()
        binding.webview.loadUrl(Parametres.LINK_REMOTE)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
