package cn.nurasoft.benchmark.tools

import java.io.IOException

class HttpResultException : IOException {
    var errorInfo: ErrorInfo? = null

    constructor(errorInfo: ErrorInfo?) {
        this.errorInfo = errorInfo
    }

    constructor(detailMessage: String?) : super(detailMessage) {}
}