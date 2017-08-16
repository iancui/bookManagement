/**
 * 
 */
package com.iancui.exeception;

/**
 *  预约业务异常
 * @author S.Murata
 * @version $Id$
 * @since JDK5.0
 */
public class AppointException extends RuntimeException {

    public AppointException(String message) {
        super(message);
    }

    public AppointException(String message, Throwable cause) {
        super(message, cause);
    }

}
