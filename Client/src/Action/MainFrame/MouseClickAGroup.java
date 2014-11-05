/**
 * @Author hurray
 * @Part 
 * @Note 
 * @Encoding UTF-8 
 * @Date 2014-11-04 09:56:38
 * @Copyright Hurray@BUPT
 * @MainPage http://www.ihurray.com
 * 
 */

package Action.MainFrame;

import Bean.*;
import Interface.GroupChat;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @Author hurray
 * @Class MouseClickAGroup
 */
public class MouseClickAGroup extends MouseAdapter {

    GroupInfo thisgroup;
    MyInfo myinfo;

    public MouseClickAGroup(GroupInfo thisgroup, MyInfo myinfo) {
        this.thisgroup = thisgroup;
        this.myinfo = myinfo;
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            new GroupChat(thisgroup, myinfo);

            //扩充功能
            int judge = 1;

            if (judge == 0) {
                //JFrame
                JFrame jfm_err = new JFrame();
                jfm_err.setTitle("error");
                jfm_err.setLocationRelativeTo(null);
                jfm_err.setDefaultCloseOperation(jfm_err.HIDE_ON_CLOSE);
                jfm_err.setSize(300, 150);
                jfm_err.setVisible(true);

                //新建Panel
                JPanel jpn_err = new JPanel();
                jpn_err.setLayout(null);
                jfm_err.add(jpn_err);

                //JLabel
                JLabel jlb_entername = new JLabel("您不存在该好友！");
                jlb_entername.setBounds(20, 20, 250, 30);
                jpn_err.add(jlb_entername);
            }
        }
    }
}