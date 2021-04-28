package model;
import java.awt.*;
import java.io.File;

/**
 * @author Philip Persson
 * @author Alexander Olsson
 * @author
 * @version 1.0
 */
public class Guide {

    private Image pic;
    private String description,category,type,author,title;
    private File[] files;


    public Guide(){ //TODO KOMMENTERA DENNA KLASSEN
    }

    public Guide(String title,String description,String author, File[] files) {
        this.title = title;
        this.files = files;
        this.author = author;
        this.description = description;
    }

    public Guide(String title,String description,String author, File[] files, String type ) {
        this.title = title;
        this.files = files;
        this.type = type;
        this.author = author;
        this.description = description;
    }

    /**
     * Konstruktor för att skapa en guide.
     * @param title
     * @param description
     * @param author
     */

    public Guide(String title, String description, String author, String type, String category) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.type = type;
        this.category = category;
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

    public String getCategory(){
        return category;
    }

    public void setCategory(String category){
        this.category = category;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
