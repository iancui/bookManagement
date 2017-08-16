package com.iancui.entity;

import java.util.Date;

public class Appointment {

    private long idBook;// 图书ID

    private long idStudent;// 学号

    private Date timeAppoint;// 预约时间

    // 多对一的复合属性
    private Book book;// 图书实体

    /**
     * idBook is returned.
     * <br>
     * @return  idBook
     */
    public long getIdBook() {
        return idBook;
    }

    /**
     * idBook is set up.
     * <br>
     * @param idBook long
     */
    public void setIdBook(long idBook) {
        this.idBook = idBook;
    }

    /**
     * idStudent is returned.
     * <br>
     * @return  idStudent
     */
    public long getIdStudent() {
        return idStudent;
    }

    /**
     * idStudent is set up.
     * <br>
     * @param idStudent long
     */
    public void setIdStudent(long idStudent) {
        this.idStudent = idStudent;
    }

    /**
     * timeAppoint is returned.
     * <br>
     * @return  timeAppoint
     */
    public Date getTimeAppoint() {
        return timeAppoint;
    }

    /**
     * timeAppoint is set up.
     * <br>
     * @param timeAppoint Date
     */
    public void setTimeAppoint(Date timeAppoint) {
        this.timeAppoint = timeAppoint;
    }

    /**
     * book is returned.
     * <br>
     * @return  book
     */
    public Book getBook() {
        return book;
    }

    /**
     * book is set up.
     * <br>
     * @param book Book
     */
    public void setBook(Book book) {
        this.book = book;
    }

    public String toString() {
        return "idBook = " + idBook + " idStudent = " + idStudent
            + " timeAppoint = " + timeAppoint;
    }

}
