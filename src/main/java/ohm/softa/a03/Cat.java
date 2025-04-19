package ohm.softa.a03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static ohm.softa.a03.Cat.State.*;

public class Cat {
	private static final Logger logger = LogManager.getLogger();

	// valid states
	public enum State {SLEEPING, HUNGRY, DIGESTING, PLAYFUL, DEAD}

	// initially, animals are sleeping
	private CatState currentState;
	// state durations (set via constructor), ie. the number of ticks in each state
	private final int sleep;
	private final int awake;
	private final int digest;

	public int getSleep() {
		return sleep;
	}

	public int getAwake() {
		return awake;
	}

	public int getDigest() {
		return digest;
	}

	public int getTime(){
		return time;
	}

	public int getTimeDigesting(){
		return timeDigesting;
	}

	public void setTimeDigesting(int timeDigesting){
		this.timeDigesting = timeDigesting;
	}

	public void setTime(int time){
		this.time = time;
	}

	private final String name;

	private int time = 0;
	private int timeDigesting = 0;

	public Cat(String name, int sleep, int awake, int digest) {
		this.name = name;
		this.sleep = sleep;
		this.awake = awake;
		this.digest = digest;
		currentState = new SleepingState(this.sleep);
	}

	public void tick(){
		logger.info("tick()");
		time = time + 1;
		this.currentState = this.currentState.tick(this);
		logger.info(currentState.getStateType().name());

	}

	/**
	 * This would be a user interaction: feed the cat to change its state!
	 */
	public void feed(){
		this.currentState = this.currentState.feed(this);
		timeDigesting = 0;
	}

	public State getCurrentStateType() {
		return this.currentState.getStateType();
	}

	public boolean isAsleep() {
		return getCurrentStateType() == State.SLEEPING;
	}

	public boolean isPlayful() {
		return getCurrentStateType() == State.PLAYFUL;
	}

	public boolean isHungry() {
		return getCurrentStateType() == State.HUNGRY;
	}

	public boolean isDigesting() {
		return getCurrentStateType() == State.DIGESTING;
	}

	public boolean isDead() {
		return getCurrentStateType() == State.DEAD;
	}

	@Override
	public String toString() {
		return name;
	}

}
