package com.imgurwrapper.imgurwrapper.service;

import com.imgurwrapper.imgurwrapper.Dao.entity.Repository.UserProfileRepo;
import com.imgurwrapper.imgurwrapper.Dao.entity.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User profile Service.
 */
@Service
public class UserprofileService implements UserProfileServiceInterface {
    /**
     * User profile repo.
     */
    @Autowired
    UserProfileRepo userProfileRepo;

    /**
     * method to register user.
     * @param user
     * @return
     */
    @Override
    public UserProfile registerUser(final UserProfile user) {
        return userProfileRepo.save(user);
    }

    /**
     * method to validate user.
     * @param userId
     * @return
     */
    @Override
    public UserProfile validateuser(final String userId){
return userProfileRepo.findByUserId( userId);
    }
}
