package validator;

import models.member.JoinValidationException;

public interface DuplicatedValidator {
    default void duplicatedCheck(String str, String userId, JoinValidationException e) {
        if (str.equals(userId)) {
           throw e;
        }
    }
}
