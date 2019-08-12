package com.imgurwrapper.imgurwrapper.service;

import com.imgurwrapper.imgurwrapper.Dao.entity.UserProfile;

public interface UserProfileServiceInterface {

    public UserProfile registerUser(UserProfile user);
    public UserProfile validateuser(final String userId);
}
