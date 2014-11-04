/**
 * @Author hurray
 * @Part
 * @Note
 * @Encoding UTF-8
 * @link Expression link is undefined on line 6, column 12 in Templates/Classes/Class.java.
 * @Date 2014-11-04 09:04:22
 * @Copyright Hurray@BUPT
 * @MainPage http://www.ihurray.com
 *
 */
package Interface.MainInterface.MainInterface_Panel;

import Action.MainFrame.MouseClickAFriend;
import Bean.*;
import Interface.Method.ImagePanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @Author hurray
 * @Class UserList
 */
public class Panel_User extends JPanel {

    private MyInfo myinfo;
    private FriendInfo thisfriend;
    private int i;

    public Panel_User(MyInfo myinfo, int i) {

        this.myinfo = myinfo;
        this.thisfriend = (FriendInfo)(myinfo.getFriendList().get(i));
        //i用来算panel的位置,从0开始

        //panel的设置
        this.setLayout(null);
        this.setBounds(7, 40 * i, 250, 40);

        //头像
        ImageIcon imi_picture = thisfriend.getPicture();
        Image img_picture = imi_picture.getImage();
        ImagePanel imp_picture = new ImagePanel(img_picture);
        imp_picture.setBounds(5, 5, 30, 30);
        this.add(imp_picture);

        //名字
        JLabel jl_name = new JLabel(thisfriend.getName());
        jl_name.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        jl_name.setForeground(new Color(0, 0, 0));
        jl_name.setBounds(45, 5, 100, 15);
        this.add(jl_name);

        //ID
        JLabel jl_ID = new JLabel("(" + thisfriend.getID() + ")");
        jl_ID.setFont(new Font("微软雅黑", Font.PLAIN, 10));
        jl_ID.setForeground(new Color(0, 0, 150));
        jl_ID.setBounds(45, 25, 100, 10);
        this.add(jl_ID);

        //状态
        if (thisfriend.getStatus() == 1) {
            ImageIcon imi_status = new ImageIcon("Image/green.png");
            Image img_status = imi_status.getImage();
            ImagePanel imp_status = new ImagePanel(img_status);
            imp_status.setBounds(0, 0, 40, 5);
            this.add(imp_status);
        } else {
            ImageIcon imi_status = new ImageIcon("Image/red.png");
            Image img_status = imi_status.getImage();
            ImagePanel imp_status = new ImagePanel(img_status);
            imp_status.setBounds(0, 0, 40, 5);
            this.add(imp_status);
        }
        //监听事件
        this.addMouseListener(new MouseClickAFriend(thisfriend, myinfo));
    }
}
