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
        //Always encrypt password
        User user = authRepository.getUser(credentials.get("username"), DigestUtils.md5DigestAsHex(credentials.get("password").getBytes()));

        if (user == null) {
            //user not found
            return new ResponseEntity<>(buildResponse(false, Constants.INVALID_USERNAME_OR_PASSWORD), HttpStatus.NOT_FOUND);
        } else {
            //Success, no messages are necessary
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    private ApiResponseViewModel buildResponse(boolean success, String message) {
        return new ApiResponseViewModel(success, message);
    }

}
