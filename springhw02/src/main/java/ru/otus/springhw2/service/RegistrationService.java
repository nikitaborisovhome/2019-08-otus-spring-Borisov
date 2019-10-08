package ru.otus.springhw2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.springhw2.domain.Person;
import ru.otus.springhw2.exception.RegistrationServiceException;
import ru.otus.springhw2.utils.ICustomLocaleManager;

@Service
public class RegistrationService implements IRegistrationService {
    private final ICommonIOService io;
    private final ICustomLocaleManager localeManager;

    @Autowired
    public RegistrationService(ICommonIOService io, ICustomLocaleManager localeManager){
        this.io = io;
        this.localeManager = localeManager;
    }

    public Person registerNewPerson() throws RegistrationServiceException {
        localeManager.askName();
        String firstName = io.readString();
        localeManager.askSureName();
        String lastName = io.readString();
        if(firstName.isEmpty() || lastName.isEmpty())
            throw new RegistrationServiceException("Can't register new person!");

        return new Person(firstName,lastName);
    }


}
