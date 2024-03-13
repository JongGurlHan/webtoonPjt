package com.jghan.webtoonPjt.webtoon.controller.port;

import com.jghan.webtoonPjt.webtoon.domain.UpdateDay;
import com.jghan.webtoonPjt.webtoon.domain.Webtoon;
import com.jghan.webtoonPjt.webtoon.domain.WebtoonCreate;

import java.io.IOException;

public interface WebtoonService {

    Webtoon create(String day) throws IOException, InterruptedException;
}
