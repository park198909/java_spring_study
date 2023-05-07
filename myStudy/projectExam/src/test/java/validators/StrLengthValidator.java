package validators;

public interface StrLengthValidator {
   default void strLengthCheck(String str, int min, int max, RuntimeException e) {
        if(str.length() < min || (max>0 && str.length() > max)) {
            throw e;
            }
        }
  default void strLengthCheck(String str, int min, RuntimeException e) {
        strLengthCheck(str,min,0,e);
   }
}
