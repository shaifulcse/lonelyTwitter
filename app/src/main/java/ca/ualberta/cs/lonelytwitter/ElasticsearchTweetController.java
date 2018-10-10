package ca.ualberta.cs.lonelytwitter;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.searchly.jestdroid.DroidClientConfig;
import com.searchly.jestdroid.JestClientFactory;
import com.searchly.jestdroid.JestDroidClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.searchbox.client.JestResult;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;

/**
 * Created by romansky on 10/20/16.
 */
public class ElasticsearchTweetController {

    private static JestDroidClient client=null;

    public static class AddTweetTask extends AsyncTask<Tweet, Void, Void>{
        @Override
        protected Void doInBackground(Tweet... p){
            setClient();
            Tweet tweet=p[0];
            Index index=new Index.Builder(tweet)
                    .index("shaiful-new-test")
                    .type("tweet")
                    .build();
            try {
                DocumentResult result=client.execute(index);
                if(result.isSucceeded()){
                    tweet.setTweetID(result.getId());

                }
            }catch(IOException e){}
            return null;
        }
    }

    public static class GetTweetsTask extends AsyncTask<String, Void, ArrayList<Tweet>>{
        @Override
        //String instead of void to implement search
        protected ArrayList<Tweet> doInBackground(String... params) {
            setClient();
            ArrayList<Tweet> tweets=new ArrayList<Tweet>();
            Search search = new Search.Builder(params[0])
                            .addIndex("shaiful-new-test")
                            .addType("tweet")
                    .build();
            try {
                JestResult result=client.execute(search);

                if(result.isSucceeded()){
                    List<NormalTweet> tweetList;
                tweetList=result.getSourceAsObjectList(NormalTweet.class);
                tweets.addAll(tweetList);
                }

            }catch(IOException e){}

            return tweets;
        }

    }

    public static class GetFilteredTweetsTask extends AsyncTask<String, Void, ArrayList<Tweet>>{
        @Override
        //String instead of void to implement search
        protected ArrayList<Tweet> doInBackground(String... params) {
            setClient();
            ArrayList<Tweet> tweets=new ArrayList<Tweet>();
            //Log.d("chowdhury",params[0]);
            String searchString="{ \"query\": { \"term\" : { \"message\" : \""
                    + params[0] + "\"}}}";
            Search search = new Search.Builder(searchString)
                    .addIndex("shaiful-new-test")
                    .addType("tweet")
                    .build();
            try {
                JestResult result=client.execute(search);

                if(result.isSucceeded()){
                //    Log.d("chowdhury","hit");
                    List<NormalTweet> tweetList;
                    tweetList=result.getSourceAsObjectList(NormalTweet.class);
                    tweets.addAll(tweetList);
                }

            }catch(IOException e){
               // Log.d("chowdhury", "did not hit");
            }

            return tweets;
        }

    }

    private static void setClient(){
        if(client==null){

            DroidClientConfig config =new DroidClientConfig
                    .Builder("http://cmput301.softwareprocess.es:8080/")
                    .build();
            JestClientFactory factory= new JestClientFactory();
            factory.setDroidClientConfig(config);
            client=(JestDroidClient) factory.getObject();

        }


    }


}