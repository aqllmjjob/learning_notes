package banksystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class zhufacea extends JFrame implements ActionListener{

JButton b1=new JButton("返回上一页");
JButton b2=new JButton("注册");
JButton b3=new JButton("登录");
JButton b4=new JButton("退出");
zhufacea() {
	// TODO Auto-generated constructor stub
	ImageIcon icon=new ImageIcon("../bank//src//denglu.jpg");
	JLabel label=new JLabel(icon);
	Container container=this.getContentPane();
	JPanel panel=new JPanel();
	panel.setLayout(new GridLayout(2,2));
	panel.add(b1);
	panel.add(b2);
	panel.add(b3);
	panel.add(b4);
	container.add(panel);
	container.add(label,BorderLayout.NORTH);	
	//添加监听
	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
	b4.addActionListener(this);
}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==b1) {
			zhuface ad=new zhuface();
			ad.setVisible(true);
			ad.pack();
			ad.setLocationRelativeTo(null);
			ad.setBackground(Color.gray);
		    ad.setVisible(true);
			this.setVisible(false);
			zhufaceb wZhufaceb=new zhufaceb();dispose();
			wZhufaceb.setVisible(true);
			return;
		}
		else if (e.getSource()==b2) {
		zhufaceb wZhufaceb=new zhufaceb();
		wZhufaceb.pack();
		wZhufaceb.setLocationRelativeTo(null);
		wZhufaceb.setBackground(Color.cyan);
		wZhufaceb.setDefaultLookAndFeelDecorated(true);
		wZhufaceb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		wZhufaceb.setVisible(true);
		this.setVisible(false);
			return;
		}
		else if (e.getSource()==b3) {
			zhufacec wZhufacec=new zhufacec();
			wZhufacec.pack();
			wZhufacec.setLocationRelativeTo(null);
			wZhufacec.setBackground(Color.gray);
			wZhufacec.setDefaultLookAndFeelDecorated(true);
			wZhufacec.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			wZhufacec.setDefaultLookAndFeelDecorated(true);
			wZhufacec.setVisible(true);
			this.setVisible(false);
			return;
		}
		else if (e.getSource()==b4) {
			JOptionPane.showMessageDialog(this, "欢迎下次光临！");
			System.exit(0);
			return ;
		}
	}
public static void main(String[]args){
	zhufacea a=new zhufacea();
	a.pack();
	a.setLocationRelativeTo(null);
	a.setBackground(Color.white);
	a.setDefaultLookAndFeelDecorated(true);
	a.setVisible(true);
}
}
