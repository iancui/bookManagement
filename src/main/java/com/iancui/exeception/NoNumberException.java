/**
 * 
 */
package com.iancui.exeception;

/**
 * @author S.Murata
 * @version $Id$
 * @since JDK5.0
 */
public class NoNumberException extends RuntimeException {

    public NoNumberException(String message) {
        super(message);
    }

    public NoNumberException(String message, Throwable cause) {
        super(message, cause);
    }

}
