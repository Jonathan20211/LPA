package edu.ifes.ci.si.les.lpa.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})

public class ItensPedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "Quantidade deve ser preenchido")
	@Range(min = 1, max = 10, message = "Quantidade deve ser entre 1 e 10")
	private Integer quantidade;
	
	@NotNull(message = "Valor deve ser preenchido")
	@Digits(integer = 6, fraction = 2, message = "Valor do pedido deve ser preenchido com um valor decimal")
	private Double valor;
	
	@NotNull(message = "Valor Total deve ser preenchido")
	@Digits(integer = 6, fraction = 2, message = "Valor do pedido deve ser preenchido com um valor decimal")
	private Double valorTotal;

	@NotNull(message = "O pedido deve ser preenchido")
	@ManyToOne
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;

	@NotNull(message = "O produto deve ser preenchido")
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;
}
