/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
/**
 * Contains the API for {@link io.github.mmm.ui.widget.custom.UiCustomWidget} and its sub-classes. While all native
 * widgets of this API are provided as interface to be implemented for native UI toolkits, here we provide custom
 * widgets as a classes to extend by users building client UIs. These are delegating to a
 * {@link io.github.mmm.ui.widget.UiNativeWidget native widget} and allow to build reusable structures and components in
 * your client UI what would be rather tricky with just interfaces. This way you can follow known best-practices such as
 * divide and conquer, separation of concerns, etc. and build smaller reusable UI components that you compose to larger
 * and more and more complex parts of your UI to make it modular and maintainable.
 */
package io.github.mmm.ui.widget.custom;
