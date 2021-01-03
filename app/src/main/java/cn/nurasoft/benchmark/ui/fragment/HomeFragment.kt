package cn.nurasoft.benchmark.ui.fragment

import cn.nurasoft.benchmark.base.BaseFragment
import cn.nurasoft.benchmark.mvp.contract.HomeContract
import cn.nurasoft.benchmark.mvp.model.bean.HomeBean

/**
 * Created by xuhao on 2017/11/8.
 * 分类
 */

class HomeFragment : BaseFragment(), HomeContract.View {
    override fun getLayoutId(): Int {
        return 0
    }

    override fun initView() {}
    override fun lazyLoad() {}

    override fun setHomeData(homeBean: HomeBean) {
    }

    override fun setMoreData(itemList: ArrayList<HomeBean.Issue.Item>) {
    }

    override fun showError(errorMsg: String, errorCode: Int) {
    }

    override fun showLoading() {
    }

    override fun dismissLoading() {
    }


/*

    private val mPresenter by lazy { CategoryPresenter() }

    private val mAdapter by lazy { activity?.let { CategoryAdapter(it, mCategoryList, R.layout.item_category) } }

    private var mTitle: String? = null
    private var mCategoryList = ArrayList<CategoryBean>()



    */
/**
     * 伴生对象
     *//*

    companion object {
        fun getInstance(title: String): CategoryFragment {
            val fragment = CategoryFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title
            return fragment
        }
    }


//    override fun getLayoutId(): Int = R.layout.fragment_category


    @Suppress("DEPRECATION")
    override fun initView() {
        mPresenter.attachView(this)


        mLayoutStatusView = multipleStatusView

        mRecyclerView.adapter = mAdapter
        mRecyclerView.layoutManager = GridLayoutManager(activity,2)
        mRecyclerView.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
                val position = parent.getChildPosition(view)
                val offset = DisplayManager.dip2px(2f)!!

                outRect.set(if (position % 2 == 0) 0 else offset, offset,
                        if (position % 2 == 0) offset else 0, offset)
            }

        })

        //状态栏透明和间距处理
//        StatusBarUtil.darkMode(activity)
//        StatusBarUtil.setPaddingSmart(activity, toolbar)
//        StatusBarUtil.setPaddingSmart(activity,mRecyclerView)

    }

    override fun lazyLoad() {

        //获取分类信息
        mPresenter.getCategoryData()
    }

    override fun showLoading() {
        multipleStatusView?.showLoading()
    }

    override fun dismissLoading() {
        multipleStatusView?.showContent()
    }

    */
/**
     * 显示分类信息
     *//*

    override fun showCategory(categoryList: ArrayList<CategoryBean>) {
        mCategoryList = categoryList
        mAdapter?.setData(mCategoryList)

    }

    override fun showError(errorMsg: String,errorCode:Int) {
        showToast(errorMsg)
        if (errorCode == ErrorStatus.NETWORK_ERROR) {
            multipleStatusView?.showNoNetwork()
        } else {
            multipleStatusView?.showError()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }

*/

}
