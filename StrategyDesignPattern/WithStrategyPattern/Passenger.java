package StrategyDesignPattern.WithStrategyPattern;

import StrategyDesignPattern.WithStrategyPattern.Strategy.DriveStrategyInterface;
import StrategyDesignPattern.WithStrategyPattern.Strategy.NormalDriveStrategy;

public class Passenger extends Vehicle{
    Passenger() {
        super(new NormalDriveStrategy());
    }
}
