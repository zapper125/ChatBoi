package chat.controller;
import javax.swing.JOptionPane;

import chat.model.Chatbot;


public class ChatController
{
	private Chatbot simpleBot;

	public  void Controller()
	{
		simpleBot = new Chatbot();
	}

	public void start()
	{
		//String UserInput = "";
		
			String userInput = "";
					
			while(!userInput.equalsIgnoreCase("quit"))
			{
				userInput = interactWithBot(userInput);
			}
	
	}

	
	public String interactWithBot(String text)
	{
		String output = "";
		String userResponse = JOptionPane.showInputDialog(null, "Hi");
		output = simpleBot.processText(userResponse);
		
		return output;
	}
	
	public String useBotCheckers(String text)
	{
		String output = "";
		String userResponce = JOptionPane.showInputDialog(null, "Wazzzzzup");
		
		return output;
	}
	
	public Chatbot getChatbot()
	{
		return simpleBot;
	}
}
