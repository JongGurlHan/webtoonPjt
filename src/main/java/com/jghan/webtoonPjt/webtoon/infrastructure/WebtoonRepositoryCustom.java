package com.jghan.webtoonPjt.webtoon.infrastructure;

import com.jghan.webtoonPjt.webtoon.controller.request.WebtoonSearchCondition;
import com.jghan.webtoonPjt.webtoon.controller.response.WebtoonResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface WebtoonRepositoryCustom {

    Page<WebtoonResponse> search(WebtoonSearchCondition condition, Pageable pageable);
}
