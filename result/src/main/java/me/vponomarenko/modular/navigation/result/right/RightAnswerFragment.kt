package me.vponomarenko.modular.navigation.result.right

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nav.Store
import kotlinx.android.synthetic.main.fragment_right.*
import me.vponomarenko.modular.navigation.result.R

/**
 * Author: Valery Ponomarenko
 * Date: 30/01/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class RightAnswerFragment : Fragment() {

    private val navigation = Store.instance.getNavigator() as RightAnswerNavigation

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_right, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_all_questions.setOnClickListener {
            navigation.openAllQuestions()
        }
    }
}