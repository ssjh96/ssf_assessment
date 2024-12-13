package vttp.batch5.ssf.noticeboard.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Notice {

    @NotEmpty(message = "Title is required")
    @Size(min = 3, max = 128, message = "Title must be between 3 to 128 characters.")
    private String title;

    @Email(message = "Must be a valid email.")
    @NotEmpty(message = "Poster is required.")
    private String poster;
    
    @Future(message = "Post date must be a future date")
    @NotNull(message = "You must set your posting date.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date postDate;

    @NotEmpty(message = "Must include at least 1 category.")
    private List<String> categories;

    @NotEmpty(message = "You must input your notice.")
    private String text;

    public Notice() {
    }

    public Notice(String title, String poster, Date postDate, List<String> categories, String text) {
        this.title = title;
        this.poster = poster;
        this.postDate = postDate;
        this.categories = categories;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return title + "," + poster + "," + postDate + "," + categories
                + "," + text;
    }

    


}
