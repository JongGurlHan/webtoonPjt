package com.jghan.webtoonPjt.webtoon.controller.port;

import com.jghan.webtoonPjt.webtoon.controller.request.WebtoonSearchCondition;
import com.jghan.webtoonPjt.webtoon.controller.response.WebtoonResponse;
import com.jghan.webtoonPjt.webtoon.domain.UpdateDay;
import com.jghan.webtoonPjt.webtoon.domain.Webtoon;
import com.jghan.webtoonPjt.webtoon.domain.WebtoonCreate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;

public interface WebtoonService {

    Webtoon create(String day) throws IOException, InterruptedException;

    Page<WebtoonResponse> search(WebtoonSearchCondition condition, Pageable pageable);
}
