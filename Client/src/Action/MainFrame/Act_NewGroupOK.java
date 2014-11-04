/**
 * @Author hurray
 * @Part
 * @Note
 * @Encoding UTF-8
 * @Date 2014-11-05 12:00:12
 * @Copyright Hurray@BUPT
 * @MainPage http://www.ihurray.com
 *
 */
package Action.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @Author hurray
 * @Class Act_NewGroup
 */
public class Act_NewGroupOK implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        int judge = 1;
        //判断是否申请成功，成功judge设为1
        if (judge == 0) {
            //新建页面
            JFrame jfm_newgroup = new JFrame();
            jfm_newgroup.setTitle("error");
            jfm_newgroup.setLocationRelativeTo(null);
            jfm_newgroup.setDefaultCloseOperation(jfm_newgroup.HIDE_ON_CLOSE);
            jfm_newgroup.setSize(300, 150);
            jfm_newgroup.setVisible(true);

            //新建Panel
            JPanel jpn_newgroup = new JPanel();
            jpn_newgroup.setLayout(null);
            jfm_newgroup.add(jpn_newgroup);

            //请输入群名
            JLabel jlb_entername = new JLabel("申请失败！请重试！");
            jlb_entername.setBounds(20, 20, 250, 30);
            jpn_newgroup.add(jlb_entername);
        } else {
            //获取newgroupID
            String newgroupID = "null";

            //新建页面
            JFrame jfm_newgroup = new JFrame();
            jfm_newgroup.setTitle("seccess");
            jfm_newgroup.setLocationRelativeTo(null);
            jfm_newgroup.setDefaultCloseOperation(jfm_newgroup.HIDE_ON_CLOSE);
            jfm_newgroup.setSize(300, 150);
            jfm_newgroup.setVisible(true);

            //新建Panel
            JPanel jpn_newgroup = new JPanel();
            jpn_newgroup.setLayout(null);
            jfm_newgroup.add(jpn_newgroup);

            //请输入群名
            JLabel jlb_entername = new JLabel("申请成功！您的群号是：" + newgroupID);
            jlb_entername.setBounds(20, 20, 250, 30);
            jpn_newgroup.add(jlb_entername);
        }
    }
}
