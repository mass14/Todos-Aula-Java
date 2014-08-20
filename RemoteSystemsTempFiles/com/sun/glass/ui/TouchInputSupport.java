/*
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package com.sun.glass.ui;

import com.sun.glass.events.GestureEvent;
import com.sun.glass.events.TouchEvent;

import java.util.HashMap;
import java.util.Map;

public class TouchInputSupport
{
    private int touchCount = 0;

    private boolean filterTouchCoordinates;
    private Map<Long, Integer> touchX;
    private Map<Long, Integer> touchY;

    private TouchCountListener listener;

    private int curTouchCount;
    private View curView;
    private int curModifiers;
    private boolean curIsDirect;

    public static interface TouchCountListener {
        void touchCountChanged(TouchInputSupport sender, View view,
                               int modifiers, boolean isDirect);
    }

    public TouchInputSupport(TouchCountListener listener,
                             boolean filterTouchCoordinates) {
        Application.checkEventThread();
        this.listener = listener;
        this.filterTouchCoordinates = filterTouchCoordinates;
        if (filterTouchCoordinates) {
            touchX = new HashMap<Long, Integer>();
            touchY = new HashMap<Long, Integer>();
        }
    }

    public int getTouchCount() {
        Application.checkEventThread();
        return touchCount;
    }

    public void notifyBeginTouchEvent(View view, int modifiers, boolean isDirect,
                                      int touchEventCount) {
        curTouchCount = touchCount;
        curView = view;
        curModifiers = modifiers;
        curIsDirect = isDirect;
        if (view != null) {
            view.notifyBeginTouchEvent(modifiers, isDirect, touchEventCount);
        }
    }

    public void notifyEndTouchEvent(View view) {
        if (view == null) {
            return;
        }

        view.notifyEndTouchEvent();

        // RT-21288. Notify outer world when touch point count changes
        if (curTouchCount != 0 && touchCount != 0 && curTouchCount != touchCount &&
                listener != null) {
            listener.touchCountChanged(this, curView, curModifiers, curIsDirect);
        }
    }

    public void notifyNextTouchEvent(View view, int state, long id, int x, int y,
                                     int xAbs, int yAbs)
    {
        switch (state) {
            case TouchEvent.TOUCH_RELEASED:
                touchCount--;
                break;
            case TouchEvent.TOUCH_PRESSED:
                touchCount++;
                break;
            case TouchEvent.TOUCH_MOVED:
            case TouchEvent.TOUCH_STILL:
                break;
            default:
                System.err.println("Unknown touch state: " + state);
                return;
        }
        
        if (filterTouchCoordinates) {
            state = filterTouchInputState(state, id, x, y);
        }

        if (view != null) {
            view.notifyNextTouchEvent(state, id, x, y, xAbs, yAbs);
        }
    }

    private int filterTouchInputState(int state, long id, int x, int y) {
        switch (state) {
            case TouchEvent.TOUCH_RELEASED:
                touchX.remove(id);
                touchY.remove(id);
                break;
            case TouchEvent.TOUCH_MOVED:
                if (x == touchX.get(id) && y == touchY.get(id)) {
                    state = TouchEvent.TOUCH_STILL;
                    break;
                }
                // fall through;
            case TouchEvent.TOUCH_PRESSED:
                touchX.put(id, x);
                touchY.put(id, y);
                break;
            case TouchEvent.TOUCH_STILL:
                break;
            default:
                System.err.println("Unknown touch state: " + state);
                break;
        }
        return state;
    }
}
