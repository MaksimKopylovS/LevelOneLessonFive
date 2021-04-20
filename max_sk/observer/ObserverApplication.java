package max_sk.observer;

import java.util.ArrayList;
import java.util.List;

public class ObserverApplication {
    public static void main(String[] args) {
        PoleNotefier pole = new PoleNotefier();
        Sportsmen sportsmen = new Sportsmen(pole);
        Sportsmen sportsmen2 = new Sportsmen(pole);
        Refferi refferi = new Refferi("Старт");
        pole.comandRefferi(refferi);

    }
}

interface Observer {
    public void comand();
}

class Sportsmen implements Observer {
    private PoleNotefier notifier;

    public Sportsmen(PoleNotefier notifier) {
        this.notifier = notifier;
        notifier.addObserver(this);
    }

    @Override
    public void comand() {
        System.out.println("Побежали");
    }
}

interface Notifier {
    public void addObserver(Observer add);

    public void removeObserver(Observer obs);

    public void notifyObserver();
}

class PoleNotefier implements Notifier {
    private List<Observer> observerList;

    public PoleNotefier() {
        observerList = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer obs) {

    }

    @Override
    public void notifyObserver() {
        for (Observer o : observerList) {
            o.comand();
        }
    }

    public void comandRefferi(Refferi refferi) {
        System.out.println(refferi.signal());
        notifyObserver();

    }
}

class Refferi {
    private String signal;

    Refferi(String signal) {
        this.signal = signal;

    }

    public String signal() {
        return signal;
    }


}