package max_sk.interpreter;

import java.beans.Expression;

public class InterpreterApplication {
    public static void main(String[] args) {
        Mikroovolnovka mikroovolnovka = new Mikroovolnovka();
        Usera user = new Usera();
        Interpreter morozinik = new Morozinik(mikroovolnovka);
        morozinik.interpret(user);

        Interpreter duhovka = new Duhovka(mikroovolnovka);
        duhovka.interpret(user);

    }
}

class Mikroovolnovka {

    public void gret() {
        System.out.println("Греет");
    }

    public void razmorozka() {
        System.out.println("Рapмораживает");
    }
}

interface Interpreter {
    void interpret(Usera user);
}

class Usera {
    public void razogret(Mikroovolnovka mikroovolnovka) {
        mikroovolnovka.gret();
    }

    public void razmorozit(Mikroovolnovka mikroovolnovka) {
        mikroovolnovka.razmorozka();
    }
}

class Morozinik implements Interpreter {
    private Mikroovolnovka mikroovolnovka;

    Morozinik(Mikroovolnovka mikroovolnovka) {
        this.mikroovolnovka = mikroovolnovka;
    }

    @Override
    public void interpret(Usera user) {
        user.razmorozit(mikroovolnovka);
        System.out.println("Замораживает");
    }
}

class Duhovka implements Interpreter {
    private Mikroovolnovka mikroovolnovka;

    public Duhovka(Mikroovolnovka mikroovolnovka) {
        this.mikroovolnovka = mikroovolnovka;
    }


    @Override
    public void interpret(Usera user) {
        user.razogret(mikroovolnovka);
        System.out.println("Запекает");
    }
}