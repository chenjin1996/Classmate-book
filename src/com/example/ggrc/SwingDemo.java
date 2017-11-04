package com.example.ggrc;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class SwingDemo implements ActionListener {
	JLabel jlab;
	JFrame jfrm ;
	SwingDemo(){
		jfrm = new JFrame("同学录");
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(400, 200);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton button1 = new JButton("记录");
		JButton button3 = new JButton("删除");
		JButton button2 = new JButton("导出到excel");
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
		if(arg0.getActionCommand().equals("记录")) {
			jfrm.dispose();
			RecordSwing recordSwing = new RecordSwing();
		}
		if(arg0.getActionCommand().equals("删除")) {
			jfrm.dispose();
			DeleteSwing deleteSwing = new DeleteSwing();
			
		}
		if(arg0.getActionCommand().equals("导出到excel")) {
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
