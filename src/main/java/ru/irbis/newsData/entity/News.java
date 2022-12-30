package ru.irbis.newsData.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "topic_id", insertable = false, updatable = false)
    private Topic topic;

    @Column(name = "topic_id")
    private Long topicId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "source_id", insertable = false, updatable = false)
    private Source source;

    @Column(name = "source_id")
    private Long sourceId;
}
