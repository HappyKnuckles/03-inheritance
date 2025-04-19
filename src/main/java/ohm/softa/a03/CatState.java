package ohm.softa.a03;

public interface CatState {
        int getDuration(Cat cat);
        Cat.State getStateType();
        CatState tick(Cat cat);
        CatState feed(Cat cat);

}
