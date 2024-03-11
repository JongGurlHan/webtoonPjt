package com.jghan.webtoonPjt.webtoon.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Webtoon {

    private final Long id;
    private final String title;
    private final String author;
    private final String url;
    private final String img;
    private final Platform platform;
    private final UpdateDay updateDay;
    private final int rank;
    private final IsNew isNew;
    private final IsPublish isPublish;
    private final double rating;
    private final LocalDateTime createdDate;
    private final LocalDateTime lastModifiedDate;

    @Builder
    public Webtoon(Long id, String title, String author, String url, String img, Platform platform, UpdateDay updateDay, int rank, IsNew isNew, IsPublish isPublish, double rating, LocalDateTime createdDate, LocalDateTime lastModifiedDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.url = url;
        this.img = img;
        this.platform = platform;
        this.updateDay = updateDay;
        this.rank = rank;
        this.isNew = isNew;
        this.isPublish = isPublish;
        this.rating = rating;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }

    public static Webtoon from(WebtoonCreate webtoonCreate){
        return Webtoon.builder()
                .title(webtoonCreate.getTitle())
                .author(webtoonCreate.getAuthor())
                .url(webtoonCreate.getUrl())
                .img(webtoonCreate.getImg())
                .platform(webtoonCreate.getPlatform())
                .updateDay(webtoonCreate.getUpdateDay())
                .rank(webtoonCreate.getRank())
                .isNew(webtoonCreate.getIsNew())
                .rating(webtoonCreate.getRating())
                .isPublish(webtoonCreate.getIsPublish())
                .createdDate(webtoonCreate.getCreatedDate())
                .lastModifiedDate(webtoonCreate.getLastModifiedDate())
                .build();
    }

}