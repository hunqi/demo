package com.company;

import java.security.Permission;
import java.security.PermissionCollection;
import java.security.Policy;
import java.security.ProtectionDomain;
import java.util.Enumeration;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        System.setSecurityManager(new MySecurityManager());
        MySecurityManager securityManager = (MySecurityManager) System.getSecurityManager();
        securityManager.listPermissions();
    }

    class MySecurityManager extends SecurityManager {
        public void listPermissions() {
            Policy policy = Policy.getPolicy();
            Class[] classes = getClassContext();

            for (Class cls : classes){
                ProtectionDomain pd = cls.getProtectionDomain();
                PermissionCollection permissions = policy.getPermissions(pd);
                Enumeration<Permission> elements = permissions.elements();

                while (elements.hasMoreElements()){
                    System.out.println(elements.nextElement());
                }
            }
        }
    }
}
