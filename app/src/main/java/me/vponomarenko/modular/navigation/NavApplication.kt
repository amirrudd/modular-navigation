package me.vponomarenko.modular.navigation

import android.app.Application
import com.example.nav.Store

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
}