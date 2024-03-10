package com.jghan.webtoonPjt.webtoon.infrastructure;

import com.jghan.webtoonPjt.common.domain.BaseTimeEntity;
import com.jghan.webtoonPjt.member.domain.Member;
import com.jghan.webtoonPjt.member.infrastructure.MemberEntity;
import com.jghan.webtoonPjt.webtoon.domain.IsNew;
import com.jghan.webtoonPjt.webtoon.domain.Platform;
import com.jghan.webtoonPjt.webtoon.domain.UpdateDay;
import com.jghan.webtoonPjt.webtoon.domain.Webtoon;
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
    private Platform platform;

    private UpdateDay updateDay;

    private int rank;

    private IsNew isNew;

    private double rating;

    public static WebtoonEntity from(Webtoon webtoon){
        WebtoonEntity webtoonEntity = new WebtoonEntity();
        webtoonEntity.id = webtoon.getId();
        webtoonEntity.title = webtoon.getTitle();
        webtoonEntity.author = webtoon.getAuthor();
        webtoonEntity.url = webtoon.getAuthor();
        webtoonEntity.img = webtoon.getImg();
        webtoonEntity.platform = webtoon.getPlatform();
        webtoonEntity.updateDay = webtoon.getUpdateDay();
        webtoonEntity.rank = webtoon.getRank();
        webtoonEntity.isNew = webtoon.getIsNew();
        webtoonEntity.rating = webtoon.getRating();
        webtoonEntity.createdDate = webtoon.getCreatedDate();
        webtoonEntity.lastModifiedDate = webtoon.getLastModifiedDate();
        return webtoonEntity;
    }

}