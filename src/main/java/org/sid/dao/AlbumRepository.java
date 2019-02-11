package org.sid.dao;

import org.sid.entities.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
	/*@Query("select a from Album a where a.titre like  :x ")
	public Page<Album> rechercher(@Param("x") String mc,Pageable pageable);*/


}
