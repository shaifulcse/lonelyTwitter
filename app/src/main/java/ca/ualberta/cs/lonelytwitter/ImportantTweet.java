package ca.ualberta.cs.lonelytwitter;

/**
 * Created by shaiful on 17/09/18.
 */

public class ImportantTweet extends Tweet {

    public ImportantTweet(String message){
        super(message);
    }

    @Override
    public boolean isImportant(){
        return true;
    }
}
