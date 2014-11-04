/**
 * @Author hurray
 * @Part Interface.Method
 * @Note 绘图用到的方法
 * @Encoding UTF-8 
 * @link Expression link is undefined on line 6, column 12 in Templates/Classes/Class.java. 
 * @Date 2014-11-04 08:08:58
 * @Copyright Hurray@BUPT
 * @MainPage http://www.ihurray.com
 * 
 */

package Interface.Method;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/**
 * @Author hurray
 * @Class ImagePanel
 */
public class ImagePanel extends JPanel {

    Image image = null;

    //在Panel上画图

    public ImagePanel(Image image) {
        this.image = image;
    }

    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}
