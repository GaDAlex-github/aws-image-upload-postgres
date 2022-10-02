package com.example.awsimageupload.profile;

import java.util.Objects;
import java.util.UUID;

public class UserProfile {

    private final UUID userProfileId;
    private final String name;
    private  String userProfileImageLink; //S3 key

    public UserProfile(UUID userProfileId, String name, String userProfileImageLink) {
        this.userProfileId = userProfileId;
        this.name = name;
        this.userProfileImageLink = String.valueOf(userProfileImageLink);
    }

    public UUID getUserProfileId() {
        return userProfileId;
    }

    public String getName() {
        return name;
    }


    public String getUserProfileImageLink() {
        return userProfileImageLink;
    }

    public void setUserProfileImageLink(String userProfileImageLink) {
        this.userProfileImageLink = userProfileImageLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile that = (UserProfile) o;
        return Objects.equals(userProfileId, that.userProfileId) &&
               Objects.equals(name, that.name) &&
               Objects.equals(userProfileImageLink, that.userProfileImageLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userProfileId, name, userProfileImageLink);
    }
}
