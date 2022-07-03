package karaoke.domain;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lists1")
public class List {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long maBh;
	
	@Column( columnDefinition = "nvarchar(100) not null")
    private String tenBh;
	
	@Column(columnDefinition = "nvarchar(100)  not null")
    private String loiMoDau;
	
	@Column(columnDefinition = "nvarchar(100)  not null")
    private String theLoai;
	
	@Column(columnDefinition = "nvarchar(100) not null")
    private String caSi;
	
	@Column(columnDefinition = "nvarchar(100)  not null")
    private String nhacSi;
	
	@Column(columnDefinition = "nvarchar(2000)  not null")
    private String loiBatHat; 
	
	
	
}
