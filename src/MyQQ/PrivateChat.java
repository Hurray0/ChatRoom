package MyQQ;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class PrivateChat extends JFrame{
	private   boolean   startDrag   =   false;  //拖动检测 
	private   Point   p   =   null;   //鼠标位置
	
	PrivateChat(frienddata myfriend,userdata mydata)//之所以要用PrivateChat_2代替它是因为setUndecorated会将Frame中所有东西清除
	{
		PrivateChat_2 prc = new PrivateChat_2(myfriend,mydata);
		prc.setResizable(false);//不可调整大小
		prc.setUndecorated(true);
		//this.setTitle("与"+fr_name+"聊天中");
		prc.setLocationRelativeTo(null);
		prc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		prc.setSize(600, 400);
		prc.setVisible(true);
		prc.setLocationRelativeTo(null);
	}

	public class PrivateChat_2 extends JFrame
	{
		private JTextArea jta_print = new JTextArea();
		private JTextArea jta_send = new JTextArea();
		PrivateChat_2(final frienddata myfriend,final userdata mydata)
		{
			//背景
			ImageIcon imageicon=new ImageIcon("Image/back_chat.png");
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
			jbt_exit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					t.hide();
				}
			});
			
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
			
			//好友的头像
				//从服务器读取，之后再写！！
			ImageIcon imi_fr_picture = myfriend.getpicture();
			Image img_fr_picture=imi_fr_picture.getImage();
			ImagePanel imp_fr_picture = new ImagePanel(img_fr_picture);
			imp_fr_picture.setBounds(10,8,30,30);
			mainpanel.add(imp_fr_picture);
			
			//好友的名字
				//从服务器读取，之后再写！！
			String string_fr_name = myfriend.getname();
			JLabel jl_fr_name = new JLabel(string_fr_name);
			jl_fr_name.setFont(new Font("微软雅黑",Font.PLAIN,15));
			jl_fr_name.setForeground(new Color(0,0,0));
			jl_fr_name.setBounds(50, 0, 100, 30);
			mainpanel.add(jl_fr_name);
			JLabel jl_fr_name2 = new JLabel(string_fr_name);
			jl_fr_name2.setFont(new Font("微软雅黑",Font.PLAIN,15));
			jl_fr_name2.setForeground(new Color(255,255,255));
			jl_fr_name2.setBounds(51, 1, 100, 30);
			mainpanel.add(jl_fr_name2);
			
			
			//好友的ID
				//从服务器读取，之后再写！！
			String string_fr_ID = "("+myfriend.getID()+")";
			JLabel jl_fr_ID = new JLabel(string_fr_ID);
			jl_fr_ID.setFont(new Font("微软雅黑",Font.PLAIN,10));
			jl_fr_ID.setForeground(new Color(0,0,150));
			jl_fr_ID.setBounds(50, 20, 100, 30);
			mainpanel.add(jl_fr_ID);
			
			//聊天信息框
			//JTextArea jta_print = new JTextArea();写作类私有变量了
			jta_print.setLineWrap(true);//这两行使JTextArea里的文字不能被修改
			jta_print.setEditable(false);//这两行使JTextArea里的文字不能被修改
			JScrollPane jsp_print = new JScrollPane(jta_print);
			jsp_print.setBounds(10, 55, 580, 195);
			mainpanel.add(jsp_print);
			
			//输入信息框
			//JTextArea jta_send = new JTextArea();写作类私有变量了
			JScrollPane jsp_send = new JScrollPane(jta_send);
			jsp_send.setBounds(10, 300, 580, 90);
			mainpanel.add(jsp_send);
			
			//发送按钮
			JButton jbt_send = new JButton("发送");
			jbt_send.setBounds(510, 260, 70, 30);
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
			
			//删除该好友按钮
			JButton jbt_dele_friend = new JButton("删除该好友");
			jbt_dele_friend.setBounds(380, 260,120, 30);
			mainpanel.add(jbt_dele_friend);
			final JFrame tt = this;
			jbt_dele_friend.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					mydata.delefriend(myfriend.getID());
					tt.hide();
				}});
			
		}
	}
	
	public static void main(String[] args)
	{
		userdata mydata = new userdata("418084903","Hurray",new ImageIcon("Image/picture"),1);
		frienddata myfriend = new frienddata("329340496","小军军",new ImageIcon("Image/fr_picture.png"),1);
		new PrivateChat(myfriend,mydata);
	}
}
