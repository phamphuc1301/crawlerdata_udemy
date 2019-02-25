package data.crawler.udemy.datacrawler;

import data.crawler.udemy.datacrawler.connect.GetLinkService;
import data.crawler.udemy.datacrawler.entity.LinkUdemy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Set;

@SpringBootApplication
public class DatacrawlerApplication {

    @Autowired
    private GetLinkService getLinkService2;

    public static void main(String[] args) throws Exception{
        ApplicationContext context = SpringApplication.run(DatacrawlerApplication.class, args);
        GetLinkService getLinkService = context.getBean(GetLinkService.class);
        Set<LinkUdemy> udemyList = getLinkService.getAllLinkUdemy();
        if(!CollectionUtils.isEmpty(udemyList)){
            for (LinkUdemy linkUdemy: udemyList) {
                System.out.println(linkUdemy);
            }
        }
        getLinkService.saveAll(new ArrayList<>(udemyList));
    }

}
