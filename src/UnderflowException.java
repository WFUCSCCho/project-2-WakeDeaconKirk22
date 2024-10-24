/***************************************************************************
 @file: UnderflowException.java
 @description: This program implements a underflow Exception that extends to
 RuntimeException
 @author:  Kennedy Kirk
 @date  Oct 24 ,2024

 *******************************************************************************/
public class UnderflowException extends RuntimeException {
    public UnderflowException() {
        super();
    }

    public UnderflowException(String message) {
        super(message);
    }
}