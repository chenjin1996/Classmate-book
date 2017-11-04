package com.example.ggrc;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class DeleteSwing implements ActionListener {
	JTextField DeleteName;
	JFrame jfrm;
	final String[] colHeads= {"name","address","phone","wechat","email","qq","signature"};
	public DeleteSwing() {
		jfrm = new JFrame("同学录");
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(1000, 600);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel name = new JLabel("要删除的同学名字:");
		Jdbc jdbc = new Jdbc();
		String[][] st=(String[][]) jdbc.select("select name,address,phone,wechat,email,qq,signature from studentInformation");
		JTable table = new JTable(st,colHeads);
		DeleteName = new JTextField(12);
		Button button = new Button("确定");
		button.addActionListener(this);
		jfrm.add(table);
		jfrm.add(name);
		jfrm.add(DeleteName);
		jfrm.add(button);
		jfrm.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand().equals("确定")) {
			String name=DeleteName.getText();
			Jdbc jdbc = new Jdbc(name);
			jdbc.delete("delete from studentInformation where Name='" + name + "'");
		}
		
	}
}
