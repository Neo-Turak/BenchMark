package cn.nurasoft.benchmark.rx.scheduler

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

//import io.reactivex.android.schedulers.AndroidSchedulers
//import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * Created by xuhao on 2017/11/17.
 * desc:
 */
class IoMainScheduler<T> : BaseScheduler<T>(Schedulers.io(), AndroidSchedulers.mainThread())
