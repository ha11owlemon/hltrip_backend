package com.hall.Bean;

public class CommentsWithBLOBs extends Comments {
    private String commentcontent;

    private String landlordreply;

    public String getCommentcontent() {
        return commentcontent;
    }

    public void setCommentcontent(String commentcontent) {
        this.commentcontent = commentcontent == null ? null : commentcontent.trim();
    }

    public String getLandlordreply() {
        return landlordreply;
    }

    public void setLandlordreply(String landlordreply) {
        this.landlordreply = landlordreply == null ? null : landlordreply.trim();
    }
}