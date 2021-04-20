package max_sk.command;

public class CommandApplication {
    public static void main(String[] args) {
        Commander commander = new Commander();
        Fonaric fonaric = new Fonaric();
        StartFonaric startFonaric = new StartFonaric(fonaric);
        commander.setCommand(startFonaric);
        commander.startCommand();

    }
}

interface Command{
    public void start();
}

class StartFonaric implements Command{
    private Fonaric fonaric;

    StartFonaric(Fonaric fonaric) {
        this.fonaric = fonaric;
    }

    @Override
    public void start() {
        fonaric.start();
    }
}

class Fonaric{
    public void start(){
        System.out.println("Свет");
    }
}

class Commander{
    private Command command;

    public void setCommand(Command command){
        this.command = command;
    }

    public void startCommand(){
        command.start();
    }
}