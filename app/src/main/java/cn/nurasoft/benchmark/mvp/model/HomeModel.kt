package cn.nurasoft.benchmark.mvp.model

import cn.nurasoft.benchmark.mvp.model.bean.HomeBean
import cn.nurasoft.benchmark.net.RetrofitManager
import cn.nurasoft.benchmark.rx.scheduler.SchedulerUtils
import io.reactivex.rxjava3.core.Observable


/**
 * Created by xuhao on 2017/11/21.
 * desc: 首页精选 model
 */

class HomeModel{

    /**
     * 获取首页 Banner 数据
     */
    fun requestHomeData(num:Int): Observable<HomeBean> {
        return RetrofitManager.service.getFirstHomeData(num)
                .compose(SchedulerUtils.ioToMain())
    }

    /**
     * 加载更多
     */
    fun loadMoreData(url:String):Observable<HomeBean>{

        return RetrofitManager.service.getMoreHomeData(url)
                .compose(SchedulerUtils.ioToMain())
    }



}
