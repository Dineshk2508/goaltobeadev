package com.htc.i18n.resourcebundle;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class UnicodeDemo  {
	
	public static void main(String[] args) {

		JLabel label = new JLabel("Tamil word");
		JTextField t1 = new JTextField(25);
		String name = "\u0BAA\u0BBF\u0BB0\u0BA4\u0BBF\u0BB5\u0BBF\u0BA8\u0BCD\u0BA4\u0BA9\u0BCD";
		t1.setFont(new Font("Latha", Font.BOLD, 16));
		t1.setText(name);
		JFrame frame=new JFrame();
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(label);
		frame.getContentPane().add(t1);
		
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setTitle("Tamil Font");
		System.out.println(name);
	}
	

}
