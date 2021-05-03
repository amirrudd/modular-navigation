package me.vponomarenko.modular.navigation.questions

import android.content.Context
import android.content.ContextWrapper
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.os.LocaleList
import android.preference.PreferenceManager.getDefaultSharedPreferences
import java.util.*


class MyContextWrapper(base: Context?) : ContextWrapper(base) {
    companion object {
        fun updateLocale(c: Context, language: String): ContextWrapper {
            val localeToSwitchTo = Locale(language)
            var context = c
            val resources: Resources = context.resources
            val configuration: Configuration = resources.configuration

//            if (localeToSwitchTo == getSystemLocale(configuration)) {
//                //nothing needs to be done
//                return MyContextWrapper(context)
//            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                val localeList = LocaleList(localeToSwitchTo)
                LocaleList.setDefault(localeList)
                configuration.locales = localeList
            } else {
                configuration.locale = localeToSwitchTo
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
                context = context.createConfigurationContext(configuration)
            } else {
                resources.updateConfiguration(configuration, resources.displayMetrics)
            }
            return MyContextWrapper(context).also {
                LanguagePref.persistLanguage(context, localeToSwitchTo.language)
            }
        }


        fun getSystemLocale(config: Configuration): Locale {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                config.locales.get(0)
            } else {
                config.locale
            }
        }
    }
}

object LanguagePref {
    private const val LANGUAGE_KEY = "language_key"
    fun persistLanguage(context: Context, language: String) {
        getDefaultSharedPreferences(context).edit()
            .putString(LANGUAGE_KEY, language)
            .apply()

    }

    fun getLanguage(context: Context): String {
        return getDefaultSharedPreferences(context).getString(LANGUAGE_KEY, "en") ?: "en"
    }
}