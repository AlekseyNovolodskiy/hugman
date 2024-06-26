package pet.hungman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pet.hungman.entity.Word8Entity;

@Repository
public interface WordRepository extends JpaRepository<Word8Entity, Long> {



    @Query(nativeQuery = true,value = "SELECT * FROM words5  ORDER BY random() LIMIT 1")
      String getTheWords5 ();
    @Query(nativeQuery = true,value = "SELECT * FROM words6  ORDER BY random() LIMIT 1")
    String getTheWords6 ();
    @Query(nativeQuery = true,value = "SELECT * FROM words7  ORDER BY random() LIMIT 1")
    String getTheWords7 ();
    @Query(nativeQuery = true,value = "SELECT * FROM words8  ORDER BY random() LIMIT 1")
    String getTheWords8 ();
}

