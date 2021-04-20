package max_sk.mediator;

import java.util.ArrayList;
import java.util.List;

public class MediatorApplication {


    public static void main(String[] args) {
        ChatMediatorImpl mediator = new ChatMediatorImpl();
        User user1 = new UserImpl(mediator, "Pety");
        User user2 = new UserImpl(mediator, "Grishq");
        User user3 = new UserImpl(mediator, "Slava");
        User user4 = new UserImpl(mediator, "Vity");

        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);
        mediator.addUser(user4);

        mediator.sendMessage("Hello", user1);
    }
}

interface ChatMediator {
    public void sendMessage(String msg, User user);
    void addUser(User user);
}

abstract class User {
    private ChatMediator mediator;
    private String name;

    public User(ChatMediator med, String name) {
        this.mediator = med;
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public abstract void send(String msg);

    public abstract void receive(String msg);
}

class UserImpl extends User {
    private ChatMediator mediator;

    public UserImpl(ChatMediator med, String name) {
        super(med, name);
    }

    @Override
    public void send(String msg) {
        System.out.println(getName() + " Отправка собщения  " + msg);
        mediator.sendMessage(msg, this);
    }

    @Override
    public void receive(String msg) {
        System.out.println(getName() + " Получение сообщения " + msg);
    }
}


class ChatMediatorImpl implements ChatMediator {

    private List<User> users;

    public ChatMediatorImpl() {
        this.users = new ArrayList<>();
    }

    @Override
    public void sendMessage(String msg, User user) {
        for (User u : this.users) {
            if (u != user) {
                u.receive(msg);
            }
        }
    }

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }
}


