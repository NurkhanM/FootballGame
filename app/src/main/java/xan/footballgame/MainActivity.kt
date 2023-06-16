package xan.footballgame

import android.media.MediaPlayer
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import xan.footballgame.databinding.ActivityMainBinding
import xan.footballgame.utils.Parametres

class MainActivity : AppCompatActivity() {
    lateinit var mediaPlayer: MediaPlayer

    private lateinit var binding: ActivityMainBinding
    private lateinit var controller: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        // В вашей функции или методе инициализируйте mediaPlayer
        mediaPlayer = MediaPlayer.create(this, R.raw.fon_muz)
        setContentView(binding.root)

        controller = findNavController(R.id.nav_host_fragment_content_main)

    }

    private val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
        if (destination.id == R.id.MenuFragment) {
            if (Parametres.CURRENT_NUMBER_GAME >= Parametres.CURRENT_NUMBER_GAME_MAX){
                Parametres.CURRENT_NUMBER_GAME = 0
            }else{
                Parametres.CURRENT_NUMBER_GAME++
            }
        }
    }

    override fun onResume() {
        super.onResume()
        controller.addOnDestinationChangedListener(listener)
    }
}