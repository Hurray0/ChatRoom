/**
 * @Author hurray
 * @Part
 * @Note
 * @Encoding UTF-8
 * @Date 2014-11-04 11:49:02
 * @Copyright Hurray@BUPT
 * @MainPage http://www.ihurray.com
 *
 */
package Action.MainFrame;

import Interface.MainInterface.MainInterface;
import java.awt.Color;
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
 * @Class Act_ChangeCode
 */
public class Act_ChangeCode implements ActionListener {

    public void actionPerformed(ActionEvent arg0) {
        //新添一个JFrame
        final JFrame jfm_cgcode = new JFrame();
        jfm_cgcode.setTitle("修改密码");
        jfm_cgcode.setLocationRelativeTo(null);
        jfm_cgcode.setDefaultCloseOperation(jfm_cgcode.HIDE_ON_CLOSE);
        jfm_cgcode.setSize(300, 300);
        jfm_cgcode.setVisible(true);

        //添加一个主JPanel
        JPanel jpn_cgcode = new JPanel();
        jfm_cgcode.add(jpn_cgcode);
        jpn_cgcode.setLayout(null);/*这一句非常重要，如果没有这句，后面的组件将没法安排位置*/

                //输入旧密码
        //文字提示
        JLabel jl_oldcode = new JLabel("请输入您的密码：");
        jl_oldcode.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        jl_oldcode.setForeground(new Color(0, 0, 150));
        jl_oldcode.setBounds(20, 20, 140, 30);
        jpn_cgcode.add(jl_oldcode);
        //修改框
        JTextField jfm_oldcode = new JTextField();
        jfm_oldcode.setBounds(150, 20, 100, 30);
        jpn_cgcode.add(jfm_oldcode);

                //新密码
        //文字提示
        JLabel jl_newcode = new JLabel("请输入新密码：");
        jl_newcode.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        jl_newcode.setForeground(new Color(0, 0, 150));
        jl_newcode.setBounds(20, 120, 140, 30);
        jpn_cgcode.add(jl_newcode);
        //修改框
        JTextField jfm_newcode = new JTextField();
        jfm_newcode.setBounds(150, 120, 100, 30);
        jpn_cgcode.add(jfm_newcode);

        //确定修改按钮
        JButton jbt_cgcode_y = new JButton("修改密码");
        jbt_cgcode_y.setFont(new Font("微软雅黑", Font.PLAIN, 10));
        jbt_cgcode_y.setBounds(150, 200, 80, 25);
        jpn_cgcode.add(jbt_cgcode_y);
        
        //取消按钮
        JButton jbt_cgcode_n = new JButton("取消");
        jbt_cgcode_n.setFont(new Font("微软雅黑", Font.PLAIN, 10));
        jbt_cgcode_n.setBounds(50, 200, 80, 25);
        jpn_cgcode.add(jbt_cgcode_n);
        jbt_cgcode_n.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jfm_cgcode.hide();
            }
        });
    }
}
