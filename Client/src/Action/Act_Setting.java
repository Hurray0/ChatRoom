/**
 * @Author hurray
 * @Part
 * @Note
 * @Encoding UTF-8
 * @link Expression link is undefined on line 6, column 12 in Templates/Classes/Class.java.
 * @Date 2014-11-04 08:18:22
 * @Copyright Hurray@BUPT
 * @MainPage http://www.ihurray.com
 *
 */
package Action;

//导入公用库
import Interface.MainInterface.MainInterface;
import Interface.Method.ImagePanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//导入私有库
import Bean.MyInfo;
/**
 * @Author hurray
 * @Class Act_Setting
 */
public class Act_Setting implements ActionListener {

    MyInfo myinfo;
    
    public Act_Setting(MyInfo myinfo) {
        this.myinfo = myinfo;
    }
    
    public void actionPerformed(ActionEvent arg0) {
        //显示设置面板jfm_setting
        JFrame jfm_setting = new JFrame();
        jfm_setting.setTitle("设置");
        jfm_setting.setLocationRelativeTo(null);
        jfm_setting.setDefaultCloseOperation(jfm_setting.HIDE_ON_CLOSE);
        jfm_setting.setSize(300, 300);
        jfm_setting.setVisible(true);

        //建立主Panel
        JPanel jpn_setting = new JPanel();
        jfm_setting.add(jpn_setting);
        jpn_setting.setLayout(null);/*这一句非常重要，如果没有这句，后面的组件将没法安排位置*/

        //打印头像
        Image IMG_my_picture = myinfo.getPicture().getImage();
        ImagePanel IMP_my_picture = new ImagePanel(IMG_my_picture);
        IMP_my_picture.setBounds(20, 20, 80, 80);
        jpn_setting.add(IMP_my_picture);

        //修改头像
        JButton jbt_cgpicture = new JButton("修改头像");
        jbt_cgpicture.setFont(new Font("微软雅黑", Font.PLAIN, 10));
        jbt_cgpicture.setBounds(20, 110, 80, 25);
        jpn_setting.add(jbt_cgpicture);
        jbt_cgpicture.addActionListener(null);//这里需要写

        //打印ID
        JLabel jl_my_ID = new JLabel("账号：" + myinfo.getID());
        jl_my_ID.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        jl_my_ID.setForeground(new Color(0, 0, 150));
        jl_my_ID.setBounds(130, 60, 200, 30);
        jpn_setting.add(jl_my_ID);

				//姓名
        //打印“昵称：”
        JLabel jl_my_name = new JLabel("昵称：");
        jl_my_name.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        jl_my_name.setForeground(new Color(0, 0, 150));
        jl_my_name.setBounds(130, 100, 200, 30);
        jpn_setting.add(jl_my_name);
        //修改框
        JTextField jfm_newname = new JTextField(myinfo.getName());
        jfm_newname.setBounds(175, 100, 100, 30);
        jpn_setting.add(jfm_newname);

        //修改状态
        String[] status = {"隐身", "在线"};
        JComboBox jcb_my_status = new JComboBox(status);
        jcb_my_status.setSelectedIndex(1);
        jcb_my_status.setBounds(130, 140, 60, 20);
        jpn_setting.add(jcb_my_status);

        //保存按钮
        JButton jbt_save = new JButton("保存");
        jbt_save.setFont(new Font("微软雅黑", Font.PLAIN, 10));
        jbt_save.setBounds(150, 200, 80, 25);
        jpn_setting.add(jbt_save);
        jbt_save.addActionListener(null);//这里需要写

        //修改密码
        JButton jbt_cgcode = new JButton("修改密码");
        jbt_cgcode.setFont(new Font("微软雅黑", Font.PLAIN, 10));
        jbt_cgcode.setBounds(50, 200, 80, 25);
        jpn_setting.add(jbt_cgcode);
        //???
//        jbt_cgcode.addActionListener(new MainInterface.MainInterface2.act_cgcode());
    }
}
