/**
 * created by cuhp on 23/02/2019
 * no more runing, no more hidding
 */
package data.crawler.udemy.datacrawler.connect.impl;

import data.crawler.udemy.datacrawler.connect.GetLinkService;
import data.crawler.udemy.datacrawler.entity.LinkUdemy;
import data.crawler.udemy.datacrawler.repository.LinkUdemyRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

@Service
@Transactional
public class GetLinkServiceImpl implements GetLinkService {

    @Value("${source_crawler}")
    private String sourceUrl;

    @Autowired
    private LinkUdemyRepository linkUdemyRepository;

    @Override
    public int getTotal() {
        try {
        Document document = Jsoup.connect(sourceUrl).userAgent("Mozilla").timeout(50000).get();
        Elements elements = document.select("span.total");
        if(CollectionUtils.isEmpty(elements)) {
            return 0;
        }
        String elementTotal = elements.get(0).text();
        String[] elementTotalArray = elementTotal.split(" ");
        String stringTotal = elementTotalArray[elementTotalArray.length-1];

        int total = Integer.parseInt(stringTotal);
        return total;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    @Override
    public Set<LinkUdemy> getAllLinkUdemy() throws IOException {
        int total = getTotal();
        if(total <= 0) {
            return null;
        }
        Set<LinkUdemy> linkUdemys = new TreeSet<>();
        LinkUdemy linkUdemy = null;

        for (int i = 0; i <= 10 ; i++) {
            String url = sourceUrl+i;
            System.out.println("Starting get value from "+url +" .......................");
            Document document = Jsoup.connect(url).userAgent("Mozilla").timeout(50000).get();
            Elements elements = document.getElementsByClass("type-coupon");
            if(!CollectionUtils.isEmpty(elements)) {
                for (Element element: elements) {
                    String link = element.select(".entry-title a").attr("href");
                    String numberOfDiscountString = element.select(".percent").text();
                    numberOfDiscountString = numberOfDiscountString.replace("%","");
                    Long numberOfDiscount = 0L;
                    try {
                        numberOfDiscount = Long.parseLong(numberOfDiscountString);
                    } catch (NumberFormatException ex) {
                        ex.printStackTrace();
                    }
                    linkUdemy = new LinkUdemy(link,numberOfDiscount);
                    linkUdemys.add(linkUdemy);
                }
            }
        }
        return linkUdemys;
    }

    @Override
    public LinkUdemy saveALink(LinkUdemy linkUdemy) {
        LinkUdemy linkUdemyResult = linkUdemyRepository.save(linkUdemy);
        return linkUdemyRepository.save(linkUdemy);
    }
}
