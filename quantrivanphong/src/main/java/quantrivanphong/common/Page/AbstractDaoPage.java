package quantrivanphong.common.Page;

import java.util.ArrayList;
import java.util.List;

public class AbstractDaoPage<T> {
    private List<T> lstResult = new ArrayList<T>();
    //    Số page đang đứng
    private int page;
    //    Tổng sô page trong 1 item
    private Integer maxPageItem;
    //    Tổng số page hiện tại
    private int totalPage;
    //    Tổng số item
    private int totalItem;

    private int Count;

    public List<T> getLstResult() {
        return lstResult;
    }

    public void setLstResult(List<T> lstResult) {
        this.lstResult = lstResult;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public Integer getMaxPageItem() {
        return maxPageItem;
    }

    public void setMaxPageItem(Integer maxPageItem) {
        this.maxPageItem = maxPageItem;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(int totalItem) {
        this.totalItem = totalItem;
    }

    public int getCount() {
        return (lstResult!=null)?lstResult.size():0;
    }
}
