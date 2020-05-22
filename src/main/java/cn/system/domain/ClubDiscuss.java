package cn.system.domain;

import java.io.Serializable;

/**
 * 社团讨论
 */
public class ClubDiscuss implements Serializable {
    private int ClubDiscussId;
    private int ClubId;
    private String ClubDiscussName;
    private String ClubDiscussContent;
    private int ClubDiscussClickNumber;
    private String ClubDiscussComment;

    public int getClubDiscussId() {
        return ClubDiscussId;
    }

    public void setClubDiscussId(int clubDiscussId) {
        ClubDiscussId = clubDiscussId;
    }

    public int getClubId() {
        return ClubId;
    }

    public void setClubId(int clubId) {
        ClubId = clubId;
    }

    public String getClubDiscussName() {
        return ClubDiscussName;
    }

    public void setClubDiscussName(String clubDiscussName) {
        ClubDiscussName = clubDiscussName;
    }

    public String getClubDiscussContent() {
        return ClubDiscussContent;
    }

    public void setClubDiscussContent(String clubDiscussContent) {
        ClubDiscussContent = clubDiscussContent;
    }

    public int getClubDiscussClickNumber() {
        return ClubDiscussClickNumber;
    }

    public void setClubDiscussClickNumber(int clubDiscussClickNumber) {
        ClubDiscussClickNumber = clubDiscussClickNumber;
    }

    public String getClubDiscussComment() {
        return ClubDiscussComment;
    }

    public void setClubDiscussComment(String clubDiscussComment) {
        ClubDiscussComment = clubDiscussComment;
    }



    @Override
    public String toString() {
        return "ClubDiscuss{" +
                "ClubDiscussId=" + ClubDiscussId +
                ", ClubId=" + ClubId +
                ", ClubDiscussName='" + ClubDiscussName + '\'' +
                ", ClubDiscussContent='" + ClubDiscussContent + '\'' +
                ", ClubDiscussClickNumber=" + ClubDiscussClickNumber +
                ", ClubDiscussComment=" + ClubDiscussComment +
                '}';
    }

}
