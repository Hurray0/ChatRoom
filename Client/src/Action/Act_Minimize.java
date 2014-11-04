/**
 * @Author hurray
 * @Part
 * @Note
 * @Encoding UTF-8
 * @link Expression link is undefined on line 6, column 12 in Templates/Classes/Class.java.
 * @Date 2014-11-04 06:23:32
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
 * @Class Act_Minimize
 */
public class Act_Minimize implements ActionListener {

    private JFrame jframe;

    public Act_Minimize(JFrame jframe) {
        this.jframe = jframe;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jframe.setState(jframe.ICONIFIED);
    }
}
