package ru.otus.springhw1.service;

import ru.otus.springhw1.domain.Person;
import ru.otus.springhw1.exception.RegistrationServiceException;

import java.util.Scanner;

public class RegistrationService implements IRegistrationService {
    ICommonIOService io;
    public RegistrationService(ICommonIOService io){
        this.io = io;
    }

    public Person registerNewPerson() throws RegistrationServiceException {
        io.writeString("please enter your first name:");
        String firstName = io.readString();
        io.writeString("please enter your last name: ");
        String lastName = io.readString();
        if(firstName.isEmpty() || lastName.isEmpty())
            throw new RegistrationServiceException("Can't register new person!");

        return new Person(firstName,lastName);
    }


}
