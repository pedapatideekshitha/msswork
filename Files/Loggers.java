// import java.util.logging.Logger;
// import java.util.logging.Level;

// public class Loggers {
//      private static final Logger logger = Logger.getLogger(Loggers.class.getName());

//     public static void main(String[] args) {
//          logger.log(Level.INFO, "This is an info message.");

//          logger.log(Level.WARNING, "This is a warning message.");

//          logger.log(Level.SEVERE, "This is a severe message.");

//          String user = "Alice";
//         int age = 30;
//         logger.log(Level.INFO, "User {0} is {1} years old.", new Object[]{user, age});
//     }
// }

import java.util.logging.*;

public class Loggers {
private static final Logger l= Logger.getLogger(Loggers.class.getName());
    public static void main(String[] args) {
        l.log(Level.ALL, "infooo");
        l.log(Level.INFO, "infooo");
        l.log(Level.WARNING, "infooo");
        l.log(Level.FINE, "infooo");

    }
}