package ca.ualberta.cs.lonelytwitter;

/**
 * Created by shaiful on 17/09/18.
 */

public class NormalTweet extends Tweet {

    public NormalTweet(String message){
        super(message);
    }
    @Override
    public boolean isImportant(){
        return false;
    }
}
