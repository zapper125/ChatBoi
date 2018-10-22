package chat.model;
import java.util.ArrayList;

public class Chatbot
{

	/**
	 * Getters
	 */

	
	public ArrayList<String> getSpookyList()
	{
		return SpookyList;
	}
	
	public ArrayList<String> getResponseList()
	{
		return null;
	}
	
	/**
	 * Setters
	 */

	// private constructors
	private ArrayList <String> ResponceList;
	{

	}

	private ArrayList <String> SpookyList;
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
		
		this.ResponceList = new ArrayList<String>();
		this.SpookyList = new ArrayList<String>();
		
		buildTheLists();
	}
	
	private void buildTheLists()
	{
		//responce list
		ResponceList.add("How's it going!");
		ResponceList.add("Thats pretty cool");
		ResponceList.add("Nice");
		ResponceList.add("Cool beans bro");
		ResponceList.add("Adios mi amigo");
		ResponceList.add("Who died?");
		
		//spooky doocky
		SpookyList.add("Ya she got cursed");
		SpookyList.add("SpOoKy");
		SpookyList.add("You shall be followed by a skeleton");
		SpookyList.add("It's over for you");
		SpookyList.add("Pumpkin Smashing");
	}
	
	public String processText(String userText)
	{
		String answer = "";
		
		answer += "you said: " + userText;
		
		return answer;
	}


}
