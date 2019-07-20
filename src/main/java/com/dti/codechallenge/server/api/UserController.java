package com.dti.codechallenge.server.api;

import com.dti.codechallenge.server.configuration.Constants;
import com.dti.codechallenge.server.entities.User;
import com.dti.codechallenge.server.mapper.UserMapper;
import com.dti.codechallenge.server.repository.AuthRepository;
import com.dti.codechallenge.server.repository.UserRepository;
import com.dti.codechallenge.server.viewmodel.ApiResponseViewModel;
import com.dti.codechallenge.server.viewmodel.UserViewModel;
import org.aspectj.apache.bcel.classfile.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//We do not need to versioning login
@RestController
public class UserController {

    @Autowired
    AuthRepository authRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity login(@RequestBody Map<String, String> credentials) {
        User user = authRepository.getUser(credentials.get("username"), DigestUtils.md5DigestAsHex(credentials.get("password").getBytes()));

        if (user == null) {
            //user not found
            return new ResponseEntity<>(buildResponse(false, Constants.INVALID_USERNAME_OR_PASSWORD), HttpStatus.NOT_FOUND);
        } else {
            //Success, no messages are necessary
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity register(@RequestBody UserViewModel userViewModel) {
        User user = userRepository.findByUsername(userViewModel.getUsername());

        if (user != null && user.getUsername().equals(userViewModel.getUsername())) {
            //RFC 409
            return new ResponseEntity<>(buildResponse(false, Constants.USERNAME_ALREADY_TAKEN), HttpStatus.CONFLICT);
        } else {
            UserMapper userMapper = new UserMapper();
            User userEntity = userMapper.toEntity(userViewModel);

            try {
                //Simple password encryption
                userEntity.setPassword(DigestUtils.md5DigestAsHex(userViewModel.getPassword().getBytes()));
                User savedUser = userRepository.save(userEntity);

                if (savedUser == null) {
                    return new ResponseEntity<>(buildResponse(false, Constants.SERVER_UNAVAILABLE), HttpStatus.INTERNAL_SERVER_ERROR);
                } else {
                    return new ResponseEntity<>(buildResponse(true, Constants.RESULT_OK), HttpStatus.OK);
                }
            } catch (org.springframework.transaction.TransactionSystemException ex) {
                //Throws database validation exception to ensure all parameters are correct
                return new ResponseEntity<>(buildResponse(false, ex.getCause().getCause().toString()), HttpStatus.BAD_REQUEST);
            }

        }
    }

    private ApiResponseViewModel buildResponse(boolean success, String message) {
        return new ApiResponseViewModel(success, message);
    }

}
