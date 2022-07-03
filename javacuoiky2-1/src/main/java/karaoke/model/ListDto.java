package karaoke.model;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListDto implements Serializable {
	private Long maBh;
	
	@NotEmpty
    private String tenBh;
	
	@NotEmpty
    private String loiMoDau;
	
	@NotEmpty
    private String theLoai;
	
	@NotEmpty
    private String caSi;
	
	@NotEmpty
    private String nhacSi;
	
	@NotEmpty
    private String loiBatHat; 
	
	private Boolean isEdit = false;
}
