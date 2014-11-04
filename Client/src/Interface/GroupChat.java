package Interface;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

//私有库
import Action.*;
import Bean.*;
import Interface.Method.ImagePanel;

public class GroupChat extends JFrame{
	private   boolean   startDrag   =   false;  //拖动检测 
	private   Point   p   =   null;   //鼠标位置
	
	GroupChat(group mygroup,userdata mydata)//之所以要用PrivateChat_2代替它是因为setUndecorated会将Frame中所有东西清除
	{
		GroupChat_2 prc = new GroupChat_2(mygroup,mydata);
		prc.setResizable(false);
		prc.setResizable(false);//不可调整大小
		prc.setUndecorated(true);
		//this.setTitle("与"+fr_name+"聊天中");
		prc.setLocationRelativeTo(null);
		prc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		prc.setSize(600, 400);
		prc.setVisible(true);
		prc.setLocationRelativeTo(null);
	}

	public class GroupChat_2 extends JFrame
	{
		JFrame tt = this;
		private JTextArea jta_print = new JTextArea();
		private JTextArea jta_send = new JTextArea();
		GroupChat_2(final group mygroup,final userdata mydata)
		{
			//背景
			ImageIcon imageicon=new ImageIcon("Image/back_chat2.png");
			Image img=imageicon.getImage();
			ImagePanel mainpanel = new ImagePanel(img);
			add(mainpanel);
			mainpanel.setLayout(null);
			
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
			
			//关闭按钮
			ImageIcon exit1 = new ImageIcon("Image/exit1.png");
			ImageIcon exit2 = new ImageIcon("Image/exit2.png");
			ImageIcon exit3 = new ImageIcon("Image/exit3.png");
			JButton jbt_exit = new JButton(exit1);
			jbt_exit.setPressedIcon(exit3);
			jbt_exit.setRolloverIcon(exit2);
			jbt_exit.setBounds(575, 0, 25, 25);
			mainpanel.add(jbt_exit);
			final JFrame t = this;//下面在方法中不能用this，所以用t替换一下
			jbt_exit.addActionListener(new Act_Close(this));
			
			//最小化按钮
			ImageIcon minimize1 = new ImageIcon("Image/minimize1.png");
			ImageIcon minimize2 = new ImageIcon("Image/minimize2.png");
			ImageIcon minimize3 = new ImageIcon("Image/minimize3.png");
			JButton jbt_minimize = new JButton(minimize1);
			jbt_minimize.setPressedIcon(minimize3);
			jbt_minimize.setRolloverIcon(minimize2);
			jbt_minimize.setBounds(550, 0, 25, 25);
			mainpanel.add(jbt_minimize);
			jbt_minimize.addActionListener( new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					 t.setState( Frame.ICONIFIED ); 
				}
			});
			
			//群的名字
			String string_fr_name = "群："+mygroup.getname();
			JLabel jl_fr_name = new JLabel(string_fr_name);
			jl_fr_name.setFont(new Font("微软雅黑",Font.PLAIN,20));
			jl_fr_name.setForeground(new Color(0,0,0));
			jl_fr_name.setBounds(16, 1, 600, 30);
			JLabel jl_fr_name2 = new JLabel(string_fr_name);
			jl_fr_name2.setFont(new Font("微软雅黑",Font.PLAIN,20));
			jl_fr_name2.setForeground(new Color(255,255,255));
			jl_fr_name2.setBounds(15, 0, 600, 30);
			mainpanel.add(jl_fr_name2);
			mainpanel.add(jl_fr_name);
			
			//群号
			String string_group_ID = "("+mygroup.getID()+")";
			JLabel jl_group_ID = new JLabel(string_group_ID);
			jl_group_ID.setFont(new Font("微软雅黑",Font.PLAIN,10));
			jl_group_ID.setForeground(new Color(0,0,150));
			jl_group_ID.setBounds(55, 22, 600, 30);
			mainpanel.add(jl_group_ID);
			
			//聊天信息框
			//JTextArea jta_print = new JTextArea();写作类私有变量了
			jta_print.setLineWrap(true);//这两行使JTextArea里的文字不能被修改
			jta_print.setEditable(false);//这两行使JTextArea里的文字不能被修改
			JScrollPane jsp_print = new JScrollPane(jta_print);
			jsp_print.setBounds(10, 55, 430, 195);
			mainpanel.add(jsp_print);
			
			//输入信息框
			//JTextArea jta_send = new JTextArea();写作类私有变量了
			JScrollPane jsp_send = new JScrollPane(jta_send);
			jsp_send.setBounds(10, 300, 430, 90);
			mainpanel.add(jsp_send);
			
			//发送按钮
			JButton jbt_send = new JButton("发送");
			jbt_send.setBounds(360, 260, 70, 30);
			mainpanel.add(jbt_send);
			
			//添加表情
			ImageIcon imi_sendface = new ImageIcon("Image/sendface.png");
			JButton jbt_sendface = new JButton(imi_sendface);
			jbt_sendface.setPressedIcon(imi_sendface);
			jbt_sendface.setRolloverIcon(imi_sendface);
			jbt_sendface.setBounds(10, 275, 25, 25);
			mainpanel.add(jbt_sendface);
			
			//发送图片
			ImageIcon imi_sendpicture = new ImageIcon("Image/sendpicture.png");
			JButton jbt_sendpicture = new JButton(imi_sendpicture);
			jbt_sendpicture.setPressedIcon(imi_sendpicture);
			jbt_sendpicture.setRolloverIcon(imi_sendpicture);
			jbt_sendpicture.setBounds(35, 275, 40, 25);
			mainpanel.add(jbt_sendpicture);
			
			//发送语音
			ImageIcon imi_sendvoice = new ImageIcon("Image/sendvoice.png");
			JButton jbt_sendvoice = new JButton(imi_sendvoice);
			jbt_sendvoice.setPressedIcon(imi_sendvoice);
			jbt_sendvoice.setRolloverIcon(imi_sendvoice);
			jbt_sendvoice.setBounds(75, 275, 25, 25);
			mainpanel.add(jbt_sendvoice);
			
			//发送视频
			ImageIcon imi_sendvideo = new ImageIcon("Image/sendvideo.png");
			JButton jbt_sendvideo = new JButton(imi_sendvideo);
			jbt_sendvideo.setPressedIcon(imi_sendvideo);
			jbt_sendvideo.setRolloverIcon(imi_sendvideo);
			jbt_sendvideo.setBounds(100, 275, 25, 25);
			mainpanel.add(jbt_sendvideo);
			
			//发送截图
			ImageIcon imi_sendsc = new ImageIcon("Image/sendsc.png");
			JButton jbt_sendsc = new JButton(imi_sendsc);
			jbt_sendsc.setPressedIcon(imi_sendsc);
			jbt_sendsc.setRolloverIcon(imi_sendsc);
			jbt_sendsc.setBounds(125, 275, 40, 25);
			mainpanel.add(jbt_sendsc);
			
			//退出群
			JButton jbt_quitgroup = new JButton("退出该群");
			jbt_quitgroup.setFont(new Font("微软雅黑",Font.PLAIN,10));
			jbt_quitgroup.setBounds(510, 370, 80, 20);
			mainpanel.add(jbt_quitgroup);
			jbt_quitgroup.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					mygroup.deleuser(mydata.getID());
					mydata.delegroup(mygroup.getID());
					tt.hide();
				}});
			
			
			//在线用户列表
			JList jl_up = new JList();
			JScrollPane jsp_up = new JScrollPane(jl_up);
			jsp_up.setBounds(450, 60, 140, 150);
			mainpanel.add(jsp_up);
			JLabel jlb_up = new JLabel("在线用户");
			jlb_up.setFont(new Font("微软雅黑",Font.PLAIN,10));
			jlb_up.setBounds(450, 45, 100, 15);
			mainpanel.add(jlb_up);
			
			//离线用户列表
			JList jl_down = new JList();
			JScrollPane jsp_down = new JScrollPane(jl_down);
			jsp_down.setBounds(450, 240, 140, 120);
			mainpanel.add(jsp_down);
			JLabel jlb_down = new JLabel("离线用户");
			jlb_down.setFont(new Font("微软雅黑",Font.PLAIN,10));
			jlb_down.setBounds(450, 225, 100, 15);
			mainpanel.add(jlb_down);
		}
	}
	
	public static void main(String[] args)
	{
		group mygroup = new group("5555","软件12级");
		userdata mydata = new userdata("418084903","Hurray",new ImageIcon("Image/picture"),1);
		new GroupChat(mygroup,mydata);
	}
}