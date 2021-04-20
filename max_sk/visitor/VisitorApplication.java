package max_sk.visitor;

public class VisitorApplication {
    public static void main(String[] args) {
        Relis relis = new Relis1("String");
        Visitor visitor = new Test();
        relis.accept(visitor);
    }
}

interface Visitor{
    public void visit(Relis1 relis1);
    public void visit(Relis2 relis2);
}

abstract class Relis{
    public abstract void accept(Visitor visitor);

}

class Relis1 extends Relis {

    public Relis1(String s){
        System.out.println(s);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit( this );
    }

    public void foo(){
        System.out.println("Clacc: " + this.getClass());
    }
}

class Relis2 extends Relis {

    public Relis2(String s){
        System.out.println(s);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit( this );
    }

    public void foo(){
        System.out.println("Clacc: " + this.getClass());
    }
}

class Test implements Visitor{

    @Override
    public void visit(Relis1 relis1) {
        relis1.foo();
    }

    @Override
    public void visit(Relis2 relis2) {
        relis2.foo();
    }
}