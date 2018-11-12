package chat.controller;
import javax.swing.JOptionPane;

import chat.model.Chatbot;


public class ChatController
{
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
	
	public String useChatbotCheckers(String text)
	{
		if (text.contains("spooky"));
		return text;
	}
	
	public Chatbot getChatbot()
	{
		return simpleBot;
	}
}
