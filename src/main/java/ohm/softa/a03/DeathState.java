package ohm.softa.a03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeathState implements CatState{
    private static final Logger logger = LogManager.getLogger();
    private final int duration;
    public DeathState(int duration) {
        this.duration = duration;
    }
    @Override
    public CatState feed(Cat cat){
        throw new IllegalStateException("Can't stuff a cat while it is dead.");
    }

    @Override
    public int getDuration(Cat cat) {
        return 0;
    }

    @Override
    public CatState tick(Cat cat) {
        return this;
    }

    @Override
    public Cat.State getStateType(){
        return Cat.State.DEAD;
    }
}
