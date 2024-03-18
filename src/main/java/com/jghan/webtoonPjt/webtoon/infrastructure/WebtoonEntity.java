package com.jghan.webtoonPjt.webtoon.infrastructure;

import com.jghan.webtoonPjt.common.domain.BaseTimeEntity;
import com.jghan.webtoonPjt.webtoon.domain.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class WebtoonEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "webtoon_id")
    private Long id;
    private String title;
    private String author;
    private String url;
    private String img;

    @Enumerated(EnumType.STRING)
    private Platform platform;

    @Enumerated(EnumType.STRING)
    private UpdateDay updateDay;

    @Column(name = "webtoon_rank")
    private int rank;

    @Enumerated(EnumType.STRING)
    private IsNew isNew;

    @Enumerated(EnumType.STRING)
    private IsPublish isPublish;


    private double rating;

    public static WebtoonEntity from(Webtoon webtoon){
        WebtoonEntity webtoonEntity = new WebtoonEntity();
        webtoonEntity.id = webtoon.getId();
        webtoonEntity.title = webtoon.getTitle();
        webtoonEntity.author = webtoon.getAuthor();
        webtoonEntity.url = webtoon.getUrl();
        webtoonEntity.img = webtoon.getImg();
        webtoonEntity.platform = webtoon.getPlatform();
        webtoonEntity.updateDay = webtoon.getUpdateDay();
        webtoonEntity.rank = webtoon.getRank();
        webtoonEntity.isNew = webtoon.getIsNew();
        webtoonEntity.rating = webtoon.getRating();
        webtoonEntity.isPublish = webtoon.getIsPublish();
        webtoonEntity.createdDate = webtoon.getCreatedDate();
        webtoonEntity.lastModifiedDate = webtoon.getLastModifiedDate();
        return webtoonEntity;
    }

    public Webtoon toModel(){
        return Webtoon.builder()
                .id(id)
                .title(title)
                .author(author)
                .url(url)
                .img(img)
                .platform(platform)
                .updateDay(updateDay)
                .rank(rank)
                .isNew(isNew)
                .rating(rating)
                .isPublish(isPublish)
                .createdDate(createdDate)
                .lastModifiedDate(lastModifiedDate)
                .build();
    }

}

