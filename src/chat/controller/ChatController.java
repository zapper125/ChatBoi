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
	        String testedChecker = "these checkers passed:" + "\n";
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
	 
	 private void close()
	 {
		 System.exit(0);
	 }
	 
	 public  void handleErrors(Exception error)
	 {
		JOptionPane.showMessageDialog(appFrame,  error.getMessage()); 
	 }
	 
	 public ChatFrame getAppFrame()
	 {
		 return appFrame;
	 }
	
	public Chatbot getChatbot()
	{
		return simpleBot;
	}
}
