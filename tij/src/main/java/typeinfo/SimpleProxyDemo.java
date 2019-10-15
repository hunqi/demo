package typeinfo;

public class SimpleProxyDemo {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        System.out.println();
        consumer(new SimpleProxy(new RealObject()));

        SimpleProxy.printMethodInvokeTimes();
    }

}

interface Interface {
    void doSomething();

    void somethingElse(String arg);
}

class RealObject implements Interface {
    public void doSomething() {
        System.out.println("doSomething");
    }

    public void somethingElse(String arg) {
        System.out.println(("somethingElse " + arg));
    }
}

class SimpleProxy implements Interface {
    private Interface proxied;
    private static int cntMethodInvokes;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    public void doSomething() {
        System.out.println("SimpleProxy doSomething");
        proxied.doSomething();
        cntMethodInvokes++;
    }

    public void somethingElse(String arg) {
        System.out.println("SimpleProxy somethingElse " + arg);
        proxied.somethingElse(arg);
        cntMethodInvokes++;
    }

    public static void printMethodInvokeTimes(){
        System.out.println("cntMethodInvokes: " + cntMethodInvokes);
    }
}
