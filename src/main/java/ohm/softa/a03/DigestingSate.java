package ohm.softa.a03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DigestingSate implements CatState{
    private static final Logger logger = LogManager.getLogger();
    private final int duration;
    public DigestingSate(int duration) {
        this.duration = duration;
    }

    @Override
    public CatState feed(Cat cat){
        throw new IllegalStateException("Can't stuff a cat while it is digesting.");
    }

    @Override
    public CatState tick(Cat cat) {
        cat.setTimeDigesting(cat.getTimeDigesting() + 1);
        if(cat.getTimeDigesting() == cat.getDigest()){
            logger.info("Getting in a playful mood!");
            return new PlayState(cat.getAwake());
        } else {
            return this;
        }
    }

    @Override
    public int getDuration(Cat cat) {
        return cat.getDigest();
    }

    @Override
    public Cat.State getStateType(){
        return Cat.State.DIGESTING;
    }
}
