package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Word implements Serializable {

    private static final long serialVersionUID = 4630249271094850373L;

    private Long id;
    private String word;
    private int count;
}
