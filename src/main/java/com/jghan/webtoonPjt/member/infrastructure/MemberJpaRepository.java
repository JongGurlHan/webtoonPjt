package com.jghan.webtoonPjt.member.infrastructure;

import com.jghan.webtoonPjt.member.domain.MemberStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberJpaRepository extends JpaRepository<MemberEntity, Long> {

    Optional<MemberEntity> findByIdAndStatus(long id, MemberStatus userStatus);

}
