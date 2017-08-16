/**
 * 
 */
package com.iancui.entity;

/**
 * @author S.Murata
 * @version $Id$
 * @since JDK5.0
 */
public class Book {

    private long idBook;// 图书ID

    private String nameBook;// 图书名称

    private int numberBook;// 馆藏数量

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
     * nameBook is returned.
     * <br>
     * @return  nameBook
     */
    public String getNameBook() {
        return nameBook;
    }

    /**
     * nameBook is set up.
     * <br>
     * @param nameBook String
     */
    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    /**
     * numberBook is returned.
     * <br>
     * @return  numberBook
     */
    public int getNumberBook() {
        return numberBook;
    }

    /**
     * numberBook is set up.
     * <br>
     * @param numberBook int
     */
    public void setNumberBook(int numberBook) {
        this.numberBook = numberBook;
    }

    public String toString() {
        return "idBook = " + idBook + " nameBook = " + nameBook
            + " numberBook = " + numberBook;
    }

}
