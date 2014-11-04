/**
 * @Author hurray
 * @Part
 * @Note
 * @Encoding UTF-8
 * @Date 2014-11-04 09:47:09
 * @Copyright Hurray@BUPT
 * @MainPage http://www.ihurray.com
 *
 */
package Interface.MainInterface.MainInterface_Panel;

import Interface.GroupChat;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Bean.*;

/**
 * @Author hurray
 * @Class Panel_Group
 */
public class Panel_Group extends JPanel {

    private MyInfo myinfo;
    private GroupInfo thisgroup;

    public Panel_Group(MyInfo myinfo, int i) {
        thisgroup = (GroupInfo)(myinfo.getGroupList().get(i));
				//i用来算panel的位置,从0开始

        //panel的设置
        this.setLayout(null);
        this.setBounds(7, 40 * i, 250, 40);

        //名字
        JLabel jl_name = new JLabel(thisgroup.getGroupName());
        jl_name.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        jl_name.setForeground(new Color(0, 0, 0));
        jl_name.setBounds(10, 5, 100, 15);
        this.add(jl_name);

        //ID
        JLabel jl_ID = new JLabel("(" + thisgroup.getGroupID() + ")");
        jl_ID.setFont(new Font("微软雅黑", Font.PLAIN, 10));
        jl_ID.setForeground(new Color(0, 0, 150));
        jl_ID.setBounds(10, 25, 100, 10);
        this.add(jl_ID);
        
        //添加监听事件
        
    }
}