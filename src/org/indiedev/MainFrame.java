package org.indiedev;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

import org.indiedev.panels.ElementsPanel;

/*
 * May contain 2 views
 * --------------------
 * 1.Entire elements view.
 * 2.Relational view of elements.
 */
public class MainFrame extends JFrame 
{
	//number,string,symbols
	
	private JProgressBar progressBar=new JProgressBar();

	//panels
	private ElementsPanel panelLeft=new ElementsPanel();
	//private TreePanel
	MainFrame()
	{

		//set visuals
		setSize(640,480);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args)
	{
		new MainFrame();
	}
	
}
