package me.vponomarenko.modular.navigation.questions

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.nav.Store
import kotlinx.android.synthetic.main.fragment_questions.*


/**
 * Author: Valery Ponomarenko
 * Date: 30/01/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class QuestionsFragment : Fragment() {

    private val navigation = Store.instance.getNavigator() as QuestionsNavigation

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_questions, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_first_question.setOnClickListener {
            navigation.openQuestion(1)
        }
        button_second_question.setOnClickListener {
            navigation.openQuestion(2)
        }
        button_third_question.setOnClickListener {
            navigation.openQuestion(3)
        }
        button_leaderboard.setOnClickListener {
            navigation.openLeaderboard()
        }

        change_lang.setOnClickListener { changeLanguage() }
    }

    override fun onResume() {
        super.onResume()
        navigation.bind(findNavController())
    }

//    private fun changeLanguage() {
//        val config: Configuration = requireActivity().resources.configuration
//        val currentLocale =
//            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
//                config.locales.get(0)
//            } else {
//                config.locale
//            }
//        val locale = if (currentLocale == Locale("th")) Locale("en") else Locale("th")
//        Locale.setDefault(locale)
//        RuntimeLocaleChanger.overrideLocale(requireContext(), locale)
//        relaunch()
//    }


    private fun changeLanguage() {
        val config: Configuration = requireContext().applicationContext.resources.configuration
        val currentLocale =
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                config.locales[0]
            } else {
                config.locale
            }
        val locale = if (currentLocale.language == "th") "en" else "th"
        MyContextWrapper.updateLocale(requireContext().applicationContext, locale)
        relaunch()
    }

    fun relaunch() {
        Handler().post {
            val intent = activity!!.intent
            intent.addFlags(
                Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                        or Intent.FLAG_ACTIVITY_NO_ANIMATION
            )
            startActivity(intent)
            activity!!.finish()
            activity!!.overridePendingTransition(0, 0)
        }
    }
}