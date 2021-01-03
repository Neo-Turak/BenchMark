package cn.nurasoft.benchmark

import cn.nurasoft.benchmark.tools.HttpResult
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface IService {
@POST("${RestFul.GET_CONTEXT}")
    fun GET_CONTEXT(@Body body: Body):Observable<HttpResult<Boolean>>
}