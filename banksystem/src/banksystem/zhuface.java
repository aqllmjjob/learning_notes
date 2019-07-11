package banksystem;
//银行管理系统首页
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
public class zhuface extends JFrame implements ActionListener{
JPanel j1=new JPanel();
JButton b1=new JButton("进入");
JButton b2=new JButton("退出");
public zhuface() {
	// TODO Auto-generated constructor stub
	super();
	this.setTitle("欢迎进入中国银行管理系统！");
	ImageIcon icon=new ImageIcon("../bank//src//yinhang.jpg");
	JLabel label;
	Container container=this.getContentPane();
	container.add(new JLabel(icon),BorderLayout.NORTH);
	j1.add(b1,BorderLayout.EAST);
	j1.add(b2,BorderLayout.WEST);
	container.add(j1,BorderLayout.SOUTH);
	//添加监听
	b1.addActionListener(this);
	b2.addActionListener(this);
}
@Override
public void actionPerformed(ActionEvent e) {
	
	// TODO Auto-generated method stub
	if (e.getSource()==b1) {
		//触发进入按钮，则进入银行管理系统
		this.setVisible(false);
		zhufacea a=new zhufacea();
		a.pack();
		a.setLocationRelativeTo(null);
		a.setBackground(Color.white);
		a.setDefaultLookAndFeelDecorated(true);
		a.setVisible(true);
		return ;
	}
	else if (e.getSource()==b2) {
		//触发退出系统的时候，关闭显示窗口
		JOptionPane.showMessageDialog(this, "欢迎下次光临！");
		System.exit(0);
	}
}
public static void main(String args[]){
	zhuface z=new zhuface();
	z.pack();
	z.setLocationRelativeTo(null);
	z.setBackground(Color.gray);
	z.setVisible(true);
}
}
