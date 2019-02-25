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

    @Column
    private String nameCourses;

    @Column(name = "url")
    private String url;

    @Column(name = "number_discount")
    private Long numberOfDiscount;

    @Column(name = "is_enroll")
    private Boolean isEnroll;

    public LinkUdemy(String url, Long numberOfDiscount, String nameCourses) {
        this.url = url;
        this.numberOfDiscount = numberOfDiscount;
        this.isEnroll = false;
        this.nameCourses =  nameCourses;
    }

    public LinkUdemy() {
    }

    public String getNameCourses() {
        return nameCourses;
    }

    public void setNameCourses(String nameCourses) {
        this.nameCourses = nameCourses;
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

    public Boolean getEnroll() {
        return isEnroll;
    }

    public void setEnroll(Boolean enroll) {
        isEnroll = enroll;
    }
}
