package com.example.ggrc;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DeleteSwing implements ActionListener {
	JTextField DeleteName;
	JFrame jfrm;
	public DeleteSwing() {
		jfrm = new JFrame("ͬѧ¼");
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(400, 300);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel name = new JLabel("Ҫɾ����ͬѧ����:");
		DeleteName = new JTextField(12);
		Button button = new Button("ȷ��");
		button.addActionListener(this);
		jfrm.add(name);
		jfrm.add(DeleteName);
		jfrm.add(button);
		jfrm.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand().equals("ȷ��")) {
			String name=DeleteName.getText();
			Jdbc jdbc = new Jdbc(name);
			jdbc.delete("delete from studentInformation where Name='" + name + "'");
		}
		
	}
}
