package cn.system.utils;

import java.util.List;

/**
 * 分页工具类
 */
public class Page {
    private Integer currentPage;//当前页
    private int pageSize;//每页显示记录条数
    private int totalPage;//总页数
    private List<?> dataList;//每页显示的数据
    private int star;//开始数据

    public Page(){

    }
    public Page(int page,int size,List<?> dataList){
        //设置当前界面为第一页
        this.setCurrentPage(page);
        //设置每页数据
        this.setPageSize(size);
        //每页的开始数
        this.setStar((this.getCurrentPage() - 1) * this.getPageSize());
        //list的大小
        int count = dataList.size();
        //设置总页数
        this.setTotalPage(count % size == 0 ? count / size : count / size + 1);
        //对list进行截取
        this.setDataList(dataList.subList(this.getStar(),count-this.getStar()>this.getPageSize()?this.getStar()+this.getPageSize():count));
    }
    public Integer getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getTotalPage() {
        return totalPage;
    }
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    public List<?> getDataList() {
        return dataList;
    }
    public void setDataList(List<?> dataList) {
        this.dataList = dataList;
    }
    public int getStar() {
        return star;
    }
    public void setStar(int star) {
        this.star = star;
    }
}
