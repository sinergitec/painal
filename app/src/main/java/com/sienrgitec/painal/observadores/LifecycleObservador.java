package com.sienrgitec.painal.observadores;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class LifecycleObservador implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void recuperaCarrito() {
        System.out.println("On resumen");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void recuperaCarrito2() {
        System.out.println("On create");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void releaseCamera() {
        System.out.println("On Pause");
    }

}
