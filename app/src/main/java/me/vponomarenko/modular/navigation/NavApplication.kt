package me.vponomarenko.modular.navigation

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import com.example.nav.Store
import me.vponomarenko.modular.navigation.questions.LanguagePref
import me.vponomarenko.modular.navigation.questions.MyContextWrapper

/**
 * Author: Valery Ponomarenko
 * Date: 30/01/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class NavApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Store.instance.storeNavigator(Navigator())
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(MyContextWrapper.updateLocale(base, LanguagePref.getLanguage(base)))
//        super.attachBaseContext(RuntimeLocaleChanger.wrapContext(base))
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        MyContextWrapper.updateLocale(
            applicationContext,
            LanguagePref.getLanguage(applicationContext)
        )
//        RuntimeLocaleChanger.overrideLocale(this)
    }

}