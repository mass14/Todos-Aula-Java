/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.tk.quantum;

import com.sun.javafx.logging.PulseLogger;
import com.sun.prism.Graphics;
import com.sun.prism.GraphicsPipeline;
import com.sun.prism.impl.Disposer;
import com.sun.prism.impl.ManagedResource;

/**
 * The PresentingPainter is used when we are rendering to the main screen.
 * UploadingPainter is used when we need to render into an offscreen buffer.
 */
final class PresentingPainter extends ViewPainter {

    PresentingPainter(ViewScene view) {
        super(view);
    }

    @Override public void run() {
        renderLock.lock();

        boolean locked = false;
        boolean valid = false;
        boolean errored = false;

        try {
            valid = validateStageGraphics();
            if (!valid) {
                if (QuantumToolkit.verbose) {
                    System.err.println("PresentingPainter: validateStageGraphics failed");
                }
                return;
            }
            
            /*
             * As Glass is responsible for creating the rendering contexts,
             * locking should be done prior to the Prism calls.
             */
            sceneState.lock();
            locked = true;
            
            if (factory == null) {
                factory = GraphicsPipeline.getDefaultResourceFactory();
            }
            if (factory == null || !factory.isDeviceReady()) {
                sceneState.getScene().entireSceneNeedsRepaint();
                return;
            }

            if (presentable != null && presentable.lockResources(sceneState)) {
                disposePresentable();
            }
            if (presentable == null) {
                presentable = factory.createPresentable(sceneState);
                penWidth  = viewWidth;
                penHeight = viewHeight;
            }
            
            if (presentable != null) {
                Graphics g = presentable.createGraphics();

                ViewScene vs = (ViewScene) sceneState.getScene();
                if (g != null) {
                    paintImpl(g);
                }

                long start = PulseLogger.PULSE_LOGGING_ENABLED ? System.currentTimeMillis() : 0;
                if (!presentable.prepare(null)) {
                    disposePresentable();
                    sceneState.getScene().entireSceneNeedsRepaint();
                    if (PulseLogger.PULSE_LOGGING_ENABLED) {
                        PulseLogger.PULSE_LOGGER.renderMessage(start, System.currentTimeMillis(), "Presentable.prepare");
                    }
                    return;
                }
                
                /* present for vsync buffer swap */
                start = PulseLogger.PULSE_LOGGING_ENABLED ? System.currentTimeMillis() : 0;
                if (vs.getDoPresent()) {
                    if (!presentable.present()) {
                        disposePresentable();
                        sceneState.getScene().entireSceneNeedsRepaint();
                    }
                    if (PulseLogger.PULSE_LOGGING_ENABLED) {
                        PulseLogger.PULSE_LOGGER.renderMessage(start, System.currentTimeMillis(), "Presentable.present");
                    }
                }
            }
        } catch (Throwable th) {
            errored = true;
            th.printStackTrace(System.err);
        } finally {
            if (valid) {
                Disposer.cleanUp();
            }
            if (locked) {
                sceneState.unlock();
            }

            ViewScene viewScene = (ViewScene)sceneState.getScene();
            viewScene.setPainting(false);

            ManagedResource.freeDisposalRequestedAndCheckResources(errored);

            renderLock.unlock();
            if (PulseLogger.PULSE_LOGGING_ENABLED) {
                PulseLogger.PULSE_LOGGER.renderMessage(System.currentTimeMillis(), System.currentTimeMillis(), "Finished Presenting Painter");
            }
        }
    }
}
