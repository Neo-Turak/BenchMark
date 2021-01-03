package cn.nurasoft.benchmark.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle

import android.view.KeyEvent
import androidx.fragment.app.FragmentTransaction
import cn.nurasoft.benchmark.R
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import cn.nurasoft.benchmark.base.BaseActivity
import cn.nurasoft.benchmark.mvp.model.bean.TabEntity
import cn.nurasoft.benchmark.showToast
import cn.nurasoft.benchmark.ui.fragment.HomeFragment

import java.util.*


/**
 * @author Jake.Ho
 * created: 2017/10/25
 * desc:
 */


class MainActivity : BaseActivity() {


    private val mTitles = arrayOf("每日精选", "发现", "热门", "我的")

    // 未被选中的图标
    private val mIconUnSelectIds = intArrayOf(R.mipmap.ic_home_normal, R.mipmap.ic_discovery_normal, R.mipmap.ic_hot_normal, R.mipmap.ic_mine_normal)
    // 被选中的图标
    private val mIconSelectIds = intArrayOf(R.mipmap.ic_home_selected, R.mipmap.ic_discovery_selected, R.mipmap.ic_hot_selected, R.mipmap.ic_mine_selected)

    private val mTabEntities = ArrayList<CustomTabEntity>()

    private var mHomeFragment: HomeFragment? = null

    //默认为0
    private var mIndex = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            mIndex = savedInstanceState.getInt("currTabIndex")
        }
        super.onCreate(savedInstanceState)
        initTab()

        switchFragment(mIndex)

    }

    override fun layoutId(): Int {
        return R.layout.activity_main
    }


    //初始化底部菜单
    private fun initTab() {
        (0 until mTitles.size)
                .mapTo(mTabEntities) { TabEntity(mTitles[it], mIconSelectIds[it], mIconUnSelectIds[it]) }
        //为Tab赋值

    }

    /**
     * 切换Fragment
     * @param position 下标
     */
    private fun switchFragment(position: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        hideFragments(transaction)
        when (position) {
            0->{} // 首页
//            -> mHomeFragment?.let {
//                transaction.show(it)
//            } ?: HomeFragment.getInstance(mTitles[position]).let {
//                mHomeFragment = it
//                transaction.add(R.id.fl_container, it, "home")

        }

        mIndex = position
        transaction.commitAllowingStateLoss()
    }


    /**
     * 隐藏所有的Fragment
     * @param transaction transaction
     */
    private fun hideFragments(transaction: FragmentTransaction) {
        mHomeFragment?.let { transaction.hide(it) }
    }


    @SuppressLint("MissingSuperCall")
    override fun onSaveInstanceState(outState: Bundle) {
//        showToast("onSaveInstanceState->"+mIndex)
//        super.onSaveInstanceState(outState)
        //记录fragment的位置,防止崩溃 activity被系统回收时，fragment错乱
    }

    override fun initView() {

    }

    override fun initData() {

    }

    override fun start() {

    }

    private var mExitTime: Long = 0

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis().minus(mExitTime) <= 2000) {
                finish()
            } else {
                mExitTime = System.currentTimeMillis()
             showToast("再按一次退出程序")
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }


}
