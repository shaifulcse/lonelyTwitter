package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by shaiful on 17/09/18.
 */

public abstract class Tweet {
    private String message;
    private Date date;

    public Tweet(String mesaage){
        this.message=mesaage;
        this.date=new Date();
    }
    public Tweet(String message, Date date){
        this.message=message;
        this.date=date;
    }
    public abstract boolean isImportant();
    public String getMessage(){
        return this.message;
    }
    public Date getDate(){
        return this.date;
    }
    public void setMessage(String message){
        this.message=message;
    }
    public void setDate(Date date){
        this.date=date;
    }

    @Override
    public String toString(){
        return this.getMessage()+"|"+this.date.toString();
    }
}
