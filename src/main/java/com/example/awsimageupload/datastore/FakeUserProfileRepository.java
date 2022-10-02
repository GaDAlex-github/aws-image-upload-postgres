package com.example.awsimageupload.datastore;


import com.example.awsimageupload.profile.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository("fakeDao")
public class FakeUserProfileRepository implements UserProfileRepository {

    private static final List<UserProfile> USER_PROFILES = new ArrayList<>();

    static {
        USER_PROFILES.add(new UserProfile(UUID.fromString("2aeb885d-8630-4880-b4a3-e83aaa8f6a80"), "janetjones", "janetjones.jpg-2448ace4-3500-43df-8aea-d1f4b47c11eb"));
        USER_PROFILES.add(new UserProfile(UUID.fromString("9e54dfd9-2901-41c1-9c6d-799d21df0a84"), "antoniojunior", "antoniojunior.jpg-08a3d5f9-567d-44e2-8864-72a090a305d6"));
    }

//    private static List<UserProfile> DB = new ArrayList<>();

//    @Override
//    public int insertUserProfile(UUID id, UserProfile userProfile) {
//        DB.add(new UserProfile(id, userProfile.getUsername(),userProfile
//                .getUserProfileImageLink()));
//        return 1;
//    }

    @Override
    public List<UserProfile> selectAllUserProfiles(){
        return USER_PROFILES;
    }

    @Override
    public Optional<UserProfile> selectUserProfileById(UUID id) {
        return USER_PROFILES.stream().filter(userProfile -> userProfile.getUserProfileId().equals(id)).findFirst();
    }

    @Override
    public int deleteUserProfileById(UUID id) {
        Optional<UserProfile> personMaybe = selectUserProfileById(id);
        if(personMaybe.isEmpty()) {
            return 0;
        }
        USER_PROFILES.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updateUserProfileById(UUID id, UserProfile update) {
        return selectUserProfileById(id)
                .map(userProfile -> {
                    int indexOfPersonToUpdate = USER_PROFILES.indexOf(userProfile);
                    if (indexOfPersonToUpdate >=0) {
                        USER_PROFILES.set(indexOfPersonToUpdate, new UserProfile(id, update.getName(),update.getUserProfileImageLink()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

}

