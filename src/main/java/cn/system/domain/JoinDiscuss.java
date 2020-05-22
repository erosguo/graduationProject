package cn.system.domain;

import java.io.Serializable;

/**
 * 用户与社团讨论关系
 */
public class JoinDiscuss implements Serializable {
    private String UserId;
    private int ClubDiscussId;

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public int getClubDiscussId() {
        return ClubDiscussId;
    }

    public void setClubDiscussId(int clubDiscussId) {
        ClubDiscussId = clubDiscussId;
    }

    @Override
    public String toString() {
        return "JoinDiscuss{" +
                "UserId='" + UserId + '\'' +
                ", ClubDiscussId='" + ClubDiscussId + '\'' +
                '}';
    }

}
