package banksystem;
//登录成功后对该账号进行操作
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
public class zhufaced extends JFrame implements ActionListener {
JButton b1=new JButton("查看余额");
JButton b2=new JButton("存钱");
JButton b3=new JButton("转账");
JButton b4=new JButton("取款");
JButton b5=new JButton("返回上一页");
JButton b6=new JButton("退出");
 zhufaced() {
	// TODO Auto-generated constructor stub
	 super();
	 Container container=this.getContentPane();
	 ImageIcon icon=new ImageIcon("../bank//src//q.jpg");
	 JPanel jPanel=new JPanel();
	 JLabel jLabel=new JLabel(icon);
	 container.add(jLabel, BorderLayout.NORTH);
	 jPanel.setLayout(new GridLayout(3,2));
	 jPanel.add(b1);
	 jPanel.add(b2);
	 jPanel.add(b3);
	 jPanel.add(b4);
	 jPanel.add(b5);
	 jPanel.add(b6);
	 container.add(jPanel);
	 //添加监听
	 b1.addActionListener(this);
	 b2.addActionListener(this);
	 b3.addActionListener(this);
	 b4.addActionListener(this);
	 b5.addActionListener(this);
	 b6.addActionListener(this);
}
 //当按动b1时的操作
 public void  finda(){
	 JButton b1=new JButton("存入金额");
		JButton b2=new JButton("当前余额");
		JButton b3=new JButton("确定");
		JButton b4=new JButton("取消");
//		 public init(){
//			Container container=this.getContentPane();
//		}
 }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==b1) {
		//调用函数取得账户的余额，返回余额的值
			chakanyue aCunqian=new chakanyue();
			aCunqian.pack();
			aCunqian.setLocationRelativeTo(null);
			aCunqian.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			aCunqian.setDefaultLookAndFeelDecorated(true);
			this.setVisible(false);
			
			aCunqian.setVisible(true);
		}
		else if (e.getSource()==b2) {
			//调用函数进行存钱操作，当存钱结束后，显示账户余额
			cunqian aCunqian=new cunqian();
			aCunqian.pack();
			aCunqian.setLocationRelativeTo(null);
			aCunqian.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			aCunqian.setDefaultLookAndFeelDecorated(true);
			this.setVisible(false);
			
			aCunqian.setVisible(true);
		}
		else if (e.getSource()==b3) {
			//完成转账功能，要求有转账的账户以及转入的金额，并判断转入的金额是否超出本账户的余额
			//转账结束后，显示账户余额
			zhuanzhang  aCunqian=new zhuanzhang();
			aCunqian.pack();
			aCunqian.setLocationRelativeTo(null);
			aCunqian.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			aCunqian.setDefaultLookAndFeelDecorated(true);
			this.setVisible(false);
			
			aCunqian.setVisible(true);
		}
		else if (e.getSource()==b4) {
			//完成取款功能，要求判断输入的转账金额是否超出本账户的余额，
			//转账后显示余额
			qukuan aCunqian=new qukuan();
			aCunqian.pack();
			aCunqian.setLocationRelativeTo(null);
			aCunqian.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			aCunqian.setDefaultLookAndFeelDecorated(true);
			this.setVisible(false);
			
			aCunqian.setVisible(true);
		}
		else if (e.getSource()==b5) {
			zhufacec wZhufacec=new zhufacec();
			wZhufacec.pack();
			wZhufacec.setLocationRelativeTo(null);
			wZhufacec.setBackground(Color.white);
			wZhufacec.setDefaultLookAndFeelDecorated(true);
			wZhufacec.setVisible(true);
			this.setVisible(false);
			return;
		}
		else if (e.getSource()==b6) {
			JOptionPane.showMessageDialog(this, "欢迎下次光临！");
			System.exit(0);
			return ;
		}
	}
public static void main(String[] args) {
	zhufaced wZhufaced=new zhufaced();
	wZhufaced.setSize(300, 300);
	wZhufaced.setLocationRelativeTo(null);
	wZhufaced.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	wZhufaced.setDefaultLookAndFeelDecorated(true);
	wZhufaced.setVisible(true);
}
}
