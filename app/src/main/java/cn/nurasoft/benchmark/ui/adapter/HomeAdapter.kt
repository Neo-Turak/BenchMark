package cn.nurasoft.benchmark.ui.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import cn.bingoogolapple.bgabanner.BGABanner
import cn.nurasoft.benchmark.R
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import cn.nurasoft.benchmark.Constants

import cn.nurasoft.benchmark.durationFormat
import cn.nurasoft.benchmark.mvp.model.bean.HomeBean
import cn.nurasoft.benchmark.view.recyclerview.ViewHolder
import cn.nurasoft.benchmark.view.recyclerview.adapter.CommonAdapter
import com.google.android.flexbox.FlexboxLayoutManager

import io.reactivex.rxjava3.core.Observable

/**
 * Created by xuhao on 2017/11/23.
 * desc: 首页精选的 Adapter
 */

class HomeAdapter(context: Context, data: ArrayList<HomeBean.Issue.Item>)
    : CommonAdapter<HomeBean.Issue.Item>(context, data, -1) {


    // banner 作为 RecyclerView 的第一项
    var bannerItemSize = 0

    companion object {

        private const val ITEM_TYPE_BANNER = 1    //Banner 类型
        private const val ITEM_TYPE_TEXT_HEADER = 2   //textHeader
        private const val ITEM_TYPE_CONTENT = 3    //item
    }

    /**
     * 设置 Banner 大小
     */
    fun setBannerSize(count: Int) {
        bannerItemSize = count
    }

    /**
     * 添加更多数据
     */
    fun addItemData(itemList: ArrayList<HomeBean.Issue.Item>) {
        this.mData.addAll(itemList)
        notifyDataSetChanged()
    }


    /**
     * 得到 Item 的类型
     */
    override fun getItemViewType(position: Int): Int {
        return when {
            position == 0 ->
                ITEM_TYPE_BANNER
            mData[position + bannerItemSize - 1].type == "textHeader" ->
                ITEM_TYPE_TEXT_HEADER
            else ->
                ITEM_TYPE_CONTENT
        }
    }


    /**
     *  得到 RecyclerView Item 数量（Banner 作为一个 item）
     */
    override fun getItemCount(): Int {
        return when {
            mData.size > bannerItemSize -> mData.size - bannerItemSize + 1
            mData.isEmpty() -> 0
            else -> 1
        }
    }


    /**
     * 绑定布局
     */
    override fun bindData(holder: ViewHolder, data: HomeBean.Issue.Item, position: Int) {
        when (getItemViewType(position)) {
            //Banner
            ITEM_TYPE_BANNER -> {
            }
            //没有使用到的参数在 kotlin 中用"_"代替
            //TextHeader
            ITEM_TYPE_TEXT_HEADER -> {
            }
            //content
            ITEM_TYPE_CONTENT -> {
            }
        }

    }

    /**
     *  创建布局
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            ITEM_TYPE_BANNER ->
                ViewHolder(inflaterView(R.layout.item_home_banner, parent))
            ITEM_TYPE_TEXT_HEADER ->
                ViewHolder(inflaterView(R.layout.item_home_header, parent))
            else ->
                ViewHolder(inflaterView(R.layout.item_home_content, parent))
        }
    }


    /**
     * 加载布局
     */
    private fun inflaterView(mLayoutId: Int, parent: ViewGroup): View {
        //创建view
        val view = mInflater?.inflate(mLayoutId, parent, false)
        return view ?: View(parent.context)
    }
}

    /**
     * 加载 content item
     */
 /*   private fun setVideoItem(holder: ViewHolder, item: HomeBean.Issue.Item) {
        val itemData = item.data

        val defAvatar = R.mipmap.default_avatar
        val cover = itemData?.cover?.feed
        var avatar = itemData?.author?.icon
        var tagText: String? = "#"

        // 作者出处为空，就显获取提供者的信息
        if (avatar.isNullOrEmpty()) {
            avatar = itemData?.provider?.icon
        }
        // 加载封页图
        GlideApp.with(mContext)
                .load(cover)
                .placeholder(R.drawable.placeholder_banner)
                .transition(DrawableTransitionOptions().crossFade())
                .into(holder.getView(R.id.iv_cover_feed))

        // 如果提供者信息为空，就显示默认
        if (avatar.isNullOrEmpty()) {
            GlideApp.with(mContext)
                    .load(defAvatar)
                    .placeholder(R.mipmap.default_avatar).circleCrop()
                    .transition(DrawableTransitionOptions().crossFade())
                    .into(holder.getView(R.id.iv_avatar))

        } else {
            GlideApp.with(mContext)
                    .load(avatar)
                    .placeholder(R.mipmap.default_avatar).circleCrop()
                    .transition(DrawableTransitionOptions().crossFade())
                    .into(holder.getView(R.id.iv_avatar))
        }
        holder.setText(R.id.tv_title, itemData?.title ?: "")

        //遍历标签
        itemData?.tags?.take(4)?.forEach {
            tagText += (it.name + "/")
        }
        // 格式化时间
        val timeFormat = durationFormat(itemData?.duration)

        tagText += timeFormat

        holder.setText(R.id.tv_tag, tagText!!)

        holder.setText(R.id.tv_category, "#" + itemData?.category)

        holder.setOnItemClickListener(listener = View.OnClickListener {
            goToVideoPlayer(mContext as Activity, holder.getView(R.id.iv_cover_feed), item)
        })


    }

    *//**
     * 跳转到视频详情页面播放
     *
     * @param activity
     * @param view
     *//*
    private fun goToVideoPlayer(activity: Activity, view: View, itemData: HomeBean.Issue.Item) {
        val intent = Intent(activity, VideoDetailActivity::class.java)
        intent.putExtra(Constants.BUNDLE_VIDEO_DATA, itemData)
        intent.putExtra(VideoDetailActivity.TRANSITION, true)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            val pair = Pair(view, VideoDetailActivity.IMG_TRANSITION)
            val activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    activity, pair)
            ActivityCompat.startActivity(activity, intent, activityOptions.toBundle())
        } else {
            activity.startActivity(intent)
            activity.overridePendingTransition(R.anim.anim_in, R.anim.anim_out)
        }
    }*/


    /**
     * Kotlin的函数可以作为参数，写callback的时候，可以不用interface了
     */

/*    private var mOnTagItemClick: ((tag:String) -> Unit)? = null

    fun setOnTagItemClickListener(onTagItemClickListener:(tag:String) -> Unit) {
        this.mOnTagItemClick = onTagItemClickListener
    }

    override fun bindData(holder: ViewHolder, data: String, position: Int) {

        holder.setText(R.id.tv_title,data)

        val params = holder.getView<TextView>(R.id.tv_title).layoutParams
        if(params is FlexboxLayoutManager.LayoutParams){
            params.flexGrow = 1.0f
        }

        holder.setOnItemClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                mOnTagItemClick?.invoke(data)
            }

        }*/


