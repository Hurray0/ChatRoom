/**
 * @Author hurray
 * @Part Action
 * @Note 关闭整个程序
 * @Encoding UTF-8
 * @link Expression link is undefined on line 6, column 12 in Templates/Classes/Class.java.
 * @Date 2014-11-04 06:32:16
 * @Copyright Hurray@BUPT
 * @MainPage http://www.ihurray.com
 *
 */
package Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * @Author hurray
 * @Class Act_Exit
 */
public class Act_Exit implements ActionListener {

    private JFrame jframe;
    
    public Act_Exit(JFrame jframe)
    {
        this.jframe = jframe;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
