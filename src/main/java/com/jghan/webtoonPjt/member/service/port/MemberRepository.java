package com.jghan.webtoonPjt.member.service.port;

import com.jghan.webtoonPjt.member.domain.Member;
import com.jghan.webtoonPjt.member.domain.MemberStatus;

import java.util.Optional;

public interface MemberRepository {

    Member getById(long id);

    Optional<Member>findById(long id);

    Optional<Member> findByIdAndStatus(long id, MemberStatus memberStatus);


    Member save(Member member);


}
