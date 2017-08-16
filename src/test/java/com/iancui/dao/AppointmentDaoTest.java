package com.iancui.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iancui.BaseTest;
import com.iancui.entity.Appointment;

public class AppointmentDaoTest extends BaseTest {

    @Autowired
    private AppointmentDao appointmentDao;

    @Test
    public void testInsertAppointment() throws Exception {
        long bookId = 1000;
        long studentId = 12345678910L;
        int insert = appointmentDao.insertAppointment(bookId, studentId);
        System.out.println("insert=" + insert);
    }

    @Test
    public void testQueryByKeyWithBook() throws Exception {
        long idBook = 1000;
        long idStudent = 12345678910L;
        Appointment appointment =
            appointmentDao.queryByKeyWithBook(idBook, idStudent);
        System.out.println(appointment);
        System.out.println(appointment.getBook());
    }

}
