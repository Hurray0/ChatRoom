package Interface.MainInterface;

//共有库调用
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

//私有库调用
import Action.*;
import Action.MainFrame.*;
import Const.Resouce.*;
import Interface.Method.ImagePanel;
import Bean.*;
import Interface.GroupChat;
import Interface.PrivateChat;
import Interface.MainInterface.MainInterface_Panel.*;

public class MainInterface extends JFrame {

    public MainInterface(String ID, int status) {
        MainInterface2 mif = new MainInterface2(ID, status);
        //JFrame框
        //this.setTitle("聊天软件^^");
        mif.setResizable(false);//不可调整大小
        mif.setUndecorated(true);//不显示边框
        mif.setLocationRelativeTo(null);
        mif.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mif.setSize(300, 800);
        mif.setVisible(true);
        mif.setLocation(500, 0);//使界面靠上显示

    }

    public static void main(String[] args) {
        new MainInterface("418084903", 1);
    }

    public class MainInterface2 extends JFrame {

        //个人信息
        MyInfo myinfo = new MyInfo("test");

        //界面图片
        ImageIcon MI_back = new ImageIcon("Image/back2.jpg");//背景图片
        ImageIcon MI_pr = new ImageIcon("Image/pr.png");//私聊图标
        ImageIcon MI_gr = new ImageIcon("Image/gr.png");//群聊图标

        //为了鼠标拖动设置的变量
        private boolean startDrag = false;  //拖动检测 
        private Point p = null;   //鼠标位置

        public MainInterface2(String ID, int status) {	//获取个人信息(my_name,my_picture)(my_ID,my_status直接从登陆界面Landed读取)
            myinfo.setID(ID);
            myinfo.setStatus(status);
            myinfo.setName("Hurray");
            myinfo.setPicture(new ImageIcon("Image/picture.png"));

            //获取好友列表及好友信息(name,ID,picture,status,)、群列表
            //GUI界面
            //mainpanel框(背景)
            Image img = MI_back.getImage();
            ImagePanel mainpanel = new ImagePanel(img);
            add(mainpanel);
            mainpanel.setLayout(null);/*这一句非常重要，如果没有这句，后面的组件将没法安排位置*/

            //鼠标拖动(copy from CSDN)
            addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    startDrag = true;
                    p = e.getPoint();
                }

                public void mouseReleased(MouseEvent e) {
                    startDrag = false;
                }
            });
            addMouseMotionListener(new MouseMotionAdapter() {
                public void mouseDragged(MouseEvent e) {
                    Point p1 = e.getPoint();
                    Point p2 = getLocation(null);
                    p2.x += p1.x - p.x;
                    p2.y += p1.y - p.y;
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
            jbt_exit.setBounds(275, 0, 25, 25);
            mainpanel.add(jbt_exit);
            jbt_exit.addActionListener(new Act_Exit(this));

            //最小化按钮
            ImageIcon minimize1 = new ImageIcon("Image/minimize1.png");
            ImageIcon minimize2 = new ImageIcon("Image/minimize2.png");
            ImageIcon minimize3 = new ImageIcon("Image/minimize3.png");
            JButton jbt_minimize = new JButton(minimize1);
            jbt_minimize.setPressedIcon(minimize3);
            jbt_minimize.setRolloverIcon(minimize2);
            jbt_minimize.setBounds(250, 0, 25, 25);
            mainpanel.add(jbt_minimize);
            jbt_minimize.addActionListener(new Act_Minimize(this));

            //头像
            Image IMG_my_picture = myinfo.getPicture().getImage();
            ImagePanel IMP_my_picture = new ImagePanel(IMG_my_picture);
            IMP_my_picture.setBounds(20, 20, 80, 80);
            mainpanel.add(IMP_my_picture);

            //名字
            JLabel jl_my_name = new JLabel(myinfo.getName());
            jl_my_name.setFont(new Font("微软雅黑", Font.PLAIN, 20));
            jl_my_name.setForeground(new Color(0, 0, 0));
            jl_my_name.setBounds(120, 25, 100, 40);
            mainpanel.add(jl_my_name);

            //ID
            JLabel jl_my_ID = new JLabel("(" + myinfo.getID() + ")");
            jl_my_ID.setFont(new Font("微软雅黑", Font.PLAIN, 15));
            jl_my_ID.setForeground(new Color(0, 0, 150));
            jl_my_ID.setBounds(120, 60, 100, 20);
            mainpanel.add(jl_my_ID);

            //设置个人信息
            ImageIcon IMI_setting = new ImageIcon("Image/setting.png");
            JButton jbt_setting = new JButton(IMI_setting);
            jbt_setting.setPressedIcon(IMI_setting);
            jbt_setting.setRolloverIcon(IMI_setting);
            jbt_setting.setBounds(100, 700, 30, 30);
            mainpanel.add(jbt_setting);
            //这里需要加好多东西，这里可以设置姓名和头像，并将二者传给服务器数据库更新，需要新建页面
            jbt_setting.addActionListener(new Act_Setting(myinfo));

            //私聊panel_pr
            //需要添加线程不断刷新
            JList jl_pr = new JList();
            JScrollPane jsp_pr = new JScrollPane(jl_pr);
            jsp_pr.setBounds(10, 160, 280, 500);
            for (int i = 0; i < myinfo.getGroupList().size(); i++) {
                Panel_User fr_userpanel = new Panel_User(myinfo, i);
                jsp_pr.add(fr_userpanel);
                jl_pr.add(fr_userpanel);
            }
            mainpanel.add(jsp_pr);

            //群聊panel_gr
            //需要添加线程不断刷新
            JList jl_gr = new JList();
            JScrollPane jsp_gr = new JScrollPane(jl_gr);
            jsp_gr.setBounds(10, 160, 280, 500);
            for (int i = 0; i < myinfo.getGroupList().size(); i++) {     
                Panel_Group fr_grouppanel = new Panel_Group(myinfo, i);
                jsp_gr.add(fr_grouppanel);
                jl_gr.add(fr_grouppanel);
            }

            mainpanel.add(jsp_gr);

            //选择私聊、群聊
            JButton jbt_pr = new JButton(MI_pr);
            jbt_pr.setPressedIcon(MI_pr);
            jbt_pr.setRolloverIcon(MI_pr);
            JButton jbt_gr = new JButton(MI_gr);
            jbt_gr.setPressedIcon(MI_gr);
            jbt_gr.setRolloverIcon(MI_gr);
            jbt_pr.setBounds(10, 125, 94, 33);
            jbt_gr.setBounds(105, 125, 94, 33);
            mainpanel.add(jbt_pr);
            mainpanel.add(jbt_gr);
            jbt_pr.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jsp_pr.setVisible(true);
                    jsp_gr.setVisible(false);
                }
            });/*隐藏群聊列表，显示私聊列表*/

            jbt_gr.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jsp_gr.setVisible(true);
                    jsp_pr.setVisible(false);
                }
            });/*隐藏私聊列表，显示群聊列表*/

            //查找好友、群
            ImageIcon imi_add = new ImageIcon("Image/add.png");
            JButton jbt_add = new JButton(imi_add);
            jbt_add.setPressedIcon(imi_add);
            jbt_add.setRolloverIcon(imi_add);
            jbt_add.setBounds(20, 700, 60, 28);
            mainpanel.add(jbt_add);
            jbt_add.addActionListener(new Act_Search());

            //新建群
            ImageIcon imi_addgroup = new ImageIcon("Image/addgroup.png");
            JButton jbt_addgroup = new JButton(imi_addgroup);
            jbt_addgroup.setPressedIcon(imi_addgroup);
            jbt_addgroup.setRolloverIcon(imi_addgroup);
            jbt_addgroup.setBounds(20, 750, 60, 28);
            mainpanel.add(jbt_addgroup);
            jbt_addgroup.addActionListener(new Act_NewGroup());

        }

    }
}
