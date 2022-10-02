package com.example.awsimageupload.datastore;

import com.example.awsimageupload.profile.UserProfile;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface UserProfileRepository {

    //int insertUserProfile(UUID id,UserProfile userProfile);

//    default int insertUserProfile(UserProfile userProfile) {
//        UUID id = UUID.randomUUID();
//        return insertUserProfile(id, userProfile);
//    }

    List<UserProfile> selectAllUserProfiles();

    Optional<UserProfile> selectUserProfileById(UUID id);

    int deleteUserProfileById(UUID id);
    int updateUserProfileById(UUID id, UserProfile userProfile);
}

