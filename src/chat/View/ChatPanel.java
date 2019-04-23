package chat.View;

import javax.swing.*;
import chat.controller.ChatController;
import chat.controller.IOController;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatPanel extends JPanel
{

	private SpringLayout appLayout;
	private ChatController appController;
	private JButton chatButton;
	private JButton checkerButton;
	private JButton loadButton;
	private JButton saveButton;
	private JButton resetButton;
	private JTextField chatField;
	private JTextArea chatArea;
	private JScrollPane chatPane;
	private JPanel buttonPanel;
	private JButton TweetButton;
	private JButton searchTwitterButton;
	
	private ImageIcon chatIcon;
	private ImageIcon saveIcon;
	private ImageIcon loadIcon;
	private ImageIcon checkerIcon;
	private ImageIcon tweetIcon;
	private ImageIcon searchIcon;
	private ImageIcon resetIcon;

	public ChatPanel(ChatController appController)
	{
		super();
		this.appController = appController;
		appLayout = new SpringLayout();
		
		saveIcon = new ImageIcon(getClass().getResource("/chat/view/images/GrinchMega.jpg"));
		chatIcon = new ImageIcon(getClass().getResource("/chat/view/images/2LegCat.jpeg"));
		loadIcon = new ImageIcon(getClass().getResource("/chat/view/images/Konky Dong.jpg"));
		resetIcon = new ImageIcon(getClass().getResource("/chat/view/images/floaty boi.jpeg"));
		tweetIcon = new ImageIcon(getClass().getResource("/chat/view/images/Eye of the spider.png"));
		checkerIcon = new ImageIcon(getClass().getResource("/chat/view/images/LarryHogan.png"));
		searchIcon = new ImageIcon(getClass().getResource("/chat/view/images/profile pic.jpeg"));

		saveButton = new JButton("Save", saveIcon);
		loadButton = new JButton("Load", loadIcon);
		checkerButton = new JButton("Check Text", checkerIcon);
		chatButton = new JButton("Chat", chatIcon);
		resetButton = new JButton("Reset", resetIcon);
		chatField = new JTextField("Talk to the bot here");
		chatArea = new JTextArea("Chat area", 20, 50);
		chatPane = new JScrollPane();
		
		TweetButton = new JButton("Send Tweet", tweetIcon);
		searchTwitterButton = new JButton("search Twitter", searchIcon);
		
		buttonPanel = new JPanel(new GridLayout(1,0));
		appLayout.putConstraint(SpringLayout.NORTH, buttonPanel, 6, SpringLayout.SOUTH, chatField);
		appLayout.putConstraint(SpringLayout.EAST, buttonPanel, -10, SpringLayout.EAST, chatField);

		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();
		setupButtonPanel();

	}

	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.setPreferredSize(new Dimension(1024, 768));
		this.setBackground(Color.RED);
		this.add(chatPane);
		this.add(chatButton);
		this.add(saveButton);
		this.add(loadButton);
		this.add(checkerButton);
		this.add(chatField);
		this.add(resetButton);
		buttonPanel.setPreferredSize(new Dimension(900, 150));
		buttonPanel.setBackground(Color.GRAY);
		this.add(buttonPanel);
	}

	private void setupScrollPane()
	{
		chatArea.setEditable(false);
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);

		chatPane.setViewportView(chatArea);
		chatPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	}
	
	private String getPath(String choice)
	{
		String path = ".";
		int result = - 99 ; 
		JFileChooser fileChooser = new JFileChooser();
		if(choice.equals("save"))
		{
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			result = fileChooser.showSaveDialog(this);
			if(result == JFileChooser.APPROVE_OPTION)
			{
				path = fileChooser.getCurrentDirectory().getAbsolutePath();
			}
		}
		else
		{
			result = fileChooser.showOpenDialog(this);
			if(result == JFileChooser.APPROVE_OPTION)
			{
				path = fileChooser.getSelectedFile().getAbsolutePath();
			}
		}
		return path;
	}

	private void setupLayout()
	{
		//chat box
		appLayout.putConstraint(SpringLayout.NORTH, chatPane, 50, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, chatPane, 50, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatPane, -50, SpringLayout.EAST, this);
		
		//talk to bot here
		appLayout.putConstraint(SpringLayout.NORTH, chatField, 38, SpringLayout.SOUTH, chatPane);
		appLayout.putConstraint(SpringLayout.WEST, chatField, 0, SpringLayout.WEST, chatPane);
		appLayout.putConstraint(SpringLayout.EAST, chatField, 0, SpringLayout.EAST, chatPane);
		
	}

	private void setupButtonPanel()
	{
		buttonPanel.add(saveButton);
		buttonPanel.add(loadButton);
		buttonPanel.add(chatButton);
		buttonPanel.add(checkerButton);
		buttonPanel.add(TweetButton);
		buttonPanel.add(resetButton);
		buttonPanel.add(searchTwitterButton);
	}
	
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String input = chatField.getText();
				String output = "";
				output = appController.interactWithChatbot(input);
				chatArea.append(output);
				chatField.setText("");
				chatArea.setCaretPosition(chatArea.getDocument().getLength());
			}
		});
		
		
		loadButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String path = getPath("load");
				String chatText = IOController.loadFile(appController, path);
				chatArea.setText(chatText);
			}	
		});
		
		saveButton.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent click)
		{
			String chatText = chatArea.getText();
			String path = ".";
			IOController.saveText(appController, path, chatText);
			chatArea.setText("Chat saved!");
		}	
		});
		
		checkerButton.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent click)
		{
			
		}	
		});
		
		resetButton.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent click)
		{
			
		}	
		});	
		}
	}
