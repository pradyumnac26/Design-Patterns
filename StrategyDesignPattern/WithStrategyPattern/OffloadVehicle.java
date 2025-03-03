package StrategyDesignPattern.WithStrategyPattern;

import StrategyDesignPattern.WithStrategyPattern.Strategy.SportsDriveStrategy;

public class OffloadVehicle extends Vehicle {

    OffloadVehicle(){
        super (new SportsDriveStrategy());
    }

}
