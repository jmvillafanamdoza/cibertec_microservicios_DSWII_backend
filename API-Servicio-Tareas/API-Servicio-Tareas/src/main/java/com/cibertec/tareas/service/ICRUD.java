package com.cibertec.tareas.service;

import java.util.List;

public interface ICRUD<T,ID> {
	 T registrar(T bean);
	 T actualizar(T bean);
	 void eliminar(ID cod);
	 T buscarPorID(ID cod);
	 List<T> listarTodos();
}
