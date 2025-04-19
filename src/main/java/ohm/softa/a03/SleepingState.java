package ohm.softa.a03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SleepingState implements CatState {

    private static final Logger logger = LogManager.getLogger();
    private final int duration;

    public SleepingState(int duration) {
        this.duration = duration;
    }

    @Override
    public CatState tick(Cat cat) {
        if (cat.getTime() >= duration) {
            cat.setTime(0);
            logger.info("Yoan... getting hungry!");
            return new HungryState(cat.getAwake());
        } else {
            return this;
        }
    }

    @Override
    public CatState feed(Cat cat) {
        logger.info("Cat is sleeping peacefully, can't feed it now.");
        throw new IllegalStateException("Can't stuff a cat while it's sleeping!");
    }

    @Override
    public int getDuration(Cat cat) {
        return cat.getSleep();
    }

    @Override
    public Cat.State getStateType() {
        return Cat.State.SLEEPING;
    }
}