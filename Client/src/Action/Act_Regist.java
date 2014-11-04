/**
 * @Author hurray
 * @Part 
 * @Note 
 * @Encoding UTF-8 
 * @link Expression link is undefined on line 6, column 12 in Templates/Classes/Class.java. 
 * @Date 2014-11-04 06:21:32
 * @Copyright Hurray@BUPT
 * @MainPage http://www.ihurray.com
 * 
 */

package Action;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @Author hurray
 * @Class Act_Regist
 */
public class Act_Regist implements ActionListener {

    public void actionPerformed(ActionEvent arg0) {
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
        jlb_new_name.setFont(new Font("微软雅黑", Font.BOLD, 15));
        jlb_new_name.setBounds(20, 20, 100, 20);
        jpn_reg.add(jlb_new_name);

        //建立JLabel jlb_new_code
        JLabel jlb_new_code = new JLabel("请输入密码");
        jlb_new_code.setFont(new Font("微软雅黑", Font.BOLD, 15));
        jlb_new_code.setBounds(20, 50, 100, 20);
        jpn_reg.add(jlb_new_code);

        //输入昵称框
        JTextField jtf_new_name = new JTextField();
        jtf_new_name.setFont(new Font("微软雅黑", Font.BOLD, 15));
        jtf_new_name.setBounds(110, 20, 120, 20);
        jpn_reg.add(jtf_new_name);

        //输入密码框
        JTextField jtf_new_code = new JTextField();
        jtf_new_code.setFont(new Font("微软雅黑", Font.BOLD, 15));
        jtf_new_code.setBounds(110, 50, 120, 20);
        jpn_reg.add(jtf_new_code);

        //注册按钮
        JButton jbt_new_reg = new JButton("注册");
        jbt_new_reg.setBounds(200, 80, 80, 20);
        jpn_reg.add(jbt_new_reg);
        jbt_new_reg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String str_err = "注册失败";
                String str_sec = "注册成功";
                int x = 1;
                //加判断注册成功的语句，成功则把x设成1
                if (x == 1) {
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
                    JLabel jlb_new_ID = new JLabel("您的号码为：" + new_ID);
                    jlb_new_ID.setBounds(20, 60, 200, 30);
                    jpn_reg_sec.add(jlb_new_ID);

                } else {
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
