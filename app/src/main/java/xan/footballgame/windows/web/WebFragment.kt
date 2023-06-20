package xan.footballgame.windows.web

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import xan.footballgame.MainActivity
import xan.footballgame.databinding.FragmentWebBinding
import xan.footballgame.utils.Parametres
import xan.footballgame.utils.Parametres.LINK_REMOTE
import xan.footballgame.utils.Parametres.MUSIC_STATE


class WebFragment : Fragment() {
    private var _binding: FragmentWebBinding? = null

    private val binding get() = _binding!!


    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWebBinding.inflate(inflater, container, false)

        val mediaPlayer = (activity as MainActivity).mediaPlayer
        mediaPlayer.pause()
        MUSIC_STATE = false
        binding.webview.settings.javaScriptEnabled = true
        binding.webview.webViewClient = WebViewClient()
        binding.webview.loadUrl(LINK_REMOTE)

        return binding.root
    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}