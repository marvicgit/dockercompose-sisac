package aate.gob.pe.service;

import java.util.List;

public interface ICrud<T> {
	T registrar(T t);
	T modificar(T t);
	List<T> listar();
	T leer(Integer id);
	void eliminar(Integer id);
}