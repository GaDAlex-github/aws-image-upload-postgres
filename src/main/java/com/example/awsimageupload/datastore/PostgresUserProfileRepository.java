package com.example.awsimageupload.datastore;

import com.example.awsimageupload.profile.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;



@Repository("userProfiles")
public class PostgresUserProfileRepository implements UserProfileRepository {

    private final JdbcTemplate  jdbcTemplate;

    @Autowired
    public PostgresUserProfileRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<UserProfile> selectAllUserProfiles() {
        final String sql= "SELECT id, name,imageLink FROM userProfiles";
        return jdbcTemplate.query(sql,(resultSet, i) -> {
            UUID userProfileId = UUID.fromString(resultSet.getString("id"));
            String username = resultSet.getString("name");
            String userProfileImageLink =resultSet.getString("imageLink");
            return new UserProfile(userProfileId , username, userProfileImageLink);
        });
    }

    @Override
    public Optional<UserProfile> selectUserProfileById(UUID id) {
        final String sql = "SELECT id, username FROM userProfiles WHERE id = ?";
        UserProfile userProfile = jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                (resultSet, i) -> {
                    UUID userProfileId = UUID.fromString(resultSet.getString("id"));
                    String username = resultSet.getString("username");
                    String userProfileImageLink = resultSet.getString("imageLink");
                    return new UserProfile(userProfileId , username, userProfileImageLink);
                });
        return Optional.ofNullable(userProfile);
    }

//    @Override
//    public int insertUserProfile(UUID id,UserProfile userProfile) {
//        // TODO Auto-generated method stub
//        return 0;
//    }

    @Override
    public int deleteUserProfileById(UUID id) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updateUserProfileById(UUID id, UserProfile userProfile) {
        // TODO Auto-generated method stub
        return 0;
    }
}


