// package com.example.demo.controller;

// import com.example.demo.dto.AuthResponse;
// import com.example.demo.dto.LoginRequest;
// import com.example.demo.model.User;
// import com.example.demo.security.JwtUtil;
// import com.example.demo.service.UserService;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.web.bind.annotation.*;

// import java.util.HashMap;
// import java.util.Map;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     private final UserService userService;
//     private final JwtUtil jwtUtil;
//     private final PasswordEncoder passwordEncoder;

//     public AuthController(
//             UserService userService,
//             JwtUtil jwtUtil,
//             PasswordEncoder passwordEncoder
//     ) {
//         this.userService = userService;
//         this.jwtUtil = jwtUtil;
//         this.passwordEncoder = passwordEncoder;
//     }

//     // ================= REGISTER =================
//     @PostMapping("/register")
//     public ResponseEntity<?> register(@RequestBody User user) {

//         User registeredUser = userService.registerUser(user);

//         Map<String, Object> response = new HashMap<>();
//         response.put("success", true);
//         response.put("id", registeredUser.getId());
//         response.put("email", registeredUser.getEmail());
//         response.put("role", registeredUser.getRole());

//         return ResponseEntity.status(HttpStatus.CREATED).body(response);
//     }

//     // ================= LOGIN =================
//     @PostMapping("/login")
//     public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {

//         User user;

//         // 1️⃣ Check email
//         try {
//             user = userService.findByEmail(loginRequest.getEmail());
//         } catch (Exception ex) {
//             return unauthorizedResponse();
//         }

//         // 2️⃣ Check password
//         if (!passwordEncoder.matches(
//                 loginRequest.getPassword(),
//                 user.getPassword())
//         ) {
//             return unauthorizedResponse();
//         }

//         // 3️⃣ Generate JWT
//         String token = jwtUtil.generateToken(
//                 user.getId(),
//                 user.getEmail(),
//                 user.getRole()
//         );

//         // 4️⃣ Build response
//         AuthResponse authResponse = new AuthResponse(
//                 token,
//                 user.getId(),
//                 user.getEmail(),
//                 user.getRole()
//         );

//         return ResponseEntity.ok(authResponse);
//     }

//     // ================= HELPER =================
//     private ResponseEntity<Map<String, Object>> unauthorizedResponse() {
//         Map<String, Object> error = new HashMap<>();
//         error.put("success", false);
//         error.put("message", "Invalid email or password");
//         error.put("status", 401);
//         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
//     }
// }





package com.example.demo.controller;

import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.model.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserService userService, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        User savedUser = userService.registerUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        User user = userService.findByEmail(loginRequest.getEmail());
        
        if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            String token = jwtUtil.generateToken(user.getEmail(), user.getRole(), user.getId());
            AuthResponse response = new AuthResponse(token, user.getId(), user.getEmail(), user.getRole());
            return ResponseEntity.ok(response);
        }
        
        throw new RuntimeException("Invalid credentials");
    }
}