package paging;

public class PageRequest implements PageAble{
    private int page;
    private int size;

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public int getObset() {
        return (page -1)*size;
    }

    @Override
    public int getLimit() {
        return size;
    }

    @Override
    public int getPage() {
        return page;
    }
}
