package com.jghan.webtoonPjt.member.controller.response.member.infrastructure;


import com.jghan.museumProject.common.domain.exception.ResourceNotFoundException;
import com.jghan.museumProject.member.domain.Member;
import com.jghan.museumProject.member.domain.MemberStatus;
import com.jghan.museumProject.member.service.port.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {

    private final MemberJpaRepository memberJpaRepository;

    @Override
    public Member getById(long id) {
        return findById(id).orElseThrow(()-> new ResourceNotFoundException("Members", id));
    }

    @Override
    public Optional<Member> findById(long id) {
        return memberJpaRepository.findById(id).map(MemberEntity::toModel); //MemberEntity 를 Member도메인 객체로 바꿔줌
    }

    @Override
    public Optional<Member> findByIdAndStatus(long id, MemberStatus memberStatus) {
        return memberJpaRepository.findByIdAndStatus(id, memberStatus).map(MemberEntity::toModel);
    }

    //Member 도메인을 MemberEntity로 변환
    //tomodel(): MemberEntity를 db에 저장한 후 결과를 다시 Member 도메인으로 번환
    @Override
    public Member save(Member member) {
        return memberJpaRepository.save(MemberEntity.from(member)).toModel();
    }
}
