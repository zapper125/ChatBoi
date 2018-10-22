package chat.model;
import java.util.ArrayList;

public class Chatbot
{

	/**
	 * Getters
	 */

	/**
	 * Setters
	 */

	// private constructors
	private ArrayList <String> responceListArray;
	{

	}

	private ArrayList <String> spookyListArray;
	{

	}

	private String content;
	private String currentUser;
	private String joke;
	
	public Chatbot()
	{
		this.joke = "";
		this.content = new String("");
		this.currentUser = new String("");
		
		this.responceListArray = new ArrayList<String>();
		this.spookyListArray = new ArrayList<String>();
		
		buildTheLists();
	}
	
	private void buildTheLists()
	{
		//responce list
		responceListArray.add("How's it going!");
		responceListArray.add("Thats pretty cool");
		responceListArray.add("Nice");
		responceListArray.add("Cool beans bro");
		responceListArray.add("Adios mi amigo");
		responceListArray.add("Who died?");
		
		//spooky doocky
		spookyListArray.add("Ya she got cursed");
		spookyListArray.add("SpOoKy");
		spookyListArray.add("You shall be followed by a skeleton");
		spookyListArray.add("It's over for you");
		spookyListArray.add("Pumpkin Smashing");
	}
	
	public String processText(String userText)
	{
		String answer = "";
		
		answer += "you said: " + userText;
		
		return answer;
	}
}
