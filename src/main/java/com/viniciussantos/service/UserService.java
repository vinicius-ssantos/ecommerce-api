package com.viniciussantos.service;


import com.viniciussantos.api.model.RegistrationBody;
import com.viniciussantos.exception.UserAlreadyExistsException;
import com.viniciussantos.model.LocalUser;
import com.viniciussantos.model.dao.LocalUserDAO;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

@Service
public class UserService {
    private LocalUserDAO localUserDAO;


    public UserService( LocalUserDAO localUserDAO) {
        this.localUserDAO = localUserDAO;

    }


    public LocalUser registerUser(@Valid RegistrationBody registrationBody) throws UserAlreadyExistsException {

        if (localUserDAO.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()
                || localUserDAO.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException();

        }
        LocalUser user = new LocalUser();
        user.setEmail(registrationBody.getEmail());
        user.setFirstName(registrationBody.getFirstName());
        user.setLastName(registrationBody.getLastName());
        user.setUsername(registrationBody.getUsername());
        // TODO: Criptografar senha

        user.setPassword(registrationBody.getPassword());

        return localUserDAO.save(user);
    }
}
