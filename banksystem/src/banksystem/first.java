package banksystem;
import java.sql.*;
//数据库增删改查操作汇总
public class first {
	Connection con=null;
	Statement state=null;
	 ResultSet rs=null;
	//获得数据库连接
	public void fand(){
	try {
		Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
		  try {
			con= DriverManager.getConnection("jdbc:microsoft:sqlserver://localhost:1434;DatabaseName=bank","sa","sa");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
}
	//插入数据
	public void insert(String sql){
		this.fand();
		try {
			state = con.createStatement();
		 //容器
	        //String sql="insert into banks values('"+b1+"','"+b2+"','"+b3+"')";   //SQL语句
				state.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}         //将sql语句上传至数据库执行
	        finally{
	        	try {
	        		if (state!=null) {
	        			state.close();
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
	        try {
	        	if (con!=null) {
	        		con.close();	
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}//关闭通道
	        }
	}
	//修改数据库
	public void uppdate(String sql){
		this.fand();
		try{
		  state=con.createStatement();   //容器
	        //String sql="update banks set name='刘伟' where acount='汉企' ";   //SQL语句
	        state.executeUpdate(sql);         //将sql语句上传至数据库执行
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				if (state!=null) {
					state.close();
				}
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
	        try {
	        	if (con!=null) {
	        		con.close();
				}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}//关闭通道
		}
	}
	//删除数据
	public void delete(String sql){
		this.fand();
	    try{
        state=con.createStatement();   //容器
      //  String sql="delete from banks where name='刘伟'";   //SQL语句
        state.executeUpdate(sql);         //将sql语句上传至数据库执行
	    }
	    catch (Exception e) {
	    	e.printStackTrace();
		}
	    finally{
	    	try {
	    		if (state!=null) {
	    			state.close();
				}
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
        try {
        	if (con!=null) {
        		con.close();
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}//关闭通道
	}
	}
	//查询数据库
	public String[] select(String sql){
		 String arr[]=new String [100];
		    int i=0;
		this.fand();
		try{
		state=con.createStatement();//容器
	   // String sql="select * from banks";           //sql语句
	    rs=state.executeQuery(sql);     //将sql语句传至数据库，返回的值为一个字符集用一个变量接收 
	   
	    while(rs.next()){    //next（）获取里面的内容
	    String s=(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3));
	                         //getString（n）获取第n列的内容
	           arr[i++]=s;                 //数据库中的列数是从1开始的
	   
	    }
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	    
	    finally{
	    	try {
	    		if (state!=null) {
	    			state.close();
				}
				
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
	    try {
	    	if (rs!=null) {
	    		rs.close();
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	    try {
	    	if (con!=null) {
	    		con.close();
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    }
		return arr;
	}
	//查询数据库
		public String select1(String sql,int i){
			this.fand();
			String yue=null;
			try{
			state=con.createStatement();//容器
		   // String sql="select * from banks";           //sql语句
		    rs=state.executeQuery(sql);     //将sql语句传至数据库，返回的值为一个字符集用一个变量接收 
		    
		    while(rs.next()){    //next（）获取里面的内容
		   yue=(rs.getString(i));
		                         //getString（n）获取第n列的内容
		                            //数据库中的列数是从1开始的
		    }
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		    
		    finally{
		    	try {
		    		if (state!=null) {
		    			state.close();
					}
					
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
		    try {
		    	if (rs!=null) {
		    		rs.close();	
				}
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		    try {
		    	if (con!=null) {
		    		con.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		    }
		return yue;
		}
}
