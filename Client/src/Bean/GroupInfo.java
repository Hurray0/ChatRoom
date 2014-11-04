/**
 * @Author hurray
 * @Part 
 * @Note 
 * @Encoding UTF-8 
 * @link Expression link is undefined on line 6, column 12 in Templates/Classes/Class.java. 
 * @Date 2014-11-04 08:44:11
 * @Copyright Hurray@BUPT
 * @MainPage http://www.ihurray.com
 * 
 */

package Bean;

/**
 * @Author hurray
 * @Class GroupInfo
 */
public class GroupInfo {
    private String groupID;
    private String groupName;
    private String groupLeaderName;
    private String[] groupUsername;

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupLeaderName() {
        return groupLeaderName;
    }

    public void setGroupLeaderName(String groupLeaderName) {
        this.groupLeaderName = groupLeaderName;
    }

    public String[] getGroupUsername() {
        return groupUsername;
    }

    public void setGroupUsername(String[] groupUsername) {
        this.groupUsername = groupUsername;
    }
    
}