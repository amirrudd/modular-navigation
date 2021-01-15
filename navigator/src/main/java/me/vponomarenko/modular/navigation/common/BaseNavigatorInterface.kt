package me.vponomarenko.modular.navigation.common

import androidx.navigation.NavController

interface BaseNavigatorInterface {
    fun bind(navController: NavController)
    fun unbind()
}