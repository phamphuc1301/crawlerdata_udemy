package data.crawler.udemy.datacrawler;

import data.crawler.udemy.datacrawler.connect.GetLinkService;
import data.crawler.udemy.datacrawler.entity.LinkUdemy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.util.CollectionUtils;
import java.util.Set;

@SpringBootApplication
public class DatacrawlerApplication {

    public static void main(String[] args) throws Exception{
        ApplicationContext context = SpringApplication.run(DatacrawlerApplication.class, args);
        LinkUdemy linkUdemy2 = new LinkUdemy("123",123L);
        GetLinkService getLinkService = context.getBean(GetLinkService.class);
        linkUdemy2 = getLinkService.saveALink(linkUdemy2);
        Set<LinkUdemy> udemyList = getLinkService.getAllLinkUdemy();
        if(!CollectionUtils.isEmpty(udemyList)){
            for (LinkUdemy linkUdemy: udemyList) {
                System.out.println(linkUdemy);
            }
        }
    }

}
