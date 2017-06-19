package com.jobfair.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.jobfair.beans.Review;

@Transactional
public interface ReviewDao extends CrudRepository<Review, Long> {
	
	public List<Review> findByReviewon(Long userid);

}
