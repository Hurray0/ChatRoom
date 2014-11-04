/**
 * @Author hurray
 * @Part
 * @Note
 * @Encoding UTF-8
 * @Date 2014-11-05 12:02:17
 * @Copyright Hurray@BUPT
 * @MainPage http://www.ihurray.com
 *
 */
package Action.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @Author hurray
 * @Class Act_NewGroup
 */
public class Act_NewGroup implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        //新建页面
        JFrame jfm_addgroup = new JFrame();
        jfm_addgroup.setTitle("新建群");
        jfm_addgroup.setLocationRelativeTo(null);
        jfm_addgroup.setDefaultCloseOperation(jfm_addgroup.HIDE_ON_CLOSE);
        jfm_addgroup.setSize(300, 150);
        jfm_addgroup.setVisible(true);

        //新建Panel
        JPanel jpn_addgroup = new JPanel();
        jpn_addgroup.setLayout(null);
        jfm_addgroup.add(jpn_addgroup);

        //请输入群名
        JLabel jlb_entername = new JLabel("请输入群名：");
        jlb_entername.setBounds(20, 20, 150, 30);
        jpn_addgroup.add(jlb_entername);

        //输入框
        JTextField jtf_entername = new JTextField();
        jtf_entername.setBounds(120, 20, 120, 30);
        jpn_addgroup.add(jtf_entername);

        //申请按钮
        JButton jbt_newgroup = new JButton("申请");
        jbt_newgroup.setBounds(120, 70, 70, 30);
        jpn_addgroup.add(jbt_newgroup);
        jbt_newgroup.addActionListener(new Act_Search());
    }
}