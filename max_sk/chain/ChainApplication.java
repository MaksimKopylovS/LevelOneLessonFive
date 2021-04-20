package max_sk.chain;



public class ChainApplication{
        public static void main(String args[]){
            Bolnoy bolnoy = new Bolnoy("Нога");
            Registratura registratura = new Psihiator(null);
            Herurg herurg = new Herurg(registratura);
            herurg.setMaster("Нога");
            Registratura teropeft = new Teropeft(herurg);

            System.out.println(teropeft.doFilter(bolnoy));

        }
}

abstract class Registratura {
    private Registratura next;

    public Registratura(Registratura next){
        this.next = next;
    }

    public abstract boolean doFilter(Bolnoy bolnoy);

    public Registratura getNext(){
        return this.next;
    }
}

class Teropeft extends Registratura{
    private String master;

    public Teropeft(Registratura next) {
        super(next);
    }

    @Override
    public boolean doFilter(Bolnoy bolnoy) {
        if(bolnoy.getBolezn() == master){
            return true;
        }
        return this.getNext().doFilter(bolnoy);
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }
}

class Psihiator extends Registratura{
    private String master;

    public Psihiator(Registratura next) {
        super(next);
    }

    @Override
    public boolean doFilter(Bolnoy bolnoy) {
        if(bolnoy.getBolezn() == master){
            return true;
        }
        return false;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }
}

class Herurg extends Registratura{
    private String master;

    public Herurg(Registratura next) {
        super(next);
    }

    @Override
    public boolean doFilter(Bolnoy bolnoy) {
        if(bolnoy.getBolezn() == master){
            return true;
        }
        return this.getNext().doFilter(bolnoy);
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }
}

class Bolnoy{
   private String bolezn;

    Bolnoy(String bolezn) {
        this.bolezn = bolezn;
    }

    public String getBolezn() {
        return bolezn;
    }
}

