package com.jghan.webtoonPjt.member.infrastructure;

import com.jghan.museumProject.common.domain.BaseTimeEntity;
import com.jghan.museumProject.member.domain.Member;
import com.jghan.museumProject.member.domain.MemberRole;
import com.jghan.museumProject.member.domain.MemberStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class MemberEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "email_rcv")
    private String emailRcv;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "certification_code")
    private String certificationCode;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private MemberRole role;

    @Column(name = "lastLoginTime")
    private LocalDateTime lastLoginTime;

    private int loginCount;

    @Column(name = "last_login_at")
    private Long lastLoginAt;
    
    public static MemberEntity from (Member member){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.id = member.getId();
        memberEntity.email = member.getEmail();
        memberEntity.emailRcv = member.getEmailRcv();
        memberEntity.nickname = member.getNickname();
        memberEntity.mobile = member.getMobile();
        memberEntity.status = MemberStatus.ACTIVE;
        memberEntity.role = MemberRole.USER;
        memberEntity.loginCount = 0;
        return memberEntity;
    }

    public Member toModel() {
        return Member.builder()
                .id(id)
                .email(email)
                .email(emailRcv)
                .nickname(nickname)
                .mobile(mobile)
                .status(status)
                .role(role)
                .loginCount(loginCount)
                .build();
    }

    
    

}
