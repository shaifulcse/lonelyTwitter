package ca.ualberta.cs.lonelytwitter;

import android.util.Log;

/**
 * Created by shaiful on 17/09/18.
 */

public class Animal {

    protected String type;
    protected String food;

    public void makeSound(){
        System.out.println("I can make sounds");
    }

    public void setType(String type){
        this.type=type;

    }
    public void setFood(String food){
        this.food=food;
    }
    public String getType(){
        return this.type;
    }
    public String getFood(){
        return this.food;
    }
}
