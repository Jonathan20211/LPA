package edu.ifes.ci.si.les.lpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})

@Entity

public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 20)
	@NotBlank(message = "Nome do produto deve ser preenchida")
	@Size(min = 3, max = 20, message = "Nome do produto deve ter entre 3 e 20 letras")
	private String nomeProduto;
	
	@NotNull(message = "Preço do produto deve ser preenchido")
	@Digits(integer = 3, fraction = 2, message = "Preço do produto deve ser preenchido com um valor decimal")
	private Double preco;

}
