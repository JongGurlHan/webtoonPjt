package com.jghan.webtoonPjt.member.controller.response.member.controller.port;

import com.jghan.museumProject.member.domain.Member;
import com.jghan.museumProject.member.domain.MemberCreate;
import com.jghan.museumProject.member.domain.MemberUpdate;

public interface MemberService {

    Member getById(long id);

    Member create(MemberCreate memberCreate);

    Member update(long id, MemberUpdate memberUpdate);
}
