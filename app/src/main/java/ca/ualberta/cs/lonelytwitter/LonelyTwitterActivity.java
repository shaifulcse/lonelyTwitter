package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class LonelyTwitterActivity extends Activity {


	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	
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
				Cat cat=new Cat();
				cat.setType("Cat");
				cat.setFood("Fish and rice");
				System.out.println("I am a "+cat.getType());
				System.out.println("I love "+cat.getFood());
				cat.makeSound();

				WildDuck duck =new WildDuck();
				duck.setType("WildDuck");
				duck.setFood("Fish");
                System.out.println("I am a "+duck.getType());
                System.out.println("I love "+duck.getFood());
                duck.makeSound();
                duck.doLike();
                duck.length();

                DomesticDuck domesticDuck =new DomesticDuck();
                domesticDuck.setType("Domestic Duck");
                domesticDuck.setFood("Fish and others");
                System.out.println("I am a "+domesticDuck.getType());
                System.out.println("I love "+domesticDuck.getFood());
                domesticDuck.makeSound();
                domesticDuck.doLike();
                domesticDuck.length();
			}
		});
	}




}