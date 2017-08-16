/**
 * 
 */
package com.iancui.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iancui.BaseTest;
import com.iancui.dto.AppointExecution;
import com.iancui.service.BookService;

/**
 * @author S.Murata
 * @version $Id$
 * @since JDK5.0
 */
public class BookServiceImplTest extends BaseTest {

    @Autowired
    private BookService bookService;

    @Test
    public void testAppoint() throws Exception {
        long idBook = 1002;
        long idStudent = 12345678910L;
        AppointExecution execution = bookService.appoint(idBook, idStudent);
        System.out.println(execution.toString());
    }

}
