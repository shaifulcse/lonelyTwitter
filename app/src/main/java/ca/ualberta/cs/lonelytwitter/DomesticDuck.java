package ca.ualberta.cs.lonelytwitter;

/**
 * Created by shaiful on 17/09/18.
 */

public class DomesticDuck extends Animal implements FlyingBehaviour{
    @Override
    public void makeSound(){
        System.out.println("I Quack a lot");

    }
    public void length(){
        System.out.println("I fly for a short time");
    }
    public void doLike(){
        System.out.println("I only fly when I am forced");
    }
}
