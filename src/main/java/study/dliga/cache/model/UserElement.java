package study.dliga.cache.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserElement {
    private Long id;
    private String name;
    private String email;

    public UserElement(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
