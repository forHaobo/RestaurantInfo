package daomain;

import java.util.List;

/**
 * @outhor li
 * @create 2019-12-30 14:17
 */
public class PageBean<T> {
    private int totalCount; //总记录数
    private int totalPage; //总页数
    private int currentPage; //当前页码
    private int pageSize; //每页显示条数
    private List<T> list; //每页显示集合数

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}