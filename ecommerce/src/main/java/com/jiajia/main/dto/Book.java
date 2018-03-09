package com.jiajia.main.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Book implements Serializable {
 private String bookId;
 private String bookName;
 private String bookPrice;
 private Date bookTime;
}
