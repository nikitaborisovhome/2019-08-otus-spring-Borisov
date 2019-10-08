package ru.otus.springhw2.service;

import ru.otus.springhw2.domain.Person;
import ru.otus.springhw2.exception.RegistrationServiceException;

public interface IRegistrationService {
    Person registerNewPerson()  throws RegistrationServiceException;
}
