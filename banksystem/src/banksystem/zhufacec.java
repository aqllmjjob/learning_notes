package banksystem;
//实现登录界面
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
public class zhufacec extends JFrame implements ActionListener {
first f=new first();//数据库的操作
JLabel l2=new JLabel("请输入登录账号（手机号）");
JTextField t2=new JTextField();
JLabel l3=new JLabel("请输入登录密码");
JTextField t3=new JTextField();
JButton b1=new JButton("登录");
JButton b2=new JButton("取消");
JButton b3=new JButton("返回上一级");
JButton b4=new JButton("退出");
 zhufacec() {
	// TODO Auto-generated constructor stub
	 super();
	 Container container=this.getContentPane();
	 ImageIcon icon=new ImageIcon("../bank//src//o.jpg");
	 JLabel label=new JLabel(icon);
	 JPanel jPanel=new JPanel();
	 container.add(label, BorderLayout.NORTH);
	 jPanel.setLayout(new GridLayout(4,2));
	 jPanel.add(l2);
	 jPanel.add(t2);
	 jPanel.add(l3);
	 jPanel.add(t3);
	 jPanel.add(b1);
	 jPanel.add(b2);
	 jPanel.add(b3);
	 jPanel.add(b4);
	 container.add(jPanel);
	 //添加监听
	 b1.addActionListener(this);
	 b2.addActionListener(this);
	 b3.addActionListener(this);
	 b4.addActionListener(this);
}
 //通过客户在输入框内输入的内容判断其是否注册过，如果注册过，
 //若注册过，则进入操作存钱，转账等功能的操作界面
 //若没有注册，弹出要顾客注册的显示框
 //默认一个手机号后八位相同的账户为同一个账号
 //默认登录密码为注册过的密码
 public boolean findone(){
	 String s1=t2.getText();
		String s2=t3.getText();
		/*System.out.println(s1);
		System.out.println(s2);*/
		String arr1[]=new String[1024];
	 String sql="select * from banks"; 
	 String arr[]=f.select(sql);
	 int k=0;
	 for(int i=0;i<arr.length;i++){
		 String s0=arr[i];
		 if (s0!=null) {
			 arr1=s0.split(",");
	 for(int j=0;j<arr1.length;j+=3){
		 
		 if (arr1[j]!=null) {
			/* System.out.println(arr1[j]+"  "+arr1[j+1])*/;//取出账户和密码
			 if ((arr1[j].equals(s1))&&(arr1[j+1].equals(s2))) {
				 return true;
			}
			
		}
		 else break;
	 }
		}
		 else break;
	 }
	 return false;
	
 }
 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==b1) {
			//点击此按钮进入银行操作系统
			if(findone()){
				this.setVisible(false);
			zhufaced wZhufaced=new zhufaced();
			wZhufaced.setSize(300, 300);
			wZhufaced.setLocationRelativeTo(null);
			wZhufaced.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			wZhufaced.setDefaultLookAndFeelDecorated(true);
			wZhufaced.setVisible(true);
		
			}
			else{
				
				JOptionPane.showMessageDialog(this, "用户不存在，请重新输入！");
				zhuface as=new zhuface();
				
				as.setLocationRelativeTo(null);
				as.setBackground(Color.cyan);
				as.setDefaultLookAndFeelDecorated(true);
				as.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				as.setVisible(true);
			}
		}
		else if (e.getSource()==b2) {
			//点击此按钮清空输入的内容
			JOptionPane.showMessageDialog(this, "欢迎下次光临！");
			System.exit(0);
			return ;
		}
		else if (e.getSource()==b3) {
			zhufacea wZhufacea=new zhufacea();
			wZhufacea.pack();
			wZhufacea.setLocationRelativeTo(null);
			wZhufacea.setBackground(Color.white);
			wZhufacea.setDefaultLookAndFeelDecorated(true);
			wZhufacea.setVisible(true);
			this.setVisible(false);
			return;
		}
		else if (e.getSource()==b4) {
			JOptionPane.showMessageDialog(this, "欢迎下次光临！");
			System.exit(0);
			return ;
		}
	}
	public static void main(String[] args) {
		zhufacec wZhufacec=new zhufacec();
		wZhufacec.setSize(400, 400);
		wZhufacec.setLocationRelativeTo(null);
		wZhufacec.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		wZhufacec.setDefaultLookAndFeelDecorated(true);
		wZhufacec.setVisible(true);
	}

}
