package edu.ifes.ci.si.les.lpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})

@Entity

public class Bairro implements Serializable {
	
	
	private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 60)
	@NotBlank(message = "Nome da bairro deve ser preenchida")
	@Size(min = 3, max = 60, message = "Nome da bairro deve ter entre 3 e 60 letras")
	private String nomeBairro;

}
