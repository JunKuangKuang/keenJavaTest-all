package xyz.clzly.keen.process;

public class BlogHandler {
    private String blogRootPath;
    private String blogImagesRootPath;

    public String getBlogRootPath() {
        return blogRootPath;
    }

    public void setBlogRootPath(String blogRootPath) {
        this.blogRootPath = blogRootPath;
    }

    public String getBlogImagesRootPath() {
        return blogImagesRootPath;
    }

    public void setBlogImagesRootPath(String blogImagesRootPath) {
        this.blogImagesRootPath = blogImagesRootPath;
    }

    public Boolean dealImages(){
        return true;
    }
}