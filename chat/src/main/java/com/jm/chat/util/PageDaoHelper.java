package com.jm.chat.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jm.chat.entiy.BaseBean;
import com.jm.chat.entiy.PageBean;



/**
 * 分页工具类
 *
 * Created by HuangKai on 2017/8/29.
 */
public class PageDaoHelper
{
    /**
     * 查询分页工具方法
     * 根据传入的实现类和相关参数，对数据进行分页处理
     * 
     * @param baseDao DAO
     * @param paramMap 参数
     * @param currPage 页码
     * @param pageSize 每页条数
     * @return 分页对象
     */
    public  static PageBean search(final BaseDao baseDao,
                                   final Map<String, Object> paramMap, int currPage, int pageSize)
    {
        int mapSize = 2;
        if (paramMap != null)
        {
            mapSize += paramMap.size();
        }
        // 创建一个新的参数map
        final Map<String, Object> tempMap = new HashMap<String, Object>(mapSize);
        tempMap.putAll(paramMap);

        PageBean pageBean = new PageBean();
        // 如果要查询的对象不存在，直接返回pageBean
        if (baseDao == null)
        {
            return pageBean;
        }
        
        // 获取总记录条数
        int count = baseDao.count(tempMap);
        if (count == 0)
        {
            return pageBean;
        }
        pageBean.setCountData(count);
        // 设置页面大小
        pageBean.setPageSize(pageSize);
        // 计算总页数
        int sumPage = count / pageSize;
        if (count % pageSize > 0)
        {
            sumPage = sumPage + 1;
        }
        // 如果当前页比总页数大，则设置为最大页
        if (currPage > sumPage)
        {
            currPage = sumPage;
        }
        // 设置当前页和总页数
        pageBean.setCurrPage(currPage);
        pageBean.setSumPage(sumPage);
        
        // 设置起止查询记录条数位置
        tempMap.put("OFFSET", (currPage - 1) * pageSize);
        
        tempMap.put("LIMIT", pageSize);
        // 根据条件和分页数据起止位置查询数据
        List<BaseBean> result = baseDao.list(tempMap);
        pageBean.setResult(result);
        return pageBean;
    }
    
    
   
}
