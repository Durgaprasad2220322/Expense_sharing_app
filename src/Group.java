package src;

import java.util.List;
public class Group {
    private String groupId;
    private String groupName;
    private List<User> members;

    public Group(String groupId, String groupName, List<User> members) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.members = members;
    }

    public String getGroupId() {
        return groupId;
    }
    public String getGroupName() {
        return groupName;
    }
    public List<User> getMembers() {
        return members;
    }
}
