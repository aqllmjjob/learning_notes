package banksystem;
//实现注册页面
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class zhufaceb extends JFrame implements ActionListener{
	first f=new first();
	zhufacea wZhufacea=new zhufacea();
JLabel l1=new JLabel("请输入注册手机号(手机号后8位):");
JTextField f1=new JTextField();
JLabel l2=new JLabel("请输入注册密码(8位):");
JTextField p1=new JTextField();
JLabel l3=new JLabel("请再次输入注册密码(8位):");
JTextField p2=new JTextField();
JButton b1=new JButton("确定");
JButton b2=new JButton("取消");
JButton b3=new JButton("返回上一级");
JButton b4=new JButton("退出");
zhufaceb(){
	super();
	ImageIcon icon=new ImageIcon("../bank//src//zhuce.jpg");
	JLabel label=new JLabel(icon);
	Container container =this.getContentPane();
	JPanel jPanel=new JPanel();
	jPanel.setLayout(new GridLayout(5,2));
	jPanel.add(l1);
	jPanel.add(f1);
	jPanel.add(l2);
	jPanel.add(p1);
	jPanel.add(l3);
	jPanel.add(p2);
	jPanel.add(b1);
	jPanel.add(b2);
	jPanel.add(b3);
	jPanel.add(b4);
	container.add(label, BorderLayout.NORTH);
	container.add(jPanel);
	//增加监听
	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
	b4.addActionListener(this);
	
	

}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource()==b1) {
			//点击此按钮将输入的符合条件的内容增加到数据库保存
			try {
				this.find();
				zhufacec wZhufacea=new zhufacec();
				wZhufacea.pack();
				wZhufacea.setLocationRelativeTo(null);
				wZhufacea.setBackground(Color.white);
				wZhufacea.setDefaultLookAndFeelDecorated(true);
				wZhufacea.setVisible(true);
				this.setVisible(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
	//将注册信息存入数据库
	public  void find() throws SQLException{

		String s1=f1.getText();
		String s2=p1.getText();
		String s3=p2.getText();
		String s4="0";
		//通过手机号判断该用户是否注册过
		 if (s2.equals(s3)&&s1!=""&&s2!=""&&s3!="") {
			 //判断俩次输入的密码是否相等
			 //如果相等，则将数据存入数据库，并给顾客显示注册成功
			 String sql="select * from banks"; 
			 //添加数据的时候，应该设置四个列，前三列
			 
			 String sql1="insert into banks values('"+s1+"','"+s2+"','"+s3+"','"+s4+"')";
		f.insert(sql1);
		f.select(sql);
		JOptionPane.showMessageDialog(this, "注册成功！");
		
		}
//		 else if (s1==null||s2==null||s3==null) {
//			 JOptionPane.showMessageDialog(this, "用户输入为空，请重新输入！");
//		}
		 else{
			 //若俩次输入的密码不相等，
			 //则此次的数据不存入数据库，并给顾客显示输入错误，要求其重新输入
			 JOptionPane.showMessageDialog(this, "俩次输入的密码不相等，请重新输入！");
		 }
		}
		

public static void main(String[] args) {
	zhufaceb as=new zhufaceb();
	as.pack();
	as.setLocationRelativeTo(null);
	as.setBackground(Color.cyan);
	as.setDefaultLookAndFeelDecorated(true);
	as.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	as.setVisible(true);
}
}
