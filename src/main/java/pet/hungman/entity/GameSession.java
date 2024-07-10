package pet.hungman.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class GameSession {
    @Id
    private String keyId; //keyId = ID

    @Column(name = "word")
    private String word;

    @Column(name = "mask")
    private List<Character> mask;

    @Column(name = "uuid")
    private List<String> suggestedByUser;

}
