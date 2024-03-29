package com.alkemy.ong.repository;

import com.alkemy.ong.models.entity.OrganizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrganizationRepository extends JpaRepository<OrganizationEntity, Long> {

}
