package chat.model;

import java.util.ArrayList;
import chat.View.ChatFrame;


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
		return ResponseList;
	}

	public String getContent()
	{
		return content;
	}

	public String getCurrentUser()
	{
		return currentUser;
	}

	/**
	 * Setters
	 */

	// private constructors
	private ArrayList<String> ResponseList;
	{
		
	}

	private ArrayList<String> SpookyList;
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

		this.ResponseList = new ArrayList<String>();
		this.SpookyList = new ArrayList<String>();

		buildTheLists();
	}

	private void buildTheLists()
	{
		// responce list
		ResponseList.add("Hello");
		ResponseList.add("Thats pretty cool");
		ResponseList.add("Nice");
		ResponseList.add("Cool beans bro");
		ResponseList.add("Adios mi amigo");
		ResponseList.add("Who died?");
		ResponseList.add("a");
		ResponseList.add("s");
		ResponseList.add("d");
		ResponseList.add("f");
		ResponseList.add("g");
		ResponseList.add("h");
		ResponseList.add("j");
		ResponseList.add("k");
		ResponseList.add("l");
		ResponseList.add(";");

		// spooky doocky
		SpookyList.add("Halloween");
		SpookyList.add("Ya she got cursed");
		SpookyList.add("SpOoKy");
		SpookyList.add("You shall be followed by a skelington");
		SpookyList.add("It's over for you");
		SpookyList.add("Pumpkin Smashing");
		SpookyList.add("s");
		SpookyList.add("d");
		SpookyList.add("f");
	}

	public Boolean legitimacyChecker(String input)
	{
		boolean isValid = true;
		if (input == null)
		{
			isValid = false;
		} 
		else if (input.length() < 1)
		{
			isValid = false;
		} 
		else if (input.contains("sdf") || input.contains("cvb"))
		{
			isValid = false;
		}

		return isValid;
	}

	  public boolean contentChecker(String userText) {
	        boolean isContent = false;
	        // String text = "words";
	        if (userText.contains(" " + content + " ")) {
	            isContent = true;
	        }
	        else if (userText.contains("You said the special words")) {
	            isContent = true;
	        }
	        else if (userText.equals(content)) {
	            isContent = true;
	        }
	        else if (getContent() != "") {
	            isContent = false;
	        }
	        else if (!userText.contains(" " + getContent())) {
	            isContent = false;
	        }
	        else if (userText == null) {
	            isContent = false;
	        }
	        return isContent;
	    }

	public Boolean spookyChecker(String userText)
	{
		if (userText.contains("Halloween"))
			return true;
		if (userText.contains("Easter"))
			return false;
		for (String Phrase : SpookyList)
		{
			if (userText.contains(Phrase))
			{
				return true;
			}
		}
		return false;
	}

	public Chatbot(String string)
	{
		content = "sample content";
	}

	public String processText(String userText)
	{
		String answer = "";
		
		if (!contentChecker(userText))
		{
			answer += "You really should not send null\n";
		}
		else
		{
			answer += "you said " + userText + "\n";
			
			if (contentChecker(userText))
			{
				answer += "You said the special words.\n";
			}
			int randomIndex = (int) (ResponseList.size() * Math.random());
			answer += "Chatbot says:" + ResponseList.get(randomIndex) + "\n";
			}
		return answer;
		}
		
		

	}


