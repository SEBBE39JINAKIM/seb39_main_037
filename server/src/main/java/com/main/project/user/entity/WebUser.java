package com.main.project.user.entity;

import com.main.project.badge.UserBadge;
import com.main.project.comment.entity.Comment;
import com.main.project.review.entity.Review;
import com.main.project.thumbUp.entity.ThumbUp;
import com.main.project.location.Location;
import com.main.project.qna.QnA;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;

import java.util.ArrayList;
import java.util.List;

import static com.main.project.user.entity.WebUser.authority.REGULAR_USER;

@NoArgsConstructor
@Setter
@Entity
@Getter
@Table(name = "webUser")
public class WebUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column
    private String userName;
    @Column
    private String nickName;

    @Column
    @Email
    private String email;

    @Column
    private String password;

    @Column
    private Enum<WebUser.authority> authority = REGULAR_USER;

    @Column
    byte profileImg;

    @Column
    String profileImgName;
/////

    boolean isUserActive;//유저 데이터 바로 삭제하는 대신 비활성화 -> 일정 기간 지난 후 삭제(1~2년)

    double userLevel = 1.0d;// 유저 활동에 따른 레벨업

////


//    @ManyToOne
//    @JoinColumn(name = "location_Id")
//    private Location location;

    @OneToMany(mappedBy = "webUser", cascade = CascadeType.ALL)
    private List<UserBadge> userBadges = new ArrayList<>();

    @OneToMany(mappedBy = "webUser", cascade = CascadeType.ALL)
    private List<ThumbUp> thumbUps = new ArrayList<>();

    @OneToMany(mappedBy = "qnaUser", cascade = CascadeType.ALL)
    private List<QnA> userQnAs = new ArrayList<>();

    @OneToMany(mappedBy = "webUser", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    public enum authority {

        REGULAR_USER("일반 계정"),
        ADMIN_USER("관리자 게정");


        @Getter
        private final String authority;


        authority(String authority) {
            this.authority =authority;
        }
    }

    @OneToMany(mappedBy = "webUser", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();



}
