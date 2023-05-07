package models.member;

import validators.Validator;

public class ServiceManager {
    public Validator joinValidator() {
        return new JoinValidator();
    }

    public JoinService getJoinService() {
        JoinService service = new JoinService();
        service.setValidator(joinValidator());

        return service;
    }
}
