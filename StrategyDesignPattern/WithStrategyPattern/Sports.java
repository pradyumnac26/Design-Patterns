package StrategyDesignPattern.WithStrategyPattern;

import StrategyDesignPattern.WithStrategyPattern.Strategy.DriveStrategyInterface;
import StrategyDesignPattern.WithStrategyPattern.Strategy.SportsDriveStrategy;

public class Sports extends Vehicle{
    Sports( ) {
        super(new SportsDriveStrategy());
    }
}
