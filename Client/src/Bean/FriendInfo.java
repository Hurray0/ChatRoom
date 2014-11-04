/**
 * @Author hurray
 * @Part 
 * @Note 
 * @Encoding UTF-8 
 * @link Expression link is undefined on line 6, column 12 in Templates/Classes/Class.java. 
 * @Date 2014-11-04 08:37:14
 * @Copyright Hurray@BUPT
 * @MainPage http://www.ihurray.com
 * 
 */

package Bean;

import javax.swing.ImageIcon;

/**
 * @Author hurray
 * @Class FriendInfo
 */
public class FriendInfo {
    private String ID;
    private String name;
    private ImageIcon picture;
    private int status;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ImageIcon getPicture() {
        return picture;
    }

    public void setPicture(ImageIcon picture) {
        this.picture = picture;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}