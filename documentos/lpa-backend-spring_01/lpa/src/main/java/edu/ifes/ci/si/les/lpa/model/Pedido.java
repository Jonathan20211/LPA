package edu.ifes.ci.si.les.lpa.model;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})

public class Pedido implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dataPedido;

	@NotNull(message = "Valor do pedido deve ser preenchido")
	@Digits(integer = 6, fraction = 2, message = "Valor do pedido deve ser preenchido com um valor decimal")
	private Double valor;
	
	@NotNull(message = "O cliente deve ser preenchido")
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
}
