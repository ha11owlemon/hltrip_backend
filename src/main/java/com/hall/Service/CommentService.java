package com.hall.Service;

import com.hall.Bean.CommentsWithBLOBs;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

public interface CommentService {
    boolean isComment(String ordernum);


    int toComment(String content,
                  int uid,
                  boolean hasImage,
                  int hid,
                  int lid,
                  double r1,
                  double r2,
                  double r3,
                  double r4,
                  double r5,
                  double rating,
                  String uname,
                  int oid
    );

    void insertImages(List<String> urls, int commentid, int uid);

    List<CommentsWithBLOBs> queryNeedReply(int lid);

    void replyComment(int cid, String reply);

    void updateUname(int uid, String name);

    @Transactional
    HashMap<String, Object> getSingalComment(int cid);

    double getNewRating(int hid);
}
