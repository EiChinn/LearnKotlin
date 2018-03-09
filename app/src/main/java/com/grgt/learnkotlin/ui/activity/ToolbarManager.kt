package com.grgt.learnkotlin.ui.activity

import android.support.v7.widget.Toolbar

/**
 * Created by JDRJ on 2018/3/9.
 */
interface ToolbarManager {
    val toolbar: Toolbar

    var toolbarTitle: String
        get() = toolbar.title.toString()
        set(value) {
            toolbar.title = value
        }
}