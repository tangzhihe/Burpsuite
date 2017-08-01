package burp;

/*
 * @(#)IContextMenuFactory.java
 *
 * Copyright PortSwigger Ltd. All rights reserved.
 *
 * This code may be used to extend the functionality of Burp Suite Free Edition
 * and Burp Suite Professional, provided that this usage does not violate the
 * license terms for those products.
 */

import javax.swing.JMenuItem;
import java.util.List;

/**
 * Extensions can implement this interface and then call
 * <code>IBurpExtenderCallbacks.registerContextMenuFactory()</code> to register
 * a factory for custom context menu items.
 */
public interface IContextMenuFactory
{
    /**
     * This method will be called by Burp when the user invokes a context menu
     * anywhere within Burp. The factory can then provide any custom context
     * menu items that should be displayed in the context menu, based on the
     * details of the menu invocation.
     *
     * @param invocation An object that implements the
     * <code>IMessageEditorTabFactory</code> interface, which the extension can
     * query to obtain details of the context menu invocation.
     * @return A list of custom menu items (which may include sub-menus,
     * checkbox menu items, etc.) that should be displayed. Extensions may
     * return
     * <code>null</code> from this method, to indicate that no menu items are
     * required.
     * 
     * 当用户在Burp中的任何地方调用一个上下文菜单时，Burp则会调用这个工厂方法。此方法
     * 会根据菜单调用的细节，提供应该被显示在上下文菜单中的任何自定义上下文菜单项.
     */
    List<JMenuItem> createMenuItems(IContextMenuInvocation invocation);
}
