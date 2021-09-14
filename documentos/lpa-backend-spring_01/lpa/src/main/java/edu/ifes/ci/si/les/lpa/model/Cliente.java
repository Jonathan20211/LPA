package edu.ifes.ci.si.les.lpa.model;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})

@Entity

public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	
	@Column(length = 60)
	@NotBlank(message = "Nome da cliente deve ser preenchida")
	@Size(min = 3, max = 60, message = "Nome da cliente deve ter entre 3 e 60 letras")
	private String nomeCompleto;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dataNasc;

	@Column(length = 60)
	@NotBlank(message = "Nome da endereço deve ser preenchida")
	@Size(min = 3, max = 60, message = "Nome da endereço deve ter entre 3 e 60 letras")
	private String endereco;

	@Digits(integer=4, fraction=0, message = "Número da Casa deve ser preenchido com um valor inteiro")
	private Integer numero;

	@Column(length = 9)
	@NotBlank(message = "CEP deve ser preenchido")
	@Size(min = 3, max = 9, message = "CEP deve ter entre 3 e 9 letras")
	@Pattern(regexp = "\\d{5}-\\d{3}", message = "CEP deve seguir o padrão NNNNN-NNN")
	private String cep;
	
	@Column(length = 2)
	@NotBlank(message = "Sigla da UF deve ser preenchida")
	@Size(min = 2, max = 2, message = "Sigla da UF deve ter 2 letras")
	private String uf;
	
	@NotNull(message = "O bairro deve ser preenchido")
	@ManyToOne
	@JoinColumn(name = "bairro_id")
	private Bairro bairro;

}
