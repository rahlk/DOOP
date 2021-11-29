/**
 * Modeling interprocedural calls
 */

public class Interprocedural1 {

  public static void func(A m, A n) {
    B f = m.getF(); 
    n.f = f;
  }

  public static void main(String[] args) {

    A a = new A();
    A b = new A();

    b.f = new B();
    Interprocedural1 ip1 = new Interprocedural1();
    ip1.func(a, b);

    B x = a.f;
    B y = b.f;

    /* 
     * allocId:1, mayAlias:[x,y], notMayAlias:[a,b], mustAlias:[x,y], notMustAlias:[a,b]
     */
  }
}
