package ohm.softa.a03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PlayState implements CatState{
    private static final Logger logger = LogManager.getLogger();
    private final int duration;

    public PlayState(int duration) {
        this.duration = duration;
    }
    @Override
    public CatState feed(Cat cat){
        throw new IllegalStateException("Can't stuff a cat while it is playing.");
    }

    @Override
    public CatState tick(Cat cat){
        if(cat.getTime() >= cat.getAwake()) {
            cat.setTime(0);
            logger.info("Yoan... getting tired!");
            return new SleepingState(cat.getSleep());
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
        return Cat.State.PLAYFUL;
    }
}
