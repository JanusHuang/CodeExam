package thrift.impl;

import org.apache.thrift.TException;
import thrift.idl.IndexNewsOperatorServices;
import thrift.idl.NewsModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhijing.huang
 *         Created by zhijing.huang on 2014/9/9.
 */
public class IndexNewsOperatorServicesImpl implements IndexNewsOperatorServices.Iface {
    private static Map<Integer, NewsModel> newsMap = new ConcurrentHashMap<Integer, NewsModel>();

    @Override
    public boolean indexNews(NewsModel indexNews) throws TException {
        newsMap.put(Integer.valueOf(indexNews.getId()), indexNews);
        return true;
    }

    @Override
    public boolean deleteArtificiallyNews(int id) throws TException {
        final NewsModel newsModel = newsMap.get(Integer.valueOf(id));
        if (null != newsModel) {
            newsMap.remove(newsModel);
            return true;
        } else {
            return false;
        }
    }
}
