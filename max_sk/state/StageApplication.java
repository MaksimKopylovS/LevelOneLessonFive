package max_sk.state;

public class StageApplication {

    public static void main(String[] args) {
            Car bmw = new BMW();
            bmw.setDrive(new RoadDrive());
            bmw.goDrive();
            bmw.setDrive(new WaterDrive());
            bmw.goDrive();
    }
}

interface Drive {
    public void drive();
}

class RoadDrive implements Drive{
    @Override
    public void drive() {
        System.out.println("Едет по дороге");
    }
}

class WaterDrive implements Drive{
    @Override
    public void drive() {
        System.out.println("Едет по воде");
    }
}

abstract class Car {
    private Drive drive;

    public void setDrive(Drive drive) {
        this.drive = drive;
    }

    public void goDrive() {
        drive.drive();
    }
}

class BMW extends Car{
    public BMW(){
        setDrive(new RoadDrive());
    }
}

class Kater extends Car{
    public Kater(){
        setDrive(new WaterDrive());
    }
}
