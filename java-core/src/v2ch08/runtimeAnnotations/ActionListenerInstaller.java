package v2ch08.runtimeAnnotations;

import java.awt.event.ActionListener;
import java.lang.reflect.*;

public class ActionListenerInstaller {

    /**
     * Processes all ActionListenerFor annotations in the given object
     *
     * @param obj
     */
    public static void processAnnotations(Object obj) {
        Class<?> cl = obj.getClass();
        for (Method m : cl.getDeclaredMethods()) {
            ActionListenerFor a = m.getAnnotation(ActionListenerFor.class);
            if (a != null) {
                try {
                    Field field = cl.getDeclaredField(a.source());
                    field.setAccessible(true);
                    addListener(field.get(obj), obj, m);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Adds an action listener that calls a given method
     *
     * @param source the event source to which an action listener will be added
     * @param param  the implicit parameter of the method that the listener calls
     * @param m      the method that the listener calls
     */
    private static void addListener(Object source, final Object param, final Method m) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return m.invoke(param);
            }
        };

        Object listener = Proxy.newProxyInstance(null, new Class[]{java.awt.event.ActionListener.class}, handler);
        Method adder = source.getClass().getMethod("addActionListener", ActionListener.class);
        adder.invoke(source, listener);
    }

}
