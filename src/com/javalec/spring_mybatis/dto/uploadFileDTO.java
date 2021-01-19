package com.javalec.spring_mybatis.dto;

public class uploadFileDTO {
    private int file_num;
    private String o_name;
    private String file_name;
    private long file_size;
    private int article_num;
 
    public int getFile_num() {
        return file_num;
    }
 
    public void setFile_num(int file_num) {
        this.file_num = file_num;
    }
 
    public String getO_name() {
        return o_name;
    }
 
    public void setO_name(String o_name) {
        this.o_name = o_name;
    }
 
    public String getFile_name() {
        return file_name;
    }
 
    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }
 
    public long getFile_size() {
        return file_size;
    }
 
    public void setFile_size(long file_size) {
        this.file_size = file_size;
    }
 
    public int getArticle_num() {
        return article_num;
    }
 
    public void setArticle_num(int article_num) {
        this.article_num = article_num;
    }
}
