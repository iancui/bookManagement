/**
 * 
 */
package com.iancui.exeception;

/**
 *  重复预约异常
 * @author S.Murata
 * @version $Id$
 * @since JDK5.0
 */
public class RepeatAppointException extends RuntimeException {

    public RepeatAppointException(String message) {
        super(message);
    }

    public RepeatAppointException(String message, Throwable cause) {
        super(message, cause);
    }

}
