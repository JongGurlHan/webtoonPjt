package com.jghan.webtoonPjt.webtoon.infrastructure;

import com.jghan.webtoonPjt.webtoon.domain.Webtoon;
import com.jghan.webtoonPjt.webtoon.service.WebtoonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class WebtoonRepositoryImpl implements WebtoonRepository {

    private final WebtoonJpaRepository webtoonJpaRepository;

    @Override
    public Webtoon save(Webtoon webtoon) {
        return webtoonJpaRepository.save(WebtoonEntity.from(webtoon)).toModel();
    }
}
