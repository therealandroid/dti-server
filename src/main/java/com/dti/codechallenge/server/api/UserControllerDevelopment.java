package com.dti.codechallenge.server.api;

import com.dti.codechallenge.server.configuration.Constants;
import com.dti.codechallenge.server.viewmodel.ApiResponseViewModel;
import com.dti.codechallenge.server.viewmodel.UserViewModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * This controller returns static responses
 *
 */
@RestController
public class UserControllerDevelopment {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity login(@RequestBody Map<String, String> credentials) {
        if(credentials.get("username").equals("exemplo") && credentials.get("password").equals("exemplo")){
            return new ResponseEntity<>(buildResponse(true, Constants.RESULT_OK), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(buildResponse(false, Constants.SERVER_UNAVAILABLE), HttpStatus.OK);  //Correct status code should be HttpStatus.NOT_FOUND
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity register(@RequestBody UserViewModel userViewModel) {
        if (userViewModel.getUsername().equals("exemplo") || userViewModel.getPassword().equals("exemplo")) {
            return new ResponseEntity<>(buildResponse(true, Constants.RESULT_OK), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(buildResponse(false, Constants.SERVER_UNAVAILABLE), HttpStatus.OK);
        }
    }

    private ApiResponseViewModel buildResponse(boolean success, String message) {
        return new ApiResponseViewModel(success, message);
    }

}
