package generate;

import java.io.Serializable;
import lombok.Data;

/**
 * book
 * @author 
 */
@Data
public class Book implements Serializable {
    private String bid;

    private String title;

    private String author;

    private static final long serialVersionUID = 1L;
}