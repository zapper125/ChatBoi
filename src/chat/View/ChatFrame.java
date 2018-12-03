package chat.View;

import javax.swing.JFrame;

import chat.controller.ChatController;

public class ChatFrame extends JFrame
{
	private ChatController appController;
	private ChatPanel appPanel; 
	
	public ChatFrame(ChatController appController)
	{
		super();
		this.appController = appController; 
		this.appPanel = new ChatPanel(appController);
		setupFrame();
	}

	private void setupFrame()
	{
		// TODO Auto-generated method stub
		
	}
	
	
}
