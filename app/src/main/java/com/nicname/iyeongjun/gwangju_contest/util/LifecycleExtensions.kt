package com.nicname.iyeongjun.gwangju_contest.util

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver


operator fun Lifecycle.plusAssign(observer: LifecycleObserver)
        = this.addObserver(observer)
