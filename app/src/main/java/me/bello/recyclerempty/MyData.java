package me.bello.recyclerempty;

/**
 * @Info
 * @Auth Bello
 * @Time 19-4-15 上午9:48
 * @Ver
 */
public class MyData {
    private String url;
    private String title;

    public MyData() {
    }

    public MyData(String url, String title) {
        this.url = url;
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
