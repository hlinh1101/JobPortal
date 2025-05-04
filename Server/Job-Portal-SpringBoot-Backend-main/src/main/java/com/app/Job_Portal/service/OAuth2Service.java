package com.app.Job_Portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.Job_Portal.dto.SignInResponseDto;
import com.app.Job_Portal.entities.User;
import com.app.Job_Portal.entities.JobSeeker;
import com.app.Job_Portal.repository.UserRepository;
import com.app.Job_Portal.repository.JobSeekerRepository;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class OAuth2Service {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    public SignInResponseDto processOAuthPostLogin(OAuth2User principal) {
        String email = principal.getAttribute("email");

        // Tìm user theo email
        Optional<User> existingUser = userRepository.findByEmail(email);

        User user;
        if (existingUser.isPresent()) {
            // Nếu user đã tồn tại, sử dụng thông tin hiện có
            user = existingUser.get();
        } else {
            // Nếu user chưa tồn tại, tạo mới
            user = createNewUser(principal);
        }

        // Tạo response
        SignInResponseDto response = new SignInResponseDto();
        response.setId(user.getId());
        response.setRole(user.getRole());
        response.setEmail(user.getEmail());

        return response;
    }

    private User createNewUser(OAuth2User principal) {
        User user = new User();
        user.setEmail(principal.getAttribute("email"));
        user.setRole("ROLE_JOBSEEKER");
        // Đặt một mật khẩu ngẫu nhiên cho user từ OAuth
        user.setPassword(UUID.randomUUID().toString());
        user = userRepository.save(user);

        // Tạo profile JobSeeker
        JobSeeker jobSeeker = new JobSeeker();
        jobSeeker.setEmail(user.getEmail());
        jobSeeker.setFirstName(principal.getAttribute("given_name"));
        jobSeeker.setLastName(principal.getAttribute("family_name"));
        jobSeekerRepository.save(jobSeeker);

        return user;
    }
}