package cn.system.domain;

/**
 * 好友关系
 */
public class UserRelationShip {
    private String RelationshipUserId;
    private String RelationshipFriendId;

    @Override
    public String toString() {
        return "UserRelationShipService{" +
                "RelationshipUserId='" + RelationshipUserId + '\'' +
                ", RelationshipFriendId='" + RelationshipFriendId + '\'' +
                '}';
    }

    public String getRelationshipUserId() {
        return RelationshipUserId;
    }

    public void setRelationshipUserId(String relationshipUserId) {
        RelationshipUserId = relationshipUserId;
    }

    public String getRelationshipFriendId() {
        return RelationshipFriendId;
    }

    public void setRelationshipFriendId(String relationshipFriendId) {
        RelationshipFriendId = relationshipFriendId;
    }



}
