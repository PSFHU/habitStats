package pte.mik.habitstatsserver.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TryCatchService {
    public interface passInterface {
        public void passMethod();
    }

    public static String tryFunction(passInterface runMethod) {
        try {
            runMethod.passMethod();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
        return "Done!";
    }
}
