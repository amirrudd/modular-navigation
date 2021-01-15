package me.vponomarenko.modular.navigation.leaderboard

import me.vponomarenko.modular.navigation.common.BaseNavigatorInterface

/**
 * Author: Valery Ponomarenko
 * Date: 2019-08-07
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

interface LeaderboardNavigation : BaseNavigatorInterface {
    fun openQuestionPreview(questionId: Long)
}