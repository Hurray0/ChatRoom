package Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Action.*;

public class Landed extends JFrame {

    private boolean startDrag = false;  //拖动检测 
    private Point p = null;   //鼠标位置
    public JTextField jtf_id = new JTextField();
    public JTextField jtf_code = new JTextField();
    public String[] status = {"", "在线", "隐身"};
    public JComboBox jcb_status = new JComboBox(status);

    //JFrame
    final JFrame t = this;

    public static void main(Landed mylanded) {
        mylanded.setResizable(false);
        mylanded.setUndecorated(true);
        mylanded.setTitle("用户登陆");
        mylanded.setLocationRelativeTo(null);
        mylanded.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mylanded.setSize(400, 300);
        mylanded.setVisible(true);
    }

    public Landed() {
		//GUI界面
        //背景
        ImageIcon imageicon = new ImageIcon("Image/back2.jpg");
        Image img = imageicon.getImage();
        ImagePanel mainpanel = new ImagePanel(img);
        add(mainpanel);
        mainpanel.setLayout(null);
        //顶层文字
        JLabel jl_top = new JLabel("登陆窗口");
        jl_top.setFont(new Font("微软雅黑", Font.PLAIN, 30));
        jl_top.setForeground(new Color(255, 255, 255));
        jl_top.setBounds(140, 0, 150, 70);
        mainpanel.add(jl_top);
        //阴影重叠效果（下层）
        JLabel jl_top2 = new JLabel("登陆窗口");
        jl_top2.setFont(new Font("微软雅黑", Font.PLAIN, 30));
        jl_top2.setForeground(new Color(0, 0, 0));
        jl_top2.setBounds(142, 2, 150, 70);
        mainpanel.add(jl_top2);

        //账号：
        JLabel jl_id = new JLabel("账  号 ：");
        jl_id.setFont(new Font("微软雅黑", Font.BOLD, 15));
        //jl_id.setForeground(new Color(0,0,0));
        jl_id.setBounds(80, 70, 150, 70);
        mainpanel.add(jl_id);

        //JTextField jtf_id = new JTextField();在类中声明
        jtf_id.setBounds(140, 94, 150, 25);
        mainpanel.add(jtf_id);

        //密码：
        JLabel jl_code = new JLabel("密  码 ：");
        jl_code.setFont(new Font("微软雅黑", Font.BOLD, 15));
        //jl_code.setForeground(new Color(0,0,0));
        jl_code.setBounds(80, 140, 150, 70);
        mainpanel.add(jl_code);

        //JTextField jtf_code = new JTextField();在类中声明
        jtf_code.setBounds(140, 164, 150, 25);
        mainpanel.add(jtf_code);

        //注册按钮
        JButton jbt_reg = new JButton("注  册");
        jbt_reg.setBounds(55, 240, 100, 30);
        mainpanel.add(jbt_reg);
        jbt_reg.addActionListener(new Act_Regist());

        //登陆按钮
        JButton jbt_landed = new JButton("登  陆");
        jbt_landed.setBounds(245, 240, 100, 30);
        mainpanel.add(jbt_landed);

        jbt_landed.addActionListener(new Act_Landed(this));

        //关闭按钮
        ImageIcon exit1 = new ImageIcon("Image/exit1.png");
        ImageIcon exit2 = new ImageIcon("Image/exit2.png");
        ImageIcon exit3 = new ImageIcon("Image/exit3.png");
        JButton jbt_exit = new JButton(exit1);
        jbt_exit.setPressedIcon(exit3);
        jbt_exit.setRolloverIcon(exit2);
        jbt_exit.setBounds(370, 0, 30, 30);
        mainpanel.add(jbt_exit);
        jbt_exit.addActionListener(new Act_Exit(this));

        //最小化按钮
        ImageIcon minimize1 = new ImageIcon("Image/minimize1.png");
        ImageIcon minimize2 = new ImageIcon("Image/minimize2.png");
        ImageIcon minimize3 = new ImageIcon("Image/minimize3.png");
        JButton jbt_minimize = new JButton(minimize1);
        jbt_minimize.setPressedIcon(minimize3);
        jbt_minimize.setRolloverIcon(minimize2);
        jbt_minimize.setBounds(340, 0, 30, 30);
        mainpanel.add(jbt_minimize);
        jbt_minimize.addActionListener(new Act_Minimize(this));

			//状态选择
        //String[] status = {"隐身","在线"};
        //JComboBox jcb_status = new JComboBox(status);在类中声明
        jcb_status.setSelectedIndex(1);
        jcb_status.addActionListener(null);
        jcb_status.setBounds(300, 100, 80, 20);
        mainpanel.add(jcb_status);

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
    }

    public String GetID() {
        return this.jtf_id.getText();
    }

    public String GetCode() {
        return this.jtf_code.getText();
    }

    public int GetStatus() {
        return jcb_status.getSelectedIndex();
    }

}
//背景图片类

class ImagePanel extends JPanel {

    Image image = null;

    //在Panel上画图

    ImagePanel(Image image) {
        this.image = image;
    }

    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}
