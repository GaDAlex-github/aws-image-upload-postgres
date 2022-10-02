package com.example.awsimageupload.profile;

import com.example.awsimageupload.datastore.FakeUserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileDataAccessService {

    private final FakeUserProfileRepository postgresUserProfileRepository;

    @Autowired
    public UserProfileDataAccessService(FakeUserProfileRepository postgresUserProfileRepository) {
        this.postgresUserProfileRepository = postgresUserProfileRepository;
    }

    List<UserProfile> getUserProfiles(){
        return postgresUserProfileRepository.selectAllUserProfiles();
    }
}
