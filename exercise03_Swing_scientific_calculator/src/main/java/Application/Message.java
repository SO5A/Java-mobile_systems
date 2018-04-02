package Application;

import java.text.MessageFormat;
import java.util.Locale;
import org.mariuszgromada.math.mxparser.Expression;

public class Message extends MessageFormat{
        public Message() {
            super("");
        }
    Double result;
    public String msg(String formula){

            Expression expression = new Expression(formula);
            result = expression.calculate() ;

            try {
                if(Double.toString(result).equals("NaN")) {
                    throw new MyException();
            }
            else {
                    Object[] objects = {formula, result};
                    MessageFormat messageFormat = new MessageFormat("{0}\n\t = {1} \n-----------\n");
                    return messageFormat.format(objects);
                }
        } catch(MyException a) {}
          return "";
        }
    public String msgg(String formula){

        Expression expression = new Expression(formula);
        Double result = expression.calculate() ;

        try {
            if(Double.toString(result) == "NaN") {
                throw new MyException();
            }
            else {
                Object[] objects = {formula, result};

                MessageFormat messageFormat = new MessageFormat("{1}");
                messageFormat.setLocale(Locale.US);
                return messageFormat.format(objects);
            }
        } catch(MyException a) {}
        return "";
    }
}

