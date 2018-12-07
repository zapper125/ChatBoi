package chat.controller;
import javax.swing.JOptionPane;

import chat.View.ChatFrame;
import chat.model.Chatbot;


public class ChatController
{
	
	private ChatFrame appFrame; 
	private Chatbot simpleBot;

	public ChatController()
	{
		simpleBot = new Chatbot();
		appFrame = new ChatFrame(this);
	}

	public void start()
	{
	
	}

	
	public String interactWithChatbot(String text)
	{
		String output = "";
		output += simpleBot.processText(text);
		return output;
	}
	
	 public String useChatbotCheckers(String Text)
	    {
	        String testedChecker = "these checkers passed:";
	        if (simpleBot.contentChecker(Text))
	        {
	            testedChecker += "\nContent Checker";
	        }
	        if (simpleBot.spookyChecker(Text))
	        {
	            testedChecker += "Halloween";
	        }
	        return testedChecker;
	            
	        
	    }
	
	public Chatbot getChatbot()
	{
		return simpleBot;
	}
}
