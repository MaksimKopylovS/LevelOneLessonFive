package max_sk.template_method;

public class TemplateMethodApplication {
    public static void main(String[] args) {
        new Clendar().seson();
    }
}

abstract class Year{

    public final void seson(){
        winter();
        summer();
        autumn();
        spring();
    }

    private void winter(){
        System.out.println("Зима");
    }
    private void summer(){
        System.out.println("Лето");
    }
    private void autumn(){
        System.out.println("Осень");
    }
    private void spring(){
        System.out.println("Зима");
    }
}
class Clendar extends Year{


}
