package com.example.organization;

import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member,Integer> {
	
	public Iterable<Member> findByAge (int age);
	
}

