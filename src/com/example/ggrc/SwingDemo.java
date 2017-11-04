package com.example.ggrc;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class SwingDemo implements ActionListener {
	JLabel jlab;
	JFrame jfrm ;
	SwingDemo(){
		jfrm = new JFrame("ͬѧ¼");
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(400, 200);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton button1 = new JButton("��¼");
		JButton button3 = new JButton("ɾ��");
		JButton button2 = new JButton("������excel");
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		jfrm.add(button1);
		jfrm.add(button2);
		jfrm.add(button3);
		jfrm.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand().equals("��¼")) {
			jfrm.dispose();
			RecordSwing recordSwing = new RecordSwing();
		}
		if(arg0.getActionCommand().equals("ɾ��")) {
			jfrm.dispose();
			DeleteSwing deleteSwing = new DeleteSwing();
			
		}
		if(arg0.getActionCommand().equals("������excel")) {
			OutToExcel outToExcel = new OutToExcel();
			outToExcel.toexcel();
		}
		
		
	};
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new SwingDemo();
			}
		});
	}
}
