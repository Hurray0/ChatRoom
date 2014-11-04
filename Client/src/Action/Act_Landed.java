/**
 * @Author hurray
 * @Part 
 * @Note 
 * @Encoding UTF-8 
 * @link Expression link is undefined on line 6, column 12 in Templates/Classes/Class.java. 
 * @Date 2014-11-04 06:22:30
 * @Copyright Hurray@BUPT
 * @MainPage http://www.ihurray.com
 * 
 */

package Action;

import Interface.Landed;
import Interface.MainInterface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @Author hurray
 * @Class Act_Landed
 */
public class Act_Landed implements ActionListener {

    private String mycode;
    private String myID;
    private int status;
    private Landed landed;

    public Act_Landed(Landed landed) {
        this.landed = landed;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        mycode = landed.GetCode();
        myID = landed.GetID();
        status = landed.GetStatus();
        ////哈哈 这里的逻辑完全不对啊 当时还是太年轻
        int judge = 1;
        //验证账号和密码（从服务器）,正确的话返回1，否则为0
        if (judge == 1) {
            System.out.println(myID + "hahahaha");
            new MainInterface(myID, status);
            landed.hide();
        } else {	//JFrame
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

            //请输入群名
            JLabel jlb_entername = new JLabel("登陆失败！请重试！");
            jlb_entername.setBounds(20, 20, 250, 30);
            jpn_err.add(jlb_entername);

        }
    }

}
