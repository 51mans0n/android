package com.example.sis2


import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class FlowCollectorLifecycleObserver<T>(
    private val owner: LifecycleOwner,
    private val flow: StateFlow<T>,
    private val onEach: (T) -> Unit
) : DefaultLifecycleObserver {
    private var job: Job? = null
    override fun onStart(owner: LifecycleOwner) {
        job = owner.lifecycleScope.launch { flow.collect { onEach(it) } }
    }
    override fun onStop(owner: LifecycleOwner) {
        job?.cancel()
        job = null
    }
}