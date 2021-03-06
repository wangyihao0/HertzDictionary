package com.w10group.hertzdictionary.app.biz.ui.statistics

import android.os.Bundle
import android.view.MenuItem
import com.w10group.hertzdictionary.app.core.architecture.BaseActivity

/**
 * 统计 Activity
 * @author Qiao
 */

class StatisticsActivity : BaseActivity<StatisticsActivity>() {

    override val uiComponent = StatisticsActivityUIComponent(this)
    override val implementer = this

    init { lifecycle.addObserver(uiComponent) }

    private lateinit var viewModel: StatisticsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = getAndroidViewModel {
            uiUpdateData.observe(implementer) {
                uiComponent.updateUI(it)
            }
        }
    }

    fun weekSelected() = viewModel.weekSelected()

    fun monthSelected() = viewModel.monthSelected()

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

}