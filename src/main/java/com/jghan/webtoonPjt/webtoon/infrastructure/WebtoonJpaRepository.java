package com.jghan.webtoonPjt.webtoon.infrastructure;

import com.jghan.webtoonPjt.webtoon.domain.Webtoon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebtoonJpaRepository extends JpaRepository<WebtoonEntity, Long> {
}
