package ru.otus.springhw1.service;

import ru.otus.springhw1.domain.Person;
import ru.otus.springhw1.exception.RegistrationServiceException;

public interface IRegistrationService {
    Person registerNewPerson()  throws RegistrationServiceException;
}
