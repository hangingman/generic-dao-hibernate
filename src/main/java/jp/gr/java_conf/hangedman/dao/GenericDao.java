package jp.gr.java_conf.hangedman.dao;

import java.io.Serializable;
import java.util.List;

/**
 * This is the article 10 years ago, we should follow this
 * @see https://www.ibm.com/developerworks/jp/java/library/j-genericdao/
 */
public interface GenericDao<T, PK extends Serializable> {

	/** Persist the newInstance object into database */
	PK create(T newInstance);

	/**
	 * Retrieve an object that was previously persisted to the database using
	 * the indicated id as primary key
	 */
	T read(PK id);
	List<T> read();

	/** Save changes made to a persistent object. */
	void update(T transientObject);

	/** Remove an object from persistent storage in the database */
	void delete(PK id) throws Exception;
	void delete(T persistentObject) throws Exception;
}
