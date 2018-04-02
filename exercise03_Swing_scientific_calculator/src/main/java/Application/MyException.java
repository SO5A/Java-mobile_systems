package Application;
import javax.swing.*;

public class MyException extends RuntimeException {
        public MyException() {
            JOptionPane.showMessageDialog(null, "Incorrect data !" ,"Exception",
                    JOptionPane.ERROR_MESSAGE);
    }
}