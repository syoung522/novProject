// DB를 접근하게 해줄 DB Layer 접근자
// MyBatis에서는 Dao라고 불리지만 JPA에선 Repository라고 불림

package com.novProject.domain.posts;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PostsRepository extends JpaRepository<Posts, Long>{

}
