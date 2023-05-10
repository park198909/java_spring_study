package validators;

public interface EmailFormValidator {
    default void emailFormCheck(String str, RuntimeException e) {
        int cnt = 0;
        for (int i=0; i < str.length(); i++) {
            if(str.substring(i,i+1).contains("@")) {
                cnt++;
            }
        }
        if (cnt != 1) {
            cnt = 0;
           throw e;
        }
    }
}
