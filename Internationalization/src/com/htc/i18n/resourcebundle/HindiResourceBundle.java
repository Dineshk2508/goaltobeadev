package com.htc.i18n.resourcebundle;

import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class HindiResourceBundle{
	
	public static void main(String[] args) {
	
		ResourceBundle bundle=ResourceBundle.getBundle("ApplicationResources",new Locale("hi","IN"));
		StringBuilder text=new StringBuilder();
		text.append(bundle.getString("good"));
		text.append(" ");
		text.append(bundle.getString("afternoon"));
		text.append(" ");
		text.append(bundle.getString("team"));
		System.out.println(text);
		JLabel label = new JLabel(text.toString());
		
		label.setFont(new Font(bundle.getString("font"), Font.BOLD, 22));
		JFrame frame=new JFrame();
		
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(label);
		
		frame.setVisible(true);
		frame.setSize(300, 300);
		frame.setTitle("French Font");
		
	}

}
