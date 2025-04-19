package ohm.softa.a03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HungryState implements CatState{
    private static final Logger logger = LogManager.getLogger();
    private final int duration;

    public HungryState(int duration) {
        this.duration = duration;
    }

    @Override
    public CatState feed(Cat cat) {
        return new DigestingSate(cat.getDigest());
    }

    @Override
    public CatState tick(Cat cat) {
        if(cat.getTime() == cat.getAwake()) {
            logger.info("I've starved for a too long time...good bye...");
            return new DeathState(0);
        } else {
            return this;
        }
    }

    @Override
    public int getDuration(Cat cat) {
        return cat.getSleep();
    }

    @Override
    public Cat.State getStateType() {
        return Cat.State.HUNGRY;
    }
}
