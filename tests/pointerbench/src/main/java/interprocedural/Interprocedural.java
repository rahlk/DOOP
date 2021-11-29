/**
 * Modeling interprocedural calls
 */

public class Interprocedural {

    public static void func(A m, A n) {
        A f = m.getF();
        n.f = f;
    }

    public static void main(String[] args) {

        A a = new A();
        A b = new A();
        int n = args.length;
        if (n > 1) {
            b.h = new B();
        }
        else {
            a.h = new B();
        }
        Interprocedural ip1 = new Interprocedural();
        ip1.func(a, b);

        A x = a.f;
        A y = b.f;

        /*
         * allocId:1, mayAlias:[x,y], notMayAlias:[a,b], mustAlias:[x,y],
         * notMustAlias:[a,b]
         */
    }
}

class A {

    // Object A with attributes of type B

    public int i = 5;

    public A f = new A();
    public B g = new B();
    public B h;

    public A() {
    }

    public A(B b) {
        this.f = b;
    }

    public A getF() {
        return f;
    }

    public B getH() {
        return h;
    }

    public B id(B b) {
        return b;
    }

}

class B {
    public B() {
    }
}
