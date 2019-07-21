package com.dti.codechallenge.server.api;
//
//import com.dti.codechallenge.server.configuration.Constants;
//import com.dti.codechallenge.server.entities.User;
//import com.dti.codechallenge.server.mapper.UserMapper;
//import com.dti.codechallenge.server.repository.AuthRepository;
//import com.dti.codechallenge.server.repository.UserRepository;
//import com.dti.codechallenge.server.viewmodel.ApiResponseViewModel;
//import com.dti.codechallenge.server.viewmodel.UserViewModel;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.util.DigestUtils;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Map;

/**
 * README
 *
 * This class is fully commented due to exercise ask for static response.
 *
 * If you want to use a database approach uncomment this class and follow the server docs.
 *
 */
//@RestController
//public class UserControllerProduction {
//
//    @Autowired
//    AuthRepository authRepository;
//
//    @Autowired
//    UserRepository userRepository;
//
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    @ResponseBody
//    public ResponseEntity login(@RequestBody Map<String, String> credentials) {
//        User user = authRepository.getUser(credentials.get("username"), DigestUtils.md5DigestAsHex(credentials.get("password").getBytes()));
//
//        if (user == null) {
//            //user not found
//            return new ResponseEntity<>(buildResponse(false, Constants.INVALID_USERNAME_OR_PASSWORD), HttpStatus.OK);  //Correct status code should be HttpStatus.NOT_FOUND
//        } else {
//            //Success, no messages are necessary
//            return new ResponseEntity<>(buildResponse(true, Constants.RESULT_OK), HttpStatus.OK);
//        }
//    }
//
//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    @ResponseBody
//    public ResponseEntity register(@RequestBody UserViewModel userViewModel) {
//        if (userViewModel.getUsername().isEmpty() || userViewModel.getPassword().isEmpty()) {
//            return new ResponseEntity<>(buildResponse(false, Constants.INVALID_PARAMETERS), HttpStatus.OK);
//        }
//
//        User user = userRepository.findByUsername(userViewModel.getUsername());//Search for an user to check if exists
//
//        //If we got user == null this user doesn't exists in the DB
//        if (user != null) {
//            //RFC 409
//            return new ResponseEntity<>(buildResponse(false, Constants.USERNAME_ALREADY_TAKEN), HttpStatus.OK); //Correct value should be HttpStatus.CONFLICT
//        } else {
//            UserMapper userMapper = new UserMapper();
//            User userEntity = userMapper.toEntity(userViewModel);
//
//            try {
//                //Simple password encryption
//                userEntity.setPassword(DigestUtils.md5DigestAsHex(userViewModel.getPassword().getBytes()));
//                User savedUser = userRepository.save(userEntity);
//
//                if (savedUser == null) {
//                    return new ResponseEntity<>(buildResponse(false, Constants.SERVER_UNAVAILABLE), HttpStatus.OK); // Correct value should be HttpStatus.INTERNAL_SERVER_ERROR
//                } else {
//                    return new ResponseEntity<>(buildResponse(true, Constants.RESULT_OK), HttpStatus.OK);
//                }
//            } catch (org.springframework.transaction.TransactionSystemException ex) {
//                //Throws database validation exception to ensure all parameters are correct
//                //Shows the sample response
//                //print log for debug purpose
//                System.out.println(ex.getCause().getCause().toString());
//                return new ResponseEntity<>(buildResponse(false, Constants.SERVER_UNAVAILABLE), HttpStatus.OK);// Correct value should be HttpStatus.BAD_REQUEST
//            }
//        }
//    }
//
//    private ApiResponseViewModel buildResponse(boolean success, String message) {
//        return new ApiResponseViewModel(success, message);
//    }

//}
