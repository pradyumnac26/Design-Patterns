package StrategyDesignPattern.WithStrategyPattern;
import StrategyDesignPattern.WithStrategyPattern.Strategy.DriveStrategyInterface;

public class Vehicle{
    //object create -> DriveStrategyInterface
    DriveStrategyInterface driveStrategyObject;

    //Constructor vehicle class - obj
    Vehicle(DriveStrategyInterface driveStrategyObject) {
        this.driveStrategyObject = driveStrategyObject;

    }
    public void drive(){
        driveStrategyObject.drive();
    }
}
