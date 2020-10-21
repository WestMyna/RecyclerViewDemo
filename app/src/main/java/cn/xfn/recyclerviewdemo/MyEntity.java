package cn.xfn.recyclerviewdemo;

public class MyEntity {

    private int imgResource;
    private String title;
    private String content;
    private boolean isClick = false;

    public MyEntity() {
    }

    public MyEntity(int imgResource, String title, String content) {
        this.imgResource = imgResource;
        this.title = title;
        this.content = content;
        this.isClick = isClick;
    }

    public int getImgResource() {
        return imgResource;
    }

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isClick() {
        return isClick;
    }

    public void setClick(boolean click) {
        isClick = click;
    }
}
