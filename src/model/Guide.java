package model;
import java.awt.*;
import java.util.Date;

public class Guide {

    private int guideId;
    private String title;
    private Image pic;
    private String description;
    private String username;
    private Date datetime;
    private int rating;
    private int views;
    private int nbrofratings;

    private String category;

    private String type;

    public Guide(String title, Image pic, String type, String description) {
        this.title = title;
        this.pic = pic;
        this.type = type;
        this.description = description;
    }

    public Guide(String title, String type, String description) {
        this.title = title;
        this.type = type;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Image getPic() {
        return pic;
    }

    public void setPic(Image pic) {
        this.pic = pic;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
