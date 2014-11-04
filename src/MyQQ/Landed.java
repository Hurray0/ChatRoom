package MyQQ;

import javax.swing.*;

import java.awt.*;
import   java.awt.event.*; 

public class Landed extends JFrame{
	private   boolean   startDrag   =   false;  //拖动检测 
	private   Point   p   =   null;   //鼠标位置
	JTextField jtf_id = new JTextField();
	JTextField jtf_code = new JTextField();
	String[] status = {"","在线","隐身"};
	JComboBox jcb_status = new JComboBox(status);
	
	//JFrame
	final JFrame t = this;
	
	Landed()
	{
		//GUI界面
			//背景
		ImageIcon imageicon=new ImageIcon("Image/back2.jpg");
		Image img=imageicon.getImage();
		ImagePanel mainpanel = new ImagePanel(img);
		add(mainpanel);
		mainpanel.setLayout(null);
			//顶层文字
		JLabel jl_top = new JLabel("登陆窗口");
		jl_top.setFont(new Font("微软雅黑",Font.PLAIN,30));
		jl_top.setForeground(new Color(255,255,255));
		jl_top.setBounds(140, 0, 150, 70);
		mainpanel.add(jl_top);
				//阴影重叠效果（下层）
		JLabel jl_top2 = new JLabel("登陆窗口");
		jl_top2.setFont(new Font("微软雅黑",Font.PLAIN,30));
		jl_top2.setForeground(new Color(0,0,0));
		jl_top2.setBounds(142, 2, 150, 70);
		mainpanel.add(jl_top2);
		
			//账号：
		JLabel jl_id = new JLabel("账  号 ：");
		jl_id.setFont(new Font("微软雅黑",Font.BOLD,15));
		//jl_id.setForeground(new Color(0,0,0));
		jl_id.setBounds(80,70,150,70);
		mainpanel.add(jl_id);
		
		//JTextField jtf_id = new JTextField();在类中声明
		jtf_id.setBounds(140, 94, 150, 25);
		mainpanel.add(jtf_id);
		
			//密码：
		JLabel jl_code = new JLabel("密  码 ：");
		jl_code.setFont(new Font("微软雅黑",Font.BOLD,15));
		//jl_code.setForeground(new Color(0,0,0));
		jl_code.setBounds(80,140,150,70);
		mainpanel.add(jl_code);
		
		//JTextField jtf_code = new JTextField();在类中声明
		jtf_code.setBounds(140, 164, 150, 25);
		mainpanel.add(jtf_code);
		
			//注册按钮
		JButton jbt_reg= new JButton("注  册");
		jbt_reg.setBounds(55, 240,100,30);
		mainpanel.add(jbt_reg);
		jbt_reg.addActionListener(new act_reg());
		
			//登陆按钮
		JButton jbt_landed= new JButton("登  陆");
		jbt_landed.setBounds(245, 240,100,30);
		mainpanel.add(jbt_landed);
		jbt_landed.addActionListener(new act_landed());
		
			//关闭按钮
		ImageIcon exit1 = new ImageIcon("Image/exit1.png");
		ImageIcon exit2 = new ImageIcon("Image/exit2.png");
		ImageIcon exit3 = new ImageIcon("Image/exit3.png");
		JButton jbt_exit = new JButton(exit1);
		jbt_exit.setPressedIcon(exit3);
		jbt_exit.setRolloverIcon(exit2);
		jbt_exit.setBounds(370, 0, 30, 30);
		mainpanel.add(jbt_exit);
		jbt_exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		
			//最小化按钮
		ImageIcon minimize1 = new ImageIcon("Image/minimize1.png");
		ImageIcon minimize2 = new ImageIcon("Image/minimize2.png");
		ImageIcon minimize3 = new ImageIcon("Image/minimize3.png");
		JButton jbt_minimize = new JButton(minimize1);
		jbt_minimize.setPressedIcon(minimize3);
		jbt_minimize.setRolloverIcon(minimize2);
		jbt_minimize.setBounds(340, 0, 30, 30);
		mainpanel.add(jbt_minimize);
		jbt_minimize.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				 setState( Frame.ICONIFIED ); 
			}
		});
		
			//状态选择
		//String[] status = {"隐身","在线"};
		//JComboBox jcb_status = new JComboBox(status);在类中声明
		jcb_status.setSelectedIndex(1);
		jcb_status.addActionListener(null);
		jcb_status.setBounds(300,100 ,60, 20);
		mainpanel.add(jcb_status);
		
		//鼠标拖动(copy from CSDN)
		addMouseListener(new   MouseAdapter()
		{   
			 public   void   mousePressed(MouseEvent   e)
			 {   
				 startDrag   =   true;   
				 p   =   e.getPoint();   
			 }   
			 public   void   mouseReleased(MouseEvent   e)
			 {   
				 startDrag   =   false;   
			 }  
		}); 
		addMouseMotionListener(new   MouseMotionAdapter()
		{   
			public   void   mouseDragged(MouseEvent   e)
			{   
				Point   p1   =   e.getPoint();   
				Point   p2   =   getLocation(null);   
				p2.x   +=   p1.x   -   p.x;   
				p2.y   +=   p1.y   -   p.y;   
				setLocation(p2);   
			}   
		});
	}
	public static void main(String[] args)
	{
		final JFrame frame = new Landed();
		frame.setResizable(false);
		frame.setUndecorated(true);

		frame.setTitle("用户登陆");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);
		frame.setVisible(true);			
	}
	
	class act_reg implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0) 
		{
			//建立JFrame jfm_reg
			JFrame jfm_reg = new JFrame();
			jfm_reg.setTitle("注册");
			jfm_reg.setLocationRelativeTo(null);
			jfm_reg.setDefaultCloseOperation(jfm_reg.HIDE_ON_CLOSE);
			jfm_reg.setSize(300, 150);
			jfm_reg.setVisible(true);
			jfm_reg.setResizable(false);//不可调整大小
			
			//建立主JPanel jpn_reg
			JPanel jpn_reg = new JPanel();
			jpn_reg.setLayout(null);/*这一句非常重要，如果没有这句，后面的组件将没法安排位置*/
			jfm_reg.add(jpn_reg);
			
			//建立JLabel jlb_new_name
			JLabel jlb_new_name = new JLabel("请输入昵称");
			jlb_new_name.setFont(new Font("微软雅黑",Font.BOLD,15));
			jlb_new_name.setBounds(20, 20, 100, 20);
			jpn_reg.add(jlb_new_name);
			
			//建立JLabel jlb_new_code
			JLabel jlb_new_code = new JLabel("请输入密码");
			jlb_new_code.setFont(new Font("微软雅黑",Font.BOLD,15));
			jlb_new_code.setBounds(20, 50, 100, 20);
			jpn_reg.add(jlb_new_code);
			
			//输入昵称框
			JTextField jtf_new_name = new JTextField();
			jtf_new_name.setFont(new Font("微软雅黑",Font.BOLD,15));
			jtf_new_name.setBounds(110, 20, 120, 20);
			jpn_reg.add(jtf_new_name);
			
			//输入密码框
			JTextField jtf_new_code = new JTextField();
			jtf_new_code.setFont(new Font("微软雅黑",Font.BOLD,15));
			jtf_new_code.setBounds(110, 50, 120, 20);
			jpn_reg.add(jtf_new_code);
			
			//注册按钮
			JButton jbt_new_reg = new JButton("注册");
			jbt_new_reg.setBounds(200, 80, 80, 20);
			jpn_reg.add(jbt_new_reg);
			jbt_new_reg.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) 
				{
					String str_err = "注册失败";
					String str_sec = "注册成功";
					int x=1;
					//加判断注册成功的语句，成功则把x设成1
					if(x==1)
					{
						//创建JFrame
						JFrame jfm_reg_sec = new JFrame();
						jfm_reg_sec.setTitle("注册成功");
						jfm_reg_sec.setLocationRelativeTo(null);
						jfm_reg_sec.setDefaultCloseOperation(jfm_reg_sec.HIDE_ON_CLOSE);
						jfm_reg_sec.setSize(150, 150);
						jfm_reg_sec.setVisible(true);
						jfm_reg_sec.setResizable(false);//不可调整大小
						
						//创建JPanel
						JPanel jpn_reg_sec = new JPanel();
						jpn_reg_sec.setLayout(null);
						jfm_reg_sec.add(jpn_reg_sec);
						
						//输出申请的号码
						JLabel jlb_show_sec = new JLabel("申请成功！");
						jlb_show_sec.setBounds(10, 10, 200, 30);
						jpn_reg_sec.add(jlb_show_sec);
						String new_ID = "123123123";
						JLabel jlb_new_ID = new JLabel("您的号码为："+new_ID);
						jlb_new_ID.setBounds(20, 60, 200, 30);
						jpn_reg_sec.add(jlb_new_ID);
						
					}
					else
					{
						//创建JFrame
						JFrame jfm_reg_err = new JFrame();
						jfm_reg_err.setTitle("注册失败");
						jfm_reg_err.setLocationRelativeTo(null);
						jfm_reg_err.setDefaultCloseOperation(jfm_reg_err.HIDE_ON_CLOSE);
						jfm_reg_err.setSize(150, 150);
						jfm_reg_err.setVisible(true);
						jfm_reg_err.setResizable(false);//不可调整大小
						
						//创建JPanel
						JPanel jpn_reg_err = new JPanel();
						jpn_reg_err.setLayout(null);
						jfm_reg_err.add(jpn_reg_err);
						
						//输出失败
						JLabel jlb_show_err = new JLabel("申请失败！");
						jlb_show_err.setBounds(10, 10, 200, 30);
						jpn_reg_err.add(jlb_show_err);
						JLabel jlb_new_ID = new JLabel("申请失败，请重试！");
						jlb_new_ID.setBounds(20, 60, 200, 30);
						jpn_reg_err.add(jlb_new_ID);
					}
				}
			});
		}
	}
	
	class act_landed implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int judge = 1;
			String myID=jtf_id.getText();
			String mycode=jtf_code.getText();
			int mystatus=jcb_status.getSelectedIndex();
			//验证账号和密码（从服务器）,正确的话返回1，否则为0
			if(judge==1)
			{
				new MainInterface(myID,mystatus);
				t.hide();
			}
			else
			{	//JFrame
				JFrame jfm_err = new JFrame();
				jfm_err.setTitle("error");
				jfm_err.setLocationRelativeTo(null);
				jfm_err.setDefaultCloseOperation(jfm_err.HIDE_ON_CLOSE);
				jfm_err.setSize(300, 150);
				jfm_err.setVisible(true);
				
				//新建Panel
				JPanel jpn_err = new JPanel();
				jpn_err.setLayout(null);
				jfm_err.add(jpn_err);
				
				//请输入群名
				JLabel jlb_entername = new JLabel("登陆失败！请重试！");
				jlb_entername.setBounds(20, 20, 250, 30);
				jpn_err.add(jlb_entername);
				
			}
		}
		
	}
	
}
//背景图片类
class ImagePanel extends JPanel
{	
	Image image=null;
	//在Panel上画图
	ImagePanel(Image image)
	{
		this.image=image;
	}
	protected void paintComponent(Graphics g)
	{
		g.drawImage(image,0,0,getWidth(),getHeight(),this);
	}
}


