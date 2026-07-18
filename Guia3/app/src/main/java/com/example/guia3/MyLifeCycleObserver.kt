package com.example.guia3

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import  androidx.lifecycle.LifecycleOwner


class MyLifeCycleObserver(val activity:String) : DefaultLifecycleObserver {
    /* Callbacks */
    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.d("MyLifeCycleObserver", "$activity -> onCreate")
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        Log.d("MyLifeCycleObserver", "onStart")
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.d("MyLifeCycleObserver","onResesume")
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        Log.d("MyLifeCycleObserver", "onStop")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        Log.d("MyLifeCycleObserver", "onDestroy")
    }
}
