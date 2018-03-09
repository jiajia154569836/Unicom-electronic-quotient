package com.jiajia.backend.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BookDto implements Serializable {
 private Integer bookId;
 private String bookName;
 private String bookPrice;
 private Date bookTime;
 private String sex;
}
