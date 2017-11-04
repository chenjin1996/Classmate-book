package com.example.ggrc;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RecordSwing implements ActionListener {
	JTextField inputName;
	JTextField inputAddress;
	JTextField inputPhone;
	JTextField inputWechat;
	JTextField inputEmail;
	JTextField inputQq;
	JTextField inputSigature;
	public RecordSwing(){
		JFrame jfrm = new JFrame("同学录");
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(400, 200);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel name = new JLabel("姓名:");
		inputName = new JTextField(12);
		JLabel address =new JLabel("家庭住址:");
		inputAddress = new JTextField(12);
		JLabel phone = new JLabel("电话:");
		inputPhone = new JTextField(12);
		JLabel wechat = new JLabel("微信:");
		inputWechat = new JTextField(12);
		JLabel email = new JLabel("邮箱:");
		inputEmail = new JTextField(12);
		JLabel qq = new JLabel("qq:");
		inputQq = new JTextField(12);
		JLabel signature = new JLabel("个性签名:");
		inputSigature = new JTextField(20);
		JButton button = new JButton("确定");
		button.addActionListener(this);
		jfrm.add(name);
		jfrm.add(inputName);
		jfrm.add(address);
		jfrm.add(inputAddress);
		jfrm.add(phone);
		jfrm.add(inputPhone);
		jfrm.add(wechat);
		jfrm.add(inputWechat);
		jfrm.add(email);
		jfrm.add(inputEmail);
		jfrm.add(qq);
		jfrm.add(inputQq);
		jfrm.add(signature);
		jfrm.add(inputSigature);
		jfrm.add(button);
		jfrm.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand().equals("确定")) {
			String name = inputName.getText();
			String address=inputAddress.getText();
			String phone = inputPhone.getText();
			String wechat = inputWechat.getText();
			String email = inputEmail.getText();
			String qq = inputQq.getText();
			String signature = inputSigature.getText();
			inputName.setText("");
			inputAddress.setText("");
			inputPhone.setText("");
			inputWechat.setText("");
			inputEmail.setText("");
			inputQq.setText("");
			inputSigature.setText("");
			Jdbc jdbc =new Jdbc(name,address,phone,wechat,email,qq,signature);
			jdbc.insert();
		}
	}
}
