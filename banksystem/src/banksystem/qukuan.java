package banksystem;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
//https://www.cnblogs.com/zhaotiancheng/p/6250184.html
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class qukuan extends JFrame implements ActionListener {
	JLabel b1=new JLabel("取款账户");
	 JTextField t1=new JTextField();
	 JLabel b2=new JLabel("取款金额");
		JTextField a1=new JTextField();
		JButton b3=new JButton("确定");
		JButton b4=new JButton("取消");
		 qukuan(){
		super();	
		Container container=this.getContentPane();
		container.setLayout(new GridLayout(3,2));
		container.add(b1);
		container.add(t1);
		container.add(b2);
		container.add(a1);
		container.add(b3);
		container.add(b4);
		//增加监听
		b3.addActionListener(this);
		b4.addActionListener(this);
		}
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource()==b3) {
					try {
						Savepoint();	
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}	
			}
		 //往数据库添加存钱金额
		 public void Savepoint()throws SQLException{
			 String string=t1.getText();
			 String string1=a1.getText();//账户
			int awe=Integer.valueOf(string1);
				first f=new first();
				String a1="select * from banks where name='"+string+"'";
				String yue1=(f.select1(a1,4));
				int yue=Integer.valueOf(yue1);
				yue-=awe;
				if (awe>=0) {
					String a0="update  banks set acount='"+yue+"' where name='"+string+"'";
					f.uppdate(a0);
					this.setVisible(false);
					JOptionPane.showMessageDialog(this,"余额为："+yue);
				}
				else {
					this.setVisible(false);
					JOptionPane.showMessageDialog(this,"余额为不足！");
				}
				
		 }
		public static void main(String[] args) {
			qukuan aCunqian=new qukuan();
			aCunqian.pack();
			aCunqian.setLocationRelativeTo(null);
			aCunqian.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			aCunqian.setDefaultLookAndFeelDecorated(true);
			aCunqian.setVisible(true);
		}
}

