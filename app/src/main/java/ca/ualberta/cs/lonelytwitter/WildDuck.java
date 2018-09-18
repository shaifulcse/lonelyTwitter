package ca.ualberta.cs.lonelytwitter;

/**
 * Created by shaiful on 17/09/18.
 */

public class WildDuck extends Animal implements FlyingBehaviour{
    @Override
    public void makeSound(){
    System.out.println("I Quack");
    }

    public void length() {
        System.out.println("Oh yeah, I love to fly long");
    }

    public void doLike(){
        System.out.println("Of course I like to fly");
    }
}
