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

public class zhuanzhang extends JFrame implements ActionListener {
	JLabel b1=new JLabel("转出账户");
	 JTextField t1=new JTextField();
	 JLabel b2=new JLabel("转入账户");
		JTextField a1=new JTextField();
		JLabel b0=new JLabel("转出金额");
		 JTextField t0=new JTextField();
		JButton b3=new JButton("确定");
		JButton b4=new JButton("取消");
		 zhuanzhang(){
		super();	
		Container container=this.getContentPane();
		container.setLayout(new GridLayout(4,2));
		container.add(b1);
		container.add(t1);
		container.add(b2);
		container.add(a1);
		container.add(b0);
		container.add(t0);
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
			 String string=t1.getText();//转出账户
			 String string1=a1.getText();//转入账户
			 String string2=t0.getText();//转出金额
			int awe=Integer.valueOf(string2);
				first f=new first();
				String a1="select * from banks where name='"+string+"'";
				String zhanghu=(f.select1(a1,1));
				String a2="select * from banks where name='"+string1+"'";
				String zhanghu1=(f.select1(a2,1));
				
				String a3="select * from banks where name='"+string+"'";
				String zhanghu2=(f.select1(a3,4));
				int yue=Integer.valueOf(zhanghu2);
				yue-=awe;
				if (yue>=0) {
					String a4="select * from banks where name='"+string1+"'";
					String zhanghu3=(f.select1(a4,4));
					int yue1=Integer.valueOf(zhanghu3);
					yue1+=awe;
						String a0="update  banks set acount='"+yue1+"' where name='"+string1+"'";
						f.uppdate(a0);
						this.setVisible(false);
						JOptionPane.showMessageDialog(this,"剩余余额为："+yue);
						String a00="update  banks set acount='"+yue+"' where name='"+string+"'";
						f.uppdate(a00);
					}
					else {
						this.setVisible(false);
						JOptionPane.showMessageDialog(this,"余额为不足！");
					}
				
				
		 }
		public static void main(String[] args) {
			zhuanzhang aCunqian=new zhuanzhang();
			aCunqian.pack();
			aCunqian.setLocationRelativeTo(null);
			aCunqian.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			aCunqian.setDefaultLookAndFeelDecorated(true);
			aCunqian.setVisible(true);
		}
}

