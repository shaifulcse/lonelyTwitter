package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	ArrayAdapter<Tweet> adapter;
	ArrayList<Tweet> tweets;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {

				String text = bodyText.getText().toString();
				ImportantTweet newTweet= new ImportantTweet(text);
				tweets.add(newTweet);
				saveInFile(tweets, new Date(System.currentTimeMillis()));

				adapter.notifyDataSetChanged();

			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		tweets= loadFromFile();

		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

	private ArrayList<Tweet> loadFromFile() {
		ArrayList<Tweet> tweets = new ArrayList<Tweet>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			Gson gson=new Gson();
			Type listType=new TypeToken<ArrayList<ImportantTweet>>(){}.getType();


			tweets=gson.fromJson(in, listType);
			Log.d("chowdhury", Integer.toString(tweets.size()));

		} catch (FileNotFoundException e) {

			// TODO Auto-generated catch block
			Log.d("chowdhury","I am here");

			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tweets;
	}
	
	private void saveInFile(ArrayList<Tweet> tweets, Date date) {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					0);
		//	BufferedWriter write= new BufferedWriter(new OutputStreamWriter(fos));
			OutputStreamWriter write =new OutputStreamWriter(fos);
			Gson gson= new Gson();
			gson.toJson(tweets,write);
			write.flush();
			fos.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}