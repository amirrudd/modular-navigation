package me.vponomarenko.modular.navigation

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.nav.Store
import me.vponomarenko.modular.navigation.questions.LanguagePref
import me.vponomarenko.modular.navigation.questions.MyContextWrapper


class MainActivity : AppCompatActivity() {

    private val navigator = Store.instance.getNavigator() as Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        navigator.bind(findNavController(R.id.nav_host_fragment))
    }

    override fun onPause() {
        navigator.unbind()
        super.onPause()
    }

    override fun onSupportNavigateUp(): Boolean =
        findNavController(R.id.nav_host_fragment).navigateUp()

    override fun attachBaseContext(base: Context) {
//        super.attachBaseContext(RuntimeLocaleChanger.wrapContext(base))
        super.attachBaseContext(MyContextWrapper.updateLocale(base, LanguagePref.getLanguage(base)))
    }
}
