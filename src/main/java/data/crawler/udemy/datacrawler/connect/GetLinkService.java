package data.crawler.udemy.datacrawler.connect;


import data.crawler.udemy.datacrawler.entity.LinkUdemy;

import java.util.*;
import java.io.IOException;
import java.util.Set;

public interface GetLinkService {

     Set<LinkUdemy> getAllLinkUdemy() throws IOException;

     int getTotal();

     LinkUdemy saveALink(LinkUdemy linkUdemy);

     List<LinkUdemy> saveAll(List<LinkUdemy> linkUdemies);

     Set<LinkUdemy> correctLink(Set<LinkUdemy> linkUdemies);
}
