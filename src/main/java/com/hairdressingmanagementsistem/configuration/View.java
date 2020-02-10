package com.hairdressingmanagementsistem.configuration;


/**
 * Web Request filter views
 */
public class View {
    /**
     * Filter for user requests
     */
    public static interface UserView {}

    /**
     * Filter for admin requests
     */
    public static interface AdminView extends UserView {}

}