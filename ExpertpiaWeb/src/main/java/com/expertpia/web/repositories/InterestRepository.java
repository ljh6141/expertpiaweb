package com.expertpia.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expertpia.web.domains.Interest;

public abstract interface InterestRepository extends JpaRepository<Interest, Long>{}
