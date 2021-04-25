package data;

import beans.Album;

public interface DataAccessInterface<T> {
	T create(T t);
	T findBy(T t);
}
