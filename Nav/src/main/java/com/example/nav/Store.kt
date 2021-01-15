package com.example.nav

class Store {
    companion object {
        val instance = Store()
    }

    private var navigator: Any? = null

    fun storeNavigator(navigator: Any) {
        this.navigator = navigator
    }

    fun getNavigator(): Any {
        return navigator ?: throw NullPointerException("navigator is empty")
    }
}