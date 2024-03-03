package model.pagination;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sort {
    public boolean empty;
    public boolean sorted;
    public boolean unsorted;
}
