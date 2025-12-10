package assignment5.E1.aaa;

import java.util.Arrays;
// import assignment5.E1.aaa.Interface.INews;
import aaa.Interface.INews;
public class News implements INews {
    private int ID;
    private String Title;
    private String PublishDate;
    private String Author;
    private String Content;
    private float AverageRate;

    private int[] Rates = new int[3];

    public News() {
    }

    public int getID(){
        return ID;
    }
    public void setID(int ID){
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }
    public void setTitle(String title) {
        Title = title;
    }


    public String getPublishDate() {
        return PublishDate;
    }
    public void setPublishDate(String publishDate){ 
        PublishDate = publishDate;
    }
    public String getAuthor() {
        return Author;
    }
    public void setAuthor(String author) {
        Author = author;
    }

    public String getContent() {
        return Content;
    }
    public void setContent(String content){
        Content = content;
    }

    public float getAverageRate() {
        return AverageRate;
    }
    public void setRates(int[] rates) {
        if (rates.length == 3) {
            this.Rates = rates;
        } else {
            System.err.println("Rate phai co 3 phan tu");
        }
    }

    @Override
    public void Display() {
        System.out.println("ID: " + this.ID);
        System.out.println("Tiêu đề: " + this.Title);
        System.out.println("Ngày xuất bản: " + this.PublishDate);
        System.out.println("Tác giả: " + this.Author);
        System.out.println("Nội dung: " + this.Content);
        System.out.println("Đánh giá TB: " + this.AverageRate);
    }

    // @Override
    public float Calculate() {
        if (Rates != null && Rates.length == 3) {
            float sum = 0;
            for (int rate : Rates) {
                sum += rate;
            }
            this.AverageRate = sum / Rates.length;
        } else {
            this.AverageRate = 0.0f;
        }
        return this.AverageRate;
    }
}