package com.jghan.webtoonPjt.webtoon.infrastructure;

import com.jghan.webtoonPjt.webtoon.controller.request.WebtoonSearchCondition;
import com.jghan.webtoonPjt.webtoon.controller.response.QWebtoonResponse;
import com.jghan.webtoonPjt.webtoon.controller.response.WebtoonResponse;
import com.jghan.webtoonPjt.webtoon.domain.Webtoon;
import com.jghan.webtoonPjt.webtoon.service.WebtoonRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.jghan.webtoonPjt.webtoon.infrastructure.QWebtoonEntity.webtoonEntity;
import static org.springframework.util.StringUtils.hasText;

@Repository
@RequiredArgsConstructor
public class WebtoonRepositoryImpl implements WebtoonRepository, WebtoonRepositoryCustom {

    private final WebtoonJpaRepository webtoonJpaRepository;
    private final JPAQueryFactory queryFactory;

    @Override
    public Webtoon save(Webtoon webtoon) {
        return webtoonJpaRepository.save(WebtoonEntity.from(webtoon)).toModel();
    }

    @Override
    public Page<WebtoonResponse> search(WebtoonSearchCondition condition, Pageable pageable) {

        List<WebtoonResponse> content = queryFactory
                .select(new QWebtoonResponse(
                        webtoonEntity.id,
                        webtoonEntity.title,
                        webtoonEntity.author,
                        webtoonEntity.url,
                        webtoonEntity.img,
                        webtoonEntity.platform,
                        webtoonEntity.updateDay,
                        webtoonEntity.rank,
                        webtoonEntity.isNew,
                        webtoonEntity.isPublish,
                        webtoonEntity.rating,
                        webtoonEntity.createdDate,
                        webtoonEntity.lastModifiedDate
                ))
                .from(webtoonEntity)
                .where(
                        titleOrAuthorContains(condition.getKeyword())
                )
                .orderBy(webtoonEntity.title.asc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> countQuery = queryFactory
                .select(webtoonEntity.count())
                .from(webtoonEntity)
                .where(
                        titleOrAuthorContains(condition.getKeyword())
                );

        return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchOne);
    }


    private BooleanExpression titleOrAuthorContains(String keyword){
        return hasText(keyword)? webtoonEntity.title.contains(keyword).or(webtoonEntity.author.contains(keyword)) :  null;
    }
}
