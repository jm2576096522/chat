package com.jm.chat.entiy;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 分页数据bean
 *
 * Created by HuangKai on 2017/8/29.
 */
public class PageBean
{
    /**
     * 每页记录条数
     */
    private int pageSize = 10;
    
    /**
     * 总页数
     */
    private int sumPage = 1;
    
    /**
     * 当前页数
     */
    private int currPage = 1;
    
    /**
     * 总记录数
     */
    private int countData = 0;
    
    /**
     * 查询结果集
     */
    private List result = new ArrayList(0);
    
    public int getPageSize()
    {
        return pageSize;
    }
    
    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }
    
    public int getSumPage()
    {
        return sumPage;
    }
    
    public void setSumPage(int sumPage)
    {
        this.sumPage = sumPage;
    }
    
    public int getCurrPage()
    {
        return currPage;
    }
    
    public void setCurrPage(int currPage)
    {
        this.currPage = currPage;
    }
    
    public List getResult()
    {
        return result;
    }
    
    public void setResult(List result)
    {
        this.result = result;
    }
    
    public int getCountData()
    {
        return countData;
    }
    
    public void setCountData(int countData)
    {
        this.countData = countData;
    }

}
