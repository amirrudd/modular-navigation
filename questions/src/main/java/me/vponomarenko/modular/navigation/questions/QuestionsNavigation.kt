package me.vponomarenko.modular.navigation.questions

import me.vponomarenko.modular.navigation.common.BaseNavigatorInterface

/**
 * Author: Valery Ponomarenko
 * Date: 30/01/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

interface QuestionsNavigation : BaseNavigatorInterface {
    fun openQuestion(questionId: Long)
    fun openLeaderboard()
}