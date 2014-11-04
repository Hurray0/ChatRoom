/**
 * @Author hurray
 * @Part
 * @Note
 * @Encoding UTF-8
 * @Date 2014-11-04 11:00:49
 * @Copyright Hurray@BUPT
 * @MainPage http://www.ihurray.com
 *
 */
package Action.MainFrame;

import Interface.Method.ImagePanel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @Author hurray
 * @Class Act_SearchFriend
 */
public class Act_SearchFriend extends JFrame {

    int search_yn;

    public Act_SearchFriend(String s) {
                //GUI
        //JFrame设置
        this.setTitle("查找用户");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.HIDE_ON_CLOSE);
        this.setSize(300, 200);
        this.setVisible(true);
        this.setResizable(false);//不可调整大小

        //JPanel设置
        JPanel jpn_search = new JPanel();
        jpn_search.setLayout(null);
        this.add(jpn_search);

        //查找
        search_yn = 0;//需要添加查找判断
        if (search_yn == 0) {
            JLabel jlb_search_err = new JLabel("没有找到！");
            jlb_search_err.setBounds(20, 20, 150, 30);
            jpn_search.add(jlb_search_err);
        } else {
            //Label
            JLabel jlb_search_sec = new JLabel("成功找到，是否添加好友？");
            jlb_search_sec.setBounds(20, 20, 200, 30);
            jpn_search.add(jlb_search_sec);

            //被查找用户的头像
            ImageIcon imi_search = new ImageIcon("Image/fr_picture.png");
            //这里需要调用用户头像,并把上一行括号里的东西删掉
            Image img_fr_picture = imi_search.getImage();
            ImagePanel imp_fr_picture = new ImagePanel(img_fr_picture);
            imp_fr_picture.setBounds(20, 50, 40, 40);
            jpn_search.add(imp_fr_picture);

            //被查找用户的昵称
            String str_search_name = "searchname";
            JLabel jlb_search_name = new JLabel(str_search_name);
            jlb_search_name.setBounds(90, 50, 150, 30);
            jpn_search.add(jlb_search_name);

            //被查找用户的ID
            String str_search_ID = "searchID";
            JLabel jlb_search_ID = new JLabel("(" + str_search_ID + ")");
            jlb_search_ID.setBounds(90, 80, 150, 30);
            jpn_search.add(jlb_search_ID);

            //按钮是
            JButton jbt_yes = new JButton("是");
            jbt_yes.setBounds(70, 120, 70, 30);
            jpn_search.add(jbt_yes);
            jbt_yes.addActionListener(null);//以后再写

            //按钮否
            final JFrame t = this;
            JButton jbt_no = new JButton("否");
            jbt_no.setFont(new Font("微软雅黑", Font.PLAIN, 10));
            jbt_no.setBounds(170, 120, 70, 30);
            jpn_search.add(jbt_no);
            jbt_no.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    t.hide();
                }
            });
        }

    }
}
