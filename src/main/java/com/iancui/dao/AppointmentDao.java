package com.iancui.dao;

import org.apache.ibatis.annotations.Param;

import com.iancui.entity.Appointment;

public interface AppointmentDao {

    /**
     * 插入预约图书记录
     * 
     * @param idBook
     * @param idStudent
     * @return 插入的行数
     */
    int insertAppointment(@Param("idBook") long idBook,
        @Param("idStudent") long idStudent);

    /**
     * 通过主键查询预约图书记录，并且携带图书实体
     * 
     * @param bookId
     * @param studentId
     * @return
     */
    Appointment queryByKeyWithBook(@Param("idBook") long idBook,
        @Param("idStudent") long idStudent);

}
