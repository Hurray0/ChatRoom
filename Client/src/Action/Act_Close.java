/**
 * @Author hurray
 * @Part Action
 * @Note 关闭当前窗口
 * @Encoding UTF-8 
 * @link Expression link is undefined on line 6, column 12 in Templates/Classes/Class.java. 
 * @Date 2014-11-04 06:35:09
 * @Copyright Hurray@BUPT
 * @MainPage http://www.ihurray.com
 * 
 */

package Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.awt.Window;

/**
 * @Author hurray
 * @Class Act_Hide
 */
public class Act_Close implements ActionListener{
    
    private JFrame jframe;
    
    public Act_Close(JFrame jframe)
    {
        this.jframe = jframe;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        jframe.dispose();
    }
}