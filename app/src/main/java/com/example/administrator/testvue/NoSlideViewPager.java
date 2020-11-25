package com.example.administrator.testvue;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by HSH on 2017/9/12.
 */

public class NoSlideViewPager extends ViewPager {

    private boolean enabled = false;

    public NoSlideViewPager(Context context) {
        super(context);
    }

    public NoSlideViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 触摸事件不触发
        if (this.enabled) {
            return super.onTouchEvent(event);
        }
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        // 不处理触摸拦截事件
        if (this.enabled) {
            return super.onInterceptTouchEvent(event);
        }
        return false;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        // 分发事件，这个是必须要的，如果把这个方法覆盖了，那么ViewPager的子View就接收不到事件了
        if (this.enabled) {
            return super.dispatchTouchEvent(event);
        }
        return super.dispatchTouchEvent(event);
    }

    public void setPagingEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}