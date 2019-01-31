package v2ch09.auth;

import java.security.PrivilegedAction;

public
/**
 * This action looks up a system property
 */
class SysPropAction implements PrivilegedAction {

    private String propertyName;

    public SysPropAction(String propertyName) {
        this.propertyName = propertyName;
    }

    @Override
    public Object run() {
        return System.getProperty(propertyName);
    }
}
