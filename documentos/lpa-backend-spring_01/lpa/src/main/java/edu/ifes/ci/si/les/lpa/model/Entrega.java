package edu.ifes.ci.si.les.lpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})

public class Entrega implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 100)
	@NotBlank(message = "Comentário deve ser preenchida")
	@Size(min = 5, max = 100, message = "Comentário deve ter entre 5 e 100 letras")
	private String comentario;

	@NotNull(message = "O pedido deve ser preenchido")
	@OneToOne
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;

}
