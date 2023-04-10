package restful.demo.model;

import lombok.Data;

@Data
public class BookInfoVO {

    private int book_key;

    private String book_reg_no;

    private String book_title;

    private String book_author;

    private String book_publisher;



    public BookInfoVO(int book_key, String book_reg_no, String book_title, String book_author, String book_publisher) {
        this.book_key = book_key;
        this.book_reg_no = book_reg_no;
        this.book_title = book_title;
        this.book_author = book_author;
        this.book_publisher = book_publisher;
    }

}
