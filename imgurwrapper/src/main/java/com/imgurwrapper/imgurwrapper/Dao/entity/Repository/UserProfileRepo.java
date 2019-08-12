package com.imgurwrapper.imgurwrapper.Dao.entity.Repository;

import com.imgurwrapper.imgurwrapper.Dao.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository Interface to perform Own Conditions related CRUD operations.
 */
@Repository
public interface UserProfileRepo extends JpaRepository<UserProfile, String> {

    UserProfile findByUserId(String userId);
}
