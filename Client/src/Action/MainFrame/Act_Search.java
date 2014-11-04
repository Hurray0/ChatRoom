/**
 * @Author hurray
 * @Part
 * @Note
 * @Encoding UTF-8
 * @Date 2014-11-04 11:51:14
 * @Copyright Hurray@BUPT
 * @MainPage http://www.ihurray.com
 *
 */
package Action.MainFrame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * @Author hurray
 * @Class Act_Search
 */
public class Act_Search implements ActionListener {

    protected int choice;
    JTextField jtf_add = new JTextField();

    public void actionPerformed(ActionEvent e) {
        //新建JFrame
        JFrame jfm_add = new JFrame();
        jfm_add.setTitle("查找");
        jfm_add.setLocationRelativeTo(null);
        jfm_add.setDefaultCloseOperation(jfm_add.HIDE_ON_CLOSE);
        jfm_add.setSize(300, 300);
        jfm_add.setVisible(true);
        jfm_add.setResizable(false);//不可调整大小

        //新建JPanel
        JPanel jpn_add = new JPanel();
        jpn_add.setLayout(null);
        jfm_add.add(jpn_add);

        //单选按钮：查找人/群
        choice = -1;
        JPanel jpn_jrb_add = new JPanel();
        jpn_jrb_add.setBounds(0, 20, 200, 100);
        jpn_add.add(jpn_jrb_add);
        JRadioButton jrb_1 = new JRadioButton("查找用户");
        jpn_jrb_add.add(jrb_1);
        JRadioButton jrb_2 = new JRadioButton("查找群");
        jpn_jrb_add.add(jrb_2);
        ButtonGroup group = new ButtonGroup();
        group.add(jrb_1);
        group.add(jrb_2);
        jrb_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                choice = 1;
            }
        });
        jrb_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                choice = 2;
            }
        });

        //Label提示
        JLabel jlb_add = new JLabel("请输入账号：");
        jlb_add.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        jlb_add.setBounds(20, 150, 200, 30);
        jpn_add.add(jlb_add);

                //输入框
        //JTextField jtf_add = new JTextField();在类中定义
        jtf_add.setBounds(120, 150, 100, 30);
        jpn_add.add(jtf_add);

        //”查找“按钮
        JButton jbt_search = new JButton("查找");
        jbt_search.setBounds(150, 200, 70, 30);
        jbt_search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (choice == 1) {
                    new Act_SearchFriend(jtf_add.getText());
                }
                if (choice == 2) {
                    new Act_SearchGroup(jtf_add.getText());
                }
            }
        });
        jpn_add.add(jbt_search);

    }

}
