/**
 * 
 */
package com.iancui.dto;

import com.iancui.entity.Appointment;
import com.iancui.enums.AppointStateEnum;

/**
 * @author S.Murata
 * @version $Id$
 * @since JDK5.0
 */
public class AppointExecution {

    // 图书ID
    private long bookId;

    // 秒杀预约结果状态
    private int state;

    // 状态标识
    private String stateInfo;

    // 预约成功对象
    private Appointment appointment;

    public AppointExecution() {
    }

    // 预约失败的构造器
    public AppointExecution(long bookId, AppointStateEnum stateEnum) {
        this.bookId = bookId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    // 预约成功的构造器
    public AppointExecution(long bookId, AppointStateEnum stateEnum,
        Appointment appointment) {
        this.bookId = bookId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.appointment = appointment;
    }

    /**
     * bookId is returned.
     * <br>
     * @return  bookId
     */
    public long getBookId() {
        return bookId;
    }

    /**
     * bookId is set up.
     * <br>
     * @param bookId long
     */
    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    /**
     * state is returned.
     * <br>
     * @return  state
     */
    public int getState() {
        return state;
    }

    /**
     * state is set up.
     * <br>
     * @param state int
     */
    public void setState(int state) {
        this.state = state;
    }

    /**
     * stateInfo is returned.
     * <br>
     * @return  stateInfo
     */
    public String getStateInfo() {
        return stateInfo;
    }

    /**
     * stateInfo is set up.
     * <br>
     * @param stateInfo String
     */
    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    /**
     * appointment is returned.
     * <br>
     * @return  appointment
     */
    public Appointment getAppointment() {
        return appointment;
    }

    /**
     * appointment is set up.
     * <br>
     * @param appointment Appointment
     */
    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

}
