package data.crawler.udemy.datacrawler.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "link_udemy")
public class LinkUdemy implements Serializable,Comparable<LinkUdemy>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "url")
    private String url;

    @Column(name = "number_discount")
    private Long numberOfDiscount;

    public LinkUdemy(String url, Long numberOfDiscount) {
        this.url = url;
        this.numberOfDiscount = numberOfDiscount;
    }

    public LinkUdemy() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getNumberOfDiscount() {
        return numberOfDiscount;
    }

    public void setNumberOfDiscount(Long numberOfDiscount) {
        this.numberOfDiscount = numberOfDiscount;
    }

    @Override
    public String toString() {
        return "Udemy link............. " + this.url + " - " +this.getNumberOfDiscount();
    }

    @Override
    public int compareTo(LinkUdemy linkUdemy) {
        return this.url.compareTo(linkUdemy.getUrl());
    }
}
