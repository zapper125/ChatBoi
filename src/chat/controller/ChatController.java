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
	}

	public void start()
	{
		//String UserInput = "";
		
			String userInput = "";
					
			while(!userInput.equalsIgnoreCase("quit"))
			{
				userInput = interactWithChatbot(userInput);
				System.exit(0);
			}
	
	}

	
	public String interactWithChatbot(String text)
	{
		String output = "";
		String userResponce = JOptionPane.showInputDialog(null, "Hi");
		text = userResponce;
		if (text == null)
		{
			JOptionPane.showMessageDialog(null, "input a value");
		}
	
		return text;
		
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
