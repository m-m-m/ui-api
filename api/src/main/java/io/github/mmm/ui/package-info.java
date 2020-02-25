/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
/**
 * Contains the API to build a toolkit-agnostic user-interface (UI).
 * <h2>The Problem</h2>
 *
 * Java and its enterprise edition aims at providing standard APIs that allow vendor independent programming. However,
 * to build user-interfaces Java only provided implementations but always missed to define a stable API. Therefore,
 * projects invested to build APIs with AWT, Swing, JavaFx, JSPs, JSF and also with tons of other proprietary frameworks
 * like SWT, JFace, EclipseRCP, Qt Jambi, Struts, Tapestry, Wicked, PrimeFaces, UltraFaces, GWT, SmartGWT, or Vaadin.
 * Just to name a few of the Java GUI Frameworks. Others gave up with Java and wanted to enter the browser hype with
 * JQuery, YUI, Dojo, SAP UI5, Amber, Knockout, Vue, React, AngularJS, Angular, Flutter, Ionic, etc. This list could go
 * on forever.
 *
 * However, it shows one common trend: GUI frameworks and related technology tended to come and go. This leads to loss
 * of huge investments and applies the principles of the "throwaway society" also to software clients. Java is however
 * famous for "security of investment" and stability. But if we have to build clients with JavaScript we have two
 * complex technology stacks if we keep Java for the backend. So Java is sooner or later dead if there is no strong
 * answer to build cross-platform clients.
 *
 * <h2>The Solution</h2>
 *
 * We define the missing API to build user-interfaces in Java. This does not require black-magic - after 20 years of
 * coding a button is still a button, a label is still a label and a text-input-field is still a text-input-field. The
 * latest and most hyped UI frameworks might bring ultimate flexibility to adopt to any kind of UI from a 3D game to a
 * data-driven-business app. However, they are still very poor to address the daily need of the latter kind of
 * applications such as (non-trivial) validation, accessibility, authorization, notifications, usability, or bindings
 * with call-by-value. Of course you can address all these demands and solve the problems but it is rather hard as they
 * are not build-in properly by design. Our API is designed exactly for this purpose and will massively boost your
 * productivity.
 *
 * As we provide implementations for this API that bridge to JavaFx, the browser, or other UI technologies you can build
 * a client once that runs on all supported platforms and technologies. You do not believe us? Then try our demo-ui and
 * see how the Java code runs as JavaScript in the browser while the same code runs in a JVM with JavaFx on the desktop.
 */
package io.github.mmm.ui;
